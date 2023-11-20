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
@Table(name="user_experiences")
public class UserExperience {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /** Columns */

    @Column(name="test_group")
    private Integer testGroup = 0; // 0 traditional, 1 scrollytelling

    //@Column(name="value1")
    private Integer value1;

    //@Column(name="value2")
    private Integer value2;

    //@Column(name="value3")
    private Integer value3;

    /** Foreign Keys */

    @OneToOne(mappedBy = "userExperience")
    private Person person;

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
