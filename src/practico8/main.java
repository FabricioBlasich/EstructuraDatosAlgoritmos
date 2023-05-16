package practico8;

public class main {
    public static void main(String[] args) {
        ArbolBinario arbolB = ArbolBinario.armarAB(ArbolBinario.armarAB(ArbolBinario.armarAB(null, 1, null), 5, ArbolBinario.armarAB(null, 2, null)), 7, ArbolBinario.armarAB(ArbolBinario.armarAB(null, 3, null), 6, ArbolBinario.armarAB(null, 4, null)));
        System.out.println("PreOrden:");
        arbolB.ordenPrevio();
        System.out.println("\nEnOrden:");
        arbolB.ordenSimetrico();
        System.out.println("\nPostOrden:");
        arbolB.ordenPosterior();
        System.out.println();
    }
}
