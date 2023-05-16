package practico7;

public class Main {
    public static void main(String[] args) {
        Servidor servidor1 = new Servidor(30000);
        servidor1.procesar();
        servidor1.resultados();
    }
}
