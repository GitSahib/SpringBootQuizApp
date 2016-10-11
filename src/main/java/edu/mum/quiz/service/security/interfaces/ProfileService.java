package edu.mum.quiz.service.security.interfaces;

import edu.mum.quiz.domain.Profile;
import edu.mum.quiz.domain.User;

public interface ProfileService {
    void save(Profile Profile);
    void updateUserProfile(User user, Profile profileForm);
    Profile findByFirstName(String FirstName);
}
