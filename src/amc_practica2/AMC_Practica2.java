package amc_practica2;

import java.io.IOException;

/**
 *
 * @author Maria S
 */
public class AMC_Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        GestionFicheros gf = new GestionFicheros();
        AFD aut = gf.cargarAutomataAFD("src/amc_practica2/ficherosPruebas/automataAFD1.txt");
        //System.out.println("estados: "+aut.getEstados());
        //System.out.println("estados finales: "+aut.getEstadosFinales());
        //System.out.println("transiciones: "+aut.getTransiciones());
        //System.out.println("***" +aut.transicion("q0", "0"));   //AÑADIDA PARA COMPROBACIONES
        System.out.println(aut+"\n");

        if(aut.reconocer("0,1,1,0")){
            System.out.println("Pertenece al automata\n");
        }else
            System.out.println("NO pertenece\n");
        
        if(aut.reconocer("0,1")){
            System.out.println("Pertenece al automata\n");
        }else
            System.out.println("NO pertenece\n");
        
        if(aut.reconocer("1,0")){
            System.out.println("Pertenece al automata\n");
        }else
            System.out.println("NO pertenece\n");

        //System.out.println(aut);   
    }
    
}
