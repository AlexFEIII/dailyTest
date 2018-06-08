package com.pro.daily.dailyRepository;

import com.pro.daily.domain.DailyColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyColumnRepository extends JpaRepository<DailyColumn,Integer> {
    List<DailyColumn> findByName(String str);
}
