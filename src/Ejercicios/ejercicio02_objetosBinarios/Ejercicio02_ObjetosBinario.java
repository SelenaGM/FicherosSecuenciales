package Ejercicios.ejercicio02_objetosBinarios;

import Ejercicios.modelos.EstadoPartida;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02_ObjetosBinario {

    private static Scanner sc;
    private static ArrayList<EstadoPartida> partidita;
    private static File partidaGuardada;


    static {
        sc = new Scanner(System.in);
        partidita = new ArrayList<>();
        partidaGuardada = new File("PartidaGuardada3.dat");
    }

    public static void main(String[] args) {

        int opcion = 0;

        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1:
                        guardarPartida();
                        break;
                    case 2:
                        mostrarPartidas();
                        break;
                    case 3:
                        eliminarPartidas();
                        break;
                    case 4:
                        System.out.println("Hasta la próxima");
                        break;
                    default:
                        System.out.println("Esa opción no existe. Hasta luegui");
                }
            }catch (InputMismatchException e){
                opcion =0;
                sc.nextLine();
            }
        }while(opcion!=4);

    }

    private static void eliminarPartidas() {

        sc.nextLine();
        System.out.println("Esto eliminará las partidas, ¿estás seguro? (si/no)");
        String respuesta= sc.nextLine().toLowerCase().trim();
        if(respuesta.equalsIgnoreCase("si")){
            partidaGuardada.delete();
            partidita.clear();
            System.out.println("Partidas eliminadas");
        }else{
            System.out.println("No se han eliminado las partidas");

        }

    }

    private static void mostrarPartidas() {
        FileInputStream fis;

        try {
            if (partidaGuardada.exists()) {


            fis = new FileInputStream(partidaGuardada);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                //con la excepcion EOFException nos aseguramos de que cuando acabe de leer, explote de forma controlada
                EstadoPartida partida = (EstadoPartida) ois.readObject();
                System.out.printf("Tiene %d vida/s y está en la pantalla %d%n", partida.getVidasRestantes(), partida.getPantallaActual());
            }
        }else{
                System.out.println("No tengo partidas guardadas, crea una partida antes");
        }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {

        } catch (ClassNotFoundException|IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void guardarPartida() {
        FileOutputStream fos;
        EstadoPartida partida = crearPartida();
        partidita.add(partida);
        try {
            ObjectOutputStream oos;
            if (partidaGuardada.exists()) {
                oos = new MyOOS(new FileOutputStream(partidaGuardada, true));

            } else {
                oos = new ObjectOutputStream(new FileOutputStream(partidaGuardada, true));
            }
            for (EstadoPartida p : partidita) {
                oos.writeObject(p);

            }
            oos.close();
        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }

    private static EstadoPartida crearPartida() {
        int vida, pantalla;
        System.out.println("Dime la vida");
        vida = sc.nextInt();
        System.out.println("Dime la pantalla");
        pantalla = sc.nextInt();
        sc.nextLine();
        return new EstadoPartida(vida, pantalla);
    }

    private static int menu() {
        System.out.println("1-Guardar Partida");
        System.out.println("2-Mostrar Partidas");
        System.out.println("3-Eliminar Partidas");
        System.out.println("4-Salir");
        return sc.nextInt();
    }
}
