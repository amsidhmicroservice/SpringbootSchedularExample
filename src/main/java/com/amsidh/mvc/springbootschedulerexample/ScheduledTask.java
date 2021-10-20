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

    //By setting lockAtMostFor we make sure that the lock is released even if the node dies
    // and by setting lockAtLeastFor we make sure it's not executed more than once in three minutes.
    // Please note that lockAtMostFor is just a safety net in case that the node executing the task dies,
    // so set it to a time that is significantly larger than maximum estimated execution time.
    // If the task takes longer than lockAtMostFor, it may be executed again and the results will be unpredictable (more processes will hold the lock).
    @Scheduled(cron = "0 */3 * * * *")
    @SchedulerLock(name = "ScheduledTask.shortRunningTask", lockAtMostFor = "2m", lockAtLeastFor = "2m")
    public void shortRunningTask() {
        log.info("cron 0 */3 * * * * and  lockAtMostFor 2m and lockAtLeastFor 2m " + dateFormat.format(new Date()) + " and instance name is :" + instanceInformationService.retrieveInstanceInfo());
    }

}
