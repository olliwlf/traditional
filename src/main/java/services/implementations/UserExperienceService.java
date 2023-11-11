package services.implementations;

import entities.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IUserExperienceRepository;

@Service
public class UserExperienceService {
    @Autowired
    private IUserExperienceRepository userExperienceRepository;
}
