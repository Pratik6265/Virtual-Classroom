package com.project.virtualclassroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String role; // 'ROLE_ADMIN' or 'ROLE_STUDENT'

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments;

    // getters, setters, constructors
}