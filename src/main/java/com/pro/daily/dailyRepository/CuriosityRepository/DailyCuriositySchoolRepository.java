package com.pro.daily.dailyRepository.CuriosityRepository;

import com.pro.daily.domain.DailyCuriosity.DailyCuriositySchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyCuriositySchoolRepository extends JpaRepository<DailyCuriositySchool,Integer> {
    DailyCuriositySchool findByTitle(String title);
    DailyCuriositySchool findById(int id);
}
