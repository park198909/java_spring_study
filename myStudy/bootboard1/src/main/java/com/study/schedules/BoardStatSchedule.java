package com.study.schedules;

import com.study.models.board.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BoardStatSchedule {

    @Autowired
    private BoardDao boardDao;

    @Scheduled(cron = "0 0 1 * * *")    // 새벽 1시에 실행
    public void process() {
        boardDao.processStat();
    }
}
