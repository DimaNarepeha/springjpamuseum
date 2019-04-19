//package ua.home.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ua.home.entity.Test;
//import ua.home.exception.NotFoundException;
//import ua.home.repository.TestRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class TestService {
//  private Integer number;
//    @Autowired
//    TestRepository testRepository;
//    @Transactional
//    public void save(Integer number){
//        Test test = new Test();
//       // test.setId(id);
//        test.setNumber(number);
//        testRepository.save(test);
//    }
//
//    @Transactional
//    public Test get(Integer id){
//       if(!testRepository.existsById(id)){
//           throw new NotFoundException("No such element in database!!!");
//       }
//     Test byId = testRepository.findById(id).get();
//     number = byId.getNumber();
//     return byId;
//    }
//
//
//
//}
