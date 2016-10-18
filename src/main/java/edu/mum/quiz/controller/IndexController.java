package edu.mum.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.quiz.domain.Contact;
import edu.mum.quiz.service.bl.interfaces.ContactService;
import edu.mum.quiz.service.validator.impl.ContactValidator;

@Controller
public class IndexController {
	
	@Autowired
	ContactService contactService;
	@Autowired
	ContactValidator contactValidator;
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
    	return "index";
    }
    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String about(Model model) {
          return "about";
    }
    @RequestMapping(value = {"error"}, method = RequestMethod.GET)
    public String error(Model model) {
          return "error-custom";
    }
    @RequestMapping(value = {"/contact", "/contact.html","contact.jsp"}, method = RequestMethod.GET)
    public String contact(Model model) {
    	model.addAttribute("contactForm", new Contact()); 
    	return "contact";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String register(@ModelAttribute("contactForm") Contact contactForm, BindingResult bindingResult, Model model) {
    	contactValidator.validate(contactForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "contact";
		}
    	contactService.save(contactForm);
    	model.addAttribute("message","Thank you for contacting we will soon contact you");
    	return "contact";
    }
   
    @RequestMapping(value="/*",method=RequestMethod.GET)
    public String error_404(Model model)
    {
    	return "404";
    }
}
