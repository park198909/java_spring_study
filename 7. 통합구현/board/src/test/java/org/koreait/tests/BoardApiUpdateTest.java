package org.koreait.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardForm;
import org.koreait.entities.BoardData;
import org.koreait.models.board.BoardInfoService;
import org.koreait.models.board.BoardSaveService;
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
public class BoardApiUpdateTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BoardSaveService saveService;
    @Autowired
    private BoardInfoService infoService;

    private void getParams() {
        for (int i=1; i<=5; i++) {
            BoardForm item = new BoardForm();
            item.setId((long) i);
            item.setSubject("테스트 글제목"+ i);
            item.setContent("테스트 글내용"+ i);
            saveService.save(item);
        }
    }

    private String getParam(String subject, String content) {
        String param = String.format("{\"mode\":\"update\",\"subject\":\"%s\",\"content\":\"%s\"}",subject,content);

        return param;
    }

    @Test
    @DisplayName("게시글 수정 성공시 응답코드 201")
    void updateSuccessTest() throws Exception {
        getParams();

        // 제목, 내용 모두 수정할 경우
        String param = getParam("(수정)테스트 글제목", "(수정)테스트 글내용");
        mockMvc.perform(post("/api/board/update/1")
                .contentType("application/json")
                .content(param))
                .andDo(print())
                .andExpect(status().isCreated());

        // 제목만 수정할 경우
        BoardData item = infoService.get(2L);
        param = getParam("(수정)테스트 글제목", item.getContent());
        mockMvc.perform(post("/api/board/update/2")
                        .contentType("application/json")
                        .content(param))
                .andDo(print())
                .andExpect(status().isCreated());

        // 내용만 수정할 경우
        item = infoService.get(3L);
        param = getParam(item.getSubject(), "(수정)테스트 글내용");
        mockMvc.perform(post("/api/board/update/3")
                        .contentType("application/json")
                        .content(param))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("필수항목(제목) 누락시 발생 문구 테스트")
    void requiredSubjectTest() throws Exception {
        getParams();
        String param = getParam("", "(수정)테스트 글내용");
        String body = mockMvc.perform(post("/api/board/update/1")
                        .contentType("application/json")
                        .content(param))
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("제목을 입력"));
    }

    @Test
    @DisplayName("필수항목(내용) 누락시 발생 문구 테스트")
    void requiredContentTest() throws Exception {
        getParams();
        String param = getParam("(수정)테스트 글제목", "");
        String body = mockMvc.perform(post("/api/board/update/1")
                        .contentType("application/json")
                        .content(param))
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("내용을 입력"));
    }
}
