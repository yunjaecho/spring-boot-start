package com.yunjae;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@AutoConfigureWebTestClient   // webflux
//@Import(TestConfig.class)
public class SampleControllerTest {

    // inner class 시  @TestConfiguration scanning 대상
    //@TestConfiguration
//    @Configuration
//    @ComponentScan(basePackageClasses = Application.class)
//    static class TestConf {
//        @Bean
//        public String myBean() {
//            return "hello";
//        }
//    }

    @LocalServerPort
    int port;

    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    String myBean;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private TestRestTemplate client;

    // @AutoConfigureWebTestClient 반드시 지정
    // webflux 용
    //@Autowired
    //private WebTestClient webTestClient;



    @Test
    public void testFood() throws Exception {
        System.out.println("===================== PORT ========================");
        System.out.println(port);

        //assertThat(myBean).isNotNull();
        assertThat(mockMvc).isNotNull();
        mockMvc.perform(get("/food"))
                .andExpect(status().isOk())
                .andExpect(content().string("\"Hello\""))
                .andDo(print());

    }


    @Test
    public void testFoodWithWebTestClient() {
        String body = client.getForObject("/food", String.class);
        assertThat(body).isEqualTo("Hello");
    }

//    @Test
//    public void testhWebTestClient() {
//        webTestClient.get().uri("/food").exchange()
//                .expectStatus().isOk()
//                .expectBody(String.class).isEqualTo("Hello");
//    }


    @Test
    public void testRemoteMock() {
        String body = client.getForObject("/remote", String.class);
        assertThat(body).isEqualTo("Remote Service");

        //given(remoteService.remote()).willReturn("Mock")
    }
}
