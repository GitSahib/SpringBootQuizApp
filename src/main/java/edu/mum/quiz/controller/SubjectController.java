package edu.mum.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.quiz.domain.quiz.Subject;
import edu.mum.quiz.service.bl.interfaces.SubjectService;
import javassist.NotFoundException;

@Controller
@RequestMapping("/admin")
public class SubjectController extends MEMSController {
	@Autowired
	SubjectService subjectService;

	protected SubjectController() {
		super("Subjects");
	}
	// Subject Routes
	
	@RequestMapping(value = { "/subject/create" }, method = RequestMethod.GET)
	public String createSubject(@ModelAttribute("subject") Subject subject, Model model) {

		setPageTitle("Create Subject");
		model.addAttribute("pageTitle",getPageTitle());
		return "admin/subject/create";
	}

	@RequestMapping(value = { "/subject/create" }, method = RequestMethod.POST)
	public String createSubject(@ModelAttribute("subject") Subject subject, BindingResult result,Model model) {
		if (result.hasErrors()) {
			setPageTitle("Create Subject");
			model.addAttribute("pageTitle",getPageTitle());
			return "admin/subject/create";
		} else {
			subjectService.save(subject);
			return "redirect:/admin/subject/details/" + subject.getId();
		}

	}

	@RequestMapping(value = { "/subject/list","/subject" }, method = RequestMethod.GET)
	public String listSubject(Model model) {
		List<Subject> list = subjectService.findAll();
		model.addAttribute("list", list);
		setPageTitle("List Subjects");
		model.addAttribute("pageTitle",getPageTitle());
		return "admin/subject/list";
	}

	@RequestMapping(value = { "/subject/details/{id}" }, method = RequestMethod.GET)
	public String subjectDetails(@PathVariable("id") Long id, Model model) {
		Subject subject = subjectService.findById(id);
		model.addAttribute("subject", subject);
		setPageTitle("Subject Details");
		model.addAttribute("pageTitle",getPageTitle());
		return "admin/subject/details";
	}
	
	@RequestMapping(value = { "/subject/edit/{id}" }, method = RequestMethod.GET)
	public String editSubject(@PathVariable("id") Long id, Model model) throws NotFoundException {

		setPageTitle("Edit Subject");
		model.addAttribute("pageTitle",getPageTitle());
		Subject subject = subjectService.findById(id);
		if(subject == null)
		{
			throw new NotFoundException("Subject with id:"+id+" Not Found");
		}
		model.addAttribute("subject",subject);
		return "admin/subject/edit";
	}
	@RequestMapping(value = { "/subject/delete/{id}" }, method = RequestMethod.GET)
	public String deleteSubject(@PathVariable("id") Long id, Model model) throws NotFoundException {

		Subject subject = subjectService.findById(id);
		if(subject == null)
		{
			throw new NotFoundException("Subject with id:"+id+" Not Found");
		}
		subjectService.delete(subject);
		return "redirect:/admin/subject/list";
	}
	@RequestMapping(value = { "/subject/edit" }, method = RequestMethod.POST)
	public String editSubject(@ModelAttribute("subject") Subject subject, BindingResult result,Model model) {
		if (result.hasErrors()) {
			setPageTitle("Edit Subject");
			model.addAttribute("pageTitle",getPageTitle());
			return "admin/subject/edit";
		} else {
			subjectService.save(subject);
			return "redirect:/admin/subject/details/" + subject.getId();
		}

	}

}
