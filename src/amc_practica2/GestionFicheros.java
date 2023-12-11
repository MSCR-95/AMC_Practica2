package amc_practica2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Maria S
 */
public class GestionFicheros {

    //Se prodia modificar para introducir por parametros el tipo o combrobar el tipo y añadir las TRANSICIONES LAMBDA: si es un AFND
    public AFD cargarAutomataAFD(String nombreArchivo) throws IOException {
        AFD automataAFD = new AFD();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("TIPO: AFD")) {
                    // No es necesario hacer nada con esta línea
                } else if (linea.startsWith("ESTADOS:")) {
                    String[] estadosArray = linea.substring("ESTADOS: ".length()).split("\\s+");
                    for (String estado : estadosArray) {
                        if (!estado.isEmpty()) {
                            automataAFD.añadirEstado(estado);
                        }
                    }
                } else if (linea.startsWith("INICIAL:")) {
                    automataAFD.setInicial(linea.substring("INICIAL: ".length()));
                } else if (linea.startsWith("FINALES:")) {
                    String[] finalesArray = linea.substring("FINALES: ".length()).split("\\s+");
                    for (String estado : finalesArray) {
                        if (!estado.isEmpty()) {
                            automataAFD.añadirFinal(estado);
                        }
                    }
                } else if (linea.startsWith("TRANSICIONES:")) {
                    while ((linea = br.readLine()) != null && !linea.equals("FIN")) {
                        String[] partes = linea.split("\\s+");
                        if (partes.length == 3) {
                            String estadoOrigen = partes[0];
                            String simbolo = partes[1].replaceAll("'", ""); // Elimina comillas simples
                            String estadoDestino = partes[2];
                            automataAFD.agregarTransicion(estadoOrigen, simbolo, estadoDestino);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return automataAFD;
    }

    public void guardarAutomataAFD(AFD automataAFD, String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/amc_practica2/ficherosPruebas/" + nombreArchivo + ".txt"))) {
            writer.write("TIPO: AFD");
            writer.newLine();

            writer.write("ESTADOS: " + String.join(" ", automataAFD.getEstados()));
            writer.newLine();

            writer.write("INICIAL: " + automataAFD.getInicial());
            writer.newLine();

            writer.write("FINALES: " + String.join(" ", automataAFD.getEstadosFinales()));
            writer.newLine();

            writer.write("TRANSICIONES:");
            writer.newLine();
            for (TransicionAFD transicion : automataAFD.getTransiciones()) {
                writer.write(transicion.toString());
                writer.newLine();
            }
            writer.write("FIN");
        }
    }
}
