package edu.mum.quiz.service.bl.interfaces;
import java.util.List;

import edu.mum.quiz.domain.QuizApplicationForm;
import edu.mum.quiz.domain.quiz.Quiz;
public interface QuizService 
{	
	Quiz createQuize(QuizApplicationForm quizAF);

	Quiz findById(Long id);

	List<Quiz> findAll();

	void delete(Quiz question);

	Quiz update(QuizApplicationForm quizAF);

	QuizApplicationForm getForm(Quiz quiz);

}