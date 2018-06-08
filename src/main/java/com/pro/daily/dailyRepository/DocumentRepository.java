package com.pro.daily.dailyRepository;

import com.pro.daily.domain.DailyDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<DailyDocument,Integer> {
    //根据上下重复类型查找
    List<DailyDocument> findByIstop15OrderByIdDesc(boolean a);
    List<DailyDocument> findByIslongOrderByIdDesc(boolean a);
    List<DailyDocument> findByIsbusinessOrderByIdDesc(boolean a);
    List<DailyDocument> findByIstenimageOrderByIdDesc(boolean a);
    List<DailyDocument> findByIsappOrderByIdDesc(boolean a);
    List<DailyDocument> findByIsthoughtOrderByIdDesc(boolean a);
    List<DailyDocument> findByIsmediumOrderByIdDesc(boolean a);
    List<DailyDocument> findByIsworldOrderByIdDesc(boolean a);

    //根据类型查找
    List<DailyDocument> findByTypeOrderByIdDesc(String str);

    //根据标题模糊查找
    List<DailyDocument> findByTitleLikeOrSontitleLike(String str1,String str2);

    DailyDocument findById(int id);
}
