package edu.mum.quiz.service.bl.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.quiz.domain.Contact;
import edu.mum.quiz.repository.ContactRepository;
import edu.mum.quiz.service.bl.interfaces.ContactService;

@Transactional
@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactDao;

	@Override
	public Contact findByName(String name) {
		// TODO Auto-generated method stub
		return contactDao.findByName(name);
	}

	@Override
	public Contact findByEmail(String email) {
		// TODO Auto-generated method stub
		return contactDao.findByEmail(email);
	}

	@Override
	public Contact findBySubject(String subject) {
		// TODO Auto-generated method stub
		return contactDao.findBySubject(subject);
	}

	@Override
	public Contact findById(Long id) {
		// TODO Auto-generated method stub
		return contactDao.findById(id);
	}

	@Override
	public void save(Contact contact) {
		// TODO Auto-generated method stub
		contactDao.save(contact);
	}

	@Override
	public void delete(Contact contact) {
		// TODO Auto-generated method stub
		contactDao.delete(contact);
	}
    
	
	

} // The End of Class;