package Interfaz;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Respuesta {

    public static JFrame interfazG;
    public static JDialog ventanaCarga;
    
    public static void setInterfazG(JFrame interfazG) {
        Respuesta.interfazG = interfazG;
        Respuesta.interfazG.setEnabled(false);
    }

    public static void setVentanaCarga(JDialog ventanaCarga) {
        //System.out.println("Respuesta/setVentanaCarga: recibió la ventana");
        Respuesta.ventanaCarga = ventanaCarga;
    }

//para la creación de roots
    public static int tamanio;
    public static String consultaRoot[];
    public static int numeroCR = 0;
    
    public static int getNumeroCR() {
        return numeroCR;
    }

    public static void setNumeroCR() {
        //System.out.println("Respuesta/setNumeroCR: hago la autosuma");
        numeroCR++;

        if (numeroCR == tamanio) {
            //System.out.println("Respuesta/setNumeroCR: SE TERMINARON LAS CONSULTAS");
            //System.out.println("Respuesta/setNumeroCR: " + numeroCR);
            ventanaCarga.setVisible(false);
            interfazG.setEnabled(true);
            numeroCR = 0;
        }
    }
    
    public static void setConsultaRoot(String consultaRoot, int position) {
        //
        //System.out.println("Respuesta/setConsultaRoot: "+consultaRoot+", "+position);
        Respuesta.consultaRoot[position] += consultaRoot;
    }

    public static String getConsultaRoot(int position) {
        //
        //System.out.println("Respuesta/getConsultaRoot: "+Respuesta.consultaRoot[position]);
        return Respuesta.consultaRoot[position];
    }

    public static int getTamanio() {
        return tamanio;
    }

    public static void setTamanio(int tamanio) {
        //
        //System.out.println("Respuesta/setTamanio: "+tamanio);
        Respuesta.tamanio = tamanio;
        Respuesta.consultaRoot = new String[tamanio];
    }
    
    //para la creación de usuarios automáticos
    public static int tamanioUC;
    public static String consultaUC[];
    public static int numeroCU = 0;
    
    public static String getConsultaUC(int position) {
        return Respuesta.consultaUC[position];
    }

    public static void setConsultaUC(String consultaUC, int position) {
        //System.out.println("Respuesta/setConsultaUC: "+position);
        Respuesta.consultaUC[position] += consultaUC;
    }

    public static void setTamanioUC(int tamanioUC) {
        Respuesta.tamanioUC = tamanioUC;
        Respuesta.consultaUC = new String[tamanioUC];
        //System.out.println("Respuesta/setTamanioUC: "+consultaUC.length);
    }
    
    public static void setNumeroCU() {
        //System.out.println("Respuesta/setNumeroCU: hago la autosuma");
        numeroCU++;

        if (numeroCU == tamanioUC) {
            //System.out.println("Respuesta/setNumeroCU: SE TERMINARON LAS CONSULTAS");
            //System.out.println("Respuesta/setNumeroCU: " + numeroCR);
            ventanaCarga.setVisible(false);
            interfazG.setEnabled(true);
            numeroCU = 0;
        }
    }

    //para la creación de fases
    public static int tamanioS;
    public static String consultaS[];
    public static int numeroNP = 0;
    
    public static String getConsultaS(int position) {
        return Respuesta.consultaS[position];
    }

    public static void setConsultaS(String consultaS, int position) {
        Respuesta.consultaS[position] += consultaS;
    }

    public static void setTamanioS(int tamanioS) {
        Respuesta.tamanioS = tamanioS;
        Respuesta.consultaS = new String[tamanioS];
    }
    
    public static void setNumeroNP() {
        //System.out.println("Respuesta/setNumeroNP: hago la autosuma");
        numeroNP++;

        if (numeroNP == tamanioS) {
            //System.out.println("Respuesta/setNumeroNP: SE TERMINARON LAS CONSULTAS");
            //System.out.println("Respuesta/setNumeroNP: " + numeroNP);
            ventanaCarga.setVisible(false);
            interfazG.setEnabled(true);
            numeroNP = 0;
        }
    }

    //para la creación de companys
    public static int tamanioCompany;
    public static String consultaCompany[];
    public static int numeroCompany = 0;

    public static void setNumeroCompany() {
        //System.out.println("Respuesta/setNumeroCompany: hago la autosuma");
        numeroCompany++;

        if (numeroCompany == tamanioCompany) {
            //System.out.println("Respuesta/setNumeroCompany: SE TERMINARON LAS CONSULTAS");
            //System.out.println("Respuesta/setNumeroCompany: " + numeroCompany);
            ventanaCarga.setVisible(false);
            interfazG.setEnabled(true);
            numeroCompany = 0;
        }
    }

    public static String getConsultaCompany(int position) {
        return consultaCompany[position];
    }

    public static void setConsultaCompany(String consultaCompany, int position) {
        //System.out.println();
        Respuesta.consultaCompany[position] += consultaCompany;
        //System.out.println("Respuesta/setConsultaCompany");
    }

    public static void setTamanioCompany(int tamanioCompany) {
        //System.out.println("Respuesta/setTamanioCompany");
        Respuesta.tamanioCompany = tamanioCompany;
        Respuesta.consultaCompany = new String[tamanioCompany];
        //System.out.println("Respuesta/setTamanioCompany/tamanio consulta company= "+Respuesta.consultaCompany.length);
    }
}