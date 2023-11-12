package services.implementations;

import entities.Education;
import entities.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IEducationRepository;
import services.IEducationService;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public void save(Education education) {
        educationRepository.saveAndFlush(education);
    }

    @Override
    public Education getById(Long educationId) { return educationRepository.getOne(educationId); }

    @Override
    public List<Education> getAll() { return educationRepository.findAll(); }
}
