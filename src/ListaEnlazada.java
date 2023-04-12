public class ListaEnlazada {
    private Nodo primero;

    
    public ListaEnlazada() {
        this.primero = null;
    }


    public static ListaEnlazada crearLista(){
        return(new ListaEnlazada());
    }

    public boolean esVacia(){
        return(this.primero == null);
    }

    public void insertarAlFinal(int x){
        
        if(!this.esVacia()){
            Nodo aux = this.primero;
            while(aux.getSig() != null){
                aux = aux.getSig();
            }
            aux.setSig(new Nodo(x));
        }
        else
            this.insertarAlinicio(x);

    }

    public void insertarAlinicio(int x){
        if(!this.esVacia()){
            Nodo nuevoNodo = new Nodo(x);
            nuevoNodo.setSig(this.primero.getSig());
            this.primero = nuevoNodo;
        }else
            this.primero = new Nodo(x);


    }

    private void mostrar(Nodo aux){
        if(aux.getSig() == null)
            System.out.println(aux.getInfo());
        else{
            System.out.println(aux.getInfo());
            mostrar(aux = aux.getSig());  
        }
    }

    public void mostrar(){
        Nodo aux = this.primero;
        this.mostrar(aux);
    }


    private int SumaListaUmbral(Nodo aux, int valorUmbral){
        if(aux.getSig() == null){
            if(aux.getInfo() > valorUmbral)
                return valorUmbral;
            else
                return 0;
        }else{
            if(aux.getInfo() > valorUmbral)
                return(aux.getInfo() + SumaListaUmbral(aux = aux.getSig(), valorUmbral));
            else
                return(SumaListaUmbral(aux = aux.getSig(), valorUmbral));
        }
    }

    public int SumaListaUmbral(int valorUmbral){
        Nodo aux = this.primero;
        return(this.SumaListaUmbral(aux, valorUmbral));
    }

    public static void main(String[] args) {
        ListaEnlazada lista1 = ListaEnlazada.crearLista();

        lista1.insertarAlFinal(6);
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(4);
        lista1.insertarAlFinal(2);

        lista1.mostrar();
        System.out.println("\n\n" +lista1.SumaListaUmbral(3));
    }

}
