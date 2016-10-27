package edu.mum.quiz.service.bl.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.quiz.domain.User;
import edu.mum.quiz.domain.quiz.Student;
import edu.mum.quiz.repository.StudentRepository;
import edu.mum.quiz.repository.UserRepository;
import edu.mum.quiz.service.bl.interfaces.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentDao;
    @Autowired
    private UserRepository userDao;
		
	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentDao.findOne(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}

	@Override
	public void delete(Long student_id,User user) {
		// TODO Auto-generated method stub
		Student student = studentDao.findByStudentAndTeacher(userDao.findOne(student_id),user);
		studentDao.delete(student);
	}
	
	@Override
	public Student assignStudent(Long studentId, Long teacherId)
	{
		Student student = new Student();
		return student;
	}

	

	
	
	

} // The End of Class;