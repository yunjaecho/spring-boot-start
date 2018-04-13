package com.yunjae;

import com.yunjae.service.RemoteService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseActions;

import javax.net.ssl.SSLPeerUnverifiedException;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(RemoteService.class)
public class RestClientSampleTest {

    @Autowired
    RemoteService remoteService;

    @Autowired
    MockRestServiceServer server;


    @Test
    public void testJson() {
        ResponseActions responseActions = server.expect(requestTo("/food"));
        responseActions.andRespond(withSuccess("yunaje", MediaType.TEXT_PLAIN));

        String name = remoteService.getName();
        Assertions.assertThat(name).isEqualTo("yunaje");


        //System.out.println(restSampleServiceImpl.getName());
    }
}
