package com.project.virtualclassroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lectureTitle;
    private String content;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Comment> comments;

}