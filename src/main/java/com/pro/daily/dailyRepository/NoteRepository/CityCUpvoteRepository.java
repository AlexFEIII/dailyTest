package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.CityCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityCUpvoteRepository extends JpaRepository<CityCUpvote,Integer> {
    CityCUpvote findByCommentid(int id);
    CityCUpvote findByUsername(String username);
    CityCUpvote findByCommentidAndUsername(int id,String username);
}
