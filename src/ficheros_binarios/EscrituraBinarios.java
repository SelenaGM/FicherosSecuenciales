package ficheros_binarios;

import java.io.*;

public class EscrituraBinarios {
    public static void main(String[] args) {

        File file = new File("binarios.dat");
        try {
            DataOutputStream  dos = new DataOutputStream(new FileOutputStream(file));

            /*dos.writeInt(200);
            dos.writeChars("Hola mundo");
            dos.writeBoolean(false);
*/
            for (int i = 0; i < 1000; i++) {
                dos.writeInt(i);
            }

            dos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
