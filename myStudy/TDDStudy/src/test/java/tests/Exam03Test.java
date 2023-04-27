package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class Exam03Test {

    @Test
    @DisplayName("Timeout test")
    @Timeout(value = 1000, unit= TimeUnit.MILLISECONDS) // 1초안에 수행해야 통과
    void test1() {
        try {
            Thread.sleep(2000);         // 딜레이 2초
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
