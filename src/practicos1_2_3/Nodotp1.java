package practicos1_2_3;

public class Nodotp1 {
    private Nodotp1 sig;
    private int info;


    public Nodotp1(int info) {
        this.info = info;
    }

    public Nodotp1 getSig() {
        return sig;
    }

    public int getInfo() {
        return info;
    }
    
    public void setSig(Nodotp1 sig) {
        this.sig = sig;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    
}
