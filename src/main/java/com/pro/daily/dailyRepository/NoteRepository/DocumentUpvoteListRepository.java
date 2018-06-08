package com.pro.daily.dailyRepository.NoteRepository;

import com.pro.daily.domain.DailyNote.DocumentUpvoteList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentUpvoteListRepository extends JpaRepository<DocumentUpvoteList,Integer> {
    List<DocumentUpvoteList> findByUsername(String username);
    DocumentUpvoteList findByUsernameAndDocumentid(String username,int id);
}
