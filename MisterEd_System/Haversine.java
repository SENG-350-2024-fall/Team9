public class Haversine {
    private static final int EARTH_RADIUS = 6371; // Radius of the Earth in kilometers

    public static void main(String[] args) {
        double lat1 = 48.64711485447695; // First latitude
        double lon1 = -123.4290421715058; // First longitude
        double lat2 = 48.462260392199106; // Second latitude
        double lon2 = -123.31211129034777; // Second longitude

        double distance = haversine(lat1, lon1, lat2, lon2);
        System.out.printf("Distance: %.2f km%n", distance);
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // Distance in kilometers
    }
}
