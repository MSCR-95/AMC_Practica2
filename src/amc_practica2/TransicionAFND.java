package amc_practica2;

import java.util.ArrayList;

public class TransicionAFND {

    private String e1;
    private ArrayList<String> e2 = new ArrayList<>();
    private String simbolo;

    /**
     * Constructor. Crea una transición para un automata AFD
     *
     * @param e1 estado de origen.
     * @param simbolo etiqueta para identificar la transición.
     * @param e2 lista de estados de destino.
     */
    public TransicionAFND(String e1, String simbolo, ArrayList<String> e2) {
        this.e1 = e1;
        this.simbolo = simbolo;
        this.e2 = e2;
    }

    /**
     * Añade un estado a la lista de estados de destino
     *
     * @param e
     */
    public void addE2(ArrayList<String> e) {
        for (int i = 0; i < e.size(); i++) {
            //Solo insertamos los estados que no estan en la lista de estados de destino
            if (!e2.contains(e.get(i))) {
                e2.addAll(e);
            }
        }
    }

    /**
     * Devuelve el estado de origen
     *
     * @return
     */
    public String getE1() {
        return e1;
    }

    /**
     * Devuelve una lista con los estados de destino
     *
     * @return
     */
    public ArrayList<String> getE2() {
        return e2;
    }

    /**
     * Devuelve la etiqueta de la transición
     *
     * @return
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Inserta el estado de origen de la transición
     *
     * @param e1
     */
    public void setE1(String e1) {
        this.e1 = e1;
    }

    /**
     * Inserta la lista de estados de destino
     *
     * @param e2
     */
    public void setE2(ArrayList<String> e2) {
        this.e2 = e2;
    }

    /**
     * Inserta la etiqueta de la transición
     *
     * @param simbolo
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        String s = e1 + " '" + simbolo + "' " + e2;
        return s;
    }
}
