package com.yunjae;

import com.yunjae.service.RemoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * MockBean 사용하기
 * RemoteService Bean 교체
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RemoteMockTest {


    //@SpyBean
    @MockBean
    RemoteService remoteService;

    @Autowired
    private TestRestTemplate client;


    @Test
    public void testRemoteMock() {
        // @MockBean 아래의 구문이 없으면 no content 리턴  - 객체를 새로 만듬
        // @SpyBean 아래의 구문이 없으면 원래 메소드 호출  - 기존 객체 래핑함
        given(remoteService.remote()).willReturn("Mock");

        String body = client.getForObject("/remote", String.class);
        //assertThat(body).isEqualTo("Remote Service");
        assertThat(body).isEqualTo("Mock");
    }

}
