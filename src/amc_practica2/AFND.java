package amc_practica2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AFND implements Proceso {

    private List<String> estadosFinales; //indica cuales son los estados Finales
    private List<TransicionAFND> transiciones; //indica la lista de transiciones del AFND
    private List<Transicionλ> transicionesL; ////indica la lista de transiciones λ del AFND
    private List<String> estados;
    private List<String> simbolos;  //Añadido para la representacion
    private String inicial = ""; // Estado inicial ahora es un String

    public AFND() {
        estadosFinales = new ArrayList<>();
        transiciones = new ArrayList<>();
        transicionesL = new ArrayList<>();
        estados = new ArrayList<>();
        simbolos = new ArrayList<>();
    }

    /**
     * Devuelve una lista con los estados finales
     *
     * @return
     */
    public List<String> getEstadosFinales() {
        return estadosFinales;
    }

    /**
     * Devuelve las transiciones del automata
     *
     * @return
     */
    public List<TransicionAFND> getTransiciones() {
        return transiciones;
    }

    /**
     * Devuelve las transiciones λ del automata
     *
     * @return
     */
    public List<Transicionλ> getTransicionesL() {
        return transicionesL;
    }

    /**
     * Devuelve la lista con los estados del automata
     *
     * @return
     */
    public List<String> getEstados() {
        return estados;
    }

    public List<String> getSimbolos() {
        return simbolos;
    }

    public void agregarSimbolo(String simbolo) {
        if (!simbolos.contains(simbolo)) {
            simbolos.add(simbolo);
        }
    }

    public String getInicial() {
        return inicial;
    }

    /**
     * Agrega una transicion al estado
     *
     * @param e1
     * @param simbolo
     * @param e2
     */
    public void agregarTransicion(String e1, String simbolo, ArrayList<String> e2) {
        if (estados.contains(e1) && estados.containsAll(e2)) {
            TransicionAFND e = new TransicionAFND(e1, simbolo, e2);
            transiciones.add(e);
            //System.out.println("Transicion añadida con exito");
        } else {
            System.out.println("Los estados no pertenecen a la lista de estados");
        }
    }

    /*
    public void agregarTransicion(String e1, String simbolo, ArrayList<String> e2) {
        if (estados.contains(e1) && estados.contains(e2)) {
            for (int i = 0; i < e2.size(); i++) {
                if (estados.contains(e2.get(i))) {
                    TransicionAFND e = new TransicionAFND(e1, simbolo, e2);
                    transiciones.add(e);
                    //System.out.println("Transicion añadida con exito");
                }
            }
        } else {
            System.out.println("Los estados no pertenecen a la lista de estados");
        }
    }
     */

    public void agregarL_Transicion(String e1, ArrayList<String> e2) {
        int i = 0;
        boolean encontrado = false;
        //Busca si hay alguna macroTransicion con el estado de origen e1.
        while (!encontrado && i < transicionesL.size()) {
            if (transicionesL.get(i).getE1().equals(e1)) {
                encontrado = true;
                transicionesL.get(i).addE2(e2);
            } else {
                i++;
            }
        }
        //Si no hay ninguna L_transicion que tenga e1 "e1" como estado de origen, se 
        //añade a la lista.
        if (!encontrado) {
            if (estados.contains(e1) && estados.containsAll(e2)) {
                transicionesL.add(new Transicionλ(e1, e2));
            }
        }
    }

    private ArrayList<String> transicion(String estadoOrigen, String simbolo) {
        ArrayList<String> estadosDestino = new ArrayList(); //-1 si no existe la macroTransicion
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < transiciones.size()) {
            //Si encuentra una transición con eOrigen y símbolo pasados por
            //parámetro, entonces los estados de destino serán los que devuelva
            //esa transición.
            if (transiciones.get(i).getE1().equals(estadoOrigen)
                    && transiciones.get(i).getSimbolo().equals(simbolo)) {
                encontrado = true;
                estadosDestino.clear();
                estadosDestino.addAll(transiciones.get(i).getE2());
            } else {
                i++;
            }
        }
        //Si no lo encuentra significa que no existe ninguna transicion con ese
        //estado de origen por lo que devuelve el destino -1.
        if (!encontrado) {
            estadosDestino.clear();
            estadosDestino.add("M");
        }
        return estadosDestino;
    }

    private ArrayList<String> macroTransicion(ArrayList<String> macroEstado, String simbolo) {
        ArrayList<String> macroDestino = new ArrayList();
        for (int i = 0; i < macroEstado.size(); i++) {
            //Si la macroTransicion no es al estado muerto (M), añade todas las transiciones al macroDestino
            if (!transicion(macroEstado.get(i), simbolo).contains("M")) {
                macroDestino.addAll(transicion(macroEstado.get(i), simbolo));
            }
        }
        return macroDestino;
    }

    /**
     * Devuelve true si estado es un estado final,.
     *
     * @param estado
     * @return
     */
    @Override
    public boolean esFinal(String estado) {
        return estadosFinales.contains(estado);
    }

    //COMPROBAR
    private boolean esFinal(ArrayList<String> macroEstado) {
        //hace la intersección con los estados finales.
        macroEstado.retainAll(getEstadosFinales());
        //se queda solamente con los elementos que tengan en común, por lo que
        //si macroestado no está vacío quiere decir que hay al menos un estado que
        //también se encuentra en los estados finales.
        return !macroEstado.isEmpty();
    }

    /**
     * Añade un estado final a la lista de estados finales
     *
     * @param e
     */
    public void añadirFinal(String e) {
        if (!estadosFinales.contains(e)) {
            if (estados.contains(e)) {
                estadosFinales.add(e);
            } else {
                System.out.println("El estado introducido no pertenece a la lista de estados");
            }
        } else {
            System.out.println("El estado ya es un estado final");
        }
    }

    /**
     * Inserta el estado inicial
     *
     * @param inicial
     */
    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    /**
     * Añade un estado a la lista de estados
     *
     * @param estado
     */
    public void añadirEstado(String estado) {
        if (!estados.contains(estado)) {
            estados.add(estado);
        }
    }

    public ArrayList<String> lambdaClausura(String estado, ArrayList<String> visitados) {
        ArrayList<String> resultados = new ArrayList();
        resultados.add(estado);
        if (!visitados.contains(estado)) {
            for (int i = 0; i < transicionesL.size(); i++) {
                if (transicionesL.get(i).getE1().equals(estado) && !visitados.contains(estado)) {
                    visitados.add(estado);
                    for (int j = 0; j < transicionesL.get(i).getE2().size(); j++) {
                        if (!visitados.contains(transicionesL.get(i).getE2().get(j))) {
                            resultados.addAll(lambdaClausura(transicionesL.get(i).getE2().get(j), visitados));
                        }
                    }
                }
            }
            //Si no existe ninguna transicion Lambda con origen en "estado",
            if (!visitados.contains(estado)) {
                visitados.add(estado);
            }
        } else {
            resultados.clear();
        }
        return resultados;
    }

    /**
     * Elimina los elementos repetidos en la lista pasada por parámetro.
     *
     * @param lista Lista a la que queremos eliminar las repeticiones.
     */
    private void eliminarRepeticiones(ArrayList<String> lista) {
        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        hs.clear();
    }

    @Override
    public boolean reconocer(String cadena) {
        String[] simbolos = cadena.split(",");
        ArrayList<String> estadosActuales = lambdaClausura(inicial, new ArrayList<>());

        System.out.println("Estado inicial: " + String.join("", estadosActuales));

        for (String simbolo : simbolos) {
            ArrayList<String> nuevosEstados = new ArrayList<>();

            for (String estadoActual : estadosActuales) {
                ArrayList<String> nuevoEstado = macroTransicion((ArrayList<String>) Collections.singletonList(estadoActual), simbolo);
                // System.out.println("**nuevo estado:" + String.join("", nuevoEstado)); // Modificado para eliminar espacios en blanco
                nuevosEstados.addAll(lambdaClausura(String.join("", nuevoEstado), new ArrayList<>()));
            }

            estadosActuales = nuevosEstados;
            System.out.println("Después de la transición con '" + simbolo + "': " + String.join("", estadosActuales));

            if (estadosActuales.isEmpty() || estadosActuales.contains("M")) {
                System.out.println("La cadena no tiene transiciones correctas.");
                return false;
            }
        }

        // Verificamos si termina en algún estado final
        if (esFinal(estadosActuales)) {
            System.out.println("La cadena termina en uno de los estados finales: " + String.join("", estadosActuales));
            return true;
        } else {
            System.out.println("La cadena no termina en un estado final.");
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += "TIPO: AFND\n";
        s += "ESTADOS: ";
        for (int i = 0; i < estados.size(); i++) {
            s += estados.get(i) + " ";
        }
        s += "\nINICIAL: ";
        s += getInicial() + "\n";
        s += "FINALES: ";
        for (int i = 0; i < estadosFinales.size(); i++) {
            s += estadosFinales.get(i) + " ";
        }
        s += "\nTRANSICIONES:\n";
        for (int i = 0; i < transiciones.size(); i++) {
            s += transiciones.get(i) + "\n";
        }

        s += "TRANSICIONES LAMBDA:\n";
        for (int i = 0; i < transicionesL.size(); i++) {
            s += transicionesL.get(i) + "\n";
        }

        s += "FIN";
        return s;
    }

    /*
     @Override
    public boolean reconocer(String cadena) {
        String[] simbolo = cadena.split(",");
        ArrayList<String> estado = new ArrayList();
        ArrayList<String> estadoaux = new ArrayList();
        ArrayList<String> visitados = new ArrayList();
        estado.addAll(lambdaClausura(inicial, visitados));
        System.out.println("Inicio: " + estado);
        for (int i = 0; i < simbolo.length; i++) {

            System.out.print("Transición " + (i + 1) + ": " + estado + " -(" + simbolo[i] + ")> ");

            estadoaux.addAll(estado);
            estado.addAll(macroTransicion(estado, simbolo[i]));
            estado.retainAll(macroTransicion(estadoaux, simbolo[i]));

            eliminarRepeticiones(estado);
            visitados.clear();
            estadoaux.clear();
            for (int j = 0; j < estado.size(); j++) {
                estado.addAll(lambdaClausura(estado.get(j), visitados));
            }

            eliminarRepeticiones(estado);
            System.out.println(estado);
            if (estado.isEmpty()) {
                //vMensaje.Mensaje("error", "La cadena no tiene transiciones correctas.\n Comprueba la sintaxis de la cadena.");
                //break;
            }
        }
        return esFinal(estado);
    }
     */
}
