package co.edu.unbosque.fourpawscitizens.model;

import co.edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.*;

import java.util.ArrayList;

public class Manager {

    private String path = "pets-citizens.csv";
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    private ObjectInputStream oin;

    /** Método encargado de cargar el archivo CSV **/

    public ArrayList<Pet> uploadData() {

        ArrayList<Pet> list = new ArrayList<Pet>();
        String line = "";

        File f = new File(this.path);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    String[] data = line.split(";");
                    String microchip = data[0];
                    String species = data[1];
                    String sex = data[2];
                    String size = data[3];
                    String potentDangerous = data[4];
                    String neighborhood = data[5];
                    Pet pet1 = new Pet();
                    pet1.setMicrochip(microchip);
                    pet1.setSpecies(species);
                    pet1.setSex(sex);
                    pet1.setSize(size);
                    pet1.setPotentDangerous(potentDangerous);
                    pet1.setNeighborhood(neighborhood);

                    list.add(pet1);
                }
            }
            fr.close();
        } catch (IOException e) {
            return null;
        }
        return list;
    }

    /** Método encargado de asignar los IDs automáticamente **/

    public void assignId() {


    }

    /** Método que recibe como parámetro el microchip, lo busca dentro del archivo
     * e imprime la infomación de la mascota bajo ese microchip **/

    public void findByMicrochip(String microchip) {

        for (int i = 0; i < pets.size(); i++) {

            if (pets.get(i).getMicrochip() == microchip) {

                System.out.println("ID: +... Species: " + pets.get(i).getSpecies() + "\n Gender: " + pets.get(i).getSpecies()+
                        "Size: " + pets.get(i).getSize() + "\n Potentially Dangerous: " + pets.get(i).getPotentDangerous().equalsIgnoreCase("SI") + "\n Neighborhood: "
                                + pets.get(i).getNeighborhood());
            } else {
                System.out.println("El Microchip " + microchip + " no ha sido encontrado");
            }
        }

    }

    /** Método que recibe como parámetro la especie, busca dentro del archivo
     * e imprime el número de animales pertenecientes a dicha especie  **/

    public void countBySpecies(String species) {

        int contador = 0;

        for (int i = 0; i < pets.size(); i++) {

            if (pets.get(i).getSpecies() == species) {

                contador++;
            } else {
                System.out.println("No se encontró ninguna especie válida");
            }
        }
        System.out.println("El número de animales de la especie " + species + " es: " + contador);
    }

    /** Método que recibe como parámetro un número, la posición y la localidad,
     * posteriormente realiza una búsqueda e imprime el número de animales de la localidad y posición especificada **/

    public void findByPotentDangerousInNeighborhood(int n, String position, String neighborhood) {

        for (int i = 0; i < pets.size(); i++) {

            if (pets.get(i).getNeighborhood() == neighborhood) {

                for (int j = 0; j < pets.size(); j++) {

                    if (pets.get(j).getPotentDangerous().equalsIgnoreCase("SI")) {

                        for (int k = 0; k < n; k++) {

                            System.out.println("ID: +... Species: " + pets.get(k).getSpecies() + "\nGender: " + pets.get(k).getSpecies()+
                                    "Size: " + pets.get(k).getSize() + "\n Potentially Dangerous: " + pets.get(k).getPotentDangerous() + "\n Neighborhood: "
                                            + pets.get(k).getNeighborhood());
                        }
                    }


                }

                System.out.println("ID: +... Species: " + pets.get(i).getSpecies() + "\nGender: " + pets.get(i).getSpecies()+
                        "Size: " + pets.get(i).getSize() + "\n Potentially Dangerous: " + pets.get(i).getPotentDangerous() + "\n Neighborhood: "
                                + pets.get(i).getNeighborhood());
            } else {
                System.out.println("Los parámetros ingresados no fueron encontrados");
            }
        }
    }

    /** Método que recibe como parámetros la especie, el sexo, el tamaño y si es peligroso o no,
     * posteriormente realiza una búsqueda e imprrime los IDs resultantes **/

    public void findByMultipleFields(String species, String sex, String size, String potentDangerous) {

        for (int i = 0; i < pets.size(); i++) {

            if (pets.get(i).getSpecies().equalsIgnoreCase(species)) {

                for (int j = 0; j < pets.size(); j++) {

                    if (pets.get(j).getSex().equalsIgnoreCase(sex)) {

                        for (int k = 0; k < pets.size(); k++) {

                            if (pets.get(k).getSize().equalsIgnoreCase(size)) {

                                for (int l = 0; l < pets.size(); l++) {

                                    if (pets.get(l).getPotentDangerous().equalsIgnoreCase("SI")) {

                                        System.out.println("Los IDs son: ");
                                    }
                                }
                            }
                        }


                    }
                }
            }
        }
    }
}
