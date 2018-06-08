package com.pro.daily.dailyRepository;

import com.pro.daily.domain.DailyTheBest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheBestRepository extends JpaRepository<DailyTheBest,Integer> {
}
