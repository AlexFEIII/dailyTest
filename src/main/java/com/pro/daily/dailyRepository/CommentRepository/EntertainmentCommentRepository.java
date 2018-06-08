package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.EntertainmentComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntertainmentCommentRepository extends JpaRepository<EntertainmentComment,Integer> {
    List<EntertainmentComment> findByDocumentidOrderByIdDesc(int id);
    EntertainmentComment findByCommentid(int id);
    EntertainmentComment findById(int id);
}
