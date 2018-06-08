package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.GameComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameCommentRepository extends JpaRepository<GameComment,Integer> {
    List<GameComment> findByDocumentidOrderByIdDesc(int id);
    GameComment findByCommentid(int id);
    GameComment findById(int id);
}
