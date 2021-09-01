/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Interfaz.StressTest.Hilo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import UCreation.hiloUC;

/**
 *
 * @author frank
 */
public class InterfazG extends javax.swing.JFrame {

    Hilo objetoH;
    hiloUC h;
    private List<JButton> botones;
    //boolean flag = false;

    public InterfazG() {
        initComponents();
        botones = new ArrayList<>();
        habilitarCB(String.valueOf(CBTypeUserUC.getSelectedItem()));
    }

    public void crearB(int n, int aHonesto, int aEnviarA) {

        for (int x = 0; x < n; x++) {
            double i = Math.floor(Math.random() * 101);
            System.out.println("el random interfaz = " + i);
            int desonesto = aHonesto + aEnviarA;
            if (i <= aHonesto) {
                //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                JButton boton = new JButton("Honest agent");
                boton.setPreferredSize(new Dimension(30, 70));
                boton.setBackground(Color.GREEN);
                jPanel2.add(boton);
                botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        int aHonesto = (Integer) sAgenteH.getValue();
                        int aEnviarA = (Integer) sEnvianA.getValue();
                        int aEmpieza = (Integer) sEmpieza.getValue();
                        int pTotal = aHonesto + aEnviarA + aEmpieza;
                        consultaHonesta();
                    }
                });
            } else {
                if (i <= desonesto) {
                    //AgentsSendAnything b = new AgentsSendAnything(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                    JButton boton = new JButton("Dishonest agent send something");
                    boton.setPreferredSize(new Dimension(30, 70));
                    boton.setBackground(Color.ORANGE);
                    jPanel2.add(boton);
                    botones.add(boton); //agrego el boton

                    boton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            consultaEnviar();
                        }
                    });
                } else {
                    //AgentsStartAnyStep c = new AgentsStartAnyStep(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, numberRequest, ip, publicKey);
                    JButton boton = new JButton("Dishonest agent begin any step");
                    boton.setPreferredSize(new Dimension(30, 70));
                    boton.setBackground(Color.YELLOW);
                    jPanel2.add(boton);
                    botones.add(boton); //agrego el boton

                    boton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            consultaEmpezarA();
                        }
                    });
                }
            }

        }

        jPanel2.updateUI();
    }

    public void crearBUC(int nSolicitudes, int aHonesto, int aDeshonesto) {
        //JOptionPane.showMessageDialog(null, nSolicitudes+" "+aHonesto+" "+aDeshonesto);
        for (int x = 0; x < nSolicitudes; x++) {
            double i = Math.floor(Math.random() * 101);
            System.out.println("el random interfaz = " + i);
            if (i < aHonesto) {
                //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                JButton boton = new JButton("Honest agent");
                boton.setPreferredSize(new Dimension(30, 70));
                boton.setBackground(Color.GREEN);
                jPanel4.add(boton);
                botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //JOptionPane.showMessageDialog(null, "Agente honesto");
                        consultaHonestaUC("Honest");
                    }
                });
            } else {
                //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                JButton boton = new JButton("Dishonest agent");
                boton.setPreferredSize(new Dimension(30, 70));
                boton.setBackground(Color.YELLOW);
                jPanel4.add(boton);
                botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //JOptionPane.showMessageDialog(null, "Agente deshonesto");
                        consultaHonestaUC("Dishonest");
                    }
                });
            }
        }

        jPanel4.updateUI();
    }

    private void consultaHonestaUC(String typeConsult) {
        //areaTexto.setText("");

        h = new hiloUC();
        int email = CBEmailUC.getSelectedIndex();
        int password = CBPasswordUC.getSelectedIndex();
        String typeU = String.valueOf(CBTypeUserUC.getSelectedItem());
        String adressU = TFAdressUUC.getText();
        String authorization = TFAuthorizationUC.getText();
        int fatherS = CBFatherSUC.getSelectedIndex();
        int name = CBNameUC.getSelectedIndex();
        int motherS = CBMotherSUC.getSelectedIndex();
        int nRequest = (Integer) SNumberRequestUC.getValue();
        int aHonest = (Integer) SHonestAgentUC.getValue();
        int aDishonest = (Integer) SDishonestAgentUC.getValue();
        String ip = String.valueOf(CBServer1.getSelectedItem());
        String dp = getRadioB();

        int porcentaje = aHonest + aDishonest;

        if (porcentaje == 100) {
            if (!adressU.isEmpty()) {
                if (!authorization.isEmpty()) {
                    jDialog2.setVisible(true);
                    h.setEmail(email);
                    h.setPassword(password);
                    h.setTypeU(typeU);
                    h.setAdressU(adressU);
                    h.setAuthorization(authorization);
                    h.setFatherS(fatherS);
                    h.setName(name);
                    h.setMotherS(motherS);
                    h.setnRequest(nRequest);
                    h.setaHonest(aHonest);
                    h.setaDishonest(aDishonest);
                    h.setTypeConsult(typeConsult);
                    h.setIp(ip);
                    h.setCaja(areaTexto);
                    h.setDp(dp);

                    //hiloUC h = new hiloUC(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, areaTexto);
                    new Thread(h).start();
                } else {
                    JOptionPane.showMessageDialog(this, "Refill the authorization field");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Refill the Adress U field");
            }
        } else {
            JOptionPane.showMessageDialog(this, "The addition of porcentages must be 100%");
        }
    }

    private void consultaHonesta() {
        //areaTexto.setText("");
        objetoH = new Hilo();

        int email = CBEmail.getSelectedIndex();
        int password = CBPassword.getSelectedIndex();
        String apellidoP = String.valueOf(CBFatherS.getSelectedIndex());
        String apellidoM = String.valueOf(CBMotherS.getSelectedIndex());
        String nombreU = String.valueOf(CBName.getSelectedIndex());
        String tipoU = "Root";
        //int sPorSegundo = (Integer) SSolicitudes.getValue();
        int nSolicitudes = (Integer) SpinnerNS.getValue();
        int aHonesto = (Integer) sAgenteH.getValue();
        int aEnviarA = (Integer) sEnvianA.getValue();
        int aEmpieza = (Integer) sEmpieza.getValue();
        String ip = String.valueOf(CBServer.getSelectedItem());
        String publicK = TFPublicK.getText();
        String tipoConsulta = "honesto";

        int pTotal = aHonesto + aEnviarA + aEmpieza;

        if (publicK.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Set the public key");
        } else {
            if (pTotal == 100) {
                jDialog2.setVisible(true);
                objetoH.setEmail(email);
                objetoH.setPassword(password);
                objetoH.setApellidoP(apellidoP);
                objetoH.setApellidoM(apellidoM);
                objetoH.setNombreU(nombreU);
                objetoH.setTypeU(tipoU);
                //objetoH.setRequestFS(sPorSegundo);
                objetoH.setNumberRequest(nSolicitudes);
                objetoH.setaHonesto(aHonesto);
                objetoH.setaEnviarA(aEnviarA);
                objetoH.setaEmpieza(aEmpieza);
                objetoH.setCaja(areaTexto);
                objetoH.setIp(ip);
                objetoH.setPublicKey(publicK);
                objetoH.setTipoConsulta(tipoConsulta);
                new Thread(objetoH).start();
                //refreshA();
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        }
    }

    private void consultaEnviar() {
        //areaText.setText("");
        objetoH = new Hilo();

        int email = CBEmail.getSelectedIndex();
        int password = CBPassword.getSelectedIndex();
        String apellidoP = String.valueOf(CBFatherS.getSelectedIndex());
        String apellidoM = String.valueOf(CBMotherS.getSelectedIndex());
        String nombreU = String.valueOf(CBName.getSelectedIndex());
        String tipoU = "Root";
        //int sPorSegundo = (Integer) SSolicitudes.getValue();
        int nSolicitudes = (Integer) SpinnerNS.getValue();
        int aHonesto = (Integer) sAgenteH.getValue();
        int aEnviarA = (Integer) sEnvianA.getValue();
        int aEmpieza = (Integer) sEmpieza.getValue();
        String ip = String.valueOf(CBServer.getSelectedItem());
        String publicK = TFPublicK.getText();
        String tipoConsulta = "enviarAlgo";

        int pTotal = aHonesto + aEnviarA + aEmpieza;

        if (publicK.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Set the public key");
        } else {
            if (pTotal == 100) {
                jDialog2.setVisible(true);
                objetoH.setEmail(email);
                objetoH.setPassword(password);
                objetoH.setApellidoP(apellidoP);
                objetoH.setApellidoM(apellidoM);
                objetoH.setNombreU(nombreU);
                objetoH.setTypeU(tipoU);
                //objetoH.setRequestFS(sPorSegundo);
                objetoH.setNumberRequest(nSolicitudes);
                objetoH.setaHonesto(aHonesto);
                objetoH.setaEnviarA(aEnviarA);
                objetoH.setaEmpieza(aEmpieza);
                objetoH.setCaja(areaTexto);
                objetoH.setIp(ip);
                objetoH.setPublicKey(publicK);
                objetoH.setTipoConsulta(tipoConsulta);
                new Thread(objetoH).start();
                //refreshA();
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        }
    }

    private void consultaEmpezarA() {
        //areaTexto.setText("");
        objetoH = new Hilo();

        int email = CBEmail.getSelectedIndex();
        int password = CBPassword.getSelectedIndex();
        String apellidoP = String.valueOf(CBFatherS.getSelectedIndex());
        String apellidoM = String.valueOf(CBMotherS.getSelectedIndex());
        String nombreU = String.valueOf(CBName.getSelectedIndex());
        String tipoU = "Root";
        //int sPorSegundo = (Integer) SSolicitudes.getValue();
        int nSolicitudes = (Integer) SpinnerNS.getValue();
        int aHonesto = (Integer) sAgenteH.getValue();
        int aEnviarA = (Integer) sEnvianA.getValue();
        int aEmpieza = (Integer) sEmpieza.getValue();
        String ip = String.valueOf(CBServer.getSelectedItem());
        String publicK = TFPublicK.getText();
        String tipoConsulta = "empiezaAlgun";

        int pTotal = aHonesto + aEnviarA + aEmpieza;

        if (publicK.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Set the public key");
        } else {
            if (pTotal == 100) {
                jDialog2.setVisible(true);
                objetoH.setEmail(email);
                objetoH.setPassword(password);
                objetoH.setApellidoP(apellidoP);
                objetoH.setApellidoM(apellidoM);
                objetoH.setNombreU(nombreU);
                objetoH.setTypeU(tipoU);
                //objetoH.setRequestFS(sPorSegundo);
                objetoH.setNumberRequest(nSolicitudes);
                objetoH.setaHonesto(aHonesto);
                objetoH.setaEnviarA(aEnviarA);
                objetoH.setaEmpieza(aEmpieza);
                objetoH.setCaja(areaTexto);
                objetoH.setIp(ip);
                objetoH.setPublicKey(publicK);
                objetoH.setTipoConsulta(tipoConsulta);
                new Thread(objetoH).start();
                //refreshA();
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        }
    }

    private void habilitarCB(String typeU) {
        System.out.println(typeU);
        switch (typeU) {
            case "Productor":
                System.out.println("Cayó productor");
                RBReadA.setEnabled(false);
                RBReadM.setEnabled(true);
                RBReadTU.setEnabled(false);
                RBUpdateA.setEnabled(false);
                RBUpdateM.setEnabled(true);
                RBUpdateTU.setEnabled(false);
                RBCreateA.setEnabled(false);
                RBCreateTU.setEnabled(false);
                RBLoginU.setEnabled(true);
                RBDeleteA.setEnabled(false);
                RBDeleteTU.setEnabled(false);
                RBDeleteM.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                ;
                break;
            case "Acopio":
                System.out.println("Cayó acopio");
                RBReadA.setEnabled(false);
                RBReadM.setEnabled(true);
                RBReadTU.setEnabled(false);
                RBUpdateA.setEnabled(false);
                RBUpdateM.setEnabled(true);
                RBUpdateTU.setEnabled(false);
                RBCreateA.setEnabled(false);
                RBCreateTU.setEnabled(false);
                RBLoginU.setEnabled(true);
                RBDeleteA.setEnabled(false);
                RBDeleteTU.setEnabled(false);
                RBDeleteM.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                ;
                break;
            case "Merchant":
                System.out.println("Cayó merchant");
                RBReadA.setEnabled(false);
                RBReadM.setEnabled(true);
                RBReadTU.setEnabled(false);
                RBUpdateA.setEnabled(false);
                RBUpdateM.setEnabled(true);
                RBUpdateTU.setEnabled(false);
                RBCreateA.setEnabled(false);
                RBCreateTU.setEnabled(false);
                RBLoginU.setEnabled(true);
                RBDeleteA.setEnabled(false);
                RBDeleteTU.setEnabled(false);
                RBDeleteM.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                ;
                break;
            case "Carrier":
                System.out.println("Cayó carrier");
                RBReadA.setEnabled(false);
                RBReadM.setEnabled(true);
                RBReadTU.setEnabled(false);
                RBUpdateA.setEnabled(false);
                RBUpdateM.setEnabled(true);
                RBUpdateTU.setEnabled(false);
                RBCreateA.setEnabled(false);
                RBCreateTU.setEnabled(false);
                RBLoginU.setEnabled(true);
                RBDeleteA.setEnabled(false);
                RBDeleteTU.setEnabled(false);
                RBDeleteM.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                ;
                break;
            case "Root":
                System.out.println("Cayó root");
                RBReadA.setEnabled(true);
                RBReadM.setEnabled(true);
                RBReadTU.setEnabled(true);
                RBUpdateA.setEnabled(true);
                RBUpdateM.setEnabled(true);
                RBUpdateTU.setEnabled(true);
                RBCreateA.setEnabled(true);
                RBCreateTU.setEnabled(true);
                RBLoginU.setEnabled(true);
                RBDeleteA.setEnabled(true);
                RBDeleteTU.setEnabled(true);
                RBDeleteM.setEnabled(true);
                
                RBReadA.setSelected(true);
                RBReadM.setSelected(true);
                RBReadTU.setSelected(true);
                RBUpdateA.setSelected(true);
                RBUpdateM.setSelected(true);
                RBUpdateTU.setSelected(true);
                RBCreateA.setSelected(true);
                RBCreateTU.setSelected(true);
                RBLoginU.setSelected(true);
                RBDeleteA.setSelected(true);
                RBDeleteTU.setSelected(true);
                RBDeleteM.setSelected(true);
                ;
                break;
            case "Administrador":
                System.out.println("Cayó administrador");
                RBReadA.setEnabled(true);
                RBReadM.setEnabled(true);
                RBReadTU.setEnabled(true);
                RBUpdateA.setEnabled(true);
                RBUpdateM.setEnabled(true);
                RBUpdateTU.setEnabled(true);
                RBCreateA.setEnabled(true);
                RBCreateTU.setEnabled(true);
                RBLoginU.setEnabled(true);
                RBDeleteA.setEnabled(true);
                RBDeleteTU.setEnabled(true);
                RBDeleteM.setEnabled(true);
                ;
                break;
            default:
                System.out.println("Cayó default");
                RBReadA.setEnabled(false);
                RBReadM.setEnabled(false);
                RBReadTU.setEnabled(false);
                RBUpdateA.setEnabled(false);
                RBUpdateM.setEnabled(false);
                RBUpdateTU.setEnabled(false);
                RBCreateA.setEnabled(false);
                RBCreateTU.setEnabled(false);
                RBLoginU.setEnabled(false);
                RBDeleteA.setEnabled(false);
                RBDeleteTU.setEnabled(false);
                RBDeleteM.setEnabled(false);

                RBReadA.setSelected(false);
                RBReadM.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateM.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBLoginU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                RBDeleteM.setSelected(false);
                ;
                break;
        }
    }

    private String getRadioB() {
        System.out.println("{\"\"createAdministrator\"\":"+String.valueOf(RBCreateA.isSelected())+",\"\"createTUser\"\":"+String.valueOf(RBCreateTU.isSelected())+",\"\"updateMe\"\":"+String.valueOf(RBUpdateM.isSelected())+",\"\"updateAdministrator\"\":"+String.valueOf(RBUpdateA.isSelected())+",\"\"updateTUser\"\":"+String.valueOf(RBUpdateTU.isSelected())+",\"\"deleteMe\"\":"+String.valueOf(RBDeleteM.isSelected())+",\"\"deleteAdministrator\"\":"+String.valueOf(RBDeleteA.isSelected())+",\"\"deleteTUser\"\":"+String.valueOf(RBDeleteTU.isSelected())+",\"\"readMe\"\":"+String.valueOf(RBReadM.isSelected())+",\"\"readAdministrator\"\":"+String.valueOf(RBReadA.isSelected())+",\"\"readTUser\"\":"+String.valueOf(RBReadTU.isSelected())+",\"\"loginUser\"\":"+String.valueOf(RBLoginU.isSelected())+"}");
        return "{\"\"createAdministrator\"\":"+String.valueOf(RBCreateA.isSelected())+",\"\"createTUser\"\":"+String.valueOf(RBCreateTU.isSelected())+",\"\"updateMe\"\":"+String.valueOf(RBUpdateM.isSelected())+",\"\"updateAdministrator\"\":"+String.valueOf(RBUpdateA.isSelected())+",\"\"updateTUser\"\":"+String.valueOf(RBUpdateTU.isSelected())+",\"\"deleteMe\"\":"+String.valueOf(RBDeleteM.isSelected())+",\"\"deleteAdministrator\"\":"+String.valueOf(RBDeleteA.isSelected())+",\"\"deleteTUser\"\":"+String.valueOf(RBDeleteTU.isSelected())+",\"\"readMe\"\":"+String.valueOf(RBReadM.isSelected())+",\"\"readAdministrator\"\":"+String.valueOf(RBReadA.isSelected())+",\"\"readTUser\"\":"+String.valueOf(RBReadTU.isSelected())+",\"\"loginUser\"\":"+String.valueOf(RBLoginU.isSelected())+"}";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        BIniciar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CBPassword = new javax.swing.JComboBox<>();
        CBServer = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SpinnerNS = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        CBEmail = new javax.swing.JComboBox<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sAgenteH = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sEnvianA = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        sEmpieza = new javax.swing.JSpinner();
        BAyuda = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        TFPublicK = new javax.swing.JTextField();
        CBFatherS = new javax.swing.JComboBox<>();
        CBMotherS = new javax.swing.JComboBox<>();
        CBName = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        RBReadA1 = new javax.swing.JRadioButton();
        RBReadM1 = new javax.swing.JRadioButton();
        RBReadTU1 = new javax.swing.JRadioButton();
        RBUpdateA1 = new javax.swing.JRadioButton();
        RBUpdateM1 = new javax.swing.JRadioButton();
        RBUpdateTU1 = new javax.swing.JRadioButton();
        RBUpdateA2 = new javax.swing.JRadioButton();
        RBUpdateM2 = new javax.swing.JRadioButton();
        RBUpdateTU2 = new javax.swing.JRadioButton();
        RBDeleteA1 = new javax.swing.JRadioButton();
        RBDeleteTU1 = new javax.swing.JRadioButton();
        RBDeleteM1 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        CBEmailUC = new javax.swing.JComboBox<>();
        CBPasswordUC = new javax.swing.JComboBox<>();
        CBFatherSUC = new javax.swing.JComboBox<>();
        CBNameUC = new javax.swing.JComboBox<>();
        CBTypeUserUC = new javax.swing.JComboBox<>();
        CBMotherSUC = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        TFAdressUUC = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TFAuthorizationUC = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel38 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        SHonestAgentUC = new javax.swing.JSpinner();
        SDishonestAgentUC = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        SNumberRequestUC = new javax.swing.JSpinner();
        BIniciarUC = new javax.swing.JButton();
        CBServer1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel39 = new javax.swing.JLabel();
        RBCreateA = new javax.swing.JRadioButton();
        RBCreateTU = new javax.swing.JRadioButton();
        RBUpdateM = new javax.swing.JRadioButton();
        RBUpdateA = new javax.swing.JRadioButton();
        RBUpdateTU = new javax.swing.JRadioButton();
        RBDeleteM = new javax.swing.JRadioButton();
        RBDeleteA = new javax.swing.JRadioButton();
        RBDeleteTU = new javax.swing.JRadioButton();
        RBReadM = new javax.swing.JRadioButton();
        RBReadA = new javax.swing.JRadioButton();
        RBReadTU = new javax.swing.JRadioButton();
        RBLoginU = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();

        jDialog1.setMinimumSize(new java.awt.Dimension(420, 270));
        jDialog1.setResizable(false);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel14.setText("Email");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("[x] = significa una letra que se va a generar");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("[#] = significa un número que se va a generar");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel17.setText("Password");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("En la contraseña se genera un password de 4 carácteres ");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Ejemplo:");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("[xx#x] = ab2o");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("[xxx#] = abo2");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(167, 167, 167))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel19))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20)))))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialog2.setResizable(false);
        jDialog2.setSize(new java.awt.Dimension(1000, 300));

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BIniciar.setBackground(new java.awt.Color(0, 153, 0));
        BIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BIniciar.setForeground(new java.awt.Color(255, 255, 255));
        BIniciar.setText("Start");
        BIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIniciarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setText("Stress test");

        CBPassword.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[xx#x]", "[xxx#]" }));
        CBPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPasswordActionPerformed(evt);
            }
        });

        CBServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "localhost", "54.87.22.33" }));
        CBServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Email:");

        jLabel2.setText("Password:");

        jLabel3.setText("Father Surname:");

        jLabel4.setText("Mother Surname:");

        jLabel5.setText("Name:");

        jLabel6.setText("Server:");

        SpinnerNS.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel9.setText("Number of request:");

        CBEmail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]_[x]@[x].[x].com", "[x]_[x][#]@[x].[x].com" }));
        CBEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBEmailActionPerformed(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("total: 100%");

        jLabel11.setText("HONEST AGENT:");

        sAgenteH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel12.setText("DISHONEST AGENT");

        jLabel13.setText("Send something:");

        sEnvianA.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel27.setText("Begin any step:");

        sEmpieza.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sAgenteH, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sEnvianA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(sEmpieza, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sEmpieza, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sEnvianA, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sAgenteH, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(56, 56, 56))))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sAgenteH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(sEnvianA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(sEmpieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/informacion.png"))); // NOI18N
        BAyuda.setBorder(null);
        BAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAyudaActionPerformed(evt);
            }
        });

        jLabel22.setText("Public key:");

        CBFatherS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBMotherS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jScrollPane2.setBorder(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(4, 281));
        jPanel2.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(jPanel2);

        jLabel50.setText("Permissions DP");

        RBReadA1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadA1.setText("readAdministrator");
        RBReadA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadA1ActionPerformed(evt);
            }
        });

        RBReadM1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadM1.setText("readMe");
        RBReadM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadM1ActionPerformed(evt);
            }
        });

        RBReadTU1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadTU1.setText("readTUser");
        RBReadTU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadTU1ActionPerformed(evt);
            }
        });

        RBUpdateA1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateA1.setText("updateAdministrator");
        RBUpdateA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateA1ActionPerformed(evt);
            }
        });

        RBUpdateM1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateM1.setText("updateMe");
        RBUpdateM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateM1ActionPerformed(evt);
            }
        });

        RBUpdateTU1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateTU1.setText("updateTUser");
        RBUpdateTU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateTU1ActionPerformed(evt);
            }
        });

        RBUpdateA2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateA2.setText("updateAdministrator");
        RBUpdateA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateA2ActionPerformed(evt);
            }
        });

        RBUpdateM2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateM2.setText("updateMe");
        RBUpdateM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateM2ActionPerformed(evt);
            }
        });

        RBUpdateTU2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateTU2.setText("updateTUser");
        RBUpdateTU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateTU2ActionPerformed(evt);
            }
        });

        RBDeleteA1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteA1.setText("deleteAdministrator");
        RBDeleteA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteA1ActionPerformed(evt);
            }
        });

        RBDeleteTU1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteTU1.setText("deleteTUser");
        RBDeleteTU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteTU1ActionPerformed(evt);
            }
        });

        RBDeleteM1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteM1.setText("deleteMe");
        RBDeleteM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteM1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel50))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBReadM1)
                            .addComponent(RBReadTU1)
                            .addComponent(RBReadA1)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBUpdateA1)
                            .addComponent(RBUpdateM1)
                            .addComponent(RBUpdateTU1)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBUpdateA2)
                            .addComponent(RBUpdateM2)
                            .addComponent(RBUpdateTU2)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RBDeleteTU1)))
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBDeleteA1)
                    .addComponent(RBDeleteM1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBReadA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBReadM1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBReadTU1)
                .addGap(18, 18, 18)
                .addComponent(RBUpdateA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBUpdateM1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBUpdateTU1)
                .addGap(18, 18, 18)
                .addComponent(RBUpdateA2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBUpdateM2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBUpdateTU2)
                .addGap(18, 18, 18)
                .addComponent(RBDeleteA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBDeleteTU1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBDeleteM1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TFPublicK, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CBServer, javax.swing.GroupLayout.Alignment.LEADING, 0, 158, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CBName, javax.swing.GroupLayout.Alignment.LEADING, 0, 158, Short.MAX_VALUE)
                                        .addComponent(CBMotherS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CBFatherS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(CBPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BAyuda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SpinnerNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(235, 235, 235))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(BIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(CBEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(CBFatherS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(CBMotherS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(CBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(TFPublicK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SpinnerNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BAyuda)
                                        .addGap(2, 2, 2)))
                                .addGap(18, 18, 18)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Root", jPanel1);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel23.setText("User Creation");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Email:");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Password:");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel26.setText("Father surname:");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("Mother surname:");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setText("Name:");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("Type of User:");

        CBEmailUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBEmailUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]_[x]@[x].[x].com", "[x]_[x][#]@[x].[x].com" }));

        CBPasswordUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBPasswordUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[xx#x]", "[xxx#]" }));

        CBFatherSUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBFatherSUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBNameUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBNameUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBTypeUserUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBTypeUserUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Root", "Administrador", "Productor", "Acopio", "Carrier", "Merchant" }));
        CBTypeUserUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTypeUserUCActionPerformed(evt);
            }
        });

        CBMotherSUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBMotherSUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setText("Adress U.:");

        TFAdressUUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setText("Authorization:");

        TFAuthorizationUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TFAuthorizationUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFAuthorizationUCActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setText("Number of request:");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setText("Total 100%");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("Honest agent:");

        jLabel36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel36.setText("Dishonest agent:");

        SHonestAgentUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SHonestAgentUC.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        SDishonestAgentUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SDishonestAgentUC.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLayeredPane2.setLayer(jLabel38, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel35, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel36, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(SHonestAgentUC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(SDishonestAgentUC, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(SHonestAgentUC, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel38))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(SDishonestAgentUC, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(SHonestAgentUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(SDishonestAgentUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane3.setViewportView(jPanel4);

        SNumberRequestUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SNumberRequestUC.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        BIniciarUC.setBackground(new java.awt.Color(0, 153, 0));
        BIniciarUC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BIniciarUC.setForeground(new java.awt.Color(255, 255, 255));
        BIniciarUC.setText("Start");
        BIniciarUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIniciarUCActionPerformed(evt);
            }
        });

        CBServer1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "localhost", "54.87.22.33", "52.202.214.13" }));
        CBServer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBServer1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Server:");

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setText("Permissions DP");

        RBCreateA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBCreateA.setText("createAdministrator");
        RBCreateA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCreateAActionPerformed(evt);
            }
        });

        RBCreateTU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBCreateTU.setText("createTUser");
        RBCreateTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCreateTUActionPerformed(evt);
            }
        });

        RBUpdateM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateM.setText("updateMe");
        RBUpdateM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateMActionPerformed(evt);
            }
        });

        RBUpdateA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateA.setText("updateAdministrator");
        RBUpdateA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateAActionPerformed(evt);
            }
        });

        RBUpdateTU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateTU.setText("updateTUser");
        RBUpdateTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateTUActionPerformed(evt);
            }
        });

        RBDeleteM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteM.setText("deleteMe");
        RBDeleteM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteMActionPerformed(evt);
            }
        });

        RBDeleteA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteA.setText("deleteAdministrator");
        RBDeleteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteAActionPerformed(evt);
            }
        });

        RBDeleteTU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteTU.setText("deleteTUser");
        RBDeleteTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteTUActionPerformed(evt);
            }
        });

        RBReadM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadM.setText("readMe");
        RBReadM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadMActionPerformed(evt);
            }
        });

        RBReadA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadA.setText("readAdministrator");
        RBReadA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadAActionPerformed(evt);
            }
        });

        RBReadTU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadTU.setText("readTUser");
        RBReadTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadTUActionPerformed(evt);
            }
        });

        RBLoginU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBLoginU.setText("loginUser");
        RBLoginU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBLoginUActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel39, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBCreateA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBCreateTU, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBUpdateM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBUpdateA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBUpdateTU, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBDeleteM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBDeleteA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBDeleteTU, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBReadM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBReadA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBReadTU, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(RBLoginU, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(RBDeleteA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RBDeleteTU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RBDeleteM))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel39))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(RBCreateA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBCreateTU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RBLoginU))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBReadM)
                            .addComponent(RBReadTU)
                            .addComponent(RBReadA))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBUpdateA)
                            .addComponent(RBUpdateM)
                            .addComponent(RBUpdateTU))
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadA)
                    .addComponent(RBUpdateA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadM)
                    .addComponent(RBUpdateM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadTU)
                    .addComponent(RBUpdateTU))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBCreateA)
                    .addComponent(RBCreateTU)
                    .addComponent(RBLoginU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBDeleteA)
                    .addComponent(RBDeleteTU)
                    .addComponent(RBDeleteM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TFAdressUUC, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBPasswordUC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CBEmailUC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CBTypeUserUC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TFAuthorizationUC))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CBServer1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CBFatherSUC, 0, 140, Short.MAX_VALUE)
                                    .addComponent(CBNameUC, 0, 140, Short.MAX_VALUE)
                                    .addComponent(CBMotherSUC, 0, 140, Short.MAX_VALUE)
                                    .addComponent(SNumberRequestUC)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BIniciarUC, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(CBEmailUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(CBNameUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(CBPasswordUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(CBFatherSUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(CBTypeUserUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBMotherSUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(TFAdressUUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(SNumberRequestUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBServer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(TFAuthorizationUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BIniciarUC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crear Usuario", jPanel3);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel30.setText("New productor");

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setText("FId:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "Random" }));

        jLabel40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel40.setText("Ubication:");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Name:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("Harvest date:");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel43.setText("Caducation date:");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel44.setText("Previous stage:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productor", "Acopio", "Carrier", "Merchant" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("Current stage:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productor", "Acopio", "Carrier", "Merchant" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setText("Description:");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel47.setText("Imagen:");

        jButton1.setText("Select file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel48.setText("Name of company:");

        jLabel49.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel49.setText("Code:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Start");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel30)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jButton1)
                    .addComponent(jLabel37)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agregar Productor", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBServerActionPerformed

    private void CBPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBPasswordActionPerformed

    private void BIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIniciarActionPerformed
        jPanel2.removeAll();
        jPanel2.updateUI();
        int nSolicitudes = (Integer) SpinnerNS.getValue();
        int aHonesto = (Integer) sAgenteH.getValue();
        int aEnviarA = (Integer) sEnvianA.getValue();
        int aEmpieza = (Integer) sEmpieza.getValue();
        int pTotal = aHonesto + aEnviarA + aEmpieza;
        String publicK = TFPublicK.getText();

        if (!publicK.isEmpty()) {
            if (pTotal == 100) {
                crearB(nSolicitudes, aHonesto, aEnviarA);
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Set the public key");
        }


    }//GEN-LAST:event_BIniciarActionPerformed

    private void CBEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBEmailActionPerformed

    private void BAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAyudaActionPerformed
        jDialog1.setVisible(true);
    }//GEN-LAST:event_BAyudaActionPerformed

    private void TFAuthorizationUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAuthorizationUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFAuthorizationUCActionPerformed

    private void BIniciarUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIniciarUCActionPerformed
        jPanel4.removeAll();
        jPanel4.updateUI();
        int aHonesto = (Integer) SHonestAgentUC.getValue();
        int aDeshonesto = (Integer) SDishonestAgentUC.getValue();
        int porcentaje = aHonesto + aDeshonesto;
        int nSolicitudes = (Integer) SNumberRequestUC.getValue();
        String adressU = TFAdressUUC.getText();
        String authorization = TFAuthorizationUC.getText();

        if (porcentaje == 100) {
            if (!adressU.isEmpty()) {
                if (!authorization.isEmpty()) {
                    crearBUC(nSolicitudes, aHonesto, aDeshonesto);
                } else {
                    JOptionPane.showMessageDialog(this, "Refill the authorization field");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Refill the Adress U field");
            }
        } else {
            JOptionPane.showMessageDialog(this, "The addition of porcentages must be 100%");
        }
    }//GEN-LAST:event_BIniciarUCActionPerformed

    private void CBServer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBServer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBServer1ActionPerformed

    private void RBCreateAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCreateAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBCreateAActionPerformed

    private void RBCreateTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCreateTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBCreateTUActionPerformed

    private void RBUpdateMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateMActionPerformed

    private void RBUpdateAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateAActionPerformed

    private void RBUpdateTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateTUActionPerformed

    private void RBDeleteMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteMActionPerformed

    private void RBDeleteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteAActionPerformed

    private void RBDeleteTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteTUActionPerformed

    private void RBReadMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadMActionPerformed

    private void RBReadAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadAActionPerformed

    private void RBReadTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadTUActionPerformed

    private void RBLoginUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBLoginUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBLoginUActionPerformed

    private void CBTypeUserUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTypeUserUCActionPerformed
        habilitarCB(String.valueOf(CBTypeUserUC.getSelectedItem()));
    }//GEN-LAST:event_CBTypeUserUCActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RBReadA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadA1ActionPerformed

    private void RBReadM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadM1ActionPerformed

    private void RBReadTU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadTU1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadTU1ActionPerformed

    private void RBUpdateA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateA1ActionPerformed

    private void RBUpdateM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateM1ActionPerformed

    private void RBUpdateTU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateTU1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateTU1ActionPerformed

    private void RBUpdateA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateA2ActionPerformed

    private void RBUpdateM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateM2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateM2ActionPerformed

    private void RBUpdateTU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateTU2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateTU2ActionPerformed

    private void RBDeleteA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteA1ActionPerformed

    private void RBDeleteTU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteTU1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteTU1ActionPerformed

    private void RBDeleteM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteM1ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazG().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAyuda;
    private javax.swing.JButton BIniciar;
    private javax.swing.JButton BIniciarUC;
    private javax.swing.JComboBox<String> CBEmail;
    private javax.swing.JComboBox<String> CBEmailUC;
    private javax.swing.JComboBox<String> CBFatherS;
    private javax.swing.JComboBox<String> CBFatherSUC;
    private javax.swing.JComboBox<String> CBMotherS;
    private javax.swing.JComboBox<String> CBMotherSUC;
    private javax.swing.JComboBox<String> CBName;
    private javax.swing.JComboBox<String> CBNameUC;
    private javax.swing.JComboBox<String> CBPassword;
    private javax.swing.JComboBox<String> CBPasswordUC;
    private javax.swing.JComboBox<String> CBServer;
    private javax.swing.JComboBox<String> CBServer1;
    private javax.swing.JComboBox<String> CBTypeUserUC;
    private javax.swing.JRadioButton RBCreateA;
    private javax.swing.JRadioButton RBCreateTU;
    private javax.swing.JRadioButton RBDeleteA;
    private javax.swing.JRadioButton RBDeleteA1;
    private javax.swing.JRadioButton RBDeleteM;
    private javax.swing.JRadioButton RBDeleteM1;
    private javax.swing.JRadioButton RBDeleteTU;
    private javax.swing.JRadioButton RBDeleteTU1;
    private javax.swing.JRadioButton RBLoginU;
    private javax.swing.JRadioButton RBReadA;
    private javax.swing.JRadioButton RBReadA1;
    private javax.swing.JRadioButton RBReadM;
    private javax.swing.JRadioButton RBReadM1;
    private javax.swing.JRadioButton RBReadTU;
    private javax.swing.JRadioButton RBReadTU1;
    private javax.swing.JRadioButton RBUpdateA;
    private javax.swing.JRadioButton RBUpdateA1;
    private javax.swing.JRadioButton RBUpdateA2;
    private javax.swing.JRadioButton RBUpdateM;
    private javax.swing.JRadioButton RBUpdateM1;
    private javax.swing.JRadioButton RBUpdateM2;
    private javax.swing.JRadioButton RBUpdateTU;
    private javax.swing.JRadioButton RBUpdateTU1;
    private javax.swing.JRadioButton RBUpdateTU2;
    private javax.swing.JSpinner SDishonestAgentUC;
    private javax.swing.JSpinner SHonestAgentUC;
    private javax.swing.JSpinner SNumberRequestUC;
    private javax.swing.JSpinner SpinnerNS;
    private javax.swing.JTextField TFAdressUUC;
    private javax.swing.JTextField TFAuthorizationUC;
    private javax.swing.JTextField TFPublicK;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JSpinner sAgenteH;
    private javax.swing.JSpinner sEmpieza;
    private javax.swing.JSpinner sEnvianA;
    // End of variables declaration//GEN-END:variables
}
