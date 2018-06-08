package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.FashionComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FashionCommentRepository extends JpaRepository<FashionComment,Integer> {
    List<FashionComment> findByDocumentidOrderByIdDesc(int id);
    FashionComment findByCommentid(int id);
    FashionComment findById(int id);
}
