package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

public class Exam02Test {
    @TempDir            // 임시파일을 저장하고 테스트 후 삭제
    private File file;
    
    @Test
    @DisplayName("임시파일 생성 테스트")
    void test1() {
        String path = file.getPath();
        System.out.println(path);
    }
    
    void destroy() {
        file.delete();
        System.out.println("임시파일 삭제");
    }
}
