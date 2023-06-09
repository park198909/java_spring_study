package org.koreait.tests.apitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class BoardApiSaveTest {
    @Autowired
    private MockMvc mockMvc;

    public String getParam(String subject, String content) {
        String param = String.format("{\"subject\" : \"%s\",\"content\" : \"%s\"}",subject,content);
        return param;
    }

    @Test
    @DisplayName("게시글 저장 성공 하면 응답상태코드 201")
    void saveSuccessTest() throws Exception{
        String param = getParam("제목","내용");
        mockMvc.perform(post("/api/board/write")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("필수항목(제목, 내용) 없을 경우 BAD_REQUEST 문구 발생")
    void requiredFieldTest() throws Exception {
        // 제목이 없을 경우
        String param = getParam("", "내용");
        String body = mockMvc.perform(post("/api/board/write")
                        .contentType("application/json")
                        .content(param)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));
        assertTrue(body.contains("제목을 입력"));
        
        // 내용이 없을 경우
        param = getParam("제목", "");
        body = mockMvc.perform(post("/api/board/write")
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
