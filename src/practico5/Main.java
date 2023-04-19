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

        System.out.println("\n\nTop: " + pila1.top() + "\n\n\n");

        String infija1 = "a+b=";
        String infija2 = "(a+b)-c=";
        String infija3 = "a-(b+c)=";
        String infija4 = "a+b*a=";
        String infija5 = "a*(b+c)+a/e=";
        String infija6 = "(b-a)/(c+d)=";
        String infija7 = "a+b/(d-a)*e=";
        
        System.out.println("Infija: " + infija1 + " -----> Posfija: "+  infija_Posfija.Convertir(infija1));
        System.out.println("Infija: " + infija2 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija2));
        System.out.println("Infija: " + infija3 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija3));
        System.out.println("Infija: " + infija4 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija4));
        System.out.println("Infija: " + infija5 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija5));
        System.out.println("Infija: " + infija6 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija6));
        System.out.println("Infija: " + infija7 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija7));
        
    }

}
