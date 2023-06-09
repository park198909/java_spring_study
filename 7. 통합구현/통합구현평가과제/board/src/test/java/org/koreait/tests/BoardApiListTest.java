package org.koreait.tests;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class BoardApiListTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BoardSaveService saveService;

    void getParams() {
        for (long i=1; i<=5; i++) {
            BoardForm boardForm = BoardForm.builder()
                    .id(i)
                    .subject("제목"+i)
                    .content("내용"+i)
                    .build();
            saveService.save(boardForm);
        }
    }

    @Test
    @DisplayName("게시글 목록 조회 성공시 응답코드 200, 리스트 출력")
    void listSuccessTest() throws Exception{
        getParams();
        String body = mockMvc.perform(get("/api/board/list")
                .contentType("application/json")
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        System.out.println(body);
    }

}
