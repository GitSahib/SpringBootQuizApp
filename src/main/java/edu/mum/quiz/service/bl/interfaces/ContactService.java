package edu.mum.quiz.service.bl.interfaces;

import edu.mum.quiz.domain.Contact;

public interface ContactService {
	Contact findByName(String name);
	Contact findByEmail(String email);
	Contact findBySubject(String subject);
	Contact findById(Long id);
	void save(Contact contact);
	void delete(Contact contact);
}
