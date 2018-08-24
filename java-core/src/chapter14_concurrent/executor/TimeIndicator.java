package chapter14_concurrent.executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This program demonstrates ScheduledExecutorService, which will print the datetime at every minute start
 */
public class TimeIndicator {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new TimeIndicatingTask(),
                (60 - LocalDateTime.now().getSecond()),
                60,
                TimeUnit.SECONDS);
    }

}

/**
 * time indicating task
 */
class TimeIndicatingTask implements Runnable {
    @Override
    public void run() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
