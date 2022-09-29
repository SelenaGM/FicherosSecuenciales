package ficheros_objetos;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    private static ArrayList<Dado> dados;
    private static File dadosFichero;

    static{
        dados = new ArrayList<>();
        dadosFichero = new File("dados.dat");
    }

    public static void main(String[] args) {

        crearTiradas();
        escribirTiradas();
        leerTiradas();

    }

    private static void leerTiradas() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(dadosFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                Dado dado = (Dado)ois.readObject();
                System.out.printf("La tirada es: %d%n",dado.getTirada());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(EOFException e){

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void escribirTiradas() {
        FileOutputStream fos;
        try {
            ObjectOutputStream ous ;
            //si existe, usaremos nuestro propio objectOutputStream, sino el original
            if(dadosFichero.exists()){
                ous = new MiObjectOutputStream(new FileOutputStream(dadosFichero, true));
            }else{
                ous = new ObjectOutputStream(new FileOutputStream(dadosFichero, true));
            }

            for (Dado dado:dados) {
                ous.writeObject(dado);
            }
            ous.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void crearTiradas() {
        for (int i = 0; i < 1000; i++) {
            dados.add(new Dado((int)(Math.random() * Dado.CARAS + 1)));
        }
    }
}
