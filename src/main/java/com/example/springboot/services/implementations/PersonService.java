package com.example.springboot.services.implementations;

import com.example.springboot.entities.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.springboot.repositories.IPersonRepository;
import com.example.springboot.services.IPersonService;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService implements IPersonService {
    /*private final IPersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.saveAndFlush(person);
    }*/
}
