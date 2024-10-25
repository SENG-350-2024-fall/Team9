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

    public static double getDistanceBetweenCoordinates(double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 6731 * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return c; // Distance in kilometers
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Localizer");
        System.out.println("View the Hospitals Located Nearby You");
        HospitalLocalizer hospitalLocalizer = new HospitalLocalizer();

        Double userLat = hospitalLocalizer.getUserLatitude();
        Double userLon = hospitalLocalizer.getUserLongitude();
        Double royalJubileeLat = 48.43296642000432;
        Double royalJubileeLon = -123.32755803414138;

        Double distanceToRoyalJubilee = getDistanceBetweenCoordinates(userLat, userLon, royalJubileeLat, royalJubileeLon);
        System.out.printf("Distance to Royal Jubilee Hospital: %.2f km", distanceToRoyalJubilee);
    }
}
