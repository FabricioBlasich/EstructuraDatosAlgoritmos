// Blasich, Fabricio Lucas
package practico4;

import practico4.ListaEnlazada.Nodo;

public class RedSocial{

    private ListaEnlazada listaEnlazada = new ListaEnlazada<Usuario>();


    public static RedSocial crearRedSocial(){
        return new RedSocial();
    }

    public void registrar(Usuario u){
        this.listaEnlazada.insertarAlInicio(u);
    }

    public boolean esVacia(){
        return(this.listaEnlazada.esVacia());
    }
    

    public Usuario ultimoUsuario(){
        return (Usuario) this.listaEnlazada.getValorPrimero();
    }

    public int cantidad(){
        return this.listaEnlazada.getCantidad();
    }

    public static boolean esAmigoComun(RedSocial red1, RedSocial red2, Usuario usuario){
        return(red1.esta(usuario) && red2.esta(usuario));
    }


    public static RedSocial union(RedSocial red1, RedSocial red2){
        RedSocial redSocial = RedSocial.crearRedSocial();
        while (!red1.esVacia()) {
            redSocial.registrar(red1.ultimoUsuario());
            red1.listaEnlazada.borrarPrimero();;
        }
        while (!red2.esVacia()) {
            redSocial.registrar(red2.ultimoUsuario());
            red2.listaEnlazada.borrarPrimero();;
        }

        return redSocial;
    }

    public void echar(Usuario usuario){
        this.listaEnlazada.borrarConValores(usuario);
    }

    

    public boolean esta(Usuario usuario){
        return this.listaEnlazada.esta(usuario);
    }

    public void mostrar(){
        this.listaEnlazada.mostrar();
    }



}