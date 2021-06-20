package com.example.demo.accountTest;

import com.example.demo.controllers.LoginController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

/**
 * @author 青菜白玉堂
 * @create 2021-06-20
 */
@SpringBootTest
public class LoginControllerTest {

    @Resource
    private LoginController loginController;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }


    @Test
    public void loginTest() {
        try {
            MvcResult result = mvc.perform(
                    MockMvcRequestBuilders.post("/login")
                    .accept(MediaType.APPLICATION_JSON)
                    .param("username", "hello")
                    .param("password", "123456")
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
