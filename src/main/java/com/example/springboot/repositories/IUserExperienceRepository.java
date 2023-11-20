package com.example.springboot.repositories;

import com.example.springboot.entities.UserExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IUserExperienceRepository extends CrudRepository<UserExperience, Long> {
}
