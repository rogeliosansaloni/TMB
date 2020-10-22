import Utils.DataManager;
import Utils.Menu;
import Datos.DataModel;
import User.*;
import Utils.UserJsonManager;

/**
 * Main class del programa.
 *
 * @autor Mary Grace Adina Dacuycuy
 *
 */

public class Main {
    public static void main(String[] args) {
        DataManager data = new DataManager();
        DataModel dataModel = data.loadData();
        Menu menu = new Menu(data);
        User user = new User();
        UserJsonManager userManager = new UserJsonManager();
        User userJson = userManager.extreuUser();
        if(userJson != null){
            user = userJson;
        } else{
            user.inicialitzaUsuari();
        }

        //Mentre que l'opció 6 no sigui seleccionat
        do{
            menu.printMenu();
            //Preguntem per una opció mentre que quest sigui vàlida.
            do {
                menu.preguntarOpcio(user, dataModel);
            } while (!menu.validarOpcio());
        } while (!menu.exit());
    }

}