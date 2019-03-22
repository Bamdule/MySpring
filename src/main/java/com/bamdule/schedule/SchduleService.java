package com.bamdule.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author MW
 */
@Service
public class SchduleService {

    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "10 * * * * ? ")
    public void doSchedule() {
        logger.info("Spring Schedule Start!");
    }
}
