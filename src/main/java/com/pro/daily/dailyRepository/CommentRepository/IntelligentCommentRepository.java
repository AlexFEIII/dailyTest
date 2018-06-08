package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.IntelligentComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntelligentCommentRepository extends JpaRepository<IntelligentComment,Integer> {
    List<IntelligentComment> findByDocumentidOrderByIdDesc(int id);
    IntelligentComment findByCommentid(int id);
    IntelligentComment findById(int id);
}
