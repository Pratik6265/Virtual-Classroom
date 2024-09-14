package com.project.virtualclassroom.service;

import com.project.virtualclassroom.entity.Unit;

public interface UnitService {
    Unit addUnit(Long classId, Unit unit);
    Unit getUnitById(Long classId, Long unitId);
}

