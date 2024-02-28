package com.example.springboot.entities;

import lombok.*;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    private Long id;

    /** Columns */

    private String title;

    /** Foreign Keys */

    private Set<Person> persons;

    /** Hibernate */

    private Date createdAt;

    private Date modifiedAt;
}
