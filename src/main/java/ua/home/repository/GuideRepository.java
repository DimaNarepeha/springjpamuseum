package ua.home.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.home.entity.Guide;

import java.util.List;

//@Repository
//@Transactional
public interface GuideRepository /*extends CrudRepository<Guide, Integer>*/ {
    List<Guide> findAll();
    void deleteById(Integer integer);
    Guide getGuideById(Integer integer);
    boolean existsById(Integer integer);
}
