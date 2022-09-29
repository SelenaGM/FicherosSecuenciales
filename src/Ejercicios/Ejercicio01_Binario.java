package Ejercicios;

import java.io.*;
import java.text.NumberFormat;

public class Ejercicio01_Binario {

    public static void main(String[] args) {


            escribirCuenta();
            leerCuenta();

    }

    private static void leerCuenta() {
        File file = new File("cuentaCorriente.dat");
        double saldo = 0;
        int numCargos =0;
        int numAbonos= 0;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            while(true){
                double cargo = dis.readInt();
                saldo += cargo;
                if(cargo>0){
                    numAbonos++;
                }else{
                    numCargos++;
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (EOFException eofException){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.printf("Tienes %s, con %d cargos y %d abonos", nf.format(saldo), numCargos, numAbonos);

    }

    private static void escribirCuenta()  {
        File file = new File("cuentaCorriente.dat");

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeInt(1000);
            dos.writeInt(-200);
            dos.writeInt(400);
            dos.writeInt(-100);
            //Para crear numeros al azar en negativo y positivo
        /*for (int i = 0; i < 1000; i++) {
            int x = (int) (Math.random()*1501);
            if (i % 2== 0)
                x *= -1;

            dos.writeInt(x);
            }
        }
        */
            dos.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
