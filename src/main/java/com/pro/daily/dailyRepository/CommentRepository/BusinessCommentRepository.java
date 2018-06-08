package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.BusinessComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessCommentRepository extends JpaRepository<BusinessComment,Integer> {
    List<BusinessComment> findByDocumentidOrderByIdDesc(int id);
    BusinessComment findByCommentid(int id);
    BusinessComment findById(Integer id);
}
