package amc_practica2;

import java.io.IOException;
import java.util.List;

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
        System.out.println(aut);

        if(aut.reconocer("0,1,1,0")){
            System.out.println("Pertenece al automata");
        }else
            System.out.println("NO pertenece");

        //System.out.println(aut);  
        
    }
    
}
