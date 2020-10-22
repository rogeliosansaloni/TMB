package Location;

import java.util.Arrays;

public class Location {
    private String name;
    private double[] coordinates;
    private String description;

    public Location(String name, double[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }

    public Location(String name, double longitud, double latitud, String description) {
        this.name = name;
        this.coordinates = new double[2];
        this.coordinates[0] = longitud;
        this.coordinates[1] = latitud;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + "\n" +
                ", coordinates=" + Arrays.toString(coordinates) + "\n" +
                ", description='" + description + "\n" ;
    }
}
