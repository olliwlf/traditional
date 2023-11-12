package services;

import entities.Education;

import java.util.List;

public interface IEducationService {
    void save(Education education);
    Education getById(Long educationId);

    List<Education> getAll();
}
