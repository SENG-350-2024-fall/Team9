import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;

public class LocationFetcher {
    private String latitude; 
    private String longitude;

    public LocationFetcher () {
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
            
            this.latitude = response.toString().split("[\",]")[3];
            this.longitude = response.toString().split("[\",]")[4];

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getLatitude () {
        return Double.parseDouble(latitude);
    }

    public double getLongitude () {
        return Double.parseDouble(longitude);
    }

    public String getNearbyHospitals () {
        String[] hospitalArray = new String[5]; 
        hospitalArray[0] = "Royal Jubilee Hospital";
        hospitalArray[1] = "Victoria General Hospital";
        hospitalArray[2] = "Saanich Peninsula Hospital";
        hospitalArray[3] = "";
        hospitalArray[4] = 50;

    }

    public static void main(String[] args) {
        LocationFetcher locationFetcher = new LocationFetcher();
        System.out.println(locationFetcher.getLatitude());
        System.out.println( locationFetcher.getLongitude());
    }
}
