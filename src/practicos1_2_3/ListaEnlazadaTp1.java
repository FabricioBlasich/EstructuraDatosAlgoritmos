package practicos1_2_3;

import practico4.RedSocial;

public class ListaEnlazadaTp1 {
    private Nodotp1 primero;

    

    public ListaEnlazadaTp1() {
        this.primero = null;
    }


    public static ListaEnlazadaTp1 crearLista(){
        return(new ListaEnlazadaTp1());
    }

    public boolean esVacia(){
        return(this.primero == null);
    }

    public void insertarAlFinal(int x){
        
        if(!this.esVacia()){
            Nodotp1 aux = this.primero;
            while(aux.getSig() != null){
                aux = aux.getSig();
            }
            aux.setSig(new Nodotp1(x));
        }
        else
            this.insertarAlinicio(x);

    }

    public void insertarAlinicio(int x){
        if(!this.esVacia()){
            Nodotp1 nuevoNodo = new Nodotp1(x);
            nuevoNodo.setSig(this.primero.getSig());
            this.primero = nuevoNodo;
        }else
            this.primero = new Nodotp1(x);


    }

    private void mostrar(Nodotp1 aux){
        if(aux.getSig() == null)
            System.out.println(aux.getInfo());
        else{
            System.out.println(aux.getInfo());
            mostrar(aux = aux.getSig());  
        }
    }

    public void mostrar(){
        Nodotp1 aux = this.primero;
        this.mostrar(aux);
    }


    private int SumaListaUmbral(Nodotp1 aux, int valorUmbral){
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
        Nodotp1 aux = this.primero;
        return(this.SumaListaUmbral(aux, valorUmbral));
    }

    public static void main(String[] args) {
        ListaEnlazadaTp1 lista1 = ListaEnlazadaTp1.crearLista();

        lista1.insertarAlFinal(6);
        lista1.insertarAlFinal(1);
        lista1.insertarAlFinal(4);
        lista1.insertarAlFinal(2);

        lista1.mostrar();
        System.out.println("\n\n" +lista1.SumaListaUmbral(3));
    }

}
