package escritura;

import java.io.*;

public class EjemploEscritura {

    public static void main(String[] args) {
        File destino = new File("EjemploEscritura");

        try {
            //si queremos que no sobreescriba sino que haga más, le añadiremos true, (new FileWriter(destino,true))
            BufferedWriter bw = new BufferedWriter(new FileWriter(destino));
            for (int i = 0; i < 1000; i++) {
                bw.write("Esta es la linea: "+(i+1));
                bw.newLine();
            }
            bw.close();
            /* Otra opción en vez de bufferedWriter
            PrintWriter pw = new PrintWriter(new FileWriter(destino));
            pw.println();
            */
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
