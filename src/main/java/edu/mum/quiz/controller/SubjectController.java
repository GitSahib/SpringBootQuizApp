package edu.mum.quiz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.quiz.domain.quiz.Subject;
import edu.mum.quiz.service.bl.interfaces.SubjectService;

@Controller
@RequestMapping("/admin")
public class SubjectController extends MEMSController {
	@Autowired
	SubjectService subjectService;

	protected SubjectController() {
		super("Subjects");
	}
	// Subject Routes
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	@RequestMapping(value = { "/subject/create" }, method = RequestMethod.GET)
	public String createQuestion(@ModelAttribute("subject") Subject subject, Model model) {

		setPageTitle("Create Subject");
		return "admin/subject/create";
	}

	@RequestMapping(value = { "/subject/create" }, method = RequestMethod.POST)
	public String createSubject(@ModelAttribute("subject") Subject subject, BindingResult result) {
		if (result.hasErrors()) {
			setPageTitle("Create Subject");
			return "admin/subject/create";
		} else {
			subjectService.save(subject);
			return "redirect:/admin/subject/details/" + subject.getId();
		}

	}

	@RequestMapping(value = { "/subject/list" }, method = RequestMethod.GET)
	public String listQuestion(Model model) {
		List<Subject> list = subjectService.findAll();
		model.addAttribute("list", list);
		setPageTitle("List Subjects");
		return "admin/subject/list";
	}

	@RequestMapping(value = { "/subject/details/{id}" }, method = RequestMethod.GET)
	public String subjectDetails(@PathVariable("id") Long id, Model model) {
		Subject subject = subjectService.findById(id);
		model.addAttribute("subject", subject);
		setPageTitle("Subject Details");
		return "admin/subject/details";
	}

}
