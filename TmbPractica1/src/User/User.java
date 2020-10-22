package User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Datos.DataModel;
import Location.Location;
import Route.Route;
import Utils.Util;

public class User {
    private String name;
    private String email;
    private int birthyear;
    private ArrayList<Location> locationsCreated;
    //Roge: No sé si el historial va dentro de la clase User o en otro sitio.
    private ArrayList<Location> historial;
    private ArrayList<Route> routesCreated;

    public User() {
        locationsCreated = new ArrayList<Location>();
        historial = new ArrayList<Location>();
    }

    public void setLocations(ArrayList<Location> locationsCreated) {
        this.locationsCreated = locationsCreated;
    }

    public void inicialitzaUsuari(){
        System.out.println("Benvingut a l'aplicació de TMBJson! Si us plau, introdueix les dades que se't demanen.");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nNom d'usuari:");
        this.name = sc.next();
        System.out.println("\nCorreu electrònic:");
        this.email = sc.next();
        System.out.println("\nAny de naixement:");
        Util util = new Util();
        String birthyear = sc.next();
        while(!util.isNumeric(birthyear)){
            System.out.println("\nSi us plau, introdueix un any de naixement vàlid:");
            birthyear = sc.next();
        }
        this.birthyear = Integer.parseInt(birthyear);
        System.out.println("\nLa informació s'ha registrat amb èxit!\n");
    }


    public void gestioUsuari(DataModel data){
        int opcio;
        do{
            printOpcions();
            opcio = preguntarOpcio();
            switch (opcio) {
                case 1:
                    //Les meves localitzacions
                    gestionaLocalitzacions(data);
                    break;
                case 2:
                    //Historial de localitzacions
                    mostraHistorial();
                    break;
                case 3:
                    //Les meves rutes
                    mostraRutes();
                    break;

                case 4:
                    //Parades i estacions preferides
                    break;

                case 5:
                    //Estacions inaugurades el meu any de naixement
                    break;
            }
        } while(opcio != 6);
    }

    public void printOpcions(){
        System.out.println("\na)Les meves localitzacions\n" +
                "b)Historial de localitzacions\n" +
                "c)Les meves rutes\n" +
                "d)Parades i estacions preferides\n" +
                "e)Estacions inaugurades el meu any de naixement\n" +
                "f)Tornar al menú principal\n" +
                "\nSelecciona opció:");
    }

    public int preguntarOpcio(){
        Scanner sc = new Scanner(System.in);
        int opcio_int = -1;
        do{
            String opcio = sc.next();
            if(opcio.equalsIgnoreCase("a")){
                opcio_int = 1;
            } else if(opcio.equalsIgnoreCase("b")){
                opcio_int = 2;
            } else if(opcio.equalsIgnoreCase("c")){
                opcio_int = 3;
            } else if(opcio.equalsIgnoreCase("d")){
                opcio_int = 4;
            } else if(opcio.equalsIgnoreCase("e")){
                opcio_int = 5;
            } else if(opcio.equalsIgnoreCase("f")){
                opcio_int = 6;
            } else{
                System.out.println("Si us plau, escolleix una opció vàlida.");
            }
        } while(opcio_int == -1);
        return opcio_int;
    }

    private void gestionaLocalitzacions(DataModel data){
        if(this.locationsCreated.size() == 0){
            System.out.println("\nNo tens cap localització creada.");
        } else{
            System.out.println("\nLes teves localitzacions són:");
            mostraLocalitzacions();
        }
        boolean continues = true;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\nVols crear una nova localització? (sí/no)");
            String opcion = sc.next();
            if(opcion.equalsIgnoreCase("no")) {
                continues = false;
            } else if(opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("sí")) {
                afegeixLocalitzacio(data);
            } else{
                System.out.println("\nError! S'ha d'introduir \"sí\" o \"no\".");
            }
        }while(continues);
    }

    private void afegeixLocalitzacio (DataModel data){
        Scanner sc = new Scanner(System.in);
        boolean continues = true;
        do{
            System.out.println("Nom de la localització:");
            String name = sc.next();
            boolean name_exists = existeixLocalitzacio(data, name);
            if(name_exists) {
                System.out.println("\nError! Aquesta localització ja existeix.");
            } else{
                System.out.println("\nLongitud:");
                double longitud = sc.nextDouble();
                System.out.println("\nLatitud:");
                double latitud = sc.nextDouble();
                boolean c_valides = coordenadesValides(longitud, latitud);
                if(!c_valides){
                    System.out.println("\nError! Aquestes coordenades no són vàlides seguint el sistema de coordenades en EPSG:4326.");
                } else{
                    System.out.println("\nDescripció:");
                    String descripcio = sc.next();
                    Location nova_localitzacio = new Location(name, longitud, latitud, descripcio);
                    this.locationsCreated.add(nova_localitzacio);
                    data.afegeixLocalitzacio(nova_localitzacio);
                    System.out.println("\nLa informació s'ha registrat amb èxit!\n");
                    mostraLocalitzacions();
                    continues = false;
                }
            }
        }while(continues);
    }

    private void mostraHistorial(){
        if(this.historial.size() == 0){
            System.out.println("Encara no has buscat cap localització!" + "\nPer buscar-ne una, accedeix a l'opció 2 del menú principal.");
        } else{
            System.out.println("Localitzacions buscades:");
            for(int i = this.historial.size() - 1; i >= 0; i++){
                System.out.println("-" + this.historial.get(i).getName());
            }
        }
    }

    private void mostraRutes(){
        if(this.routesCreated.size() == 0){
            System.out.println("Encara no has realitzat cap ruta :(\n" + "Per buscar-ne una, accedeix a l'opció 3 del menú principal");
        } else{
            for(int i = 0; i < this.routesCreated.size(); i++){
                System.out.println("->Ruta " + i+1 + ":" + this.historial.get(i).getName());
            }
        }
    }

    private boolean existeixLocalitzacio (DataModel data, String name){
        for(int i=0; i<data.getLocations().size(); i++){
            if(data.getLocations().get(i).getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    private boolean coordenadesValides (double longitud, double latitud){
        if((-90 < longitud && longitud < 90) && (-180 < latitud && latitud < 180)){
            return true;
        }
        return false;
    }

    private void mostraLocalitzacions(){
        for(int i=0; i<this.locationsCreated.size(); i++){
            System.out.println("-" + this.locationsCreated.get(i).getName());
        }
    }

}
