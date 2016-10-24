package edu.mum.quiz.service.bl.interfaces;
import java.util.Date;
import java.util.List;

import edu.mum.quiz.domain.quiz.Subject;

public interface SubjectService 
{
	List<Subject> searchByKeyword(String word);
	Subject findById(Long Id);
	Subject save(Subject Subject);
	List<Subject> findByStartDate(Date date);
	List<Subject> findByMission(String mission);
	void delete(Subject Subject);
	List<Subject> findAll();

}