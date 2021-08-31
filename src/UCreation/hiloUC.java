/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCreation;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class hiloUC implements Runnable {

    private String email;
    private String password;
    private String typeU;
    private String adressU;
    private String authorization;
    private String fatherS;
    private String name;
    private String motherS;
    private int nRequest;
    private int aHonest;
    private int aDishonest;
    private String typeConsult;
    private String ip;
    private JTextArea caja;
    private String dp;
    
    
    public void setDp(String dp) {
        this.dp = dp;
    }

    public void setEmail(int email) {
        this.email = generateEmail(email);
    }

    public void setPassword(int password) {
        this.password = generatePassword(password);
    }

    public void setTypeU(String typeU) {
        this.typeU = typeU;
    }

    public void setAdressU(String adressU) {
        this.adressU = adressU;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public void setFatherS(int fatherS) {
        this.fatherS = nombres(fatherS);
    }

    public void setName(int name) {
        this.name = nombres(name);
    }

    public void setMotherS(int motherS) {
        this.motherS = nombres(motherS);
    }

    public void setnRequest(int nRequest) {
        this.nRequest = nRequest;
    }

    public void setaHonest(int aHonest) {
        this.aHonest = aHonest;
    }

    public void setaDishonest(int aDishonest) {
        this.aDishonest = aDishonest;
    }

    public void setTypeConsult(String typeConsult) {
        this.typeConsult = typeConsult;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCaja(JTextArea caja) {
        this.caja = caja;
    }
    
    /*public hiloUC(int email, int password, String typeU, String adressU, String authorization, int fatherS, int name, int motherS, int nRequest, int aHonest, int aDishonest, String typeConsult, String ip, JTextArea caja) {
        this.email = generateEmail(email);
        this.password = generatePassword(password);
        this.typeU = typeU;
        this.adressU = adressU;
        this.authorization = authorization;
        this.fatherS = nombres(fatherS);
        this.name = nombres(name);
        this.motherS = nombres(motherS);
        this.nRequest = nRequest;
        this.aHonest = aHonest;
        this.aDishonest = aDishonest;
        this.typeConsult = typeConsult;
        this.ip = ip;
        this.caja = caja;
    }*/

    public void loop1() throws InterruptedException {
        if (typeConsult == "Honest") {
            HonestAgent h = new HonestAgent(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, caja, dp);
        } else {
            if (typeConsult == "Dishonest") {
                DishonestAgent d = new DishonestAgent(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, caja, dp);
            }
        }
    }

    private String generateEmail(int n) {

        String correo;

        switch (n) {
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

    private String nombres(int n) {

        switch (n) {
            case 0: return String.valueOf(letter());
            case 1:
                return String.valueOf(letter() + letter());
            case 2:
                return String.valueOf(letter() + letter() + letter());
            case 3:
                return String.valueOf(letter() + letter() + letter() + letter());
            case 4:
                return String.valueOf(letter() + letter() + letter() + letter() + letter());
            default:
                return String.valueOf(letter());
        }
    }

    private String generatePassword(int n) {

        String contrasena;

        switch (n) {
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

    private char letter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    private int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    public void run() {
        try {
            //caja.append("lalo");
            loop1();
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaz.StressTest.Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
