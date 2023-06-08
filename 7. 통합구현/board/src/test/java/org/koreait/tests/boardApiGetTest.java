package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardForm;
import org.koreait.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class boardApiGetTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BoardSaveService saveService;

    @BeforeEach
    void init() {
        getParams();
    }

    private void getParams() {
        for (int i=1; i<=5; i++) {
            BoardForm item = new BoardForm();
            item.setId((long) i);
            item.setSubject("테스트 글제목"+ i);
            item.setContent("테스트 글내용"+ i);
            saveService.save(item);
        }
    }

    @Test
    @DisplayName("게시글 조회 성공 시 응답상태코드 200, 게시글 출력")
    void getSuccessTest() throws Exception {
        String body = mockMvc.perform(get("/api/board/get/1")
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
//                .andReturn()
//                .getResponse()
//                .getContentAsString(Charset.forName("UTF-8"));
        System.out.println(body);
    }

    @Test
    @DisplayName("게시글 조회 실패 시 Bad_Request, 문구 발생 ")
    void getFailureTest() throws Exception {
        String body = mockMvc.perform(get("/api/board/get/6")
                        .contentType("application/json"))
                .andReturn() // 요청과 응답의 데이터를 출력하는 기능(MockMvcResultHandlers)
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("게시글 조회에 실패"));
    }
}


