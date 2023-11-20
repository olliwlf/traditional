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

    @Column(name="test_group")
    private Integer testGroup = 0; // 0 traditional, 1 scrollytelling

    //@Column(name="value1")
    private Integer value1;

    //@Column(name="value2")
    private Integer value2;

    //@Column(name="value3")
    private Integer value3;

    /** Foreign Keys */

    @ManyToOne
    @JoinColumn(name="education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name="education_direction_id")
    private EducationDirection educationDirection;

    /** Hibernate */

    @Column(name="created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name="modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedAt;
}
