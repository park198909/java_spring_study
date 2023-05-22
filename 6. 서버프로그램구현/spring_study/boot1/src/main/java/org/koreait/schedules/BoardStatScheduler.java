package org.koreait.schedules;

import lombok.extern.java.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log
@Component
public class BoardStatScheduler {

//    @Scheduled(cron = "0 0 1 * * *")  // 새벽1시 마다 실행
    @Scheduled(cron = "*/5 * * * * *")  // 5초 마다 실행
    public void process() {
//        log.info("5초 마다 실행");
    }
}
