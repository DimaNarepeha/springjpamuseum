package ua.home.dao;

import org.springframework.stereotype.Repository;
import ua.home.entity.Test;

import javax.transaction.Transactional;


public interface TestDAO {
    public void save();

}
