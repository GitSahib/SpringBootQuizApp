package edu.mum.quiz.service.bl.impl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.quiz.domain.quiz.Choice;
import edu.mum.quiz.domain.quiz.Question;
import edu.mum.quiz.domain.quiz.QuestionType;
import edu.mum.quiz.domain.quiz.Subject;
import edu.mum.quiz.repository.ChoiceRepository;
import edu.mum.quiz.repository.QuestionRepository;
import edu.mum.quiz.service.bl.interfaces.QuestionService;
@PreAuthorize("Teacher")
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionDao;
    @Autowired
    private ChoiceRepository choiceDao;
	@Override
	public List<Question> searchByKeyword(String word) {
		// TODO Auto-generated method stub
		return questionDao.searchByKeyword(word);
	}

	@Override
	public Question findById(Long Id) {
		// TODO Auto-generated method stub
		return questionDao.findById(Id);
	}

	@Override
	public List<Question> findBySubject(Subject subject) {
		// TODO Auto-generated method stub
		return questionDao.findBySubject(subject);
	}
	
	@Override
	public Question save(Question question) {
		Question q =  questionDao.save(question);
		for(Choice choice:question.getChoices())
		{
			choice.setQuestion(q);
			choiceDao.save(choice);
		}
		return q;
	
	}

	@Override
	public void delete(Question question) {
		// TODO Auto-generated method stub
		for(Choice ch:question.getChoices())
		{
			choiceDao.delete(ch);
		}
		questionDao.delete(question);
		
	}

	@Override
	public List<Question> findByType(QuestionType type) {
		// TODO Auto-generated method stub
		return questionDao.findByType(type);
	}

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	
	
	

} // The End of Class;