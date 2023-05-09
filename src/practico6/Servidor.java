package practico6;

import java.util.Random;

public class Servidor {
    private int tiempoActual;
    private int tiempoTotal; //  tiempo total milisegundos que durará la simulación
    private int tiempoInactivo;
    private Fila filaPrioridad = new Fila<Peticion>();
    private Fila filaComun = new Fila<Peticion>();
    private Peticion enCurso;
    private int tiempoEsperaMaxPetPrioritarias;
    private int tiempoEsperaMaxPetComunes;
    private int peticionaPrioritariaAtendidas;
    private int peticionaComunesAtendidas;

    public Servidor(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
        this.peticionaPrioritariaAtendidas = 0;
        this.tiempoEsperaMaxPetComunes = 0;
        this.enCurso = null;
    }

    private Peticion nuevaPeticion(){
        Random rand = new Random();

        if(rand.nextInt(100)==50){
            Peticion peticion = new Peticion(this.tiempoActual);
            return peticion;
        }

        return null;
    }

    public void procesar(){
        this.tiempoActual = 0;
        while(tiempoActual < tiempoTotal){
            Peticion ingresa = this.nuevaPeticion();

            if(ingresa != null){
                ingresa.setComienzaAtencion(tiempoActual);
                if(ingresa.esPrioritaria())
                    filaPrioridad.enFila(ingresa);
                else
                    filaComun.enFila(ingresa);
            }


            if(!filaPrioridad.esFilaVacia() || !filaComun.esFilaVacia()){

                if(this.enCurso == null && !filaPrioridad.esFilaVacia()){
                    this.enCurso = (Peticion) this.filaPrioridad.Frente();
                    this.enCurso.setComienzaAtencion(tiempoActual);
                }else if(this.enCurso == null && !filaComun.esFilaVacia()){
                    this.enCurso = (Peticion) this.filaComun.Frente();
                    this.enCurso.setComienzaAtencion(tiempoActual);
                }

                if(this.enCurso.esPrioritaria()){
                    if(this.enCurso.procesar() == 0){
                            if(this.tiempoEsperaMaxPetPrioritarias < this.enCurso.espera())
                                this.tiempoEsperaMaxPetPrioritarias = this.enCurso.espera();
                            this.filaPrioridad.deFila();
                            this.enCurso = null;
                            this.peticionaPrioritariaAtendidas++;
                        }
                }
                else{
                    if(this.enCurso.procesar() == 0){
                            if(this.tiempoEsperaMaxPetComunes < this.enCurso.espera())
                                this.tiempoEsperaMaxPetComunes = this.enCurso.espera();
                            this.filaComun.deFila();
                            this.enCurso = null;
                            this.peticionaComunesAtendidas++;
                        }
                }
            }else
                tiempoInactivo++;


            tiempoActual++;
        }
    }

    public void resultados(){
        System.out.println("\n");
        System.out.println("Cantidad total de peticiones atendidas: " + (this.peticionaComunesAtendidas + this.peticionaPrioritariaAtendidas));
        System.out.println("Cantidad de peticiones prioritarias atendidas: " + this.peticionaPrioritariaAtendidas);
        System.out.println("Cantidad de peticiones comunes atendidas: " + this.peticionaComunesAtendidas);
        System.out.println("Cantidad de peticiones prioritarias sin atender al finalizar: " + this.filaPrioridad.getCantidad());
        System.out.println("Cantidad de peticiones comunes sin atender al finalizar: " + this.filaComun.getCantidad());
        System.out.println("Tiempo máximo de espera de las peticiones con prioridad: " + this.tiempoEsperaMaxPetPrioritarias);
        System.out.println("Tiempo máximo de espera de las peticiones comunes: " + this.tiempoEsperaMaxPetComunes);
        System.out.println("Tiempo total del servidor inactivo: " + this.tiempoInactivo);
        System.out.println("Tamaño máximo de la fila prioritaria: " + this.filaPrioridad.longitudMaxima());
        System.out.println("Tamaño máximo de la fila común: " + this.filaComun.longitudMaxima());
    }
        

}
