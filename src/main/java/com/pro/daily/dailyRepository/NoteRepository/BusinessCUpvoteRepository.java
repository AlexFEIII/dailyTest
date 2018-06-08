package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.BusinessCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCUpvoteRepository extends JpaRepository<BusinessCUpvote,Integer> {
    BusinessCUpvote findByCommentid(int id);
    BusinessCUpvote findByUsername(String username);
    BusinessCUpvote findByCommentidAndUsername(int id,String username);
}
