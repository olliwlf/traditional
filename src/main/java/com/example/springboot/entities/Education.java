package com.example.springboot.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
public class Education {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /** Columns */

    @Column(name="title")
    private String title;

    /** Foreign Keys */

    @OneToMany(mappedBy="education")
    private Set<Person> persons;

    /** Hibernate */

    @Column(name="created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @CreationTimestamp
    private Date createdAt;

    @Column(name="modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @UpdateTimestamp
    private Date modifiedAt;
}
