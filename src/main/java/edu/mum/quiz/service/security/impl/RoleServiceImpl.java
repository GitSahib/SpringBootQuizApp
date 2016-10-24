package edu.mum.quiz.service.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.quiz.domain.Role;
import edu.mum.quiz.repository.RoleRepository;
import edu.mum.quiz.service.security.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
    
	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
}
