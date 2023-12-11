package amc_practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AFD implements Proceso {

    private List<String> estadosFinales;
    private List<TransicionAFD> transiciones;
    private List<String> estados;
    private String inicial = ""; // Estado inicial ahora es un String

    public AFD() {
        estadosFinales = new ArrayList<>();
        transiciones = new ArrayList<>();
        estados = new ArrayList<>();
    }

    public List<String> getEstadosFinales() {
        return estadosFinales;
    }

    public List<TransicionAFD> getTransiciones() {
        return transiciones;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void agregarTransicion(String e1, String simbolo, String e2) {
        if (estados.contains(e1) && estados.contains(e2)) {
            TransicionAFD e = new TransicionAFD(e1, simbolo, e2);
            transiciones.add(e);
            //System.out.println("Transicion añadida con exito");
        } else {
            System.out.println("Los estados no pertenecen a la lista de estados");
        }
    }

    public String transicion(String estado, String simbolo) {
        String e2 = ""; // Estado de destino ahora es un String
        int t = 0;
        boolean encontrado = false;

        while (!encontrado && t < transiciones.size()) {
            if (transiciones.get(t).getE1().equals(estado) && transiciones.get(t).getSimbolo().equals(simbolo)) {
                encontrado = true;
                e2 = transiciones.get(t).getE2(); // Obtenemos el estado de destino
            } else {
                t++;
            }
        }

        return e2;
    }

    @Override
    public boolean esFinal(String estado) {
        return estadosFinales.contains(estado);
    }

    @Override
    public boolean reconocer(String cadena) {
        String[] simbolos = cadena.split(",");
        String estado = inicial;

        for (String simbolo : simbolos) {
            estado = transicion(estado, simbolo);
        }

        return esFinal(estado);
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public void añadirEstado(String estado) {
        if (!estados.contains(estado)) {
            estados.add(estado);
        }
    }

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

    public static AFD pedir() throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String cadena;
        AFD automataAFD = new AFD();
        //TransicionAFD transicion;

        System.out.println("Indica los estados");       //ESTADOS
        cadena = br.readLine();
        String[] estadosArray = cadena.split("\\s+");

        for (String estado : estadosArray) {
            if (!estado.isEmpty()) {
                automataAFD.añadirEstado(estado);
            }
        }
        System.out.println("Indica el estado inicial"); //ESTADO INICIAL
        cadena = br.readLine();
        automataAFD.setInicial(cadena);

        System.out.println("Indica los estados finales"); //ESTADOS FINALES
        cadena = br.readLine();
        String[] estadosFinalesArray = cadena.split("\\s+");

        for (String estado : estadosFinalesArray) {
            if (!estado.isEmpty()) {
                automataAFD.añadirFinal(estado);
            }
        }
        // AÑADIR TRANSICIONES
        /*
        System.out.println("Indique las transiciones (Formato: estadoOrigen simbolo estadoDestino)");
        cadena = br.readLine();
        System.out.println("Entrada de transiciones: " + cadena); // Agrega esta línea
        String[] transicionesArray = cadena.trim().split("\\s+");

        for (int i = 0; i < transicionesArray.length; i += 3) {
            try {
                String estadoOrigen = transicionesArray[i];
                System.out.println("**parte[0]" + estadoOrigen);
                String simbolo = transicionesArray[i + 1];
                System.out.println("**parte[1]" + simbolo);
                String estadoDestino = transicionesArray[i + 2];
                System.out.println("**parte[2]" + estadoDestino);
                automataAFD.agregarTransicion(estadoOrigen, simbolo, estadoDestino);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: La transicion no tiene el formato correcto.");
            }
        }
         */
        // AÑADIR TRANSICIONES
        System.out.println("Indica la cantidad de transiciones que deseas añadir:");
        int cantidadTransiciones = Integer.parseInt(br.readLine());

        for (int i = 0; i < cantidadTransiciones; i++) {
            System.out.println("Indique la transicion " + (i + 1) + " (Formato: estadoOrigen simbolo estadoDestino)");
            cadena = br.readLine().trim();

            String[] partesTransicion = cadena.split("\\s+");
            if (partesTransicion.length == 3) {
                String estadoOrigen = partesTransicion[0];
                String simbolo = partesTransicion[1];
                String estadoDestino = partesTransicion[2];
                automataAFD.agregarTransicion(estadoOrigen, simbolo, estadoDestino);
            } else {
                System.out.println("Error: La transicion no tiene el formato correcto.");
            }
        }

        return automataAFD;
    }

    public String getInicial() {
        return inicial;
    }

    @Override
    public String toString() {
        String s = "";
        s += "TIPO: AFD\n";
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
        s += "\nTRANSICIONES: \n";
        for (int i = 0; i < transiciones.size(); i++) {
            s += transiciones.get(i) + "\n";
        }
        s += "FIN";
        return s;
    }
}
