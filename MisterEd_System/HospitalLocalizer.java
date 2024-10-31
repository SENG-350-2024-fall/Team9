import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.io.Console;
import java.util.Random;

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
        Double saanichPeninsulaLat = 48.59984938647225;
        Double saanichPeninsulaLon = -123.41109781238133; 
        Double cowichanDistrictLat = 48.79030179683916;
        Double cowichanDistrictLon = -123.72429264529113;
        Double victoriaGeneralLat = 48.47349136416142;
        Double victoriaGeneralLon = -123.43558640940434;

        Double distanceToRoyalJubilee = getDistanceBetweenCoordinates(userLat, userLon, royalJubileeLat, royalJubileeLon);
        System.out.printf("Distance to Royal Jubilee Hospital: %.2f km\n", distanceToRoyalJubilee);
        Double distanceToSaanichPeninsula = getDistanceBetweenCoordinates(userLat, userLon, saanichPeninsulaLat, saanichPeninsulaLon);
        System.out.printf("Distance to Saanich Peninsula Hospital: %.2f km\n", distanceToSaanichPeninsula);
        Double distanceToCowichanDistrict = getDistanceBetweenCoordinates(userLat, userLon, cowichanDistrictLat, cowichanDistrictLon);
        System.out.printf("Distance to Cowichan District Hospital: %.2f km\n", distanceToCowichanDistrict);
        Double distanceToVictoriaGeneral = getDistanceBetweenCoordinates(userLat, userLon, victoriaGeneralLat, victoriaGeneralLon);
        System.out.printf("Distance to Victoria General Hospital: %.2f km\n", distanceToVictoriaGeneral);

        Console prompter = System.console(); 
        String viewWaitTimes = prompter.readLine("Would you like to view the wait times of these local hospitals? Enter Yes or No: ");
        if(viewWaitTimes.toLowerCase().contains("no")) {
            return;
        }

        Random random = new Random();
        System.out.println("Royal Jubilee Hospital: " + (120 + 300 * random.nextInt(99) / 100) + " mins");
        System.out.println("Saanich Peninsula Hospital: " + (120 + 300 * random.nextInt(99) / 100) + " mins");
        System.out.println("Cowichan District Hospital: " + (120 + 300 * random.nextInt(99) / 100) + " mins");
        System.out.println("Victoria General Hospital: " + (120 + 300 * random.nextInt(99) / 100) + " mins");
    }
}