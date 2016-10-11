package edu.mum.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.quiz.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	
}
