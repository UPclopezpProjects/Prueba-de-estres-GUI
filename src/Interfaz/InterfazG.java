package Interfaz;

import Interfaz.StressTest.Hilo;
import Interfaz.StressTest.HiloAuto;
import NewProductor.HiloNP;
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
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InterfazG extends javax.swing.JFrame {

    private Hilo objetoH;
    private hiloUC h;
    private HiloNP hNP;

    public InterfazG() {
        initComponents();
        //botones = new ArrayList<>();
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
                //botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        jDialog2.setVisible(true);
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
                    //botones.add(boton); //agrego el boton

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
                    //botones.add(boton); //agrego el boton

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
                //botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //JOptionPane.showMessageDialog(null, "Agente honesto");
                        consultaHonestaUC("Honest");
                    }
                });
            } else {
                double a = Math.floor(Math.random() * 101);
                if (a < 50) {
                    //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                    JButton boton = new JButton("Dishonest agent A");
                    boton.setPreferredSize(new Dimension(30, 70));
                    boton.setBackground(Color.YELLOW);
                    jPanel4.add(boton);
                    //botones.add(boton); //agrego el boton

                    boton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            //JOptionPane.showMessageDialog(null, "Agente deshonesto");
                            consultaHonestaUC("Dishonest A");
                        }
                    });
                } else {
                    //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                    JButton boton = new JButton("Dishonest agent B");
                    boton.setPreferredSize(new Dimension(30, 70));
                    boton.setBackground(Color.ORANGE);
                    jPanel4.add(boton);
                    //botones.add(boton); //agrego el boton

                    boton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            //JOptionPane.showMessageDialog(null, "Agente deshonesto");
                            consultaHonestaUC("Dishonest B");
                        }
                    });
                }

            }
        }

        jPanel4.updateUI();
    }

    public void crearBNP(int nSolicitudes, int aHonesto, int aDeshonesto) {
        //JOptionPane.showMessageDialog(null, nSolicitudes+" "+aHonesto+" "+aDeshonesto);
        for (int x = 0; x < nSolicitudes; x++) {
            double i = Math.floor(Math.random() * 101);
            System.out.println("el random interfaz = " + i);
            if (i < aHonesto) {
                //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                JButton boton = new JButton("Honest agent");
                boton.setPreferredSize(new Dimension(30, 70));
                boton.setBackground(Color.GREEN);
                jPanel6.add(boton);
                //botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //JOptionPane.showMessageDialog(null, "Agente honesto");
                        consultaHonestaNP("Honest");
                    }

                });
            } else {
                //AgentsHonest a = new AgentsHonest(caja, generateEmail(), generatePassword(), nombreU, apellidoP, apellidoM, typeU, ip, publicKey);
                JButton boton = new JButton("Dishonest agent");
                boton.setPreferredSize(new Dimension(30, 70));
                boton.setBackground(Color.YELLOW);
                jPanel6.add(boton);
                //botones.add(boton); //agrego el boton

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //JOptionPane.showMessageDialog(null, "Agente deshonesto");
                        consultaHonestaNP("Dishonest");
                    }

                });
            }
        }

        jPanel6.updateUI();
    }

    private void consultaHonestaNP(String honest) {
        areaTexto.setText("");
        String ubication = getUbication();
        String harvestD = getHarvestDate();
        String caducationD = getCaducationDate();
        int description = CBDescriptionNP.getSelectedIndex();
        int fId = CBFIdNP.getSelectedIndex();
        int nameProduction = CBNameNP.getSelectedIndex();
        String previousS = String.valueOf(CBPreviousSNP.getSelectedItem());
        String currentS = String.valueOf(CBCurrentSNP.getSelectedItem());
        int code = CBCodeNP.getSelectedIndex();
        String typeConsult = honest;
        String ip = String.valueOf(CBIpNP.getSelectedItem());
        JTextArea caja = areaTexto;
        String token = TFTokenNP.getText();
        String origin = getOrigin();
        String destination = getDestination();
        String plates = getPlates();
        String productP = getImage();
        String vehicleP = getImage();
        String tracking = getPlates();
        System.out.println("InterfazG/destination: " + destination);

        int aHonest = (Integer) SHonestAgentNP.getValue();
        int aDishonest = (Integer) SDishonestAgentNP.getValue();
        int totalP = aHonest + aDishonest;
        hNP = new HiloNP();

        if (!ubication.isEmpty()) {
            if (!harvestD.isEmpty()) {
                if (!caducationD.isEmpty()) {
                    if (totalP == 100) {
                        if (currentS != "Carrier") {
                            jDialog2.setVisible(true);
                            hNP.setUbication(ubication);
                            hNP.setHarvestD(harvestD);
                            hNP.setCaducationD(caducationD);
                            hNP.setDescription(description);
                            hNP.setfId(fId);
                            hNP.setNameProduction(nameProduction);
                            hNP.setPreviousS(previousS);
                            hNP.setCurrentS(currentS);
                            hNP.setCode(code);
                            hNP.setTypeConsult(typeConsult);
                            hNP.setImage(getImage());
                            hNP.setIp(ip);
                            hNP.setCaja(caja);
                            hNP.setToken(token);

                            new Thread(hNP).start();
                        } else {
                            //fId,ubication, nameProduction, previousS, currentS, image, description, code, driverName, origin, destination, plates, productPhotos, vehiclePhotos, tracking, token, ip, caja
                            jDialog2.setVisible(true);
                            hNP.setfId(fId);
                            hNP.setUbication(ubication);
                            hNP.setPreviousS(previousS);
                            hNP.setCurrentS(currentS);
                            hNP.setImage(getImage());
                            hNP.setDescription(description);
                            hNP.setCode(code);
                            hNP.setDriverName("6");
                            hNP.setOrigin(origin);
                            hNP.setDestination(destination);
                            hNP.setPlates(plates);
                            hNP.setProductPhotos(productP);
                            hNP.setVehiclePhotos(vehicleP);
                            hNP.setTracking(tracking);
                            hNP.setToken(token);
                            hNP.setIp(ip);
                            hNP.setCaja(caja);
                            hNP.setTypeConsult(typeConsult);
                            hNP.setNameProduction(nameProduction);

                            new Thread(hNP).start();

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Set a caducation date");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Set a harvest");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Set a ubication");
        }

    }

    private void consultaHonestaUC(String typeConsult) {
        areaTexto.setText("");

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
        String dp = getRadioBCU();
        String gas = TFGasUC.getText();

        int porcentaje = aHonest + aDishonest;

        if (porcentaje == 100) {
            if (!adressU.isEmpty()) {
                if (!authorization.isEmpty()) {
                    if (!gas.isEmpty()) {
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
                        h.setGas(gas);

                        //hiloUC h = new hiloUC(email, password, typeU, adressU, authorization, fatherS, name, motherS, nRequest, aHonest, aDishonest, typeConsult, ip, areaTexto);
                        new Thread(h).start();
                    } else {
                        JOptionPane.showMessageDialog(this, "Refill the gas field");
                    }
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
        areaTexto.setText("");
        objetoH = new Hilo();
        int email = CBEmail.getSelectedIndex();
        int password = CBPassword.getSelectedIndex();
        String apellidoP = String.valueOf(CBFatherS.getSelectedIndex());
        String apellidoM = String.valueOf(CBMotherS.getSelectedIndex());
        String nombreU = String.valueOf(CBName.getSelectedIndex());
        String tipoU = "Root";
        int nSolicitudes = (Integer) SpinnerNS.getValue();
        int aHonesto = (Integer) sAgenteH.getValue();
        int aEnviarA = (Integer) sEnvianA.getValue();
        int aEmpieza = (Integer) sEmpieza.getValue();
        String ip = String.valueOf(CBServer.getSelectedItem());
        String publicK = TFPublicK.getText();
        String tipoConsulta = "honesto";
        String dp = getRadioB();
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
                objetoH.setDp(dp);
                new Thread(objetoH).start();
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        }
    }

    private void consultaEnviar() {
        areaTexto.setText("");
        objetoH = new Hilo();
        int email = CBEmail.getSelectedIndex();
        int password = CBPassword.getSelectedIndex();
        String apellidoP = String.valueOf(CBFatherS.getSelectedIndex());
        String apellidoM = String.valueOf(CBMotherS.getSelectedIndex());
        String nombreU = String.valueOf(CBName.getSelectedIndex());
        String tipoU = "Root";
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
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        }
    }

    private void consultaEmpezarA() {
        areaTexto.setText("");
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
            } else {
                JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
            }
        }
    }

    private void habilitarCB(String typeU) {
        //System.out.println(typeU);
        switch (typeU) {
            case "Productor":
                //System.out.println("Cayó productor");
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
                RBReadD.setEnabled(true);
                RBUpdateD.setEnabled(true);
                RBCreateD.setEnabled(true);
                RBDeleteD.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                RBReadD.setSelected(true);
                RBUpdateD.setSelected(true);
                RBCreateD.setSelected(true);
                RBDeleteD.setSelected(true);
                ;
                break;
            case "Acopio":
                //System.out.println("Cayó acopio");
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
                RBReadD.setEnabled(true);
                RBUpdateD.setEnabled(true);
                RBCreateD.setEnabled(true);
                RBDeleteD.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                RBReadD.setSelected(true);
                RBUpdateD.setSelected(true);
                RBCreateD.setSelected(true);
                RBDeleteD.setSelected(true);
                ;
                break;
            case "Merchant":
                //System.out.println("Cayó merchant");
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
                RBReadD.setEnabled(true);
                RBUpdateD.setEnabled(true);
                RBCreateD.setEnabled(true);
                RBDeleteD.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                RBReadD.setSelected(true);
                RBUpdateD.setSelected(true);
                RBCreateD.setSelected(true);
                RBDeleteD.setSelected(true);
                ;
                break;
            case "Carrier":
                //System.out.println("Cayó carrier");
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
                RBReadD.setEnabled(true);
                RBUpdateD.setEnabled(true);
                RBCreateD.setEnabled(true);
                RBDeleteD.setEnabled(true);

                RBReadA.setSelected(false);
                RBReadTU.setSelected(false);
                RBUpdateA.setSelected(false);
                RBUpdateTU.setSelected(false);
                RBCreateA.setSelected(false);
                RBCreateTU.setSelected(false);
                RBDeleteA.setSelected(false);
                RBDeleteTU.setSelected(false);
                RBReadD.setSelected(true);
                RBUpdateD.setSelected(true);
                RBCreateD.setSelected(true);
                RBDeleteD.setSelected(true);
                ;
                break;
            case "Administrator":
                //System.out.println("Cayó administrador");
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
                RBReadD.setEnabled(false);
                RBUpdateD.setEnabled(false);
                RBCreateD.setEnabled(false);
                RBDeleteD.setEnabled(false);

                RBReadA.setSelected(true);
                RBReadTU.setSelected(true);
                RBReadM.setSelected(true);
                RBUpdateA.setSelected(true);
                RBUpdateTU.setSelected(true);
                RBUpdateM.setSelected(true);
                RBCreateA.setSelected(true);
                RBCreateTU.setSelected(true);
                RBLoginU.setSelected(true);
                RBDeleteA.setSelected(true);
                RBDeleteTU.setSelected(true);
                RBDeleteM.setSelected(true);
                RBReadD.setSelected(false);
                RBUpdateD.setSelected(false);
                RBCreateD.setSelected(false);
                RBDeleteD.setSelected(false);
                ;
                break;
            default:
                //System.out.println("Cayó default");
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

    private String getRadioBCU() {
        boolean leerA;
        boolean leerM;
        boolean leerTU;
        boolean actualizarA;
        boolean actualizarM;
        boolean actualizarTU;
        boolean eliminarA;
        boolean eliminarTU;
        boolean eliminarM;
        boolean crearA;
        boolean crearTU;
        boolean loginU;
        boolean leerI;
        boolean actualizarI;
        boolean crearI;
        boolean borrarI;

        if (RBReadA.isSelected()) {
            leerA = true;
        } else {
            leerA = false;
        }

        if (RBReadM.isSelected()) {
            leerM = true;
        } else {
            leerM = false;
        }

        if (RBReadTU.isSelected()) {
            leerTU = true;
        } else {
            leerTU = false;
        }

        if (RBUpdateA.isSelected()) {
            actualizarA = true;
        } else {
            actualizarA = false;
        }

        if (RBUpdateM.isSelected()) {
            actualizarM = true;
        } else {
            actualizarM = false;
        }

        if (RBUpdateTU.isSelected()) {
            actualizarTU = true;
        } else {
            actualizarTU = false;
        }

        if (RBDeleteA.isSelected()) {
            eliminarA = true;
        } else {
            eliminarA = false;
        }

        if (RBDeleteM.isSelected()) {
            eliminarM = true;
        } else {
            eliminarM = false;
        }

        if (RBDeleteTU.isSelected()) {
            eliminarTU = true;
        } else {
            eliminarTU = false;
        }

        if (RBCreateA.isSelected()) {
            crearA = true;
        } else {
            crearA = false;
        }

        if (RBCreateTU.isSelected()) {
            crearTU = true;
        } else {
            crearTU = false;
        }

        if (RBLoginU.isSelected()) {
            loginU = true;
        } else {
            loginU = false;
        }

        if (RBReadD.isSelected()) {
            leerI = true;
        } else {
            leerI = false;
        }
        //boolean leerI;

        if (RBUpdateD.isSelected()) {
            actualizarI = true;
        } else {
            actualizarI = false;
        }
        //boolean actualizarI;

        if (RBCreateD.isSelected()) {
            crearI = true;
        } else {
            crearI = false;
        }
        //boolean crearI;

        if (RBDeleteD.isSelected()) {
            borrarI = true;
        } else {
            borrarI = false;
        }
        //boolean borrarI;

        System.out.println("getRadioBCU= {\"\"createAdministrator\"\":" + String.valueOf(crearA) + ",\"\"createTUser\"\":" + String.valueOf(crearTU) + ",\"\"updateMe\"\":" + String.valueOf(actualizarM) + ",\"\"updateAdministrator\"\":" + String.valueOf(actualizarA) + ",\"\"updateTUser\"\":" + String.valueOf(actualizarTU) + ",\"\"deleteMe\"\":" + String.valueOf(eliminarM) + ",\"\"deleteAdministrator\"\":" + String.valueOf(eliminarA) + ",\"\"deleteTUser\"\":" + String.valueOf(eliminarTU) + ",\"\"readMe\"\":" + String.valueOf(leerM) + ",\"\"readAdministrator\"\":" + String.valueOf(leerA) + ",\"\"readTUser\"\":" + String.valueOf(leerTU) + ",\"\"loginUser\"\":" + String.valueOf(loginU) + "}");
        return "{\"\"createAdministrator\"\":" + String.valueOf(crearA) + ",\"\"createTUser\"\":" + String.valueOf(crearTU) + ",\"\"updateMe\"\":" + String.valueOf(actualizarM) + ",\"\"updateAdministrator\"\":" + String.valueOf(actualizarA) + ",\"\"updateTUser\"\":" + String.valueOf(actualizarTU) + ",\"\"deleteMe\"\":" + String.valueOf(eliminarM) + ",\"\"deleteAdministrator\"\":" + String.valueOf(eliminarA) + ",\"\"deleteTUser\"\":" + String.valueOf(eliminarTU) + ",\"\"readMe\"\":" + String.valueOf(leerM) + ",\"\"readAdministrator\"\":" + String.valueOf(leerA) + ",\"\"readTUser\"\":" + String.valueOf(leerTU) + ",\"\"loginUser\"\":" + String.valueOf(loginU) + ",\"\"readData\"\":" + String.valueOf(leerI) + ",\"\"updateData\"\":" + String.valueOf(actualizarI) + ",\"\"createData\"\":" + String.valueOf(crearI) + ",\"\"deleteData\"\":" + String.valueOf(borrarI) + "}";
    }

    private String getRadioB() {
        boolean leerA;
        boolean leerM;
        boolean leerTU;
        boolean actualizarA;
        boolean actualizarM;
        boolean actualizarTU;
        boolean eliminarA;
        boolean eliminarTU;
        boolean eliminarM;
        boolean crearA;
        boolean crearTU;
        boolean loginU;

        return "{\"\"createAdministrator\"\":" + true + ",\"\"createTUser\"\":" + true + ",\"\"updateMe\"\":" + true + ",\"\"updateAdministrator\"\":" + true + ",\"\"updateTUser\"\":" + true + ",\"\"deleteMe\"\":" + true + ",\"\"deleteAdministrator\"\":" + true + ",\"\"deleteTUser\"\":" + true + ",\"\"readMe\"\":" + true + ",\"\"readAdministrator\"\":" + true + ",\"\"readTUser\"\":" + true + ",\"\"loginUser\"\":" + true + "}";
    }

    private String getUbication() {
        String ubicaciones[] = {"17.531220571705116, -99.54728275095816", "17.132791271521327, -96.7728431841885", "22.146749160456203, -97.79458054076693",
            "25.616705695203237, -100.31109896934211", "28.5929766805675, -106.06668768489162"};
        int i = (int) Math.floor(Math.random() * 5);
        //System.out.println("getUbication = " + i);
        String lugar = ubicaciones[i];
        return lugar;
    }

    private String getOrigin() {
        String ubicaciones[] = {"17.531220571705117, -99.54728275095817", "17.132791271521328, -96.7728431841886", "22.146749160456204, -97.79458054076694",
            "25.616705695203238, -100.31109896934212", "28.5929766805676, -106.06668768489163"};
        int i = (int) Math.floor(Math.random() * 5);
        //System.out.println("getUbication = " + i);
        String lugar = ubicaciones[i];
        return lugar;
    }

    private String getDestination() {
        String ubicaciones[] = {"17.531220571705115, -99.54728275095815", "17.132791271521326, -96.7728431841884", "22.146749160456202, -97.79458054076692",
            "25.616705695203236, -100.31109896934210", "28.5929766805674, -106.06668768489161"};
        int i = (int) Math.floor(Math.random() * 5);
        //System.out.println("getUbication = " + i);
        String lugar = ubicaciones[i];
        return lugar;
    }

    private String getHarvestDate() {
        String harvests[] = {"25/01/2021", "15/05/2021", "01/05/2021", "29/07/2021", "25/07/2021"};
        int i = (int) Math.floor(Math.random() * 5);
        System.out.println("getHavestDate = " + i);
        String fechaH = harvests[i];
        return fechaH;
    }

    private String getCaducationDate() {
        String fechas[] = {"25/02/2022", "15/06/2022", "01/06/2022", "29/08/2022", "25/08/2022"};
        int i = (int) Math.floor(Math.random() * 5);
        String fechaCD = fechas[i];
        return fechaCD;
    }

    private String getImage() {
        String imagenes[] = {"C:/imagenes/1.png", "C:/imagenes/2.png", "C:/imagenes/3.png", "C:/imagenes/4.png", "C:/imagenes/5.png"};
        int i = (int) Math.floor(Math.random() * 5);
        String imagen = imagenes[i];
        return imagen;
    }

    private String getPlates() {
        String imagenes[] = {"AÑ23HJ", "LIHJB5L", "HJKL3H52", "7KJ457K46", "2ÑL4JH2"};
        int i = (int) Math.floor(Math.random() * 5);
        String imagen = imagenes[i];
        return imagen;
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
        jDialog3 = new javax.swing.JDialog();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
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
        RBRequestAR = new javax.swing.JRadioButton();
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
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        RBReadA = new javax.swing.JRadioButton();
        RBReadM = new javax.swing.JRadioButton();
        RBReadTU = new javax.swing.JRadioButton();
        RBUpdateA = new javax.swing.JRadioButton();
        RBUpdateM = new javax.swing.JRadioButton();
        RBUpdateTU = new javax.swing.JRadioButton();
        RBCreateA = new javax.swing.JRadioButton();
        RBCreateTU = new javax.swing.JRadioButton();
        RBLoginU = new javax.swing.JRadioButton();
        RBDeleteA = new javax.swing.JRadioButton();
        RBDeleteTU = new javax.swing.JRadioButton();
        RBDeleteM = new javax.swing.JRadioButton();
        RBReadD = new javax.swing.JRadioButton();
        RBUpdateD = new javax.swing.JRadioButton();
        RBCreateD = new javax.swing.JRadioButton();
        RBDeleteD = new javax.swing.JRadioButton();
        BAyuda2 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        TFGasUC = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        CBCodeNP = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        SHonestAgentNP = new javax.swing.JSpinner();
        SDishonestAgentNP = new javax.swing.JSpinner();
        jLabel54 = new javax.swing.JLabel();
        SNumberRequestNP = new javax.swing.JSpinner();
        CBPreviousSNP = new javax.swing.JComboBox<>();
        CBCurrentSNP = new javax.swing.JComboBox<>();
        CBNameNP = new javax.swing.JComboBox<>();
        CBFIdNP = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        CBIpNP = new javax.swing.JComboBox<>();
        CBDescriptionNP = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        TFTokenNP = new javax.swing.JTextField();
        BAyuda1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        CBFIdNP1 = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        CBNameNP3 = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        CBPreviousSNP2 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        CBCurrentSNP2 = new javax.swing.JComboBox<>();
        CBDescriptionNP1 = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        CBCodeNP1 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel61 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel69 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();

        jDialog1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jDialog3.setMinimumSize(new java.awt.Dimension(499, 130));
        jDialog3.setResizable(false);

        jLabel40.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Dishonest Agents");

        jLabel42.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel42.setText("Dishonest agent A:");

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setText("Dishonest agent B:");

        jLabel48.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel48.setText("it follow the permissions with a wrong token");

        jLabel56.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel56.setText("it doesn't follow the permissions and use a correct token");

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel56))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BIniciar.setBackground(new java.awt.Color(0, 153, 0));
        BIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BIniciar.setForeground(new java.awt.Color(255, 255, 255));
        BIniciar.setText("Start");
        BIniciar.setMaximumSize(new java.awt.Dimension(720, 31));
        BIniciar.setPreferredSize(new java.awt.Dimension(720, 31));
        BIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIniciarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Stress test");

        CBPassword.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[xx#x]", "[xxx#]" }));
        CBPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPasswordActionPerformed(evt);
            }
        });

        CBServer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "localhost", "54.87.22.33", "52.202.214.13" }));
        CBServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBServerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Email:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Father Surname:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Mother Surname:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Name:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Server:");

        SpinnerNS.setModel(new javax.swing.SpinnerNumberModel(5, 1, 100, 1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("<html><body>Number of <br> requests </body></html>");

        CBEmail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]_[x]@[x].[x].com", "[x]_[x][#]@[x].[x].com" }));
        CBEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBEmailActionPerformed(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("total: 100%");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("HONEST AGENT:");

        sAgenteH.setModel(new javax.swing.SpinnerNumberModel(50, 1, 100, 1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DISHONEST AGENT");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Send something:");

        sEnvianA.setModel(new javax.swing.SpinnerNumberModel(30, 1, 100, 1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Begin any step:");

        sEmpieza.setModel(new javax.swing.SpinnerNumberModel(20, 1, 100, 1));

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
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sEmpieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sEnvianA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sAgenteH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(60, 60, 60))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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
                .addGap(3, 3, 3))
        );

        BAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/informacion.png"))); // NOI18N
        BAyuda.setBorder(null);
        BAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAyudaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Public key:");

        CBFatherS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBMotherS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jScrollPane2.setBorder(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(4, 281));
        jPanel2.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(jPanel2);

        RBRequestAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBRequestAR.setText("Automatic requests");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBFatherS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMotherS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BAyuda)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CBServer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinnerNS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFPublicK, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(RBRequestAR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(CBEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BAyuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(CBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinnerNS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(TFPublicK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RBRequestAR)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Root", jPanel1);

        jPanel3.setPreferredSize(new java.awt.Dimension(644, 100));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        CBTypeUserUC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Productor", "Acopio", "Carrier", "Merchant" }));
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
        SHonestAgentUC.setModel(new javax.swing.SpinnerNumberModel(70, 1, 100, 1));

        SDishonestAgentUC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SDishonestAgentUC.setModel(new javax.swing.SpinnerNumberModel(30, 1, 100, 1));

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
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SHonestAgentUC))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel38))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SDishonestAgentUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Server:");

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Permissions DP");

        RBReadA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadA.setText("readAdministrator");
        RBReadA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadAActionPerformed(evt);
            }
        });

        RBReadM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadM.setText("readMe");
        RBReadM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadMActionPerformed(evt);
            }
        });

        RBReadTU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadTU.setText("readTUser");
        RBReadTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadTUActionPerformed(evt);
            }
        });

        RBUpdateA.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateA.setText("updateAdministrator");
        RBUpdateA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateAActionPerformed(evt);
            }
        });

        RBUpdateM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateM.setText("updateMe");
        RBUpdateM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateMActionPerformed(evt);
            }
        });

        RBUpdateTU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateTU.setText("updateTUser");
        RBUpdateTU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBUpdateTUActionPerformed(evt);
            }
        });

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

        RBLoginU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBLoginU.setText("loginUser");
        RBLoginU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBLoginUActionPerformed(evt);
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

        RBDeleteM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteM.setText("deleteMe");
        RBDeleteM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBDeleteMActionPerformed(evt);
            }
        });

        RBReadD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBReadD.setText("readData");
        RBReadD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBReadDActionPerformed(evt);
            }
        });

        RBUpdateD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBUpdateD.setText("updateData");

        RBCreateD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBCreateD.setText("createData");

        RBDeleteD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBDeleteD.setText("deleteData");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBReadA)
                            .addComponent(RBReadM)
                            .addComponent(RBReadTU)
                            .addComponent(RBReadD))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBUpdateA)
                            .addComponent(RBUpdateM)
                            .addComponent(RBUpdateTU)
                            .addComponent(RBUpdateD))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBCreateA)
                            .addComponent(RBCreateTU)
                            .addComponent(RBLoginU)
                            .addComponent(RBCreateD))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBDeleteD)
                            .addComponent(RBDeleteM)
                            .addComponent(RBDeleteTU)
                            .addComponent(RBDeleteA))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadA)
                    .addComponent(RBUpdateA)
                    .addComponent(RBCreateA)
                    .addComponent(RBDeleteA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadM)
                    .addComponent(RBUpdateM)
                    .addComponent(RBCreateTU)
                    .addComponent(RBDeleteTU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadTU)
                    .addComponent(RBUpdateTU)
                    .addComponent(RBLoginU)
                    .addComponent(RBDeleteM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBReadD)
                    .addComponent(RBUpdateD)
                    .addComponent(RBCreateD)
                    .addComponent(RBDeleteD))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel8);

        BAyuda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/informacion.png"))); // NOI18N
        BAyuda2.setBorder(null);
        BAyuda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAyuda2ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel57.setText("Gas:");

        TFGasUC.setText("900000");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel31)
                            .addComponent(jLabel24)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TFAdressUUC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBPasswordUC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBEmailUC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBTypeUserUC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFAuthorizationUC, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBServer1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBFatherSUC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBNameUC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMotherSUC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SNumberRequestUC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFGasUC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BIniciarUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BAyuda2)))))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(CBEmailUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(CBPasswordUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(CBTypeUserUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(TFAdressUUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(TFAuthorizationUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(CBNameUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57)
                            .addComponent(TFGasUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(CBFatherSUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(CBMotherSUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(SNumberRequestUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBServer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(BIniciarUC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BAyuda2)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crear Usuario", jPanel3);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("New harvest");

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setText("Description:");

        jLabel49.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel49.setText("Code:");

        CBCodeNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel6.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(jPanel6);

        jLabel51.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Total 100%");

        jLabel52.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel52.setText("Honest agent:");

        jLabel53.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel53.setText("Dishonest agent:");

        SHonestAgentNP.setModel(new javax.swing.SpinnerNumberModel(70, 1, 100, 1));

        SDishonestAgentNP.setModel(new javax.swing.SpinnerNumberModel(30, 1, 100, 1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SHonestAgentNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SDishonestAgentNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(SHonestAgentNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(SDishonestAgentNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel9);

        jLabel54.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel54.setText("Number of request:");

        SNumberRequestNP.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        CBPreviousSNP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBPreviousSNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "Productor", "Carrier", "Acopio", "Merchant" }));
        CBPreviousSNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPreviousSNPActionPerformed(evt);
            }
        });

        CBCurrentSNP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBCurrentSNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productor", "Carrier", "Acopio", "Merchant" }));

        CBNameNP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBNameNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        CBFIdNP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBFIdNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "Random" }));

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Previous stage:");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel44.setText("Current stage:");

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("Name:");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel47.setText("FId:");

        jLabel55.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel55.setText("Server:");

        CBIpNP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBIpNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "localhost", "54.87.22.33", "52.202.214.13" }));

        CBDescriptionNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setText("Token:");

        BAyuda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/informacion.png"))); // NOI18N
        BAyuda1.setBorder(null);
        BAyuda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAyuda1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel41)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CBPreviousSNP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBDescriptionNP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBCurrentSNP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBNameNP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel49)
                            .addComponent(jLabel55)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CBFIdNP, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBCodeNP, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBIpNP, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFTokenNP, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BAyuda1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SNumberRequestNP, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SNumberRequestNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54)))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BAyuda1)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel46)
                                        .addComponent(CBDescriptionNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel47)
                                        .addComponent(CBFIdNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(8, 8, 8)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel45)
                                        .addComponent(CBNameNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel49)
                                        .addComponent(CBCodeNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel41)
                                        .addComponent(CBPreviousSNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel55)
                                        .addComponent(CBIpNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel44)
                                        .addComponent(CBCurrentSNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel37)
                                        .addComponent(TFTokenNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(13, 13, 13)))
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add harvest", jPanel5);

        jLabel50.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("New acopio");

        jLabel63.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel63.setText("FId:");

        CBFIdNP1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBFIdNP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "Random" }));

        jLabel64.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel64.setText("Name:");

        CBNameNP3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBNameNP3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jLabel65.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel65.setText("Previous stage:");

        CBPreviousSNP2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBPreviousSNP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Null", "Productor", "Carrier", "Acopio", "Merchant" }));
        CBPreviousSNP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPreviousSNP2ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel66.setText("Current stage:");

        CBCurrentSNP2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBCurrentSNP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productor", "Carrier", "Acopio", "Merchant" }));

        CBDescriptionNP1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBDescriptionNP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jLabel58.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel58.setText("Description:");

        jLabel59.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel59.setText("Code:");

        CBCodeNP1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CBCodeNP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[x]", "[xx]", "[xxx]", "[xxxx]", "[xxxxx]" }));

        jLabel60.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel60.setText("Clasification:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hass", "Bacon", "Pinkerton", "Reed", "Fuerte", "Criollo" }));

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Start");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel10);

        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jRadioButton1.setText("Automatic requests");

        jLabel61.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel61.setText("Token:");

        jLabel62.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel62.setText("Number of requests");

        jSpinner1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel67.setText("total 100%");

        jLabel68.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel68.setText("Honest agent:");

        jSpinner2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(70, 1, 100, 1));

        jLabel69.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel69.setText("Dishonest agent:");

        jSpinner3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(30, 1, 100, 1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel67)
                .addGap(80, 80, 80))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel11);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel63)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBFIdNP1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel64)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBNameNP3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel59)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBCodeNP1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBPreviousSNP2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBDescriptionNP1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBCurrentSNP2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel61)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRadioButton1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(CBFIdNP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(CBNameNP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBCodeNP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(CBPreviousSNP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(CBDescriptionNP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel66)
                                .addComponent(CBCurrentSNP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel60)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel61)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add acopio", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        int email = CBEmail.getSelectedIndex();
        int password = CBPassword.getSelectedIndex();
        int nSolicitudes = (Integer) SpinnerNS.getValue();
        int aHonesto = (Integer) sAgenteH.getValue();
        int aEnviarA = (Integer) sEnvianA.getValue();
        int aEmpieza = (Integer) sEmpieza.getValue();
        int pTotal = aHonesto + aEnviarA + aEmpieza;
        String ApellidoM = String.valueOf(CBMotherS.getSelectedIndex());
        String ApellidoP = String.valueOf(CBFatherS.getSelectedIndex());
        String nombreU = String.valueOf(CBName.getSelectedIndex());
        String tipoU = "Root";
        String ip = String.valueOf(CBServer.getSelectedItem());
        String publicK = TFPublicK.getText();
        String dp = getRadioB();

        if (RBRequestAR.isSelected()) {
            if (!publicK.isEmpty()) {
                Respuesta.setTamanio(nSolicitudes);
                if (pTotal == 100) {
                    for (int x = 0; x < nSolicitudes; x++) {
                        double i = Math.floor(Math.random() * 101);
                        HiloAuto objetoA = new HiloAuto();
                        if (i <= aHonesto) {
                            int position = x;
                            //consultaHonestaAuto("honesto", position);
                            objetoA.setApellidoM(ApellidoM);
                            objetoA.setApellidoP(ApellidoP);
                            objetoA.setCaja(areaTexto);
                            objetoA.setDp(dp);
                            objetoA.setEmail(email);
                            objetoA.setIp(ip);
                            objetoA.setNombreU(nombreU);
                            objetoA.setNumberRequest(nSolicitudes);
                            objetoA.setPassword(password);
                            objetoA.setPosition(position);
                            objetoA.setPublicKey(publicK);
                            objetoA.setTipoConsulta("honesto");
                            objetoA.setTypeU(tipoU);
                            objetoA.setaEmpieza(aEmpieza);
                            objetoA.setaEnviarA(aEnviarA);
                            objetoA.setaHonesto(aHonesto);
                            new Thread(objetoA).start();

                            JButton boton = new JButton("Honest agent");
                            boton.setPreferredSize(new Dimension(30, 70));
                            boton.setBackground(Color.GREEN);
                            jPanel2.add(boton);
                            boton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    jDialog2.setVisible(true);
                                    areaTexto.setText(Respuesta.getConsultaRoot(position));
                                }
                            });
                        } else {
                            if (i <= (aHonesto + aEnviarA)) {
                                int position = x;
                                //consultaHonestaAuto("enviarAlgo", position);
                                objetoA.setApellidoM(ApellidoM);
                                objetoA.setApellidoP(ApellidoP);
                                objetoA.setCaja(areaTexto);
                                objetoA.setDp(dp);
                                objetoA.setEmail(email);
                                objetoA.setIp(ip);
                                objetoA.setNombreU(nombreU);
                                objetoA.setNumberRequest(nSolicitudes);
                                objetoA.setPassword(password);
                                objetoA.setPosition(position);
                                objetoA.setPublicKey(publicK);
                                objetoA.setTipoConsulta("enviarAlgo");
                                objetoA.setTypeU(tipoU);
                                objetoA.setaEmpieza(aEmpieza);
                                objetoA.setaEnviarA(aEnviarA);
                                objetoA.setaHonesto(aHonesto);
                                new Thread(objetoA).start();

                                JButton boton = new JButton("Dishonest agent send something");
                                boton.setPreferredSize(new Dimension(30, 70));
                                boton.setBackground(Color.ORANGE);
                                jPanel2.add(boton);
                                boton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        jDialog2.setVisible(true);
                                        areaTexto.setText(Respuesta.getConsultaRoot(position));
                                    }
                                });

                            } else {
                                int position = x;
                                //consultaHonestaAuto("empiezaAlgun", position);
                                objetoA.setApellidoM(ApellidoM);
                                objetoA.setApellidoP(ApellidoP);
                                objetoA.setCaja(areaTexto);
                                objetoA.setDp(dp);
                                objetoA.setEmail(email);
                                objetoA.setIp(ip);
                                objetoA.setNombreU(nombreU);
                                objetoA.setNumberRequest(nSolicitudes);
                                objetoA.setPassword(password);
                                objetoA.setPosition(position);
                                objetoA.setPublicKey(publicK);
                                objetoA.setTipoConsulta("empiezaAlgun");
                                objetoA.setTypeU(tipoU);
                                objetoA.setaEmpieza(aEmpieza);
                                objetoA.setaEnviarA(aEnviarA);
                                objetoA.setaHonesto(aHonesto);
                                new Thread(objetoA).start();

                                JButton boton = new JButton("Dishonest agent begin any step");
                                boton.setPreferredSize(new Dimension(30, 70));
                                boton.setBackground(Color.YELLOW);
                                jPanel2.add(boton);
                                boton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        jDialog2.setVisible(true);
                                        areaTexto.setText(Respuesta.getConsultaRoot(position));
                                    }
                                });
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Set the public key");
            }
        } else {
            if (!publicK.isEmpty()) {
                if (pTotal == 100) {
                    crearB(nSolicitudes, aHonesto, aEnviarA);
                } else {
                    JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Set the public key");
            }
        }
    }//GEN-LAST:event_BIniciarActionPerformed

    private void CBEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBEmailActionPerformed

    private void BAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAyudaActionPerformed
        jDialog1.setVisible(true);
    }//GEN-LAST:event_BAyudaActionPerformed

    private void RBDeleteMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteMActionPerformed

    private void RBDeleteTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteTUActionPerformed

    private void RBDeleteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBDeleteAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBDeleteAActionPerformed

    private void RBLoginUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBLoginUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBLoginUActionPerformed

    private void RBCreateTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCreateTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBCreateTUActionPerformed

    private void RBCreateAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCreateAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBCreateAActionPerformed

    private void RBUpdateTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateTUActionPerformed

    private void RBUpdateMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateMActionPerformed

    private void RBUpdateAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBUpdateAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBUpdateAActionPerformed

    private void RBReadTUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadTUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadTUActionPerformed

    private void RBReadMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadMActionPerformed

    private void RBReadAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadAActionPerformed

    private void CBServer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBServer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBServer1ActionPerformed

    private void BIniciarUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIniciarUCActionPerformed
        jPanel4.removeAll();
        jPanel4.updateUI();
        int aHonesto = (Integer) SHonestAgentUC.getValue();
        int aDeshonesto = (Integer) SDishonestAgentUC.getValue();
        int porcentaje = aHonesto + aDeshonesto;
        int nSolicitudes = (Integer) SNumberRequestUC.getValue();
        String adressU = TFAdressUUC.getText();
        String authorization = TFAuthorizationUC.getText();
        String gas = TFGasUC.getText();

        if (porcentaje == 100) {
            if (!adressU.isEmpty()) {
                if (!authorization.isEmpty()) {
                    if (!gas.isEmpty()) {
                        crearBUC(nSolicitudes, aHonesto, aDeshonesto);
                    } else {
                        JOptionPane.showMessageDialog(null, "Refill the gas field");
                    }
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

    private void TFAuthorizationUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFAuthorizationUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFAuthorizationUCActionPerformed

    private void CBTypeUserUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTypeUserUCActionPerformed
        habilitarCB(String.valueOf(CBTypeUserUC.getSelectedItem()));
    }//GEN-LAST:event_CBTypeUserUCActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel6.removeAll();
        jPanel6.updateUI();

        String ubication = getUbication();
        String harvestD = getHarvestDate();
        String caducationD = getCaducationDate();
        int description = CBDescriptionNP.getSelectedIndex();
        String fId = String.valueOf(CBFIdNP.getSelectedItem());
        int nameProductor = CBNameNP.getSelectedIndex();
        String previousS = String.valueOf(CBPreviousSNP.getSelectedItem());
        String currentS = String.valueOf(CBCurrentSNP.getSelectedItem());
        int code = CBCodeNP.getSelectedIndex();
        int numberR = (Integer) SNumberRequestNP.getValue();
        int aHonest = (Integer) SHonestAgentNP.getValue();
        int aDishonest = (Integer) SDishonestAgentNP.getValue();
        int totalP = aHonest + aDishonest;

        if (!ubication.isEmpty()) {
            if (!harvestD.isEmpty()) {
                if (!caducationD.isEmpty()) {
                    if (totalP == 100) {
                        crearBNP(numberR, aHonest, aDishonest);
                    } else {
                        JOptionPane.showMessageDialog(null, "The addition of porcentages must be 100%");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Set a caducation date");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Set a harvest");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Set a ubication");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void CBPreviousSNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPreviousSNPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBPreviousSNPActionPerformed

    private void RBReadDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBReadDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBReadDActionPerformed

    private void BAyuda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAyuda1ActionPerformed
        JOptionPane.showMessageDialog(null, "Ingresa el token de root para registrar una nueva cosecha");
    }//GEN-LAST:event_BAyuda1ActionPerformed

    private void BAyuda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAyuda2ActionPerformed
        jDialog3.setVisible(true);
    }//GEN-LAST:event_BAyuda2ActionPerformed

    private void CBPreviousSNP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPreviousSNP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBPreviousSNP2ActionPerformed

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
    private javax.swing.JButton BAyuda1;
    private javax.swing.JButton BAyuda2;
    private javax.swing.JButton BIniciar;
    private javax.swing.JButton BIniciarUC;
    private javax.swing.JComboBox<String> CBCodeNP;
    private javax.swing.JComboBox<String> CBCodeNP1;
    private javax.swing.JComboBox<String> CBCurrentSNP;
    private javax.swing.JComboBox<String> CBCurrentSNP2;
    private javax.swing.JComboBox<String> CBDescriptionNP;
    private javax.swing.JComboBox<String> CBDescriptionNP1;
    private javax.swing.JComboBox<String> CBEmail;
    private javax.swing.JComboBox<String> CBEmailUC;
    private javax.swing.JComboBox<String> CBFIdNP;
    private javax.swing.JComboBox<String> CBFIdNP1;
    private javax.swing.JComboBox<String> CBFatherS;
    private javax.swing.JComboBox<String> CBFatherSUC;
    private javax.swing.JComboBox<String> CBIpNP;
    private javax.swing.JComboBox<String> CBMotherS;
    private javax.swing.JComboBox<String> CBMotherSUC;
    private javax.swing.JComboBox<String> CBName;
    private javax.swing.JComboBox<String> CBNameNP;
    private javax.swing.JComboBox<String> CBNameNP3;
    private javax.swing.JComboBox<String> CBNameUC;
    private javax.swing.JComboBox<String> CBPassword;
    private javax.swing.JComboBox<String> CBPasswordUC;
    private javax.swing.JComboBox<String> CBPreviousSNP;
    private javax.swing.JComboBox<String> CBPreviousSNP2;
    private javax.swing.JComboBox<String> CBServer;
    private javax.swing.JComboBox<String> CBServer1;
    private javax.swing.JComboBox<String> CBTypeUserUC;
    private javax.swing.JRadioButton RBCreateA;
    private javax.swing.JRadioButton RBCreateD;
    private javax.swing.JRadioButton RBCreateTU;
    private javax.swing.JRadioButton RBDeleteA;
    private javax.swing.JRadioButton RBDeleteD;
    private javax.swing.JRadioButton RBDeleteM;
    private javax.swing.JRadioButton RBDeleteTU;
    private javax.swing.JRadioButton RBLoginU;
    private javax.swing.JRadioButton RBReadA;
    private javax.swing.JRadioButton RBReadD;
    private javax.swing.JRadioButton RBReadM;
    private javax.swing.JRadioButton RBReadTU;
    private javax.swing.JRadioButton RBRequestAR;
    private javax.swing.JRadioButton RBUpdateA;
    private javax.swing.JRadioButton RBUpdateD;
    private javax.swing.JRadioButton RBUpdateM;
    private javax.swing.JRadioButton RBUpdateTU;
    private javax.swing.JSpinner SDishonestAgentNP;
    private javax.swing.JSpinner SDishonestAgentUC;
    private javax.swing.JSpinner SHonestAgentNP;
    private javax.swing.JSpinner SHonestAgentUC;
    private javax.swing.JSpinner SNumberRequestNP;
    private javax.swing.JSpinner SNumberRequestUC;
    private javax.swing.JSpinner SpinnerNS;
    private javax.swing.JTextField TFAdressUUC;
    private javax.swing.JTextField TFAuthorizationUC;
    private javax.swing.JTextField TFGasUC;
    private javax.swing.JTextField TFPublicK;
    private javax.swing.JTextField TFTokenNP;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
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
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JSpinner sAgenteH;
    private javax.swing.JSpinner sEmpieza;
    private javax.swing.JSpinner sEnvianA;
    // End of variables declaration//GEN-END:variables

}
