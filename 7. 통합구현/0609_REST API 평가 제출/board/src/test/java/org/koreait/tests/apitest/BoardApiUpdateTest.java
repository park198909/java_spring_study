package org.koreait.tests.apitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardForm;
import org.koreait.entities.BoardData;
import org.koreait.models.board.BoardDeleteService;
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
    @Autowired
    protected BoardDeleteService deleteService;

    public String getParam(String subject, String content) {
        String param = String.format("{\"subject\" : \"%s\",\"content\" : \"%s\"}",subject,content);
        return param;
    }

    public void deleteDatas() {
        for (long i=1; i<=5; i++) {
            deleteService.delete(i);
        }
    }

    public String getUpdateParam(String subject, String content) {
        String param = String.format("{\"subject\" : \"%s\",\"content\" : \"%s\"}",subject,content);
        return param;
    }

    public void getDatas() {        // 테스트 데이터 5개 저장
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
    @DisplayName("게시글 수정 성공하면 응답상태코드 201")
    void updateSuccessTest() throws Exception {
        getDatas();
        // 제목, 내용 모두 변경
        String param = getParam("(수정)제목","(수정)내용");
        mockMvc.perform(post("/api/board/update/1")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());
        // 제목만 변경
        BoardData item = infoService.get(2L);
        param = getParam("(수정)제목",item.getContent());
        mockMvc.perform(post("/api/board/update/2")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());
        // 내용만 변경
        item = infoService.get(3L);
        param = getParam(item.getSubject(), "(수정)내용");
        mockMvc.perform(post("/api/board/update/3")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());

        deleteDatas();
    }

    @Test
    @DisplayName("게시글 수정 실패하면 BAD_REQUEST 문구 발생")
    void updateFailTest() throws Exception {
        getDatas();
        // id 가 없는 번호일 경우
        String param = getParam("(수정)제목", "(수정)내용");
        String body = mockMvc.perform(post("/api/board/update/10")   // id를 없는 번호로 지정
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("등록되지 않은 게시글"));

        // 제목이 없을 경우
        param = getParam("", "(수정)내용");
        body = mockMvc.perform(post("/api/board/update/1")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("제목을 입력"));

        // 내용이 없을 경우
        param = getParam("(수정)제목", "");
        body = mockMvc.perform(post("/api/board/update/1")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("내용을 입력"));
    }

}
