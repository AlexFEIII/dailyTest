package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.IntelligentCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntelligentCUpvoteRepository extends JpaRepository<IntelligentCUpvote,Integer> {
    IntelligentCUpvote findByCommentid(int id);
    IntelligentCUpvote findByUsername(String username);
    IntelligentCUpvote findByCommentidAndUsername(int id,String username);
}
