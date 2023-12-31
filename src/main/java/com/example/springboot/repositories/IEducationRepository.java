package com.example.springboot.repositories;

import com.example.springboot.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IEducationRepository extends JpaRepository<Education, Long> {
}
