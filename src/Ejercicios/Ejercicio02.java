package Ejercicios;

import java.io.*;

public class Ejercicio02 {
    public static void main(String[] args) {

        EstadoPartida partidita = new EstadoPartida(5,20);

        partidita = recuperarPartida();

        guardarPartida(partidita);
        System.out.println(partidita);
    }

    private static EstadoPartida recuperarPartida() {
        File fichero = new File("PartidaGuardada.txt");
        EstadoPartida partidita = new EstadoPartida();

        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fr);

            int vida= Integer.parseInt(bf.readLine());
            int pantalla = Integer.parseInt(bf.readLine());
            partidita.setVidasRestantes(vida);
            partidita.setPantallaActual(pantalla);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return partidita;
    }

    private static void guardarPartida(EstadoPartida partidita) {
        File destino = new File("PartidaGuardada.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(destino));
            bw.write(""+partidita.getVidasRestantes());
            bw.newLine();
            bw.write(""+partidita.getPantallaActual());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
