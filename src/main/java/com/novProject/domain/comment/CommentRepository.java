package com.novProject.domain.comment;

import com.novProject.web.dto.CommentListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
