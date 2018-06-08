package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.DocumentCUpvote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentCUpvoteRepository extends JpaRepository<DocumentCUpvote,Integer> {
    DocumentCUpvote findByCommentid(int id);
    DocumentCUpvote findByUsername(String username);
    DocumentCUpvote findByCommentidAndUsername(int id,String username);
}
