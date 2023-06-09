package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class BoardApiUpdateTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BoardSaveService saveService;

    @Autowired
    private BoardInfoService infoService;

    private String getParam(String subject, String content) {
        String params = String.format("{\"subject\":\"%s\", \"content\":\"%s\"}", subject, content);
        // JSON -> { "subject":"%s", "content":"%s" }
        return params;
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

    @BeforeEach
    void init() {
        getParams();
    }
    
    @Test
    @DisplayName("게시글 수정 성공시 응답코드 201")
    void updateSuccessTest() throws Exception {
        // 제목, 내용 모두 수정
        String param = getParam("(수정)제목","(수정)내용");
        mockMvc.perform(post("/api/board/update/1")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());
        // 제목만 수정
        BoardData item = infoService.get(2L);
        param = getParam("(수정)제목",item.getContent());
        mockMvc.perform(post("/api/board/update/2")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());
        // 내용만 수정
        item = infoService.get(3L);
        param = getParam(item.getSubject(),"(수정)내용");
        mockMvc.perform(post("/api/board/update/3")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());
    }

}
