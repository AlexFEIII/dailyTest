package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.EntertainmentCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntertainmentCUpvoteRepository extends JpaRepository<EntertainmentCUpvote,Integer> {
    EntertainmentCUpvote findByCommentid(int id);
    EntertainmentCUpvote findByUsername(String username);
    EntertainmentCUpvote findByCommentidAndUsername(int id,String username);
}
