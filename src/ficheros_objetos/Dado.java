package ficheros_objetos;

import java.io.Serializable;

public class Dado implements Serializable {
    public static final int CARAS = 6;

    private int tirada;

    public Dado(int tirada) {
        this.tirada = tirada;
    }

    public int getTirada() {
        return tirada;
    }

    public void setTirada(int tirada) {
        this.tirada = tirada;
    }

}
