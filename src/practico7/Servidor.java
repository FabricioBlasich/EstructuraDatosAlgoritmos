package practico7;

import java.util.Random;

public class Servidor {
    private int tiempoActual;
    private int tiempoTotal; //  tiempo total milisegundos que durará la simulación
    private int tiempoInactivo;
    private ListaCircular LC_Prioridad = new ListaCircular<Peticion>();
    private ListaCircular LC_Comun = new ListaCircular<Peticion>();
    private Peticion enCurso;
    private int tiempoEsperaMaxPetPrioritarias;
    private int tiempoEsperaMaxPetComunes;
    private int peticionaPrioritariaAtendidas;
    private int peticionaComunesAtendidas;
    final int  TIEMPO_PROCESAMIENTO = 5;
    private int tiempoRestanteProcesamiento = 0;


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

    public void procesar(){  //cada peticion se procesara 1ms
        this.tiempoActual = 0;
        while(tiempoActual < tiempoTotal){
            Peticion ingresa = this.nuevaPeticion();

            if(ingresa != null){
                if(ingresa.esPrioritaria()){
                    LC_Prioridad.LC_Insertar(ingresa);
                    LC_Prioridad.LC_Rotar();
                }
                else{
                    LC_Comun.LC_Insertar(ingresa);
                    LC_Comun.LC_Rotar();
                }
            }


            if(!LC_Prioridad.EsLC_Vacia() || !LC_Comun.EsLC_Vacia()){

                if(this.enCurso == null && !LC_Prioridad.EsLC_Vacia()){
                    this.enCurso = (Peticion) this.LC_Prioridad.LC_Valor();
                    this.enCurso.setComienzaAtencion(tiempoActual);
                }else if(this.enCurso == null && !LC_Comun.EsLC_Vacia()){
                    this.enCurso = (Peticion) this.LC_Comun.LC_Valor();
                    this.enCurso.setComienzaAtencion(tiempoActual);
                }

                if(this.enCurso.esPrioritaria()){
                    if(this.enCurso.procesar() < 0){
                        if(this.tiempoEsperaMaxPetPrioritarias < this.enCurso.espera())
                            this.tiempoEsperaMaxPetPrioritarias = this.enCurso.espera();
                        this.LC_Prioridad.LC_Borrar();
                        this.enCurso = null;
                        this.peticionaPrioritariaAtendidas++;
                    }
                    else if(this.tiempoRestanteProcesamiento < TIEMPO_PROCESAMIENTO)
                        tiempoRestanteProcesamiento++;
                    else{
                        LC_Prioridad.LC_Rotar();
                        tiempoRestanteProcesamiento = 0;
                    }             
                }
                else{
                    if(this.enCurso.procesar() < 0){
                        if(this.tiempoEsperaMaxPetComunes < this.enCurso.espera())
                            this.tiempoEsperaMaxPetComunes = this.enCurso.espera();
                        this.LC_Comun.LC_Borrar();
                        this.enCurso = null;
                        this.peticionaComunesAtendidas++;
                    }
                    else if(this.tiempoRestanteProcesamiento < TIEMPO_PROCESAMIENTO)
                        tiempoRestanteProcesamiento++;
                    else{
                        LC_Comun.LC_Rotar();
                        tiempoRestanteProcesamiento = 0;
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
        System.out.println("Cantidad de peticiones prioritarias sin atender al finalizar: " + this.LC_Prioridad.getCantidad());
        System.out.println("Cantidad de peticiones comunes sin atender al finalizar: " + this.LC_Comun.getCantidad());
        System.out.println("Tiempo máximo de espera de las peticiones con prioridad: " + this.tiempoEsperaMaxPetPrioritarias);
        System.out.println("Tiempo máximo de espera de las peticiones comunes: " + this.tiempoEsperaMaxPetComunes);
        System.out.println("Tiempo total del servidor inactivo: " + this.tiempoInactivo);
        System.out.println("Tamaño máximo de la fila prioritaria: " + this.LC_Prioridad.longitudMaxima());
        System.out.println("Tamaño máximo de la fila común: " + this.LC_Comun.longitudMaxima());
    }
        

}
