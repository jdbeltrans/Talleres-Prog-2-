package co.edu.unbosque.fourpawscitizens.model;

import java.util.Scanner;

public class Main {

    /** Inicia el programa y llama al método "program" **/
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        program();
    }

    /** Muestra el menú del programa **/
    public static void program() {

        Manager m = new Manager();
        int option = 0;

        System.out.println("\n *** Bienvenido al programa FourPawsCitizens *** \n");

        while (option != 5) {

            System.out.println("Seleccione la opción que desea ejecutar: \n");
            System.out.println("1. Encontrar mediante microchip");
            System.out.println("2. Contar por tipo de especie");
            System.out.println("3. Encontrar por animal peligroso en localidad");
            System.out.println("4. Encontrar por múltiples campos");
            System.out.println("5. Salir del programa");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();


            switch (option) {
                case 1:

                    String micro;
                    System.out.println("Escriba el número del Microchip");
                    Scanner sc1 = new Scanner(System.in);
                    micro = sc1.next();

                    m.findByMicrochip(micro);
                    break;

                case 2:

                    String spec;
                    System.out.println("Ingrese la especie que desea buscar (FELINO o CANINO):");
                    Scanner sc2 = new Scanner(System.in);
                    spec = sc2.next();

                    m.countBySpecies(spec);
                    break;

                case 3:

                    int n = 0;
                    String pos;
                    String neigh;
                    System.out.println("Escriba el número de animales");
                    Scanner sc3 = new Scanner(System.in);
                    n = sc3.nextInt();
                    System.out.println("Escriba la posición (TOP o LAST)");
                    Scanner sc4 = new Scanner(System.in);
                    pos = sc4.next();
                    System.out.println("Escriba la localidad");
                    Scanner sc5 = new Scanner(System.in);
                    neigh = sc5.next();

                    m.findByPotentDangerousInNeighborhood(n, pos, neigh);
                    break;

                case 4:

                    String sex;
                    String species;
                    String size;
                    String danger;

                    System.out.println("Ingrese la especie que desea buscar (FELINO o CANINO):");
                    Scanner sc6 = new Scanner(System.in);
                    species = sc6.next();
                    System.out.println("Escriba el sexo de la mascota (HEMBRA o MACHO):");
                    Scanner sc7 = new Scanner(System.in);
                    sex = sc7.next();
                    System.out.println("Escriba el tamaño (MINIATURA, PEQUEÑO, MEDIANO, GRANDE):");
                    Scanner sc8 = new Scanner(System.in);
                    size = sc8.next();
                    System.out.println("Si es peligroso escriba SI, de lo contrario, escriba NO");
                    Scanner sc9 = new Scanner(System.in);
                    danger = sc9.next();

                    m.findByMultipleFields(species, sex, size, danger);
                    break;

            }

        }

    }
}

