import java.io.*;
import java.nio.file.*;
import java.time.LocalTime;

public class Backup implements Runnable {
    private final String sourceFilePath;
    private final String backupFilePath;
    private boolean running = true; // Flag to control the thread

    public Backup(String sourceFilePath, String backupFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.backupFilePath = backupFilePath;
    }

    @Override
    public void run() {
        while (running) {
            LocalTime currentTime = LocalTime.now();
            if (currentTime.getHour() >= 3 && currentTime.getHour() < 4) {
                try {
                    // Perform the backup
                    Files.copy(Paths.get(sourceFilePath), Paths.get(backupFilePath), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Backup created at " + currentTime);

                    // Sleep until 4 AM to avoid multiple backups within the hour
                    Thread.sleep(60 * 60 * 1000); // 1 hour in milliseconds
                } catch (IOException e) {
                    System.err.println("Error during backup: " + e.getMessage());
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                }
            } else {
                try {
                    // Sleep for 1 minute before checking the time again
                    Thread.sleep(60 * 1000); // 1 minute in milliseconds
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                }
            }
        }
    }

    // Method to stop the backup thread gracefully
    public void stopBackup() {
        running = false;
    }

    public static void main(String[] args) {
        // Example usage
        String sourceFilePath = "call_summaries.txt";
        String backupFilePath = "call_summaries_backup.txt";
        Backup backup = new Backup(sourceFilePath, backupFilePath);
        (new Thread(backup)).start();
        System.console().readLine("Press any key to stop the the backup thread: \n");
        backup.stopBackup();
    }
}