package Datos;

import Location.Location;
import java.util.ArrayList;

public class DataModel {
    private ArrayList<Location> locations;

    public DataModel() {
        this.locations = new ArrayList<Location>();
    }

    public DataModel(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<this.locations.size(); i++){
            result += this.locations.get(i).toString();
        }
        return result;
    }

    public void afegeixLocalitzacio (Location location){
        this.locations.add(location);
    }
}
