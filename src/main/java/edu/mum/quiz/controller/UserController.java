package edu.mum.quiz.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.quiz.domain.Profile;
import edu.mum.quiz.domain.Role;
import edu.mum.quiz.domain.User;
import edu.mum.quiz.service.security.interfaces.ProfileService;
import edu.mum.quiz.service.security.interfaces.RoleService;
import edu.mum.quiz.service.security.interfaces.SecurityService;
import edu.mum.quiz.service.security.interfaces.UserService;
import edu.mum.quiz.service.validator.impl.ProfileValidator;
import edu.mum.quiz.service.validator.impl.UserValidator;

@SessionAttributes("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private RoleService roleService;
	private Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	@Autowired
	private ProfileValidator profileValidator;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("userForm") User userForm, BindingResult errors,String error, String logout) {
		if (error != null)
			errors.rejectValue("password", "errors.username.or.password.is.invalid");			
		if (logout != null)
			errors.rejectValue("password", "message.you.are.loggedout.successfully");
		return "login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "redirect:login#toregister";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model,RedirectAttributes rda) {

		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			log.error("User Form Invalid");
			model.addAttribute("register","yes");
			return "login";
		}
		Role role = roleService.findRoleByName("Student");
		Set<Role> roles = new HashSet<Role>();		
		roles.add(role);
		userForm.setRoles(roles);	
		Profile profile = userForm.getProfile();
		userForm.setProfile(null);
		userService.save(userForm);
		profile.setUser(userForm);
		profileService.save(profile);		
		securityService.autologin(userForm.getUsername(), userForm.getPassword());
		return "redirect:/index";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileinfo(Model model, HttpServletRequest request) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByUsername(userDetails.getUsername());
		model.addAttribute("profileForm", user.getProfile());
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profileinfo(@ModelAttribute("profileForm") Profile profileForm, BindingResult bindingResult,
			Model model) {
		profileValidator.validate(profileForm, bindingResult);
		if (bindingResult.hasErrors()) {
			log.error("User Profile Form Invalid");
			return "profile";
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByUsername(userDetails.getUsername());
		if(!profileForm.getUser().getPassword().isEmpty())
		{
			userService.changePassword(user.getUsername(), profileForm.getUser().getPassword());
		}
		profileService.updateUserProfile(user,profileForm);
		
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/colors", method = RequestMethod.GET)
	public String colors(@RequestParam(name="colors",defaultValue="gray") String[] colors,Model model) {
		
		model.addAttribute("list",colors);
		return "colors";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdenied() {
		return "accessdenied";
	}

	

	

	
}
