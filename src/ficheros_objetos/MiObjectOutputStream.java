package ficheros_objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
    //creamos nuestro propio objectOutputStream para que cuando le demos a true para añadir más tiradas, no se rompa


    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public MiObjectOutputStream() throws IOException, SecurityException {

    }


    @Override
    protected void writeStreamHeader() throws IOException {
        //si le quitamos el super, no añadirá la cabecera
    }
}
