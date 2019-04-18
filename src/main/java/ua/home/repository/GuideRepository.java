package ua.home.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.home.entity.Guide;
import ua.home.entity.Test;

import java.util.List;

@Repository
@Transactional
public interface GuideRepository extends CrudRepository<Guide, Integer> {

    List<Guide> findAll();
}
