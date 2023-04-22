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

        String infija1 = "2+4=";
        String infija2 = "(5+9)-3=";
        String infija3 = "6-(8+9)=";
        String infija4 = "1+9*8=";
        String infija5 = "9*(7+8)+4/2=";
        String infija6 = "(9-4)/(7+3)=";
        String infija7 = "4+6/(8-9)*3=";


        Calculadora calculadora1 = new Calculadora();
        
        System.out.println("Infija: " + infija1 + " -----> Posfija: "+  calculadora1.evaluar(infija1));
        System.out.println("Infija: " + infija2 + " -----> Posfija: "+  calculadora1.evaluar(infija2));
        System.out.println("Infija: " + infija3 + " -----> Posfija: "+  calculadora1.evaluar(infija3));
        System.out.println("Infija: " + infija4 + " -----> Posfija: "+  calculadora1.evaluar(infija4));
        System.out.println("Infija: " + infija5 + " -----> Posfija: "+  calculadora1.evaluar(infija5));
        System.out.println("Infija: " + infija6 + " -----> Posfija: "+  calculadora1.evaluar(infija6));
        System.out.println("Infija: " + infija7 + " -----> Posfija: "+  calculadora1.evaluar(infija7));


    //    System.out.println("Infija: " + infija1 + " -----> Posfija: "+  calculadora1.convertirAPostfija(infija1));
    //    System.out.println("Infija: " + infija2 + " -----> Posfija: "+  calculadora1.convertirAPostfija(infija2));
    //    System.out.println("Infija: " + infija3 + " -----> Posfija: "+  calculadora1.convertirAPostfija(infija3));
    //    System.out.println("Infija: " + infija4 + " -----> Posfija: "+  calculadora1.convertirAPostfija(infija4));
    //    System.out.println("Infija: " + infija5 + " -----> Posfija: "+  calculadora1.convertirAPostfija(infija5));
    //    System.out.println(calculadora1.convertirAPostfija(infija6));
    //    System.out.println("Infija: " + infija7 + " -----> Posfija: "+  calculadora1.convertirAPostfija(infija7));

        
    //    System.out.println("Infija: " + infija1 + " -----> Posfija: "+  infija_Posfija.Convertir(infija1));
    //    System.out.println("Infija: " + infija2 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija2));
    //    System.out.println("Infija: " + infija3 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija3));
    //    System.out.println("Infija: " + infija4 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija4));
    //    System.out.println("Infija: " + infija5 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija5));
    //    System.out.println("Infija: " + infija6 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija6));
    //    System.out.println("Infija: " + infija7 + " ----->  Posfija: "+  infija_Posfija.Convertir(infija7));
        
    }

}
