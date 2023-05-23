package org.koreait.schedules;

import org.koreait.models.board.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BoardStatScheduler {
    @Autowired
    private BoardDao boardDao;

    @Scheduled(cron = "0 0 1 * * *")    // 매일 새벽 1시에 메서드 작동
//    @Scheduled(cron = "*/5 * * * * *")
    public void process() {
        boardDao.processStat();
    }
}
