package amc_practica2;

import Visual.VentanaAFD;
import java.io.IOException;
import javax.swing.JFrame;

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
        AFND aut = gf.cargarAutomataAFND("src/amc_practica2/ficherosPruebas/automataAFND1.txt");
        System.out.println(aut);
        /*
        //PARTE DEL AFD
        GestionFicheros gf = new GestionFicheros();
        AFD aut = gf.cargarAutomataAFD("src/amc_practica2/ficherosPruebas/automataAFD1.txt");
        //System.out.println("estados: "+aut.getEstados());
        //System.out.println("estados finales: "+aut.getEstadosFinales());
        //System.out.println("transiciones: "+aut.getTransiciones());
        //System.out.println("***" +aut.transicion("q0", "0"));   //AÑADIDA PARA COMPROBACIONES
        System.out.println(aut+"\n");
        System.out.println("Numero de estados: " + aut.getEstados().size());
        System.out.println("Numero de simbolos: " + aut.getSimbolos().size());
        
        aut.imprimirTabla();
        
        VentanaAFD frame = new VentanaAFD();
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Parte 1B");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        */
        /*
        for (int i = 0; i < aut.getEstados().size(); i++) {
            for (int j = 0; j < aut.getSimbolos().size(); j++) {
                
            }
            
        }
        */
        /*
        System.out.println("cadena: 0,1,1,0");
        if(aut.reconocer("0,1,1,0")){
            System.out.println("Pertenece al automata\n");
        }else
            System.out.println("NO pertenece\n");
        
        System.out.println("cadena: 0,1");
        if(aut.reconocer("0,1")){
            System.out.println("Pertenece al automata\n");
        }else
            System.out.println("NO pertenece\n");
        
        System.out.println("cadena: 1,0");
        if(aut.reconocer("1,0")){
            System.out.println("Pertenece al automata\n");
        }else
            System.out.println("NO pertenece\n");
        */
        //System.out.println(aut);   
    }
    
}
