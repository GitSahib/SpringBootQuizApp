package edu.mum.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.quiz.domain.User;
import edu.mum.quiz.domain.quiz.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentAndTeacher(User findOne, User user);
}
