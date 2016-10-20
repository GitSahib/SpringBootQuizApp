package edu.mum.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController extends MEMSController {
	
	protected AdminController() {
		super("Backend");
	}
	@RequestMapping(value = {"/admin", "/admin/index"}, method = RequestMethod.GET)
    public String home(Model model) {
    	return "admin/index";
    }
  
}
