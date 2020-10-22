package Utils;


import Datos.DataModel;
import Location.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class DataManager {

    private DataModel data = new DataModel();

    public DataManager(){
    }

    /**
     * Aquest mètode carrega la informació de C2H50H.json a la variable data.
     * Una vegada la informació s'hagi carregat, calculem les opcions que ens demana el programa.
     *
     */

    public DataModel loadData() {
        Gson gson = new Gson();
        ArrayList<Location> locations = new ArrayList<Location>();
        DataModel dataModel = new DataModel();
        try {
            JsonReader reader = new JsonReader(new FileReader("Data/localitzacions.json"));
            try{
                reader.beginObject();
                reader.nextName();
                JsonArray array_loc =  new JsonParser().parse(reader).getAsJsonArray();
                for(int i=0; i<array_loc.size(); i++){
                    JsonObject obj = array_loc.get(i).getAsJsonObject();
                    if(obj.has("architect")){
                        Monument monument = gson.fromJson(obj, Monument.class);
                        locations.add(monument);
                    }else if(obj.has("characteristics")){
                        Restaurant restaurant = gson.fromJson(obj, Restaurant.class);
                        locations.add(restaurant);
                    } else if(obj.has("stars")){
                        Hotel hotel = gson.fromJson(obj, Hotel.class);
                        locations.add(hotel);
                    } else{
                        Location location = gson.fromJson(obj, Location.class);
                        locations.add(location);
                    }
                }
                dataModel.setLocations(locations);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataModel;
    }
    /**
     * Comprobem que l'importació de data hagi importat correctament.:
     */
    public void importacioOk(){
        for(int i=0; i<data.getLocations().size(); i++){
            if(data.getLocations().get(i) instanceof Monument){
                System.out.println(data.getLocations().get(i).toString() + "\n");
            }
        }
    }

    /**
     * Funció 1:
     */


    /**
     * Funció 2:
     */

    /**
     * Funció 3:
     */


    /**
     * Funció 4:
     */


}
