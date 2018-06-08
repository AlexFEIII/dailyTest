package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.DesignCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignCUpvoteRepository extends JpaRepository<DesignCUpvote,Integer> {
    DesignCUpvote findByCommentid(int id);
    DesignCUpvote findByUsername(String username);
    DesignCUpvote findByCommentidAndUsername(int id,String username);
}
