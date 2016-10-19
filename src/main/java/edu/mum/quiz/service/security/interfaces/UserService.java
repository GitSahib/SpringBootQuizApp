package edu.mum.quiz.service.security.interfaces;

import edu.mum.quiz.domain.User;

public interface UserService {
    void save(User user);
    
    User findByUsername(String username);

	void deleteUser(String username);

	
	void changePassword(String username, String newPassword);

	void updateUser(String username, User user);

	boolean userExists(String username);

	boolean authenticate(String password);

	User getLoggedInUser();
}
