package org.koreait.tests.apitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardForm;
import org.koreait.models.board.BoardDeleteService;
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
public class BoardApiListTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BoardSaveService saveService;
    @Autowired
    private BoardDeleteService deleteService;

    public String getParam(String subject, String content) {
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

    public void deleteDatas() {
        for (long i=1; i<=5; i++) {
            deleteService.delete(i);
        }
    }

    @Test
    @DisplayName("리스트 조회 성공하면 응답상태코드 200")
    void listSuccessTest() throws Exception {
        getDatas();     // 테스트 데이터 5개 생성
        mockMvc.perform(get("/api/board/list")
                        .contentType("application/json")
                ).andDo(print())
                .andExpect(status().isOk());
        deleteDatas();  // 생성한 테스트 데이터 삭제
    }

    @Test
    @DisplayName("리스트 조회 실패하면 BAD_REQUEST 문구 발생")
    void listFailTest() throws Exception{
        String body = mockMvc.perform(get("/api/board/list")
                                    .contentType("application/json")
                            ).andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("리스트 조회에 실패"));
    }
    
}
