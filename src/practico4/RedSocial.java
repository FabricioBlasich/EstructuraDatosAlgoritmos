// Blasich, Fabricio Lucas
package practico4;

public class RedSocial extends ListaEnlazada<Usuario>{


    public static RedSocial crearRedSocial(){
        return new RedSocial();
    }

    public void registrar(Usuario u){
        super.insertarAlInicio(u);
    }

    public boolean esVacia(){
        return(super.esVacia());
    }
    

    public Usuario ultimoUsuario(){
        return (Usuario) (super.getPrimero().getValor());
    }

    public int cantidad(){
        return super.getCantidad();
    }

    public static boolean esAmigoComun(RedSocial red1, RedSocial red2, Usuario usuario){
        return(red1.esta(usuario) && red2.esta(usuario));
    }


    public static RedSocial union(RedSocial red1, RedSocial red2){
        RedSocial redSocial = RedSocial.crearRedSocial();
        while (!red1.esVacia()) {
            redSocial.registrar(red1.ultimoUsuario());
            red1.borrarPrimero();
        }
        while (!red2.esVacia()) {
            redSocial.registrar(red2.ultimoUsuario());
            red2.borrarPrimero();
        }

        return redSocial;
    }

    public void echar(Usuario usuario){
        super.borrarConValores(usuario);
    }

    private boolean esta(Nodo aux, Usuario usuario){
        if(aux == null)
            return false;
        else if(aux.getValor().equals(usuario))
            return true;
        else
            return(esta(aux = aux.getSig(), usuario));

    }

    public boolean esta(Usuario usuario){
        return this.esta(super.getPrimero(), usuario);
    }
}