package com.pro.daily.dailyRepository.UserPackageRepository;

import com.pro.daily.domain.DailyUserPackage.DailyUserCollect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyUserCollectionRepository extends JpaRepository<DailyUserCollect,Integer> {
}
