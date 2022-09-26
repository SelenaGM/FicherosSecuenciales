package Ejercicios;

import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.NumberFormat;

public class Ejercicio01 {

    public static void main(String[] args) {
        double saldo = 0;
        int numCargos =0;
        int numAbonos= 0;
        File fichero = new File("Ejercicio01Archivo.txt");


        try {
            FileReader fr= new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while((linea=br.readLine())!=null){
                double cargo = Double.parseDouble(linea);
                saldo += cargo;
                if(cargo>0){
                    numAbonos++;
                }else{
                    numCargos++;
                }
            }

            //cambiarle el formato al saldo para q ue no salgan tantos ceros, pondrá el simbolo del euro pero para el souf tenemos que poner %s
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            System.out.printf("Tienes %s, con %d cargo y %d abonos", nf.format(saldo), numCargos, numAbonos);
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
