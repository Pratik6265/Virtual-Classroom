package com.project.virtualclassroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unitName;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoom classRoom;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
    private List<Session> sessions;

    // getters, setters, constructors
}

