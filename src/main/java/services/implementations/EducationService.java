package services.implementations;

import entities.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IEducationRepository;

@Service
public class EducationService {
    @Autowired
    private IEducationRepository educationRepository;
}
