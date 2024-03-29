/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCreation;

import Interfaz.Respuesta;
import Interfaz.StressTest.HiloAuto;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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
    private String gas;
    private JFrame interfaz;
    private JDialog carga;
    private int position;
    private JDialog dialogoCaja;
    private int tiempoL;

    public void setTiempoL(int tiempoL) {
        this.tiempoL = tiempoL;
    }

    public void setDialogoCaja(JDialog dialogoCaja) {
        this.dialogoCaja = dialogoCaja;
    }

    public void setCarga(JDialog carga) {
        this.carga = carga;
    }

    public void setInterfaz(JFrame interfaz) {
        this.interfaz = interfaz;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

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
        //System.out.println("hilo UC/fatherS recibe " + fatherS);
        this.fatherS = nombres(fatherS);
        //System.out.println("hilo UC/fatherS" + this.fatherS);
    }

    public void setName(int name) {
        //System.out.println("hilo UC/setName" + name);
        this.name = nombres(name);
        //System.out.println("hilo UC/name" + this.name);
    }

    public void setMotherS(int motherS) {
        //System.out.println("hilo UC/motherS recibe " + motherS);
        this.motherS = nombres(motherS);
        //System.out.println("hilo UC/motherS" + this.fatherS);
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

    public void loop1() throws InterruptedException {
        if (typeConsult == "Honest") {
            if (Respuesta.getConsultaUC(position) != null) {
                caja.setText(Respuesta.getConsultaUC(position).substring(4));
                dialogoCaja.setVisible(true);
            } else {
                interfaz.setEnabled(false);
                carga.setVisible(true);
                HonestAgent h = new HonestAgent(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, /*caja,*/ dp, gas, position);
                interfaz.setEnabled(true);
                carga.setVisible(false);
                caja.setText(Respuesta.getConsultaUC(position).substring(4));
                dialogoCaja.setVisible(true);
            }
        } else {
            if (typeConsult == "Dishonest A") {
                if (Respuesta.getConsultaUC(position) != null) {
                    caja.setText(Respuesta.getConsultaUC(position).substring(4));
                    dialogoCaja.setVisible(true);
                } else {
                    interfaz.setEnabled(false);
                    carga.setVisible(true);
                    DishonestAgentA d = new DishonestAgentA(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, /*caja, */ dp, gas, position);
                    interfaz.setEnabled(true);
                    carga.setVisible(false);
                    caja.setText(Respuesta.getConsultaUC(position).substring(4));
                    dialogoCaja.setVisible(true);
                }
            } else {
                if (Respuesta.getConsultaUC(position) != null) {
                    caja.setText(Respuesta.getConsultaUC(position).substring(4));
                    dialogoCaja.setVisible(true);
                } else {
                    if (typeConsult == "Dishonest B") {
                        interfaz.setEnabled(false);
                        carga.setVisible(true);
                        DishonestAgentB d = new DishonestAgentB(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, /*caja, */ dp, gas, position);
                        interfaz.setEnabled(true);
                        carga.setVisible(false);
                        caja.setText(Respuesta.getConsultaUC(position).substring(4));
                        dialogoCaja.setVisible(true);
                    }
                }
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
            case 0:
                return String.valueOf(letter());
            case 1:
                return String.valueOf(letter()) + String.valueOf(letter());
            case 2:
                return String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter());
            case 3:
                return String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter());
            case 4:
                return String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter());
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
        //System.out.println("hiloUC/letra: " + c);
        return c;

    }

    private int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    public void run() {
        System.out.println("hiloUC/antes del loop");
        //loop1();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(() -> {
            try {
                //caja.append("lalo");
                loop1();
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.StressTest.Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        try {
            future.get(tiempoL, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloAuto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(HiloAuto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            future.cancel(true);
            Respuesta.setConsultaUC("Hadn't response of server, perhaps the microservice is down" + "\n", position);
            interfaz.setEnabled(true);
            carga.setVisible(false);
            caja.setText(Respuesta.getConsultaUC(position).substring(4));
            dialogoCaja.setVisible(true);
            executor.shutdown();
        } /*finally {
            executor.shutdown();
        }*/

        System.out.println("hiloUC/después del loop");
    }

}
