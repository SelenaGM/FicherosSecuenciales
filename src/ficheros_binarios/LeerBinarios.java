package ficheros_binarios;

import java.io.*;

public class LeerBinarios {
    public static void main(String[] args) {
        File file = new File("binarios.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);

            //Creamos una excepción porque no sabemos cuan largo es el archivo, añadiremos el catch de eofException
            //para que al terminar el fichero, salte del try&catch (el tyc tiene que estar dentro, desde fuera no llega)
            while(true){
                int numero =dis.readInt();
                System.out.printf("El número es: %d%n", numero);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (EOFException eofException){
            System.out.println("Fichero terminado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
