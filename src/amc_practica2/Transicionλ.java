package amc_practica2;

import java.util.List;

public class Transicionλ {

    private String e1;
    List<String> e2;

    /**
     * Constructor. Crea una transición para un automata AFD
     *
     * @param e1 estado de origen.
     * @param e2 lista de estados de destino.
     */
    public Transicionλ(String e1, List<String> e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    /**
     * Devuelve el estado de origen
     * @return
     */
    public String getE1() {
        return e1;
    }

    /**
     * Devuelve el estado de destino
     * @return
     */
    public List<String> getE2() {
        return e2;
    }

    /**
     * Inserta el estado de origen de la transición
     * @param e1
     */
    public void setE1(String e1) {
        this.e1 = e1;
    }

    /**
     * Inserta el destino de la transición
     * @param e2
     */
    public void setE2(List<String> e2) {
        this.e2 = e2;
    }

    @Override
    public String toString(){
        String s = e1 + " " + e2;
        return s;
    }
}