import java.util.Random;

public class AtenderTareas{

    public class Tareas{
        private int minutos;
        private String tipoTarea;

        public Tareas(int minutos, String tipoTarea) {
            this.minutos = minutos;
            this.tipoTarea = tipoTarea;
        }

        public int getMinutos() {
            return minutos;
        }

        public String getTipoTarea() {
            return tipoTarea;
        }
        
    }


    private static Tareas[] MinimizacionTiempo(Tareas[] tiempoClientes){
        int numeroClientes = tiempoClientes.length;
        int horarioAtencion = 600; //10 horas de horario de atencion que equivalen a 600 minutos
        Tareas[] ConjuntoSolucion = new Tareas[numeroClientes];
        boolean sigue = true;
        int i = 0;

        AtenderTareas.OrdearTareas(tiempoClientes);

        while (i < numeroClientes && sigue) {
            if (tiempoClientes[i].getMinutos() < horarioAtencion) {
                ConjuntoSolucion[i] = tiempoClientes[i];
                horarioAtencion = horarioAtencion - tiempoClientes[i].minutos;
                i += 1;
            }
            else
                sigue = false;
        }
        
        return(ConjuntoSolucion);
    } 

    private static void OrdearTareas(Tareas[] tareas){
        Tareas aux;
        int tamanoArreglo = tareas.length;
    
        for (int i = 0; i < tamanoArreglo; i++) {
            for (int j = 1; j < (tamanoArreglo - i); j++) {
                if (tareas[j - 1].getMinutos() > tareas[j].getMinutos()) {
                    aux = tareas[j - 1];
                    tareas[j - 1] = tareas[j];
                    tareas[j] = aux;
                }
            }
        }

    }

    private  Tareas[] tiempoClientes(int numClientes){
        Tareas[] tiempoClientes = new Tareas[numClientes];
        Random random = new Random();
        for(int i = 0; i < numClientes; i++){
            int randomNumber = random.nextInt(7) + 1;
            switch (randomNumber) {
                case 1:
                    tiempoClientes[i] = new Tareas(45,"Cambio de módulo de pantalla");
                    break;
                case 2:
                    tiempoClientes[i] = new Tareas(15,"Cambio de batería"); 
                    break;
                case 3:
                    tiempoClientes[i] = new Tareas(120,"Problema de software"); 
                    break;
                case 4:
                    tiempoClientes[i] = new Tareas(25,"Cambio de pin de carga");  
                    break;
                case 5:
                    tiempoClientes[i] = new Tareas(80,"Cambio de parlante");  
                    break;
                case 6:
                    tiempoClientes[i] = new Tareas(30,"Cambio de tapa trasera"); 
                    break;
                default:
                    tiempoClientes[i] = new Tareas(60,"Otro");  
                    break;
            }
        }
        return(tiempoClientes);
    }

    private static void MotrarTareas(Tareas[] tareas){
        for (int i = 0; i < tareas.length; i++) {
            if(tareas[i] != null)
                System.out.print(tareas[i].getMinutos() + " ");
            else
                break;
        }
    }


    public static void main(String[] args) {
        AtenderTareas tarea1 = new AtenderTareas();
        Tareas[] tiempoClientes = tarea1.tiempoClientes(20);
        Tareas[] cojuntoSolucion;

        cojuntoSolucion = AtenderTareas.MinimizacionTiempo(tiempoClientes);
        
        System.out.println("Tiempos de taread de clientes: ");
        AtenderTareas.MotrarTareas(tiempoClientes);

        System.out.println("\n\nConjunto Solucion: ");
        AtenderTareas.MotrarTareas(cojuntoSolucion);

    }

}
