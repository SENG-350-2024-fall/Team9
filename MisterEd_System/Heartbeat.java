import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Heartbeat implements Runnable {
    private long interval; // interval of milliseconds
    private boolean running = true; // Flag to control the thread

    public Heartbeat(long interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); 
                System.out.println(dateTime + ": Mr. ED is running, please proceed with previous instruction: ");
                Thread.sleep(interval); // Sleep(milliseconds)
            } catch (InterruptedException e) {
                System.out.println("An issue occurred in Mr. ED: " + e.getMessage());
                running = false; // Stop the loop if interrupted
            }
        }
    }

    // Method to stop the heartbeat thread gracefully
    public void stopHeartbeat() {
        running = false;
    }
}