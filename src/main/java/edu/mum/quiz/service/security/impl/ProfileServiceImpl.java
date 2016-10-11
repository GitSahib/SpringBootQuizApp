package edu.mum.quiz.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.quiz.domain.Profile;
import edu.mum.quiz.domain.User;
import edu.mum.quiz.repository.ProfileRepository;
import edu.mum.quiz.service.security.interfaces.ProfileService;

@Transactional
@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;

	public void setProfileRepository(ProfileRepository ProfileRepository) {
		this.profileRepository = ProfileRepository;
	}

	@Override
	public void save(Profile Profile) {
		profileRepository.save(Profile);
	}

	@Override
	public Profile findByFirstName(String FirstName) {
		return profileRepository.findByFirstName(FirstName);
	}
	@Override
	public void updateUserProfile(User user,Profile profileForm) {
		try 
		{
			// hear i am trying to updating the charge_codes
			Profile profile = profileRepository.findByUser(user);
			profile.setFirstName(profileForm.getFirstName());
			profile.setLastName(profileForm.getLastName());
			profile.setPhoneNumber(profileForm.getPhoneNumber());
			profileRepository.saveAndFlush(profile);
		} 
		catch (Exception ex) 
		{

		}
	}

}
