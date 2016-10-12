package edu.mum.quiz.controller;

import javax.servlet.http.HttpServletRequest;

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

import edu.mum.quiz.domain.Profile;
import edu.mum.quiz.domain.User;
import edu.mum.quiz.service.security.interfaces.ProfileService;
import edu.mum.quiz.service.security.interfaces.UserService;
import edu.mum.quiz.service.validator.impl.ProfileValidator;

@Controller
public class ProfileController {
	Logger log = Logger.getLogger(getClass());
	@Autowired
	UserService userService;
	@Autowired
	ProfileService profileService;
	@Autowired
	ProfileValidator profileValidator;
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
}
