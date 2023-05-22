package practico8;

public class ArbolBinario{
    private Integer raiz;  //pongo como Integer para que no de error en el metodo esAB_Vacio
    private ArbolBinario izquierda;
    private ArbolBinario derecha;

    

    public ArbolBinario() {
        this.raiz = null;
        this.izquierda = null;
        this.derecha = null;
    }

    public static ArbolBinario AB_Vacio(){
        return new ArbolBinario();
    }

    public boolean esAB_Vacio(){
        return raiz == null;
    }

    public static ArbolBinario armarAB(ArbolBinario iz, Integer item, ArbolBinario der) throws NullPointerException{
        if(item == null)
            throw new NullPointerException();
        else{
            ArbolBinario nuevo = new ArbolBinario();
            nuevo.raiz = item;
            
            if(iz == null) // hago esta verificacion para que luego se facilite la busquedas de un arbol
                nuevo.izquierda = new ArbolBinario();
            else
                nuevo.izquierda = iz;
            
            if(der == null)
                nuevo.derecha = new ArbolBinario();
            else 
                nuevo.derecha = der;

            return nuevo;
        }
    }

    public ArbolBinario izquierdo() {
        return this.izquierda;
    }

    public ArbolBinario derecho(){
        return this.derecha;
    }

    public int raiz(){
        if(!this.esAB_Vacio())
            return this.raiz;
        
            throw new NullPointerException();
    }

    public boolean pertenece(int item){
        if(this.esAB_Vacio())
            return false;
        else
            return (item == this.raiz || izquierda.pertenece(item) || derecha.pertenece(item));
    }

    public void ordenPrevio(){
        if(!this.esAB_Vacio()){
            System.out.println(this.raiz());
            this.izquierda.ordenPrevio();
            this.derecha.ordenPrevio();
        }
    }

    public void ordenSimetrico(){
        if(!this.esAB_Vacio()){
            this.izquierda.ordenSimetrico();
            System.out.println(this.raiz());
            this.derecha.ordenSimetrico();
        }
    }

    public void ordenPosterior(){
        if(!this.esAB_Vacio()){
            this.izquierda.ordenPosterior();
            this.derecha.ordenPosterior();
            System.out.println(this.raiz());
        }
    }

    public static void main(String[] args) {
        ArbolBinario arbolB = ArbolBinario.armarAB(ArbolBinario.armarAB(armarAB(null, 1, null), 5, armarAB(null, 2, null)), 7, armarAB(armarAB(null, 3, null), 6, armarAB(null, 5, null)));
        
    }


}
