package com.project.virtualclassroom.service;

import com.project.virtualclassroom.entity.ClassRoom;

public interface ClassRoomService {
    ClassRoom createClass(ClassRoom classRoom);
    ClassRoom getClassById(Long id);
}
