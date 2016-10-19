package edu.mum.quiz.service.security.interfaces;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.quiz.domain.Profile;
import edu.mum.quiz.domain.User;

public interface ProfileService {
    void save(Profile Profile);
    void updateUserProfile(User user, Profile profileForm);
    Profile findByFirstName(String FirstName);
    ResponseEntity<Object> saveImage(MultipartFile uploadfile, User user, Environment env);
	ResponseEntity<Object> saveImage(MultipartFile uploadfile, User user);
}
