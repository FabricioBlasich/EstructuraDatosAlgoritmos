package practico6;

public class Main {
    public static void main(String[] args) {
        Servidor servidor1 = new Servidor(10000);
        servidor1.procesar();
        servidor1.resultados();
    }
}
