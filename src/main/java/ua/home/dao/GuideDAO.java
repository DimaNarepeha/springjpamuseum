package ua.home.dao;

import ua.home.entity.Guide;

import java.util.List;

//
//@Repository
//@Transactional

public interface GuideDAO /*extends GenericDAO<Guide, Integer>*/ {
      Integer save(Guide guide);
     List<Guide> findAll();
     Guide update(Guide guide);
      void deleteById(Integer guide_id);
     Guide findById(Integer find_department_id);


}
