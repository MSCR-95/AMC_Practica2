package Visual;

import amc_practica2.AFD;
import amc_practica2.GestionFicheros;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Maria S
 */
public class VentanaAFD extends javax.swing.JFrame {

    private String nombreFichero;
    /*
    private String estadosFinales;
    private String estados;
    private String estadoInicial;
    */
    private boolean automataCargado = false;
    AFD aut;
    AFD autAux = new AFD();
    GestionFicheros gf = new GestionFicheros();

    public VentanaAFD() {

        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        PrintStream printStream = new PrintStream(new CustomOutputStream(texto));
        System.setOut(printStream);
        System.setErr(printStream);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        introducir_nombre = new javax.swing.JTextField();
        cargar_nombre = new javax.swing.JButton();
        transicion_txt = new javax.swing.JTextField();
        botonAñadirTransicion = new javax.swing.JButton();
        estados_text = new javax.swing.JTextField();
        botonAñadirEstados = new javax.swing.JButton();
        estadoInicial_text = new javax.swing.JTextField();
        botonAñadirEstadoInicial = new javax.swing.JButton();
        estadosFinales_txt = new javax.swing.JTextField();
        botonAñadirEstadosFinales = new javax.swing.JButton();
        boton_guardar = new javax.swing.JButton();
        cadena_text = new javax.swing.JTextField();
        boton_comprobar = new javax.swing.JButton();
        nuevoFicheroNombre_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(texto);

        introducir_nombre.setText("Nombre fichero");

        cargar_nombre.setText("Cargar");
        cargar_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_nombreActionPerformed(evt);
            }
        });

        transicion_txt.setText("Nueva transicion");
        transicion_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transicion_txtActionPerformed(evt);
            }
        });

        botonAñadirTransicion.setText("Añadir");
        botonAñadirTransicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirTransicionActionPerformed(evt);
            }
        });

        estados_text.setText("Estados");
        estados_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estados_textActionPerformed(evt);
            }
        });

        botonAñadirEstados.setText("Añadir");
        botonAñadirEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirEstadosActionPerformed(evt);
            }
        });

        estadoInicial_text.setText("Estado inicial");

        botonAñadirEstadoInicial.setText("Añadir");
        botonAñadirEstadoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirEstadoInicialActionPerformed(evt);
            }
        });

        estadosFinales_txt.setText("Estados finales");
        estadosFinales_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadosFinales_txtActionPerformed(evt);
            }
        });

        botonAñadirEstadosFinales.setText("Añadir");
        botonAñadirEstadosFinales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirEstadosFinalesActionPerformed(evt);
            }
        });

        boton_guardar.setText("Guardar");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        cadena_text.setText("cadena para comprobar");
        cadena_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadena_textActionPerformed(evt);
            }
        });

        boton_comprobar.setText("Comprobar");
        boton_comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_comprobarActionPerformed(evt);
            }
        });

        nuevoFicheroNombre_text.setText("Nombre nuevo fichero");
        nuevoFicheroNombre_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoFicheroNombre_textActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAñadirEstadosFinales)
                                .addGap(160, 160, 160)
                                .addComponent(botonAñadirTransicion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(estadosFinales_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(transicion_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonAñadirEstados)
                                    .addComponent(estados_text, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(estadoInicial_text, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonAñadirEstadoInicial))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(introducir_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoFicheroNombre_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cargar_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadena_text, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(boton_comprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estados_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoInicial_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(introducir_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAñadirEstados)
                            .addComponent(botonAñadirEstadoInicial)
                            .addComponent(cargar_nombre))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estadosFinales_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transicion_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAñadirEstadosFinales)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonAñadirTransicion)
                                .addComponent(nuevoFicheroNombre_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(boton_guardar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadena_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_comprobar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_nombreActionPerformed
        try {
            
            String nombre = introducir_nombre.getText();
            aut = gf.cargarAutomataAFD("src/amc_practica2/ficherosPruebas/" + nombre + ".txt");
            imprimirEnJTable(jTable1, aut);
            automataCargado = true;
        } catch (Exception e) {
            System.out.println("Error: el automata no existe");
        }
    }//GEN-LAST:event_cargar_nombreActionPerformed

    private void transicion_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transicion_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transicion_txtActionPerformed

    private void botonAñadirEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirEstadosActionPerformed
        try {
            String estados = this.estados_text.getText();
            System.out.println("estados " + estados);
            autAux.añadirEstadosVisual(estados, autAux);
        } catch (Exception e) {
            System.out.println("error al introducir los estados");
            Logger.getLogger(VentanaAFD.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_botonAñadirEstadosActionPerformed

    private void estados_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estados_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estados_textActionPerformed

    private void estadosFinales_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadosFinales_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadosFinales_txtActionPerformed

    private void botonAñadirEstadosFinalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirEstadosFinalesActionPerformed
            try {
            String estadosFinales = this.estadosFinales_txt.getText();
            System.out.println("estados finales " + estadosFinales);
            autAux.añadirFinalesVisual(estadosFinales, autAux);
        } catch (Exception e) {
            System.out.println("error al introducir los estados finales");
            Logger.getLogger(VentanaAFD.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_botonAñadirEstadosFinalesActionPerformed

    private void cadena_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadena_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadena_textActionPerformed

    private void nuevoFicheroNombre_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoFicheroNombre_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoFicheroNombre_textActionPerformed

    private void botonAñadirEstadoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirEstadoInicialActionPerformed
        try {
            String estadoInicial = this.estadoInicial_text.getText();
            System.out.println("estado inicial " + estadoInicial);
            autAux.añadirInicialVisual(estadoInicial, autAux);
        } catch (Exception e) {
            System.out.println("error al introducir el estado inicial");
            Logger.getLogger(VentanaAFD.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_botonAñadirEstadoInicialActionPerformed

    private void botonAñadirTransicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirTransicionActionPerformed
        try {
            String transicion = this.transicion_txt.getText();
            System.out.println("transicion " + transicion);
            autAux.añadirTransiccionVisual(transicion, autAux);
        } catch (Exception e) {
            System.out.println("error al introducir la transicion");
            Logger.getLogger(VentanaAFD.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_botonAñadirTransicionActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        try {
            nombreFichero = nuevoFicheroNombre_text.getText();
            gf.guardarAutomataAFD(autAux, nombreFichero);
            imprimirEnJTable(jTable1, autAux);
        } catch (IOException ex) {
            Logger.getLogger(VentanaAFD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_boton_guardarActionPerformed

    private void boton_comprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_comprobarActionPerformed
        try {
            String cadena = this.cadena_text.getText();
            System.out.println("cadena: " + cadena);
            if(automataCargado){
                aut.reconocer(cadena);
            }else{
                autAux.reconocer(cadena);
            }
            
        } catch (Exception e) {
            System.out.println("error al leer la cadena");
            Logger.getLogger(VentanaAFD.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_boton_comprobarActionPerformed

    // Clase para redirigir la salida estándar al JTextPane
    private static class CustomOutputStream extends OutputStream {

        private JTextPane textPane;

        public CustomOutputStream(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void write(int b) {
            StyledDocument doc = textPane.getStyledDocument();
            Style style = textPane.getStyle(StyleContext.DEFAULT_STYLE);
            try {
                doc.insertString(doc.getLength(), String.valueOf((char) b), style);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAFD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAFD().setVisible(true);
            }
        });
    }

    //Controlador tabla;
    //Este método imprimirá la información en el JTable
    public void imprimirEnJTable(javax.swing.JTable jTable, AFD automata) {
        // Obtén el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        // Limpia el contenido actual de la tabla
        model.setRowCount(0);
        model.setColumnCount(0);

        // Agrega las columnas (símbolos)
        model.addColumn("-");
        for (String simbolo : automata.getSimbolos()) {
            model.addColumn(simbolo);
        }

        // Agrega las filas (estados)
        for (int i = 0; i < automata.getEstados().size(); i++) {
            String estado = automata.getEstados().get(i);

            // Crea un array para contener los datos de la fila
            Object[] rowData = new Object[automata.getSimbolos().size() + 1];

            // Rellena los datos de la fila usando el método transicion
            rowData[0] = (i == 0) ? estado + "+" : (automata.getEstadosFinales().contains(estado) ? estado + "*" : estado);
            for (int j = 0; j < automata.getSimbolos().size(); j++) {
                String destino = automata.transicion(estado, automata.getSimbolos().get(j));
                rowData[j + 1] = (destino.equals("ERROR")) ? destino : (automata.getEstadosFinales().contains(destino) ? destino + "*" : destino);
            }

            // Agrega la fila al modelo de la tabla
            model.addRow(rowData);
        }

        // Configura el modelo actualizado en la tabla
        jTable.setModel(model);
        //cambiar el color de la tabla
        //jTable.setDefaultRenderer(Object.class, new EstadoTableCellRenderer());
    }

    //Para cambiar el color de la tabla
    public class EstadoTableCellRenderer extends DefaultTableCellRenderer {

        private final Color COLOR_INICIAL = Color.YELLOW;
        private final Color COLOR_FINAL = Color.BLUE;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            //Obtén el valor de la primera columna (estado)
            Object estado = table.getValueAt(row, 0);

            //Compara con el estado inicial y final
            if (estado != null) {
                if (estado.toString().endsWith("+")) {
                    c.setBackground(COLOR_INICIAL);
                } else if (estado.toString().endsWith("*")) {
                    c.setBackground(COLOR_FINAL);
                } else {
                    //Restablece el color de fondo predeterminado
                    c.setBackground(table.getBackground());
                }
            }

            return c;
        }
    }

    class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Hacer que las celdas no sean editables
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAñadirEstadoInicial;
    private javax.swing.JButton botonAñadirEstados;
    private javax.swing.JButton botonAñadirEstadosFinales;
    private javax.swing.JButton botonAñadirTransicion;
    private javax.swing.JButton boton_comprobar;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JTextField cadena_text;
    private javax.swing.JButton cargar_nombre;
    private javax.swing.JTextField estadoInicial_text;
    private javax.swing.JTextField estadosFinales_txt;
    private javax.swing.JTextField estados_text;
    private javax.swing.JTextField introducir_nombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nuevoFicheroNombre_text;
    private javax.swing.JTextPane texto;
    private javax.swing.JTextField transicion_txt;
    // End of variables declaration//GEN-END:variables
}
