package practico7;

public class ListaCircular<T>{
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

    private Nodo LC;
    private int cantidad;
    private int longitudMax;

    public ListaCircular(){
        this.LC = null;
        this.cantidad = 0;
        this.longitudMax = 0;
    }

    public boolean EsLC_Vacia(){
        return (this.LC == null);
    }

    public void LC_Insertar(T item){
        Nodo nuevo = new Nodo(item);
        if(!this.EsLC_Vacia()){
            nuevo.setSig(this.LC.getSig());
            this.LC.setSig(nuevo);
        }else{
            this.LC = nuevo;
            this.LC.setSig(this.LC);
        }

        this.cantidad++;
        this.longitudMax++;
    }

    public ListaCircular LC_Borrar(){
        if(!this.EsLC_Vacia()){
            if(this.LC != this.LC.getSig())
                this.LC.setSig(this.LC.getSig().getSig());
            else
                this.LC = null;
            
            this.cantidad--;
        }

        return this;
    }

    public T LC_Valor(){
        if(!this.EsLC_Vacia())
            return this.LC.getSig().getItem();
        
        throw new NullPointerException();
    }

    public ListaCircular LC_Rotar(){
        if(!this.EsLC_Vacia())
            this.LC = this.LC.getSig();

        return this;
    }


    private void mostrar(Nodo aux){
        if(!this.EsLC_Vacia()){
            aux = aux.getSig();
            do {
                System.out.println(aux.getItem());
                aux = aux.getSig();
            } while (aux != this.LC.getSig());
        }
    }
    public void mostrar(){
        this.mostrar(this.LC);
    }

    public int getCantidad() {
        return cantidad;
    }

    public int longitudMaxima(){
        return this.longitudMax;
    }

    //Prueba del ADT
    public static void main(String[] args) {
        ListaCircular listaCircular = new ListaCircular<Integer>();

        listaCircular.LC_Insertar(1);
        listaCircular.LC_Insertar(2);
        listaCircular.LC_Insertar(4);
        listaCircular.LC_Insertar(7);
        System.out.println("Cantidad: " + listaCircular.cantidad);

        listaCircular.mostrar();

        System.out.println();
        listaCircular.LC_Rotar();
        listaCircular.mostrar();

        System.out.println();
        listaCircular.LC_Borrar();
        listaCircular.LC_Borrar();
        listaCircular.LC_Borrar();
        listaCircular.mostrar();
        System.out.println("Cantidad: " + listaCircular.cantidad);
        

        System.out.println("---");
        listaCircular.LC_Borrar();
        listaCircular.mostrar();

        System.out.println();
        listaCircular.LC_Insertar(5);
        listaCircular.LC_Insertar(7);
        listaCircular.mostrar();

        System.out.println("\nVentana: " + listaCircular.LC_Valor());


    }

}
