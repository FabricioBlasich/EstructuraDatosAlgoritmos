package practicos1_2_3;

public class Nodo {
    private Nodo sig;
    private int info;


    public Nodo(int info) {
        this.info = info;
    }

    public Nodo getSig() {
        return sig;
    }

    public int getInfo() {
        return info;
    }
    
    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    
}
