package practico7;

import java.util.Random;

public class Peticion {
    private int ingreso;
    private int duracion;
    private int tiempoRestante;
    private int comienzaAtencion;
    private boolean prioritaria;

    

    public Peticion(int ingreso) {
        Random rand = new Random(ingreso);

        this.ingreso = ingreso;
        this.duracion = this.tiempoRestante = rand.nextInt(251)+50;
        this.prioritaria = rand.nextInt(10)==5;
    }

    public boolean esPrioritaria(){
        return this.prioritaria;
    }

    public int procesar(){
        this.tiempoRestante--;
        return this.tiempoRestante;
    }

    public int espera(){
        return (this.comienzaAtencion - this.ingreso);
    }

    public void setComienzaAtencion(int comienzaAtencion) {
        this.comienzaAtencion = comienzaAtencion;
    }

    
    
}
