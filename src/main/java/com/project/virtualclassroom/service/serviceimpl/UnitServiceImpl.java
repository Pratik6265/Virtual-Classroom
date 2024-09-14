package com.project.virtualclassroom.service.serviceimpl;

import com.project.virtualclassroom.entity.ClassRoom;
import com.project.virtualclassroom.entity.Unit;
import com.project.virtualclassroom.exception.ResourceNotFoundException;
import com.project.virtualclassroom.repository.ClassRoomRepository;
import com.project.virtualclassroom.repository.UnitRepository;
import com.project.virtualclassroom.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public Unit addUnit(Long classId, Unit unit) {
        ClassRoom classRoom = classRoomRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("ClassRoom not found with id " + classId));

        // Link the unit to the class
        unit.setClassRoom(classRoom);
        return unitRepository.save(unit);
    }

    @Override
    public Unit getUnitById(Long classId, Long unitId) {
        // Optional validation to ensure the unit belongs to the class
        return unitRepository.findById(unitId)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found with id " + unitId));
    }
}
