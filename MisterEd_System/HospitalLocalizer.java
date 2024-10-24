import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;

public class HospitalLocalizer {
    private String userLatitude; 
    private String userLongitude;

    public HospitalLocalizer () {
        try {
            // Define the API URL for fetching location based on IP
            URL url = new URL("https://ipinfo.io/json");
            
            // Create a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                if(inputLine.contains("loc")) {
                    response.append(inputLine);
                    break;
                }
            }
            reader.close();
            
            this.userLatitude = response.toString().split("[\",]")[3];
            this.userLongitude = response.toString().split("[\",]")[4];

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getUserLatitude () {
        return Double.parseDouble(userLatitude);
    }

    public double getUserLongitude () {
        return Double.parseDouble(userLongitude);
    }

    public String[] getNearbyHospitals () {
        String[] nearbyHospitals = {"","",""};
        return nearbyHospitals; 
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Localizer");
        System.out.println("View the Hospitals Located Nearby You");
        HospitalLocalizer hospitalLocalizer = new HospitalLocalizer();
        System.out.println(hospitalLocalizer.getUserLatitude());
        System.out.println(hospitalLocalizer.getUserLongitude());
    }
}
