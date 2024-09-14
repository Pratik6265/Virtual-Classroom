package com.project.virtualclassroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private List<Unit> units;

    // getters, setters, constructors
}

