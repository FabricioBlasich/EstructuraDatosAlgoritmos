package practico4;

// Blasich, Fabricio Lucas

public class ListaEnlazada <T>{
    
    class Nodo<T>{
        private T valor;
        private Nodo sig;

        public Nodo(T valor){
            this.setValor(valor);
        }
        
        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }
    }
    
    private Nodo primero;
    private int cantidad;
    
    public ListaEnlazada(){
        this.primero=null;
        this.cantidad=0;
    }
    
    
    public boolean esVacia(){
        return this.primero==null;
    }
    
    public void insertarAlInicio(T valor){
        
        Nodo aux=new Nodo(valor);
        
        aux.setSig(this.primero);
        this.primero=aux;
        this.cantidad++;
    }
    
    public void insertarAlFinal(T valor){
        
        if(this.esVacia()){
            this.primero=new Nodo(valor);
        }
        else{
            Nodo aux=this.primero;
            while(aux.getSig()!= null){
                aux=aux.getSig();
            }
            aux.setSig(new Nodo(valor));
        }
        this.cantidad++;
    }
    
    public void borrarPrimero(){
        
        if(!this.esVacia()){
            this.primero=this.primero.getSig();
            this.cantidad--;
        }
    }
    
     public void borrarUltimo(){
        
        if(!this.esVacia()){
            
            if(this.primero.getSig()==null){
                primero=null;
            }
            else{
                Nodo aux=this.primero;
              
                while(aux.getSig().getSig()!= null){
                    aux=aux.getSig();
                }
                aux.setSig(null);
            }
            this.cantidad--;
        }
    }
     
    public void mostrarIterativo(){
        Nodo aux=this.primero;
        
        while(aux!=null){
            System.out.print(aux.getValor()+" -> ");
            aux=aux.getSig();
        }
        System.out.println("NULL");
    }
    
    public void mostrar(){
        this.mostrar(this.primero);
    }
    
    private void mostrar(Nodo aux){        
        while(aux!=null){
            System.out.println(aux.getValor()+" -> ");
            aux=aux.getSig();
        }
        System.out.println("NULL");
    }

    public void borrarConValores(T valor){
        if(!this.esVacia()){
            while(this.primero.getValor().equals(valor)){
                this.primero = this.primero.getSig();
                this.cantidad--;
            }  
            
            Nodo aux = this.primero; 
            
            while(aux.getSig() != null){
                if(aux.getSig().getValor().equals(valor)){
                    aux.setSig(aux.getSig().getSig());
                    this.cantidad--;
                }else
                    aux = aux.getSig();
            }            
        }
    }
    
    private boolean esta(Nodo aux, T item){
        if(aux == null)
            return false;
        else if(aux.getValor().equals(item))    // deberia definir esta funcion "esta" en la lista enlazada
            return true;
        else
            return(esta(aux = aux.getSig(), item));
    }

<<<<<<< HEAD
    public boolean esta(T item){
        return this.esta(this.primero, item);
    }

=======
>>>>>>> 69b5d257d7272bdfc1ebd81815114d8d546a9d2c
    public T getValorPrimero() {
        return (T) this.primero.getValor();
    }

    public int getCantidad() {
        return this.cantidad;
    }

    
}
