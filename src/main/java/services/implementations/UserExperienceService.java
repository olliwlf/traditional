package services.implementations;

import entities.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IUserExperienceRepository;
import services.IUserExperienceService;

@Service
public class UserExperienceService implements IUserExperienceService {
    @Autowired
    private IUserExperienceRepository userExperienceRepository;

    @Override
    public void save(UserExperience userExperience) {
        userExperienceRepository.saveAndFlush(userExperience);
    }
}
