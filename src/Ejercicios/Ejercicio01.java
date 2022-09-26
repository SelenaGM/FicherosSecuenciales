package Ejercicios;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio01 {

    public static void main(String[] args) {
        File fichero = new File("Ejercicio01Archivo.txt");
        ArrayList<String> lineas = new ArrayList<>();


        try {
            FileReader fr= new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = null;
            int contador = 0;
            int negativo =0;
            int positivo = 0;
            while((linea=br.readLine())!=null){
                lineas.add(linea);
            }

            if(lineas.size()>0){
                for (int i = 0; i < lineas.size(); i++) {
                    contador+= Integer.parseInt(lineas.get(i));

                }
                System.out.println("Tu saldo total es de: "+contador);
                System.out.println("Han habido un total de: "+lineas.size()+" transacciones");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
