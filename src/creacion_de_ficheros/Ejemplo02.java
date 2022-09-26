package creacion_de_ficheros;

import java.io.File;
import java.io.IOException;

public class Ejemplo02 {

    public static void main(String[] args) {
        //Cómo crear una nueva carpeta -> PRUEBAS
        File directorio = new File("PRUEBAS");
        directorio.mkdir();

        //Creamos dos ficheros nuevos
        File f1= new File(directorio,"f1.txt");
        File f2 = new File(directorio, "f2.txt");

        try {
            boolean f1Created = f1.createNewFile();
            boolean f2Created = f2.createNewFile();

            if(f1Created){
                System.out.println("Fichero 1 creado");
            }else{
                System.out.println("Fichero 1 no creado");
            }
            if(f2Created){
                System.out.println("Fichero 2 creado");
            }else{
                System.out.println("Fichero 2 no creado");
            }

            //renombramos los ficheros
            if(f1Created){
                boolean renombrado = f1.renameTo(new File(directorio, "f1new.txt"));
                if(renombrado)
                    System.out.println("Fichero renombrado");
                else
                    System.out.println("Error al renombrar el fichero");
            }

            //borrar ficheros o directorios
            //los directorios solo se pueden borrar si estan vacios
            boolean borrado = f2.delete();
            if(borrado)
                System.out.println("Fichero borrado");
            else
                System.out.println("Fichero no borrado");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
