package practicos1_2_3;

public class Bternaria {
    private static boolean Busquedaternaria(int[] vector, int X, int inf, int sup){
        int medioInf = inf + (sup - inf)/3;
        int medioSup = sup - (sup - inf)/3;
        if(inf > sup)
            return false;
        else if(vector[medioInf] == X || vector[medioSup] == X)
            return true;
        else if(vector[medioInf] > X )
            return(Busquedaternaria(vector, X, inf, medioInf-1));
        else if(vector[medioSup] < X)
            return(Busquedaternaria(vector, X, medioSup+1, sup));
        else // vector[medioInf] < X && vector[medioSup] > X
            return(Busquedaternaria(vector, X, medioInf+1, medioSup-1));

    }

    public static boolean Busquedaternaria(int[] vector, int X){
            return(Busquedaternaria(vector, X, 0, vector.length- 1));
    }

    public static void main(String[] args) {
        int vector[] = {2,4,7,15,29,45,57,59,60,97,100};
        System.out.println(Bternaria.Busquedaternaria(vector, 29));
    }
    

  
}
