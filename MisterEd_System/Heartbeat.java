import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Heartbeat implements Runnable {
    private static Heartbeat instance; // Singleton instance
    private static final Object lock = new Object(); // Lock for thread safety
    private long interval; // interval of milliseconds
    private boolean running = true; // Flag to control the thread

    // Private constructor to prevent instantiation from outside
    private Heartbeat(long interval) {
        this.interval = interval;
    }

    // Public method to get the Singleton instance
    public static Heartbeat getInstance(long interval) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Heartbeat(interval);
                }
            }
        }
        return instance;
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