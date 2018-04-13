package com.yunjae;

import com.yunjae.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Rest 호출한 Document 생성
 * 위치 : /target/generated-snippets/문서명
 * 추가할 어노테이션 @AutoConfigureRestDocs
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureRestDocs
public class RestDocsSampleTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SampleService sampleService;

    /**
     * 메소드 이름 기준으로 모든 데스트의 문서 생성
     */
    @TestConfiguration
    static class ResultHandlerConfiguration {

        @Bean
        public RestDocumentationResultHandler restDocumentation() {
            return MockMvcRestDocumentation.document("{method-name}");
        }

    }

    @Test
    public void testFood() throws Exception {
        given(sampleService.message()).willReturn("Yunjae");

        mockMvc.perform(get("/message"))
                .andExpect(status().isOk())
                .andExpect(content().string("Yunjae"))
                //.andDo(document("message"))  // RestDocumentationResultHandler 빈이 생성시 필요없음
        ;
    }

}
