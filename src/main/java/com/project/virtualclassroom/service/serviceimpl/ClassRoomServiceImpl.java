package com.project.virtualclassroom.service.serviceimpl;

import com.project.virtualclassroom.entity.ClassRoom;
import com.project.virtualclassroom.exception.ResourceNotFoundException;
import com.project.virtualclassroom.repository.ClassRoomRepository;
import com.project.virtualclassroom.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public ClassRoom createClass(ClassRoom classRoom) {
        // Any additional logic before saving, like validation, etc.
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom getClassById(Long id) {
        // Find class by ID and handle exception if not found
        return classRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClassRoom not found with id " + id));
    }
}

