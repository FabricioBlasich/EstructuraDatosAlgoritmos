package practico5;


public class Pila<T>{

    class Nodo<T>{
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
    
    private Nodo tope;
    private int altura;

    

    Pila() {
        this.tope = null;
        this.altura = 0;
    }



    public boolean esPilaVacia(){
        return(this.tope == null);
    }

    public T top(){
        if (!this.esPilaVacia()) 
            return (T) this.tope.getItem();
        else    
            throw new NullPointerException();
    }

    public Pila pop(){
        if(!this.esPilaVacia()){
            this.tope = this.tope.getSig();
            this.altura--;
        }

        
        return this;
    }

    public void push(T item){
        Nodo nuevo = new Nodo<T>(item);
        nuevo.setSig(this.tope);
        this.tope = nuevo; 

        this.altura++;
    }

    private void mostar(Nodo aux){
        if(aux.getSig() == null)
            System.out.println(aux.getItem());
        else{
            System.out.println(aux.getItem());
            mostar(aux = aux.getSig());
        }
    }
    public void mostrar(){
        this.mostar(this.tope);
    }
}

