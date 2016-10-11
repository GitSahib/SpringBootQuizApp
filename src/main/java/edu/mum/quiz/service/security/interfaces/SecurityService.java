package edu.mum.quiz.service.security.interfaces;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);

	boolean authenticat(String username, String password);
}
