package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.DocumentComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentCommentRepository extends JpaRepository<DocumentComment,Integer> {
    List<DocumentComment> findByDocumentidOrderByIdDesc(int id);
    DocumentComment findByCommentid(int id);
    DocumentComment findById(int id);
}
