import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.Console;

public class SanityCheck implements Runnable {
    private long interval; // interval of milliseconds
    private boolean running = true; // Flag to control the thread
    private String urlString;

    public SanityCheck(String urlString, long interval) {
        this.urlString = urlString;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (running) { // Infinite loop to keep pinging
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000); // Set timeout to 5 seconds
                connection.setReadTimeout(5000);

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    System.out.println(urlString + " is running! Response code: " + responseCode + ", Please proceed with previous instruction:");
                } else {
                    System.out.println(urlString + " returned a non-OK response: " + responseCode);
                }
            } catch (IOException e) {
                System.out.println("Failed to ping " + urlString + ": " + e.getMessage());
                System.exit(0);
            }

            try {
                Thread.sleep(interval); // Wait for the default interval before next ping
            } catch (InterruptedException e) {
                System.out.println("Sanity check thread was interrupted: " + e.getMessage());
                break; // Exit the loop if the thread is interrupted
            }
        }
    }

    // Method to stop the sanity check thread gracefully
    public void stopSanityCheck() {
        running = false;
    }

    public static void main(String[] args) { 
        SanityCheck sanityCheck = new SanityCheck("https://ipinfo.io/json", 2500);
        (new Thread(sanityCheck)).start();
        // thread.start();

        System.out.println("Sanity checking initiated. You can do other things during the checking ...");
        System.console().readLine("Press any key to stop the the sanity check thread: \n");
        sanityCheck.stopSanityCheck();
    }   
}