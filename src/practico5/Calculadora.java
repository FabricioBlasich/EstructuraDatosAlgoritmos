package practico5;

public class Calculadora {


    private int prioridadOperadorEnLaPila(char operador){
        switch (operador) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        
            default:
                return -1;
        }
    }

    private int prioridadOperadorFueraDeLaPila(char operador){
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 4;
            case '(':
                return 5;
        
            default:
                return 6;
        }
    }

    private boolean esOperador(char c){
        return(c == '(' || c == '+'  || c == '-' || c == '/' || c == '*' || c == '^' || c == ')');
    }

    private String convertirAPostfija(String infija){
        String posfija = "";
        Pila pilaOperadores = new Pila<Character>();
        char MF = '=';

        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i); // primer caracter de infija
            if (!this.esOperador(c) && c != MF) 
                posfija = posfija.concat(Character.toString(c));
            else{
                if(pilaOperadores.esPilaVacia())
                    pilaOperadores.push(c);
                else if(c == MF){
                    while (!pilaOperadores.esPilaVacia()) {
                        posfija = posfija.concat(Character.toString((Character)pilaOperadores.top()));
                        pilaOperadores.pop();
                    }
                }else if(c == ')'){
                    while((Character)pilaOperadores.top() != '('){
                        posfija = posfija.concat(Character.toString((Character)pilaOperadores.top()));
                        pilaOperadores.pop();
                    }
                    pilaOperadores.pop();  //Elimino el '(' de la pila
                }
                else{
                    if(this.prioridadOperadorFueraDeLaPila(c) > this.prioridadOperadorEnLaPila((Character)pilaOperadores.top()))
                        pilaOperadores.push(c);
                    else{
                        while(!pilaOperadores.esPilaVacia() && this.prioridadOperadorFueraDeLaPila(c) <= prioridadOperadorEnLaPila((Character)pilaOperadores.top())){
                            posfija = posfija.concat(Character.toString((Character)pilaOperadores.top()));
                            pilaOperadores.pop();
                        }
                        pilaOperadores.push(c);
                    }
                }
            }         
        }           
        return posfija;
    }


    private float evaluarPosfija(String posfija){
        int suma = 0;
        Pila pilaOperandos = new Pila<Float>(); 

        for (int i = 0; i < posfija.length(); i++) {
            char c = posfija.charAt(i); 
            if(!this.esOperador(c))
                pilaOperandos.push(Float.parseFloat(String.valueOf(c)));
            else{
                float op2 = (float) pilaOperandos.top();
                pilaOperandos.pop();
                float op1 = (float) pilaOperandos.top();
                pilaOperandos.pop();

                switch (c) {
                    case '+':
                        pilaOperandos.push(op1 + op2);
                        break;
                    case '-':
                        pilaOperandos.push(op1 - op2);
                        break;
                    case '*':
                        pilaOperandos.push(op1 * op2);
                        break;
                    case '/':
                        pilaOperandos.push(op1 / op2);
                        break;
                    case '^':
                        pilaOperandos.push(Math.pow(op1, op2));
                        break;
                
                    default:
                        break;
                }
            }
        }
        return (float) pilaOperandos.top();
    }


    public float evaluar( String infija){
        return(this.evaluarPosfija(this.convertirAPostfija(infija)));
    }


}


