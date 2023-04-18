// Blasich, Fabricio Lucas
package practico4;

public class Main {
    public static void main(String[] args) {
        RedSocial redSocial1 = RedSocial.crearRedSocial();

        // Usuarios
        Usuario usuario1 = new Usuario("Fabricio", "Blasich");
        Usuario usuario2 = new Usuario("Nestor", "Blasich");
        Usuario usuario3 = new Usuario("Lionel", "Messi");
        Usuario usuario4 = new Usuario("Rossana", "Juarez");
        Usuario usuario5 = new Usuario("Ricardo", "Silvera");

        System.out.println("La lista esta esta vacia: " + redSocial1.esVacia());

        redSocial1.registrar(usuario1);
        redSocial1.registrar(usuario1);
        redSocial1.registrar(usuario2);
        redSocial1.registrar(usuario3);
        redSocial1.registrar(usuario1);
        redSocial1.registrar(usuario1);
        redSocial1.registrar(usuario4);

        System.out.println("La lista esta esta vacia: " + redSocial1.esVacia() + "\n");
        
        System.out.println("Esta el usuario Fabricio Blasich: " + redSocial1.esta(usuario1) + "\n");

        redSocial1.mostrar();
        redSocial1.echar(usuario1);
        System.out.println("################### Echo al usuario Fabricio Blasich: \n");
        redSocial1.mostrar();

        System.out.println("\nEsta el usuario Fabricio Blasich: " + redSocial1.esta(usuario1) + "\n");
        System.out.println("El ultimo usuario es: " + redSocial1.ultimoUsuario() + "\n");
        System.out.println("La cantidad de usuarios es: " + redSocial1.cantidad() + "\n");

        //###########################################
        RedSocial redSocial2 = RedSocial.crearRedSocial();

        redSocial2.registrar(usuario1);
        redSocial2.registrar(usuario2);
        redSocial2.registrar(usuario5);

        System.out.println(("RedSocial2: "));
        redSocial2.mostrar();

        System.out.println("\n\nLa redSocial1 y redSocial2 contienen al usuario Ricardo Silvera: " + RedSocial.esAmigoComun(redSocial1, redSocial2, usuario5));
        System.out.println("La redSocial1 y redSocial2 contienen al usuario Nestor Blasich: " + RedSocial.esAmigoComun(redSocial1, redSocial2, usuario2));
        

        RedSocial redSocialUnion = RedSocial.union(redSocial1, redSocial2);

        System.out.println("\n\nLa red social union entre redSocial 1 y 2 es: ");
        redSocialUnion.mostrar();

    }
}
