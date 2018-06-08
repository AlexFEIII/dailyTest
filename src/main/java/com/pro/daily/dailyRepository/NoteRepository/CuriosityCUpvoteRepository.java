package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.CuriosityCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuriosityCUpvoteRepository extends JpaRepository<CuriosityCUpvote,Integer> {
    CuriosityCUpvote findByCommentid(int id);
    CuriosityCUpvote findByUsername(String username);
    CuriosityCUpvote findByCommentidAndUsername(int id,String username);
}
