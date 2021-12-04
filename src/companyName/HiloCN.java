/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyName;

import Interfaz.Respuesta;
//import Interfaz.StressTest.HiloAuto;
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
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class HiloCN implements Runnable {

    private String token;
    private String email;
    private String ip;
    private int position;
    private JTextArea caja;
    private JFrame interfaz;
    private JDialog carga;
    private JDialog dialogoCaja;
    private String typeConsulta;
    private int tiempoL;
    private String typeAgent;
    private String typeStage;

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
        //System.out.println("HiloCN/typeStage: "+typeStage);
    }

    public void setTypeAgent(String typeAgent) {
        this.typeAgent = typeAgent;
        //System.out.println("HiloCN/typeAgent: "+typeAgent);
    }

    public void setTiempoL(int tiempoL) {
        this.tiempoL = tiempoL;
        //System.out.println("HiloCN/tiempoL: "+tiempoL);
    }

    public void setTypeConsulta(String typeConsulta) {
        this.typeConsulta = typeConsulta;
        //System.out.println("HiloCN/typeConsulta: "+typeConsulta);
    }

    public void setInterfaz(JFrame interfaz) {
        this.interfaz = interfaz;
    }

    public void setCarga(JDialog carga) {
        this.carga = carga;
    }

    public void setDialogoCaja(JDialog dialogoCaja) {
        this.dialogoCaja = dialogoCaja;
    }

    public void setEmail(String email) {
        this.email = email;
        //System.out.println("HiloCN/email: "+email);
    }

    public void setCaja(JTextArea caja) {
        this.caja = caja;
        //System.out.println("setCaja");
    }

    public void setPosition(int position) {
        this.position = position;
        //System.out.println("HiloCN/setPosition: " + position);
    }

    public void setIp(String ip) {
        this.ip = ip;
        //System.out.println("HiloCN/setIp: " + ip);
    }

    public void setToken(String token) {
        this.token = token;
        //System.out.println("HiloCN/setToken: " + token);
    }

    public void loop() throws InterruptedException {

        if (typeAgent == "Honest") {
            if (typeConsulta == "Auto") {
                Company c = new Company(email, companyName(), token, ip, typeStage, position/*, caja*/);
                Respuesta.setNumeroCompany();
            } else {
                if (Respuesta.getConsultaCompany(position) != null) {
                    caja.setText(Respuesta.getConsultaCompany(position).replace("null", ""));
                    dialogoCaja.setVisible(true);
                } else {
                    interfaz.setEnabled(false);
                    carga.setVisible(true);
                    Company c = new Company(email, companyName(), token, ip, typeStage, position/*, caja*/);
                    carga.setVisible(false);
                    interfaz.setEnabled(true);
                    caja.setText(Respuesta.getConsultaCompany(position).replace("null", ""));
                    dialogoCaja.setVisible(true);

                }
            }
        } else {
            if (typeAgent == "Dishonest") {
                if (typeConsulta == "Auto") {
                    Company c = new Company(email, companyName(), token, ip, generateStage(), position/*, caja*/);
                    Respuesta.setNumeroCompany();
                } else {
                    if (Respuesta.getConsultaCompany(position) != null) {
                        caja.setText(Respuesta.getConsultaCompany(position).replace("null", ""));
                        dialogoCaja.setVisible(true);
                    } else {
                        interfaz.setEnabled(false);
                        carga.setVisible(true);
                        Company c = new Company(email, companyName(), token, ip, generateStage(), position/*, caja*/);
                        carga.setVisible(false);
                        interfaz.setEnabled(true);
                        caja.setText(Respuesta.getConsultaCompany(position).replace("null", ""));
                        dialogoCaja.setVisible(true);
                    }
                }
            }
        }
    }

    private String email() {
        String email = "";
        email = letter() + "_" + LETTER() + number() + "@" + letter() + letter() + letter() + letter() + ".com";
        //System.out.println(email);
        return email;
    }

    private String generateStage() {
        int i = (int) Math.floor(Math.random() * 3);
        switch (i) {
            case 0:
                if (typeStage == "Productor") {
                    generateStage();
                } else {
                    System.out.println("HiloCN/generateStage: Productor, Position: "+position);
                    return "Productor";
                }
            case 1:
                if (typeStage == "Carrier") {
                    generateStage();
                } else {
                    System.out.println("HiloCN/generateStage: Carrier, Position: "+position);
                    return "Carrier";
                }
            case 2:
                if (typeStage == "Acopio") {
                    generateStage();
                } else {
                    System.out.println("HiloCN/generateStage: Acopio, Position: "+position);
                    return "Acopio";
                }
            case 3:
                if (typeStage == "Merchant") {
                    generateStage();
                } else {
                    System.out.println("HiloCN/generateStage: Merchant, Position: "+position);
                    return "Merchant";
                }
            default:
                return "HiloCN/generateStage/FALLA";
        }
    }

    private String companyName() {
        String company = "";
        company = String.valueOf(LETTER()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter()) + String.valueOf(letter());
        //System.out.println("HiloCN/companyName: " + company);
        return company;
    }

    private char letter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    private char LETTER() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'A');
        return c;
    }

    private int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    @Override
    public void run() {
        System.out.println("HiloAuto/antes del loop");
        //loop1();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(() -> {
            try {
                loop();
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloCN.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        try {
            future.get(tiempoL, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(HiloCN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            future.cancel(true);
            if (typeConsulta == "Auto") {
                Respuesta.setNumeroCompany();
                Respuesta.setConsultaCompany("Hadn't response of server, perhaps the microservice is down" + "\n", position);
            } else {
                interfaz.setEnabled(true);
                carga.setVisible(false);
                Respuesta.setConsultaCompany("Hadn't response of server, perhaps the microservice is down" + "\n", position);
                caja.setText(Respuesta.getConsultaCompany(position).replace("null", ""));
                dialogoCaja.setVisible(true);
            }
            executor.shutdown();
        } /*finally {
            executor.shutdown();
        }*/

        System.out.println("HiloAuto/después del loop");
    }
}