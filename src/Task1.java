import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args)  {
        Long timestamp = Instant.now().getEpochSecond();
        Runnable timeLeft = () -> {
            System.out.println(Instant.now().getEpochSecond() - timestamp);
        };
        Runnable fiveSecondsLeft = () -> {
            boolean result = (Instant.now().getEpochSecond() - timestamp) % 5 == 0 && (Instant.now().getEpochSecond() - timestamp)>=5;
            if(result){
                System.out.println("Минуло 5 секунд");
            }
        };
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate(timeLeft, 1, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(fiveSecondsLeft, 0, 5, TimeUnit.SECONDS);
    }
}
