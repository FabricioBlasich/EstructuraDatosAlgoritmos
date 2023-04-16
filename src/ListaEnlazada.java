public class ListaEnlazada{
    private Nodo primero;
    private int cantidadNodos;
    

    public ListaEnlazada() {
        this.primero = null;
        this.cantidadNodos = 0;
    }

    // Definicion d ela clase Nodo
    public class Nodo<T>{
        private Nodo sig;
        private T t;

        public Nodo(T t) {
            this.t = t;
        }
    
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
        
    }

// Metodos y atributos de la clase ListaEnlazada

    public static ListaEnlazada crearLista(){
        return(new ListaEnlazada());
    }

    public boolean esVacia(){
        return(this.primero == null);
    }

    public void insertarInicio(Object objeto){
        Nodo<Object> nuevoNodo = new Nodo<Object>(objeto);
        nuevoNodo.setSig(this.primero);
        this.primero = nuevoNodo;
        
        this.cantidadNodos += 1;
    }

    void insertarFinal(Object objeto){
        if(!this.esVacia()){
            Nodo aux = this.primero;
            while(aux.getSig() != null)
                aux = aux.getSig();
            Nodo<Object> nuevoNodo = new Nodo<Object>(objeto);
            aux.setSig(nuevoNodo);
        }else
            this.insertarInicio(objeto);

        this.cantidadNodos += 1;
    }


    private void mostrar(Nodo aux){
        if(aux.getSig() == null)
            System.out.println(aux.getT());
        else{
            System.out.println(aux.getT());
            mostrar(aux = aux.getSig());
        }
    }

    public void mostrar(){
        Nodo aux = this.primero;
        this.mostrar(aux);
    }


   
    public int cantidad(){
        return(this.cantidadNodos);
    }

    public void borrarPrimero(){
        if(!this.esVacia()){
            this.primero = this.primero.getSig();
        }

        this.cantidadNodos -= 1;
    }

    public void borrarUltimo(){
        if(!this.esVacia() && this.primero.getSig() != null){
            Nodo aux = this.primero;
            while(aux.getSig().getSig() != null)
                aux = aux.getSig();
            aux.setSig(null);
        }else if(!this.esVacia())
            this.primero = null;
        
        this.cantidadNodos -= 1;
    }


}