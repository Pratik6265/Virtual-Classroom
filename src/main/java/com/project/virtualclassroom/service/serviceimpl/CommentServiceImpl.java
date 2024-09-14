package com.project.virtualclassroom.service.serviceimpl;

import com.project.virtualclassroom.entity.Comment;
import com.project.virtualclassroom.entity.Lecture;
import com.project.virtualclassroom.exception.ResourceNotFoundException;
import com.project.virtualclassroom.repository.CommentRepository;
import com.project.virtualclassroom.repository.LectureRepository;
import com.project.virtualclassroom.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public Comment addComment(Long lectureId, Comment comment) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id " + lectureId));

        // Link the comment to the lecture
        comment.setLecture(lecture);
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId));
    }
}
