package Utils;

import java.util.Scanner;

import Datos.DataModel;
import User.*;

public class Menu {
    private int opcio;
    private Scanner sc;
    private DataManager dt;

    public Menu(DataManager dt) {
        this.dt = dt;
    }

    /**
     * En les mètodes seguents son la informacio que es mostra al usuari desde  que executa el programa
     * fins  que l'usuari trii una funcionalitat de les opcions que hem printat per la pantalla
     */

    public void printMenu(){

        System.out.println("\n"+"1.Gestió d'usuari.");
        System.out.println("2.Buscar localitazacions");
        System.out.println("3.Planejar Ruta");
        System.out.println("4.Temps d'espera en el bus");
       System.out.println("5.Sortir.");
    }

    public void preguntarOpcio(User user, DataModel data){
        System.out.println("\nSelecciona una opció:");
        sc = new Scanner(System.in);
        opcio = sc.nextInt();
        funcionalitats(opcio, user, data);
    }

    /**
     * El switch on s'executa cada funcionalitat dels que triarà l'usari.
     */

    public void funcionalitats(int opcio, User user, DataModel data){
        switch (opcio) {
            case 1:
                user.gestioUsuari(data);
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:
                UserJsonManager userManager = new UserJsonManager();
                userManager.actualitzaFitxer(user);
                System.exit(1);
                break;
        }
    }

    /**
     * Comprobacio que l'opcio que hagi triat l'usuai sigui valida.
     */
    public boolean validarOpcio() {
        return opcio >= 1 && opcio <= 6;
    }

    public boolean exit (){
        return false;
    }
}
