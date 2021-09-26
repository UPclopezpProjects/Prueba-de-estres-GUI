/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author frank
 */
public class LecEscTXT {

    DefaultTableModel model;

    public DefaultTableModel leer() {
        try {
            File archivo = new File("C:\\archivo.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";

            model = new DefaultTableModel();
            model.addColumn("Dirección IP");

            while (br.ready()) {
                //linea += br.readLine();
                model.addRow(new Object[]{br.readLine()});
            }

            //TBDirecciones.setModel(model);
            //JOptionPane.showMessageDialog(this, linea);
        } catch (Exception e) {
            System.out.println("error al leer el archivo: " + e);
        }
        return model;
    }

    public void escribir() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\archivo.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void agregar(String valor) {
        try (FileWriter fw = new FileWriter("C:\\archivo.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(valor);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void modificar(DefaultTableModel model) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\archivo.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < model.getRowCount(); i++) {
                pw.println(model.getValueAt(i, 0));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    

}
