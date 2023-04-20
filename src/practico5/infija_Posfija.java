package practico5;

public class infija_Posfija {
    
    public static String Convertir(String infija){
        String posfija = "";
        Pila pilaOperadores = new Pila<Character>();

        while(!infija.isEmpty()){
            char primeroInfija = infija.charAt(0);
            if(Character.isLetter(primeroInfija))
                posfija = posfija.concat(Character.toString(primeroInfija));
            else if(pilaOperadores.esPilaVacia())
                pilaOperadores.push(primeroInfija);
            else{   
                int operatorPriority = prioridadOperdador(primeroInfija);
                if(operatorPriority == 0){
                    while(!pilaOperadores.esPilaVacia()){
                        posfija = posfija.concat(Character.toString((Character)pilaOperadores.top()));
                        pilaOperadores.pop();
                    }
                }else if(!(operatorPriority == -1)){ // operatorPriority = ')'
                    if(operatorPriority <= prioridadOperdador(((Character)pilaOperadores.top())) && operatorPriority != 1){
                        while(!pilaOperadores.esPilaVacia() && operatorPriority <= prioridadOperdador(((Character)pilaOperadores.top())) ){
                            posfija = posfija.concat(Character.toString((Character)pilaOperadores.top()));
                            pilaOperadores.pop();
                        }
                    }
                    pilaOperadores.push(primeroInfija);
                }else{
                    while((Character)pilaOperadores.top() != '('){
                        posfija = posfija.concat(Character.toString((Character)pilaOperadores.top()));
                        pilaOperadores.pop();
                    }
                    pilaOperadores.pop();
                }  
                    
            }
        infija = infija.substring(1); 
        }

        return(posfija);
    }


    private static int prioridadOperdador(char operador){
        switch (operador) {
            case '=':
                return 0;
            case '(':
                return 1;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 3;
            default:
                return -1; // ')'
        }
    }

    public boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


}
