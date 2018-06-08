package com.pro.daily.dailyRepository.CommentRepository;

import com.pro.daily.domain.DailyComment.DesignComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DesignCommentRepository extends JpaRepository<DesignComment,Integer> {
    List<DesignComment> findByDocumentidOrderByIdDesc(int id);
    DesignComment findByCommentid(int id);
    DesignComment findById(int id);
}
