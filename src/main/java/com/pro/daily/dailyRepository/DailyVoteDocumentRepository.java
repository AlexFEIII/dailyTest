package com.pro.daily.dailyRepository;

import com.pro.daily.domain.DailyCuriosity.DailyVoteDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyVoteDocumentRepository extends JpaRepository<DailyVoteDocument,Integer> {
    DailyVoteDocument findById(int id);
}
