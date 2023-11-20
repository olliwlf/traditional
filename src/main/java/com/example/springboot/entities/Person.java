package com.example.springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /** Columns */

    @Column(name="age")
    private Integer age;

    @Column(name="prior_scrollytelling_experience")
    private Boolean priorScrollytellingExperience;

    /** Foreign Keys */

    @ManyToOne
    @JoinColumn(name="education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name="education_direction_id")
    private EducationDirection educationDirection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_experience_id")
    private UserExperience userExperience;

    /** Hibernate */

    @Column(name="createdAt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name="modifiedAt")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedAt;
}
