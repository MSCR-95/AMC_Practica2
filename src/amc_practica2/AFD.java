package amc_practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class AFD implements Proceso {

    private List<Integer> estadosFinales; //DECISIONES: cambiamos int [] a List
    private List<TransicionAFD> transiciones;

    private List<Integer> estados;
    private int inicial = 0;

    public AFD() {
        estadosFinales = new ArrayList<>();
        transiciones = new ArrayList<>();
        estados = new ArrayList<>();
    }

    public void agregarTransicion(int e1, String simbolo, int e2) {

        if (estados.contains(e1) && estados.contains(e2)) {
            TransicionAFD e = new TransicionAFD(e1, simbolo, e2);
            transiciones.add(e);
            System.out.println("transicion añadida con exito");
        } else {
            System.out.println("No se ha agregado la transicion");
        }

    }

    /**
     * Dado un estado y un simbolo,devuelve el estado de destino de la
     * transicion o -1n si no existe la transicion
     *
     * @param estado
     * @param simbolo
     * @return
     */
    public int transicion(int estado, String simbolo) {
        int e2 = -1; //Estado de destino
        int t = 0;
        boolean encontrado = false;

        while (!encontrado && t < transiciones.size()) {
            if (transiciones.get(t).getE1() == estado && transiciones.get(t).getSimbolo().equals(simbolo)) {
                encontrado = true;
                e2 = transiciones.get(t).getE2();   //obtenemos el estado de destino
            } else {
                t++;
            }
        }
        //No encontramos ninguna transicion con ese estado de origen y esa etiqueta
        /*
        if(!encontrado){
            e2 = -1;
        }
         */
        return e2;
    }

    /**
     * Devuelve true si el estado pasado por parametro esta entre los estados
     * finales
     *
     * @param estado
     * @return
     */
    @Override
    public boolean esFinal(int estado) {
        return estadosFinales.contains(estado);
    }

    /**
     * True si la cadena pertenece al lenguaje descrito en el AFD
     *
     * @param cadena
     * @return
     */
    @Override
    public boolean reconocer(String cadena) {
        String[] simbolo = cadena.split(",");
        int estado = 0; //El estado inicial es el 0

        for (String simbolo1 : simbolo) {
            estado = transicion(estado, simbolo1);
        }
        return esFinal(estado);

    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public void añadirEstado(int e1) {
        if (!estados.contains(e1)) {
            estados.add(e1);
        }
    }

    public void añadirFinal(int e) {     //Puede que tengamos que cambiarlo a boolean
        if (!estadosFinales.contains(e)) {
            if (estados.contains(e)) {
                estadosFinales.add(e);
                //System.out.println("Se ha añadido como final con exito");
            } else {
                System.out.println("El estado introducido no pertenece a la lista de estados");
            }
        } else {
            System.out.println("El estado ya es un estado final");
        }
    }

    public static AFD pedir() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String cadena;
        AFD automataAFD = new AFD();
        TransicionAFD transicion;
  
        System.out.println("Añade los estados");                //ESTADOS
        cadena = br.readLine();
        String[] estadosArray = cadena.split("\\s+");

        for (String estado : estadosArray) {
            if (!estado.isEmpty()) {
                try {
                    int numero = Integer.parseInt(estado);
                    automataAFD.añadirEstado(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + estado + " no es un número entero válido.");
                }
            }
        }
        System.out.println("Añade el estado inicial");          //ESTADO INICIAL
        cadena = br.readLine();
        automataAFD.setInicial(Integer.parseInt(cadena));

        System.out.println("Añade los estados finales");        //ESTADOS FINALES
        cadena = br.readLine();
        String[] estadosFinalesArray = cadena.split("\\s+");

        for (String estado : estadosFinalesArray) {
            if (!estado.isEmpty()) {
                try {
                    int numero = Integer.parseInt(estado);
                    automataAFD.añadirFinal(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + estado + " no es un número entero válido.");
                }
            }
        }
        
        return automataAFD;
    }

    public int getInicial() {
        return inicial;
    }

    @Override
    public String toString() {
        String s = "";
        s += "TIPO: AFD\n";
        s += "ESTADOS: ";
        for (int i = 0; i < estados.size() - 1; i++) {
            s += estados.get(i) + " ";
        }
        s += "INICIALES: ";
        s += getInicial() + "\n";
        s += "FINALES: ";
        for (int i = 0; i < estadosFinales.size() - 1; i++) {
            s += estadosFinales.get(i) + " ";
        }
        s += "TRANSICIONES: \n";
        for (int i = 0; i < transiciones.size() - 1; i++) {
            s += transiciones.get(i) + " ";
        }
        s += "FIN";
        return s;
    }
    /*
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("TIPO: AFD\n");
        s.append("ESTADOS: ");
        for (int i = 0; i < estados.size() - 1; i++) {
            s.append(estados.get(i)).append(" ");
        }
        s.append("INICIAL: ").append(getInicial()).append("\n");
        s.append("FINALES: ");
        for (int i = 0; i < estadosFinales.size() - 1; i++) {
            s.append(estadosFinales.get(i)).append(" ");
        }
        s.append("TRANSICIONES: \n");
        for (TransicionAFD transicion : transiciones) {
            s.append(transicion).append(" ");
        }
        s.append("FIN");
        return s.toString();
    }
    */
}
