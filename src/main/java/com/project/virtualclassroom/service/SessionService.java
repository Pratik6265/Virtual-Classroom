package com.project.virtualclassroom.service;

import com.project.virtualclassroom.entity.Session;

public interface SessionService {
    Session addSession(Long unitId, Session session);
    Session getSessionById(Long sessionId);
}

