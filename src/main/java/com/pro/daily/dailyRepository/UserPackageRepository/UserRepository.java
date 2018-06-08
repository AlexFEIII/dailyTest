package com.pro.daily.dailyRepository.UserPackageRepository;

import com.pro.daily.domain.DailyUserPackage.DailyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DailyUser,Integer> {
    DailyUser findByUsername(String user);
}
