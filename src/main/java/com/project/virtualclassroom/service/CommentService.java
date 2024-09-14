package com.project.virtualclassroom.service;

import com.project.virtualclassroom.entity.Comment;

public interface CommentService {
    Comment addComment(Long lectureId, Comment comment);
    Comment getCommentById(Long commentId);
}

