package edu.mum.quiz.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.quiz.domain.User;
import edu.mum.quiz.repository.UserRepository;
import edu.mum.quiz.service.security.interfaces.SecurityService;
import edu.mum.quiz.service.security.interfaces.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired 
    SecurityService securityService;
    public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    @Transactional
	@Override
	public void changePassword(String username, String newPassword) {
		User user = userRepository.findByUsername(username);
		user.setPassword(bCryptPasswordEncoder.encode(newPassword));
		userRepository.saveAndFlush(user);
	}
   
	@Transactional
	@Override
	public void deleteUser(String username) {
		
	}
	@Transactional
	@Override
	public void updateUser(String username, User user) {
		User userOld = userRepository.findByUsername(username);
		userOld.setPassword(user.getPassword());
		userOld.setRoles(user.getRoles());
		userRepository.saveAndFlush(user);
	}
	@Transactional(readOnly = true)
	@Override
	public boolean userExists(String username) {
		return userRepository.findByUsername(username) != null;
	}
	@Override
	public boolean authenticate(String password) {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userRepository.findByUsername(userDetails.getUsername());
		return securityService.authenticat(user.getUsername(), password);
	}
	@Transactional(readOnly = true)
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
