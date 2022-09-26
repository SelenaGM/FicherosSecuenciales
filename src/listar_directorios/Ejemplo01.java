package listar_directorios;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejemplo01 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Dime la ruta");
        listarFicherosDirActual(sc.nextLine());
    }

    private static void listarFicherosDirActual(String dirActual) {
        //String dirActual = ".";
        File file = new File(dirActual);

        if(file.exists()) {

            System.out.println("EXISTE!!");
            String[] archivos = file.list();
            List<String> arrayList = Arrays.asList(archivos);
            arrayList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2) *-1; //-1 de mayor a menor, sin nada de menor a mayor.
                }
            });
            //el %d (decimal) se sustituira por lo que pongamos fuera de las comillas, en este caso archivos.length
            // %s string, %b bolean, %n para saltar de linea
            System.out.printf("Ficheros en el directorio %s: %d %n", file.getName(), archivos.length);
            for (String fichero : archivos) {
                File temp = new File(file, fichero);
                System.out.printf("Nombre: %s - FILE: %b - DIR: %b%n", temp.getName(), temp.isFile(), temp.isDirectory());
            }
        }else{

            System.out.println("No existe");
        }



    }


}
