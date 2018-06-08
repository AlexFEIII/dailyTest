package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.CuriosityComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuriosityCommentRepository extends JpaRepository<CuriosityComment,Integer> {
    List<CuriosityComment> findByDocumentidOrderByIdDesc(int id);
    CuriosityComment findById(int id);
}
