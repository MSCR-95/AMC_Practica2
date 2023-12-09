package amc_practica2;

import java.util.List;

public class AFND {

    private int[] estadosFinales; //indica cuales son los estados Finales
    private List<TransicionAFND> transiciones; //indica la lista de transiciones del AFND
    private List<Transicionλ> transicionesλ; //indica la lista de transiciones λ del AFND

    public AFND() {
    }

    public void agregarTransicion(int e1, char simbolo, int[] e2) {
    }

    public void agregarTransicionλ(int e1, int[] e2) {
    }

    private int[] transicion(int estado, char simbolo) {
        int a[] = null;
        return a;
    }

    public int[] transicion(int[] macroestado, char simbolo) {
        int a[] = null;
        return a;
    }

    public int[] transicionλ(int estado) {

        return estadosFinales;
    }

    private boolean esFinal(int estado) {
        return false;
    }

    public boolean esFinal(int[] macroestado) {
        return false;
    }

    private int[] λ_clausura(int[] macroestado) {
        return macroestado;
    }

    public boolean reconocer(String cadena) {
        char[] simbolo = cadena.toCharArray();
        int[] estado = {0}; //El estado inicial es el 0
        int[] macroestado = λ_clausura(estado);
        for (int i = 0; i < simbolo.length; i++) {
            macroestado = transicion(macroestado, simbolo[i]);
        }
        return esFinal(macroestado);
    }

    public static AFND pedir() {
        AFND A = null;
        return A;
    }
}
