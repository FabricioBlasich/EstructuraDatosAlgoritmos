public class Nodo <T>{
    private Nodo sig;
    private T t;

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Nodo(T t) {
        this.t = t;
    }
    
}
