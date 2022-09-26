package lectura;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EjemploLectura {
    public static void main(String[] args) {

        //Fichero de destino
        File fichero = new File("EjemploEscritura");
        ArrayList<String> lineas = new ArrayList<>();


        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fr);

            String linea = null;
           while ((linea=bf.readLine())!= null){
               lineas.add(linea);
           }


            //si no hay nada en las listas no lo enseñará
            if(lineas.size()>0){
                System.out.printf("El fichero tiene %d lineas, dime la linea a mostrar%n", lineas.size());
                Scanner sc = new Scanner(System.in);
                int numLinea = sc.nextInt();

                //En vez de un if controlando que no nos pongan un número que no esta en el array, controlamos la excepción del error
                try{
                    System.out.println(lineas.get(numLinea-1));
                }catch (IndexOutOfBoundsException exception){
                    System.out.println("Esa línea no existe");
                }

                /*
                if(numLinea>0 && numLinea<=lineas.size()){
                    System.out.println(lineas.get(numLinea-1));
                }else{
                    System.out.println("Esa línea no existe");
                }
                */

                finally{
                    bf.close();
                    fr.close();

                }
            }else{
                System.out.println("El fichero está vacio");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("No tengo permisos para leer");
            throw new RuntimeException(e);
        }






    }
}
