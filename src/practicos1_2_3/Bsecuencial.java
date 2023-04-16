package practicos1_2_3;

public class Bsecuencial {

    public static void main(String[] args) {
        // int[] vector = new int[10];

        int vector[] = {1,2,3,7,5,6,5,8,9,10};
        System.out.println(Bsecuencial.BusquedaSecuencial(vector, 7, 10));
        
    }
    
    public static int BusquedaSecuencial(int[] vector, int buscado, int tamanoVector){
        if(tamanoVector == 0)
            return -1;
        else if(vector[tamanoVector - 1] == buscado)
            return tamanoVector;
        else
            return BusquedaSecuencial(vector, buscado, tamanoVector -1);
    }
}
