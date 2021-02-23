package com.angelo.restservice.RestApp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorld.class)
@ContextConfiguration(classes = {FancyWriter.class, HelloWorld.class, RegularWriter.class})
class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("RegularWriter")
    TextWriter regular;

    @MockBean
    @Qualifier("FancyWriter")
    TextWriter fancy;

    @Test
    void testHappy() throws Exception{
        when(fancy.writeText("hi hello")).thenReturn("hi mock text");
        MvcResult result = this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(), "hi mock text");
    }
}