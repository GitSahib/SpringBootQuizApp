package edu.mum.quiz.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.quiz.domain.Role;
import edu.mum.quiz.service.security.interfaces.RoleService;

@SpringBootApplication
public class QuizApplication {
	@Autowired
	static RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
		List<Role> roleList = roleService.findAll();
		if (roleList.size() < 3) {
			Role role = new Role();
			role.setName("Admin");
			roleService.save(role);

			role = new Role();
			role.setName("Student");
			roleService.save(role);

			role = new Role();
			role.setName("Teacher");
			roleService.save(role);
		}
	}

}
