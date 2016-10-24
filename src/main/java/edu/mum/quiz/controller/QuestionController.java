package edu.mum.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.quiz.domain.quiz.Question;
import edu.mum.quiz.domain.quiz.QuestionType;
import edu.mum.quiz.domain.quiz.Subject;
import edu.mum.quiz.service.bl.interfaces.QuestionService;

@Controller
@RequestMapping("/admin")
public class QuestionController extends MEMSController {
	@Autowired 
	QuestionService questionService;
	protected QuestionController() {
		super("Questions");
	}
	@ModelAttribute
	public void setTypesAndSubjects(Model model)
	{
		model.addAttribute("types", QuestionType.getNames());
		//List<Subject> subjects = subjectService.findAll();
		List<Subject> subjects = new ArrayList<Subject>();
		Subject subject = new Subject();
		subject.setName("WAP");
		subject.setId((long) 1);
		subjects.add(subject);
		model.addAttribute("subjects",subjects);
	}
	@RequestMapping(value = {"/question/create"}, method = RequestMethod.GET)
    public String createQuestion(@ModelAttribute("question") Question question,Model model) {
		
		setPageTitle("Create Question");
		model.addAttribute("pageTitle",getPageTitle());
		return "admin/question/create";
    }
	
	@RequestMapping(value = {"/question/create"}, method = RequestMethod.POST)
    public String createQuestion(@ModelAttribute("question") Question question,BindingResult result,Model model) {
    	if(result.hasErrors())
    	{
    		setPageTitle("Create Question");
    		model.addAttribute("pageTitle",getPageTitle());
    		return "admin/question/create";
    	}
    	else
    	{
    		questionService.save(question);
    		return "redirect:/admin/question/details/"+question.getId();
    	}
		
    }
	@RequestMapping(value = {"/question/list"}, method = RequestMethod.GET)
    public String listQuestions(Model model) {
		List<Question> list = questionService.findAll();
		model.addAttribute("list",list);
		setPageTitle("List Questions");
		model.addAttribute("pageTitle",getPageTitle());
		return "admin/question/list";
    }
	@RequestMapping(value = {"/question/details/{id}"}, method = RequestMethod.GET)
    public String createQuestion(@PathVariable("id") Long id,Model model) {
		Question question  = questionService.findById(id);
		model.addAttribute("question",question);
		setPageTitle("Create Details");
		model.addAttribute("pageTitle",getPageTitle());
		return "admin/quesition/details";
    }
	

}
