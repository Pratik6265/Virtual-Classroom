package com.project.virtualclassroom.service;

import com.project.virtualclassroom.entity.Lecture;

public interface LectureService {
    Lecture addLecture(Long sessionId, Lecture lecture);
    Lecture getLectureById(Long lectureId);
}

