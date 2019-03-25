package ua.home.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ua.home.Config;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@WebAppConfiguration
public class TestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }
    @Test
    public void givenGameURI_whenMockMVC_thenGetStatus() throws Exception {

        mockMvc.perform(post("/create{number}", 5))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenGreetURI_whenMockMVC_thenGetContentType() throws Exception {

        mockMvc.perform(post("/create{number}", 5));
        mockMvc.perform(get("/read{number}", 1))
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void givenGreetURI_whenMockMVC_thenGetJson() throws Exception {
        mockMvc.perform(post("/create{number}", 5));
        mockMvc.perform(get("/read{number}",1))
                .andExpect(jsonPath("$.number").value(5));
    }
}