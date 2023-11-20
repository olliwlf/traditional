package com.example.springboot.repositories;

import com.example.springboot.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IPersonRepository extends JpaRepository<Person, Long> {
}
