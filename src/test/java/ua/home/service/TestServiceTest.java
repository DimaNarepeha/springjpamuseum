//package ua.home.service;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import ua.home.Config;
//import ua.home.exception.NotFoundException;
//
//import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {Config.class})
//@WebAppConfiguration
//public class TestServiceTest {
//    @Rule
//    public ExpectedException exceptionRule = ExpectedException.none();
//    @Autowired
//    TestService testService;
//   /* @Test
//    public void whenEnteringNumber_thenNumberIsStored() {
//        testService.save(2222);
//        assertTrue(testService.get(1).getNumber()==2222);
//    }*/
//        @Test
//        public void whenExceptionThrown_thenAssertionSucceeds() {
//            exceptionRule.expect(NotFoundException.class);
//            exceptionRule.expectMessage("No such element in database!!!");
//            testService.get(2);
//    }
//
//
//
//}