package services.implementations;

import entities.Person;
import entities.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IPersonRepository;
import repositories.IUserExperienceRepository;
import services.IPersonService;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.saveAndFlush(person);
    }
}
