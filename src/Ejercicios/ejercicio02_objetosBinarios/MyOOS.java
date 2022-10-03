package Ejercicios.ejercicio02_objetosBinarios;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyOOS extends ObjectOutputStream {
    //creamos nuestro propio objectOutputStream para que cuando le demos a true para añadir más tiradas, no se rompa


    public MyOOS(OutputStream out) throws IOException {
        super(out);
    }


    @Override
    protected void writeStreamHeader() throws IOException {
        //si le quitamos el super, no añadirá la cabecera
    }
}
