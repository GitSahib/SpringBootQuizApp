package edu.mum.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import edu.mum.quiz.domain.User;
import edu.mum.quiz.service.security.interfaces.UserService;

public class MEMSController 
{
	@Autowired
	protected UserService userService;
	private String title;
	private String pageTitle;
	protected MEMSController(String title)
	{
		this.setTitle(title);
	}
	private void setTitle(String title) 
	{
		this.title = title;
	}
	
	@ModelAttribute
	public void beforeRequest(Model model)
	{
		model.addAttribute("title",this.title);
		model.addAttribute("pageTitle",this.pageTitle);
		try 
		{			
			User user = userService.getLoggedInUser();
			if(user != null)
			model.addAttribute("user", user);
		} 
		catch (Exception ex) 
		{
			
		}
	}
	/**
	 * @return the pageTitle
	 */
	public String getPageTitle() {
		return pageTitle;
	}
	/**
	 * @param pageTitle the pageTitle to set
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
}
