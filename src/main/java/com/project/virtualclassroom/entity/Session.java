package com.project.virtualclassroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sessionName;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    // getters, setters, constructors
}