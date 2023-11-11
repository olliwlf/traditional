package services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IPersonRepository;
import repositories.IUserExperienceRepository;

@Service
public class PersonService {
    @Autowired
    private IPersonRepository personRepository;
}
