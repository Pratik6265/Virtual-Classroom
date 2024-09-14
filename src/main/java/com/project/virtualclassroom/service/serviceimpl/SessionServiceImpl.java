package com.project.virtualclassroom.service.serviceimpl;

import com.project.virtualclassroom.entity.Session;
import com.project.virtualclassroom.entity.Unit;
import com.project.virtualclassroom.exception.ResourceNotFoundException;
import com.project.virtualclassroom.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.virtualclassroom.repository.SessionRepository;
import com.project.virtualclassroom.repository.UnitRepository;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Session addSession(Long unitId, Session session) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id " + unitId));

        // Link the session to the unit
        session.setUnit(unit);
        return sessionRepository.save(session);
    }

    @Override
    public Session getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id " + sessionId));
    }
}
