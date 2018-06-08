package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.FashionCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FashionCUpvoteRepository extends JpaRepository<FashionCUpvote,Integer> {
    FashionCUpvote findByCommentid(int id);
    FashionCUpvote findByUsername(String username);
    FashionCUpvote findByCommentidAndUsername(int id,String username);
}
