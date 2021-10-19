package com.amsidh.mvc.springbootschedulerexample;

import com.amsidh.mvc.springbootschedulerexample.service.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private final InstanceInformationService instanceInformationService;

    @Scheduled(fixedRate = 300000) // 5 minutes
    @SchedulerLock(name = "ScheduledTask.performTask", lockAtLeastFor = "3m")
    public void performTask() {
        log.info("FixedRate 5 minutes and  lockAtMostFor 10m " + dateFormat.format(new Date()) + " and instance name is :" + instanceInformationService.retrieveInstanceInfo());
    }

    @Scheduled(cron = "0 * * * * *")
    @SchedulerLock(name = "ScheduledTask.shortRunningTask", lockAtMostFor = "50s", lockAtLeastFor = "30s")
    public void shortRunningTask() {
        log.info("cron 0 * * * * * and  lockAtMostFor 50s and lockAtLeastFor 30s " + dateFormat.format(new Date()) + " and instance name is :" + instanceInformationService.retrieveInstanceInfo());
    }

}
