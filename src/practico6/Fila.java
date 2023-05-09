package practico6;

public class Fila<T>{
    class Nodo{
        private T item;
        private Nodo sig;

        public Nodo(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }  
    }

    private Nodo frente;
    private Nodo fondo;
    private int cantidad;
    private int longitudMax;

    public Fila() {
        this.frente = null;
        this.fondo = null;
        this.cantidad = 0;
        this.longitudMax = 0;
    }

    public boolean esFilaVacia(){
        return frente == null;
    }

    public void enFila(T item){
        Nodo aux = new Nodo(item);
        if(this.esFilaVacia())
            this.frente = this.fondo = aux;
        else{
            this.fondo.setSig(aux);
            this.fondo = aux;
        }

        this.cantidad++;
        this.longitudMax++;
    }

    public void deFila(){
        if(!this.esFilaVacia()){
            if(this.frente.getSig() == null)
                this.frente = this.fondo = null;
            else
                this.frente = this.frente.getSig();

            this.cantidad--;
        }
    }

    public T Frente(){
        if(!this.esFilaVacia())
            return this.frente.getItem();

        throw new NullPointerException();
    }

    public int longitudMaxima(){
        return this.longitudMax;
    }

    public int getCantidad() {
        return cantidad;
    }

    private void mostrar(Nodo aux){
        if(aux == null)
            return;
        else{
            System.out.println(aux.getItem());
            mostrar(aux = aux.getSig());
        }
    }


    // Esta funcion no pertenece al ADT fila
    public void mostrar(){
        this.mostrar(this.frente);
    }

    // Prueba de la Fila
    public static void main(String[] args) {
    
        Fila fila1 = new Fila<Integer>();

        fila1.enFila(1);
        fila1.enFila(2);
        fila1.enFila(3);

        System.out.println("EsVacia: " + fila1.esFilaVacia());
        fila1.mostrar();
        System.out.println();

        fila1.deFila();
        fila1.mostrar();
        System.out.println();

        fila1.deFila();
        fila1.mostrar();
        System.out.println();

        fila1.deFila();
        fila1.mostrar();
        System.out.println("EsVacia: " + fila1.esFilaVacia());
        System.out.println("-----");

        fila1.enFila(10);
        fila1.enFila(20);
        fila1.mostrar();
        System.out.println();

        System.out.println("Frente: " + fila1.Frente());
    
    }


}