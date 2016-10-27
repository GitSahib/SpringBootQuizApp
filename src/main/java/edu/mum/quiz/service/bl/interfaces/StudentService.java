package edu.mum.quiz.service.bl.interfaces;

import edu.mum.quiz.domain.User;
import edu.mum.quiz.domain.quiz.Student;

public interface StudentService {
	Student findById(Long id);
	void save(Student student);
	Student assignStudent(Long studentId, Long teacherId);
	void delete(Long student_id, User user);
}
