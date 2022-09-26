package Ejercicios;

import Ejercicios.modelos.EstadoPartida;

import java.io.*;

public class Ejercicio02 {
    public static void main(String[] args) {

        EstadoPartida partidita = new EstadoPartida(6,20);

        try {
            guardarPartida(partidita);
            partidita = recuperarPartida();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println(partidita);
    }

    private static EstadoPartida recuperarPartida() throws IOException {
        File fichero = new File("PartidaGuardada.txt");

            FileReader fr = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fr);

            int vida= Integer.parseInt(bf.readLine());
            int pantalla = Integer.parseInt(bf.readLine());
            bf.close();
            fr.close();

        return new EstadoPartida(vida,pantalla);
    }

    private static void guardarPartida(EstadoPartida partidita) throws IOException {
        File destino = new File("PartidaGuardada.txt");

            BufferedWriter bw = new BufferedWriter(new FileWriter(destino));
            bw.write(String.valueOf(partidita.getVidasRestantes()));
            bw.newLine();
            bw.write(String.valueOf(partidita.getPantallaActual()));
            bw.close();

    }


}
