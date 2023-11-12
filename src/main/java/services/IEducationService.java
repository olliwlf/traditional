package services;

import entities.Education;

public interface IEducationService {
    void save(Education education);
    Education getById(Long educationId);
}
