package edu.mum.quiz.service.bl.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.quiz.domain.quiz.Question;
import edu.mum.quiz.domain.quiz.QuestionType;
import edu.mum.quiz.domain.quiz.Subject;
import edu.mum.quiz.repository.QuestionRepository;
import edu.mum.quiz.service.bl.interfaces.QuestionService;
@PreAuthorize("Teacher")
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionDao;

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
		return questionDao.save(question);
	}

	@Override
	public void delete(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
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