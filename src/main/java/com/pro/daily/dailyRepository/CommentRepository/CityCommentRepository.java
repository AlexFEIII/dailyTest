package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.CityComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityCommentRepository extends JpaRepository<CityComment,Integer> {
    List<CityComment> findByDocumentidOrderByIdDesc(int id);
    CityComment findByCommentid(int id);
    CityComment findById(int id);
}
