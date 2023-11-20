package com.example.springboot.services.implementations;

import com.example.springboot.entities.Education;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.springboot.repositories.IEducationRepository;
import com.example.springboot.services.IEducationService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EducationService implements IEducationService {
    /*private final IEducationRepository educationRepository;

    @Override
    public void save(Education education) {
        educationRepository.saveAndFlush(education);
    }

    @Override
    public Optional<Education> getById(Long educationId) { return educationRepository.findById(educationId); }

    @Override
    public List<Education> getAll() { return educationRepository.findAll(); }*/
}
