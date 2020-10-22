package Utils;
import Location.Hotel;
import User.User;
import com.google.gson.*;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class UserJsonManager {


    public UserJsonManager() {
    }

    public void actualitzaFitxer(User user) {
        Gson gson = new Gson();
        try{
            FileReader file = new FileReader("Data/user.json");
            JsonElement userElement = new JsonParser().parse(file);
            JsonObject userObject = userElement.getAsJsonObject();
            //userObject.put("")
            User old_user = gson.fromJson(file, User.class);
            //old_user.setLocations(user.);
            FileWriter writer = new FileWriter("Data/user.json");
            //writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User extreuUser(){
        Gson gson = new Gson();
        User usuario_json = new User();
        try {
            JsonReader reader = new JsonReader(new FileReader("Data/user.json"));
            usuario_json =  gson.fromJson(reader, User.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usuario_json;
    }
}
