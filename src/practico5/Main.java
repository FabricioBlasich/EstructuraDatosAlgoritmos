package practico5;

public class Main {

    public static void main(String[] args) {
        Pila pila1 = new Pila<String>();

    System.out.println("La pila esta vacia: " + pila1.esPilaVacia() + "\n");
        pila1.push("Hola");
        pila1.push("Mundo");
        pila1.push("chau");


        pila1.mostrar();

        System.out.println( "\n");

        System.out.println("La pila esta vacia: " + pila1.esPilaVacia() );

        pila1.pop().pop();

        System.out.println("################");

        pila1.mostrar();

        System.out.println("\n\nTop: " + pila1.top());

    }

}
