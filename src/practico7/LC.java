package practico7;

public class LC<T>{
    
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

    private Nodo ultimo;
    private int cantidad;

    public LC() {
        this.ultimo = null;
        this.cantidad = 0;
    }

    public boolean esLC_Vacia(){
        return this.ultimo == null;
    }

    public T LC_Valor(){
        if(!this.esLC_Vacia())
            return this.ultimo.getSig().getItem();

        throw new NullPointerException();
    }

    public void LC_Insertar(T item){
        Nodo nuevo = new Nodo(item);
        if(!this.esLC_Vacia()){
            nuevo.setSig(this.ultimo.getSig());
            this.ultimo.setSig(nuevo);
        }
        else{
            this.ultimo = nuevo;
            this.ultimo.setSig(this.ultimo);
        }

        this.cantidad++;
    }

    public LC LC_Borrar(){
        if(!this.esLC_Vacia()){
            if(this.ultimo != this.ultimo.getSig())
                this.ultimo.setSig(this.ultimo.getSig().getSig());
            else
                this.ultimo = null;
        
            this.cantidad--;
        }

        return this;
    }

    public void LC_Rotar(){
        if(!this.esLC_Vacia())
            this.ultimo = this.ultimo.getSig();
    }


    public void mostrar(){
        Nodo aux = this.ultimo.getSig();

        while(aux != this.ultimo){
            System.out.println(aux.getItem());
            aux = aux.getSig();

            if(aux == this.ultimo)
                System.out.println(aux.getItem());
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public static void main(String[] args) {
        LC lista1 = new LC<Integer>();


        lista1.LC_Insertar(1);
        lista1.LC_Insertar(2);
        lista1.LC_Insertar(3);
        lista1.LC_Insertar(4);

        lista1.mostrar();

        System.out.println();
        lista1.LC_Borrar();
        lista1.mostrar();


        System.out.println();
        lista1.LC_Rotar();
        lista1.mostrar();



        System.out.println("\nVentana: " + lista1.LC_Valor());
    }
        
        
        
        
        
        
}
