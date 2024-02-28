package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationDirection {
    private Long id;

    /** Columns */

    private String title;

    /** Foreign Keys */

    private Set<Person> persons;

    /** Hibernate */

    private Date createdAt;

    private Date modifiedAt;
}
