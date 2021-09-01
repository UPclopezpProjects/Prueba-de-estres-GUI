/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.StressTest;

import static java.lang.Math.random;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class Hilo implements Runnable {

    private int email;
    private int password;
    private String apellidoP;
    private String apellidoM;
    private String nombreU;
    private String typeU;
    //private int delay;
    private int numberRequest;
    private JTextArea caja;
    private String ip;
    private String publicKey;
    private String tipoConsulta;
    private String dp;

    private int aHonesto;
    private int aEnviarA;
    private int aEmpieza;
    
    public void setDp(String dp) {
        this.dp = dp;
    }
    
    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCaja(JTextArea caja) {
        this.caja = caja;
    }

    public void setaHonesto(int aHonesto) {
        this.aHonesto = aHonesto;
    }

    public void setaEnviarA(int aEnviarA) {
        this.aEnviarA = aEnviarA;
    }

    public void setaEmpieza(int aEmpieza) {
        this.aEmpieza = aEmpieza;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = "";
        int valor = Integer.parseInt(apellidoP);
        for (int x = 0; x < (valor + 1); x++) {
            this.apellidoP += letter();
        }
        System.out.println("el apellido paterno:" + this.apellidoP);
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = "";
        int valor = Integer.parseInt(apellidoM);
        for (int x = 0; x < (valor + 1); x++) {
            this.apellidoM += letter();
        }
        System.out.println("el apellido materno:" + this.apellidoM);
    }

    public void setNombreU(String nombreU) {
        this.nombreU = "";
        int valor = Integer.parseInt(nombreU);
        for (int x = 0; x < (valor + 1); x++) {
            this.nombreU += letter();
        }
        System.out.println("el nombre:" + this.nombreU);
    }

    public void setTypeU(String typeU) {
        this.typeU = typeU;

    }

    /*public void setRequestFS(int requestFS) {
        this.delay = requestFS;
    }*/

    public void setNumberRequest(int numberRequest) {
        this.numberRequest = numberRequest;
    }

    /*public void setEstado(boolean estado) {
        this.estado = estado;
    }*/
    public void loop1() throws InterruptedException {
        /*for (int x = 0; x < numberRequest; x++) {
            double i = Math.floor(Math.random() * 101);
            System.out.println("el random = " + i);
            int desonesto = aHonesto+aEnviarA;
            if(i<=aHonesto){
                AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
            }else{
                if(i<=desonesto){
                    AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                } else {
                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip, publicKey);
                }
            }
            TimeUnit.MILLISECONDS.sleep(delay);
        }*/
        if(tipoConsulta=="honesto"){
            AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey, dp);
        }else{
            if(tipoConsulta=="enviarAlgo"){
                AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey, dp);
            } else{
                if(tipoConsulta=="empiezaAlgun"){
                    AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip, publicKey, dp);
                }
            }
        }
    }

    public String generateEmail() {

        String correo;

        switch (email) {
            case 0:
                correo = String.valueOf(letter()) + "_" + String.valueOf(letter()) + "@" + String.valueOf(letter()) + "." + String.valueOf(letter()) + ".com";
                return correo;

            case 1:
                correo = String.valueOf(letter()) + "_" + String.valueOf(letter()) + String.valueOf(number()) + "@" + String.valueOf(letter()) + "." + String.valueOf(letter()) + ".com";
                return correo;
            default:
                correo = String.valueOf(letter()) + "_" + String.valueOf(letter()) + "@" + String.valueOf(letter()) + "." + String.valueOf(letter()) + ".com";
                return correo;
        }

    }

    public String generatePassword() {

        String contrasena;

        switch (password) {
            case 0:
                contrasena = String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(number()) + String.valueOf(letter());
                return contrasena;
            case 1:
                contrasena = String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(number());
                return contrasena;
            default:
                contrasena = String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(number()) + String.valueOf(letter());
                return contrasena;
        }
    }

    public char letter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    public void run() {
        try {
            //caja.append("lalo");
            loop1();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
