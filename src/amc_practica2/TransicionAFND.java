package amc_practica2;

public class TransicionAFND {

    private String e1, e2;
    private String simbolo;

    /**
     * Constructor. Crea una transición para un automata AFD
     *
     * @param e1 estado de origen.
     * @param simbolo etiqueta para identificar la transición.
     * @param e22 lista de estados de destino.
     */
    public TransicionAFND(String e1, String simbolo, String e2) {
        this.e1 = e1;
        this.simbolo = simbolo;
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
    public String getE2() {
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
     * @param e1
     */
    public void setE1(String e1) {
        this.e1 = e1;
    }

    /**
     * Inserta el destino de la transición
     * @param e2
     */
    public void setE2(String e2) {
        this.e2 = e2;
    }

    /**
     * Inserta la etiqueta de la transición
     * @param simbolo
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString(){
        String s = e1 + " '" + simbolo + "' " + e2;
        return s;
    }
}
