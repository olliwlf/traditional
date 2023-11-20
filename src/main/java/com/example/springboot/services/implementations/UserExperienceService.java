package com.example.springboot.services.implementations;

import com.example.springboot.entities.UserExperience;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.springboot.repositories.IUserExperienceRepository;
import com.example.springboot.services.IUserExperienceService;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserExperienceService implements IUserExperienceService {
    /*private final IUserExperienceRepository userExperienceRepository;

    @Override
    public void save(UserExperience userExperience) {
        userExperienceRepository.saveAndFlush(userExperience);
    }*/
}
