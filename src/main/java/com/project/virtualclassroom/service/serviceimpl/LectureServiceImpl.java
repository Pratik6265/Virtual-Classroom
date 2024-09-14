package com.project.virtualclassroom.service.serviceimpl;

import com.project.virtualclassroom.entity.Lecture;
import com.project.virtualclassroom.entity.Session;
import com.project.virtualclassroom.exception.ResourceNotFoundException;
import com.project.virtualclassroom.repository.LectureRepository;
import com.project.virtualclassroom.repository.SessionRepository;
import com.project.virtualclassroom.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Lecture addLecture(Long sessionId, Lecture lecture) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id " + sessionId));

        // Link the lecture to the session
        lecture.setSession(session);
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture getLectureById(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id " + lectureId));
    }
}

