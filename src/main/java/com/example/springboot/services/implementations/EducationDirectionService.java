package com.example.springboot.services.implementations;

import com.example.springboot.entities.EducationDirection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.springboot.repositories.IEducationDirectionRepository;
import com.example.springboot.services.IEducationDirectionService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EducationDirectionService implements IEducationDirectionService {
    /*private final IEducationDirectionRepository educationDirectionRepository;

    @Override
    public List<EducationDirection> getAll() { return educationDirectionRepository.findAll(); }*/
}
