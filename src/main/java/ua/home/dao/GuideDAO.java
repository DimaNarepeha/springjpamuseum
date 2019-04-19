package ua.home.dao;

import ua.home.entity.Guide;

import java.util.List;
import java.util.Map;

//
//@Repository
//@Transactional

public interface GuideDAO /*extends GenericDAO<Guide, Integer>*/ {
      Guide save(Guide guide);
     List<Guide> findAll();
     Guide update(Guide guide);
     Guide deleteById(Integer guide_id);
     Guide findById(Integer find_department_id);

    Map<String, List<String>> getGuidesByExhibit();
}
