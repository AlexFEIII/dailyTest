package com.pro.daily.dailyRepository.CuriosityRepository;

import com.pro.daily.domain.DailyCuriosity.CuriosityResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuriosityResultRepository extends JpaRepository<CuriosityResult,Integer> {
    List<CuriosityResult> findByDocumentid(int id);
}
