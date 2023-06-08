package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class BoardApiSaveTest {

    @Autowired
    private MockMvc mockMvc;

    private String getParams(String subject, String content) {
        String params = String.format("{\"subject\":\"%s\", \"content\":\"%s\"}", subject, content);
        // JSON -> { "subject":"%s", "content":"%s" }
        return params;
    }

    @Test
    @DisplayName("게시글 작성 성공 시 응답 코드 201")
    void saveSuccessTest() throws Exception {
        String params = getParams("테스트 제목", "테스트 내용");
        mockMvc.perform(post("/api/board/write")
                        .contentType("application/json")
                        .content(params))
                .andDo(print()) // 요청과 응답의 데이터를 출력하는 기능(MockMvcResultHandlers)
                .andExpect(status().isCreated());   // assertTrue
    }

    @Test
    @DisplayName("필수 항목(제목) 누락 시 발생 문구 테스트")
    void requiredSubjectTest() throws Exception {
        String params = getParams("", "테스트 내용");

        String body = mockMvc.perform(post("/api/board/write")  // 작동할 URL
                        .contentType("application/json")                    // JSON 타입
                        .content(params))                       // 요청 바디 (request body)
                        .andReturn()                    // 응답 바디를 반환
                        .getResponse()                  // 웅답 바디
                        .getContentAsString(Charset.forName("UTF-8")); // 응답 body 데이터를 스트링으로 저장
        assertTrue(body.contains("제목을 입력"));
    }

    @Test
    @DisplayName("필수 항목(내용) 누락 시 발생 문구 테스트")
    void requiredContentTest() throws Exception {
        String params = getParams("테스트 제목", "");
        String body = mockMvc.perform(post("/api/board/write")
                        .contentType("application/json")
                        .content(params))
                        .andReturn()                                            // 결과값을 반환
                        .getResponse()
                        .getContentAsString(Charset.forName("UTF-8")); // 응답 body 데이터를 스트링으로 변환
        assertTrue(body.contains("내용을 입력"));

        System.out.println(body);
    }
}
