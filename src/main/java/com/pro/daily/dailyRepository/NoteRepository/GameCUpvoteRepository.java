package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.GameCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameCUpvoteRepository extends JpaRepository<GameCUpvote,Integer> {
    GameCUpvote findByCommentid(int id);
    GameCUpvote findByUsername(String username);
    GameCUpvote findByCommentidAndUsername(int id,String username);
}
