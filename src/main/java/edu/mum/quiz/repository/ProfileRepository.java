package edu.mum.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.quiz.domain.Profile;
import edu.mum.quiz.domain.User;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByFirstName(String FirstName);
    Profile findByUser(User user);
    
	
}
