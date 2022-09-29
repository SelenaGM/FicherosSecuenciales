package Ejercicios;

import Ejercicios.modelos.EstadoPartida;

import java.io.*;

public class Ejercicio02_Binario {

    public static void main(String[] args) {
        EstadoPartida partidita = new EstadoPartida(6,20);

        try {
            guardarPartida(partidita);
            partidita= recuperarPartida();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(partidita);
    }

    private static EstadoPartida recuperarPartida() {

        File file = new File("PartidaGuardada2.dat");

        FileInputStream fis = null;
        try {

            fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);

            //como sabemos el orden y la cantidad de lo que hay dentro del archivo binario, simplemente
            //le pasamos ambos datos
            return new EstadoPartida(dis.readInt(), dis.readInt());

        } catch (FileNotFoundException e) {

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    private static void guardarPartida(EstadoPartida partidita) throws IOException {
        File file = new File("PartidaGuardada2.dat");

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(partidita.getVidasRestantes());
        dos.writeInt(partidita.getPantallaActual());
        dos.close();


    }
}
