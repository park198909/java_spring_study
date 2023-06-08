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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class BoardApiDeleteTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BoardSaveService saveService;

    private void getParams() {
        for (long i=1; i<=5; i++) {
            BoardForm item = new BoardForm();
            item.setId(i);
            item.setSubject("테스트 글제목"+ i);
            item.setContent("테스트 글내용"+ i);
            saveService.save(item);
        }
    }

    @Test
    @DisplayName("게시글 삭제 성공 시 응답코드 200")
    void deleteSuccessTest() throws Exception {
        getParams();    // DB에 임의의 값 5개 저장
        mockMvc.perform(get("/api/board/delete/1")
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("게시글 삭제 실패 시 Bad_Request, 문구 발생")
    void deleteFailureTest() throws Exception {
        String body = mockMvc.perform(
                get("/api/board/delete/1")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("삭제에 실패"));
    }
}
