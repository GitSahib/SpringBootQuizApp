package edu.mum.quiz.service.bl.interfaces;
import java.util.List;

import edu.mum.quiz.domain.quiz.Question;
import edu.mum.quiz.domain.quiz.QuestionType;
import edu.mum.quiz.domain.quiz.Subject;

public interface QuestionService 
{
	List<Question> searchByKeyword(String word);
	Question findById(Long Id);
	Question save(Question Question);
	List<Question> findByType(QuestionType question);
	List<Question> findBySubject(Subject subject);
	void delete(Question question);
	List<Question> findAll();
	Question update(Question question);

}