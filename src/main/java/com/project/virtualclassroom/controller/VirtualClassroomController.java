package com.project.virtualclassroom.controller;

import com.project.virtualclassroom.entity.*;
import com.project.virtualclassroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class VirtualClassroomController {

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private CommentService commentService;

    // Class Management
    @PostMapping("/create")
    public ResponseEntity<ClassRoom> createClass(@RequestBody ClassRoom classRoom) {
        ClassRoom newClass = classRoomService.createClass(classRoom);
        return new ResponseEntity<>(newClass, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> getClassById(@PathVariable Long id) {
        ClassRoom classRoom = classRoomService.getClassById(id);
        return ResponseEntity.ok(classRoom);
    }

    // Unit Management
    @PostMapping("/{classId}/units")
    public ResponseEntity<Unit> addUnit(@PathVariable Long classId, @RequestBody Unit unit) {
        Unit newUnit = unitService.addUnit(classId, unit);
        return new ResponseEntity<>(newUnit, HttpStatus.CREATED);
    }

    @GetMapping("/{classId}/units/{unitId}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long classId, @PathVariable Long unitId) {
        Unit unit = unitService.getUnitById(classId, unitId);
        return ResponseEntity.ok(unit);
    }

    // Session Management
    @PostMapping("/{classId}/units/{unitId}/sessions")
    public ResponseEntity<Session> addSession(@PathVariable Long unitId, @RequestBody Session session) {
        Session newSession = sessionService.addSession(unitId, session);
        return new ResponseEntity<>(newSession, HttpStatus.CREATED);
    }

    @GetMapping("/{classId}/units/{unitId}/sessions/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        return ResponseEntity.ok(session);
    }

    // Lecture Management
    @PostMapping("/{classId}/units/{unitId}/sessions/{sessionId}/lectures")
    public ResponseEntity<Lecture> addLecture(@PathVariable Long sessionId, @RequestBody Lecture lecture) {
        Lecture newLecture = lectureService.addLecture(sessionId, lecture);
        return new ResponseEntity<>(newLecture, HttpStatus.CREATED);
    }

    @GetMapping("/{classId}/units/{unitId}/sessions/{sessionId}/lectures/{lectureId}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable Long lectureId) {
        Lecture lecture = lectureService.getLectureById(lectureId);
        return ResponseEntity.ok(lecture);
    }

    // Comment Management
    @PostMapping("/lectures/{lectureId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long lectureId, @RequestBody Comment comment) {
        Comment newComment = commentService.addComment(lectureId, comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @GetMapping("/lectures/{lectureId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }
}
