package com.yunjae;

import com.yunjae.controller.SampleController;
import com.yunjae.service.HelloService;
import com.yunjae.service.RemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest Controller 만 주입 받음
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class WebMvcSampleTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HelloService helloService;

    @MockBean
    RemoteService remoteService;

    @Test
    public void testFoo() throws Exception {
        given(remoteService.remote()).willReturn("Yunjae");

        mockMvc.perform(get("/remote"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("remote"))
                .andExpect(status().isOk())
                .andExpect(content().string("\"Yunjae\""));

    }
}
