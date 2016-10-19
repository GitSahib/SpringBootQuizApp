package edu.mum.quiz.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@Autowired
	private Environment env;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileinfo(Model model, HttpServletRequest request) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByUsername(userDetails.getUsername());
		model.addAttribute("profileForm", user.getProfile());
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profileinfo(@ModelAttribute("profileForm") Profile profileForm, BindingResult bindingResult,
			Model model, RedirectAttributes rda) {
		profileValidator.validate(profileForm, bindingResult);
		if (bindingResult.hasErrors()) {
			log.error("User Profile Form Invalid");
			return "profile";
		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findByUsername(userDetails.getUsername());
		if (!profileForm.getUser().getPassword().isEmpty()) {
			userService.changePassword(user.getUsername(), profileForm.getUser().getPassword());
			rda.addFlashAttribute("passwordChanged", true);
		}
		profileService.updateUserProfile(user, profileForm);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/colors", method = RequestMethod.GET)
	public String colors(@RequestParam(name = "colors", defaultValue = "gray") String[] colors, Model model) {

		model.addAttribute("list", colors);
		return "colors";
	}

	@RequestMapping(value = "profile/uploadPhoto", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadphoto") MultipartFile uploadfile) {

		try {
			// Get the filename and build the local file path
			
			String filename= userService.getLoggedInUser().getId().toString()+".png";
			
			String directory = env.getProperty("user.profile.uploadedImages");
			String filepath = Paths.get(directory, filename).toString();
			
			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	} // method uploadFile

}
