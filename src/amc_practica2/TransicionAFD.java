package amc_practica2;

public class TransicionAFD {
    int e1, e2;
    String simbolo; //DECISIONES: canviamos el char a String porque en el enunciado indica que tenemos que etiquetar alfanumericamente

    /**
     * Constructor. Crea una transiccion para un automata AFD
     * @param e1 estado de origen.
     * @param simbolo etiqueta para identificar la transicion.
     * @param e2  estado de destino.
     */
    public TransicionAFD(int e1, String simbolo, int e2){
        this.e1 = e1;
        this.simbolo = simbolo;
        this.e2 = e2;
    }
    
    /**
     * Devuelve el estado de origen
     * @return 
     */
    public int getE1() {
        return e1;
    }

    /**
     * Devuelve el estado de destino
     * @return 
     */
    public int getE2() {
        return e2;
    }
    
    /**
     * Devuelve la etiqueta de la transicion
     * @return 
     */
    public String getSimbolo() {
        return simbolo;
    }
    
    /**
     * Inserta el estado de origen de la transicion
     * @param e1 
     */
    public void setE1(int e1) {
        this.e1 = e1;
    }
    
    /**
     * Inserta el destino de la transicion 
     * @param e2 
     */
    public void setE2(int e2) {
        this.e2 = e2;
    }
    
    /**
     * Inserta la etiqueta de la transicion
     * @param simbolo 
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    @Override
    public String toString(){
        String s = e1 + "\t'" + simbolo + "'\t" + e2;
        return s;
    }
}
