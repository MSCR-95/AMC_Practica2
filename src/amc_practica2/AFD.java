package amc_practica2;

import java.util.List;

public class AFD{

    private int [ ] estadosFinales;
    private List<TransicionAFD> transiciones;

    public AFD(){}
    public void agregarTransicion(int e1, char simbolo, int e2){
        TransicionAFD e = new TransicionAFD(e1, simbolo, e2);
        transiciones.add(e);
    }

    public int transicion(int estado, char simbolo){
        int t = 0;

        return t;
    }
    public boolean esFinal(int estado){

        return false;
    }
    public boolean reconocer(String cadena) {
        char[ ] simbolo = cadena.toCharArray();
        int estado = 0 ; //El estado inicial es el 0
        for(int i=0; i<simbolo.length; i++) {
            estado = transicion(estado,simbolo[i]);
        }
        return esFinal(estado);
    }

    public static AFD pedir(){
        AFD A = null;

        return A;
    }
}
