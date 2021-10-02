/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewProductor;

import Interfaz.MD5;
import Interfaz.Respuesta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class DishonestAgentNP {

    private String ubication;
    private String harvestD;
    private String caducationD;
    private String description;
    private String fId;
    private String nameProduction;
    private String previousS;
    private String currentS;
    private String code;
    private String image;
    private String ip;
    //private JTextArea caja;
    private String token;
    //exclusivo de carrier
    private String origin;
    private String destination;
    private String driverName;
    private String plates;
    private String productPhotos;
    private String vehiclePhotos;
    private String tracking;
    //exclusivo para acopio
    private String nameAcopio;
    private String arrivalDate;
    private String quantity;
    private String measure;
    private String whoReceives;
    private String nameMerchant;
    private String puerto = "80";

    public DishonestAgentNP(String ubication, String harvestD, String caducationD, String description, String fId,
            String nameProductor, String previousS, String currentS, String code, String image, String ip, /*JTextArea caja,*/
            String token, int position) {
        this.ubication = ubication;
        this.harvestD = harvestD;
        this.caducationD = caducationD;
        this.description = description;
        this.fId = fId;
        this.nameProduction = nameProductor;
        this.previousS = previousS;
        this.currentS = currentS;
        this.code = code;
        this.image = image;
        this.ip = ip;
        //this.caja = caja;
        this.token = token;
        userCreation(position);
    }

    public DishonestAgentNP(String fId, String ubication, String nameProduction, String previousStage, String currentStage,
            String image, String description, String code, String driverName, String origin, String destination, String plates,
            String productPhotos, String vehiclePhotos, String tracking, String token, String ip, /*JTextArea caja, */int position) {
        this.fId = fId;
        this.ubication = ubication;
        this.nameProduction = nameProduction;
        this.previousS = previousStage;
        this.currentS = currentStage;
        this.image = image;
        this.description = description;
        this.code = code;
        this.driverName = driverName;
        this.origin = origin;
        this.destination = destination;
        this.plates = plates;
        this.productPhotos = productPhotos;
        this.vehiclePhotos = vehiclePhotos;
        this.tracking = tracking;
        this.token = token;
        this.ip = ip;
        //this.caja = caja;
        userCreationCarrier(position);
    }

    public DishonestAgentNP(String fId, String ubication, String nameAcopio, String previousStage, String currentStage, String image, String description, String code,
            String arrivalDate, String quantity, String measure, String whoReceives, String token, String ip, /*JTextArea caja, */int position) {
        this.fId = fId;
        this.ubication = ubication;
        this.nameAcopio = nameAcopio;
        this.previousS = previousStage;
        this.currentS = currentStage;
        this.image = image;
        this.description = description;
        this.code = code;
        this.arrivalDate = arrivalDate;
        this.quantity = quantity;
        this.measure = measure;
        this.whoReceives = whoReceives;
        this.token = token;
        this.ip = ip;
        //this.caja = caja;
        userCreationAcopio(position);
    }

    public DishonestAgentNP(String fId, String ubication, String nameMerchant, String previousS, String currentS, String image, String description, String code, String arrivalDate,
            String quantity, String token, String ip, JTextArea caja, int position) {
        this.fId = fId;
        this.ubication = ubication;
        this.nameMerchant = nameMerchant;
        this.previousS = previousS;
        this.currentS = currentS;
        this.image = image;
        this.description = description;
        this.code = code;
        this.arrivalDate = arrivalDate;
        this.quantity = quantity;
        this.token = token;
        this.ip = ip;
        //this.caja = caja;
        userCreationMerchant(position);
    }

    public void userCreation(int position) {
        //System.out.print(token);
        String[] firstname = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String[] lastname = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            Random rand = new Random();
            int randomNum1 = rand.nextInt(firstname.length);
            int randomNum2 = rand.nextInt(firstname.length);
            String documentation = "document.pdf";

            String rootCreation = "curl -d \"fid=" + fId + "&"
                    + "ubication=" + ubication + "&"
                    + "name=" + nameProduction + "&"
                    + "harvestDate=" + harvestD + "&"
                    + "caducationDate=" + caducationD + "&"
                    + "previousStage=" + previousS + "&"
                    + "currentStage=" + currentS + "&"
                    + "description=" + description + "&"
                    + "documentation=" + documentation + "&"
                    + "code=" + code + "\" "
                    + "-F \"image=@" + image + "\" "
                    + "-X POST http://" + ip + ":" + puerto + "/productorsData";

            //String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"ubication="+ubication+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -X POST http://"+ip+":80/productorsData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameProduction + "\" -F \"harvestDate=" + harvestD + "\" -F \"caducationDate=" + caducationD + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"description=" + description + "\" -F \"image=@" + image + "\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code=" + code + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip +":"+puerto+ "/productorsData";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Productor/AgentDishonest --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            /*if (position == -1) {
                caja.append(response + "\n");
            } else {*/
                Respuesta.setConsultaS(response + "\n", position);
            //}

            //hace la petición como en CMD
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(rootCreation2);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);
            //System.out.println("<OUTPUT2>");
            boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now4 = new Date();
                        String strDate4 = sdf4.format(now4);
                        //System.out.println("<-- Date: " + strDate4 + "; Response: " + line);
                        response = "New Productor/AgentDishonest <-- Date: " + strDate4 + "; Response: " + line;
                        /*if (position == -1) {
                            caja.append(response + "\n \n");;
                        } else {*/
                            Respuesta.setConsultaS(response + "\n", position);
                        //}

                    }
                    intentar = false;
                }
            }
            //System.out.println("</OUTPUT2>");
            int exitVal = proc.waitFor();
            //System.out.println("Process exitValue: " + exitVal);
        } catch (IOException | InterruptedException t) {
            //System.out.println(t);
        }
    }

    public void userCreationCarrier(int position) {
        //System.out.print(token);
        String[] firstname = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String[] lastname = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            Random rand = new Random();
            int randomNum1 = rand.nextInt(firstname.length);
            int randomNum2 = rand.nextInt(firstname.length);
            String documentation = "document.pdf";

            //String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -F \"origin="+origin+"\" -F \"destination="+destination+"\" -H \"Authorization:"+token+"\" -X POST http://"+ip+":80/productorsData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameProduction + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"nameOfCompany=Transportadora de aguacates 3 S.A. de C.V." + "\" -F \"image=@" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"driverName=" + driverName + "\" -F \"origin=" + origin + "\" -F \"destination=" + destination + "\" -F \"plates=" + plates + "\" -F \"productPhotos=@" + productPhotos + "\" -F \"vehiclePhotos=@" + vehiclePhotos + "\" -F \"tracking=" + tracking + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip +":"+puerto+ "/carriersData";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Productor/AgentDishonest Carrier --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            /*if (position == -1) {
                caja.append(response + "\n");
            } else {*/
                Respuesta.setConsultaS(response + "\n", position);
            //}

            //hace la petición como en CMD
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(rootCreation2);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);
            //System.out.println("<OUTPUT2>");
            boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now4 = new Date();
                        String strDate4 = sdf4.format(now4);
                        //System.out.println("<-- Date: " + strDate4 + "; Response: " + line);
                        response = "New Productor/AgentDishonest Carrier <-- Date: " + strDate4 + "; Response: " + line;
                        /*if (position == -1) {
                            caja.append(response + "\n \n");
                        } else {*/
                            Respuesta.setConsultaS(response + "\n", position);
                        //}

                    }
                    intentar = false;
                }
            }
            //System.out.println("</OUTPUT2>");
            int exitVal = proc.waitFor();
            //System.out.println("Process exitValue: " + exitVal);
        } catch (IOException | InterruptedException t) {
            //System.out.println(t);
        }
    }

    public void userCreationAcopio(int position) {
        //System.out.print(token);
        String[] firstname = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String[] lastname = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            Random rand = new Random();
            int randomNum1 = rand.nextInt(firstname.length);
            int randomNum2 = rand.nextInt(firstname.length);
            String documentation = "document.pdf";

            //String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -F \"origin="+origin+"\" -F \"destination="+destination+"\" -H \"Authorization:"+token+"\" -X POST http://"+ip+":80/productorsData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameAcopio + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"nameOfCompany=Empresa Acopio" + "\" -F \"image=@" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"arrivalDate=" + arrivalDate + "\" -F \"clasification=Hass" + "\" -F \"quantity=" + quantity + "\" -F \"measure=" + measure + "\" -F \"whoReceives=" + whoReceives + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip +":"+puerto+ "/acopiosDataIn";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Acopio/AgentDishonest Acopio --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            /*if (position == -1) {
                caja.append(response + "\n");
            } else {*/
                Respuesta.setConsultaS(response + "\n", position);
            //}

            //hace la petición como en CMD
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(rootCreation2);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);
            //System.out.println("<OUTPUT2>");
            boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now4 = new Date();
                        String strDate4 = sdf4.format(now4);
                        //System.out.println("<-- Date: " + strDate4 + "; Response: " + line);
                        response = "New Acopio/AgentDishonest Acopio <-- Date: " + strDate4 + "; Response: " + line;
                        /*if (position == -1) {
                            caja.append(response + "\n \n");
                        } else {*/
                            Respuesta.setConsultaS(response + "\n", position);
                        //}

                    }
                    intentar = false;
                }
            }
            //System.out.println("</OUTPUT2>");
            int exitVal = proc.waitFor();
            //System.out.println("Process exitValue: " + exitVal);
        } catch (IOException | InterruptedException t) {
            //System.out.println(t);
        }
    }

    public void userCreationMerchant(int position) {
        //System.out.print(token);
        String[] firstname = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String[] lastname = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            Random rand = new Random();
            int randomNum1 = rand.nextInt(firstname.length);
            int randomNum2 = rand.nextInt(firstname.length);
            String documentation = "document.pdf";

            //String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -F \"origin="+origin+"\" -F \"destination="+destination+"\" -H \"Authorization:"+token+"\" -X POST http://"+ip+":80/productorsData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameMerchant + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"image=@" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"arrivalDate=" + arrivalDate + "\" -F \"quantity=" + quantity + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip +":"+puerto+ "/merchantsDataIn";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Acopio/AgentHonest Acopio --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            /*if (position == -1) {
                caja.append(response + "\n");
            } else {*/
                Respuesta.setConsultaS(response + "\n", position);
            //}

            //hace la petición como en CMD
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(rootCreation2);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);
            //System.out.println("<OUTPUT2>");
            boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now4 = new Date();
                        String strDate4 = sdf4.format(now4);
                        //System.out.println("<-- Date: " + strDate4 + "; Response: " + line);
                        response = "New Acopio/AgentHonest Acopio <-- Date: " + strDate4 + "; Response: " + line;
                        /*if (position == -1) {
                            caja.append(response + "\n \n");
                        } else {*/
                            Respuesta.setConsultaS(response + "\n", position);
                        //}

                    }
                    intentar = false;
                }
            }
            //System.out.println("</OUTPUT2>");
            int exitVal = proc.waitFor();
            //System.out.println("Process exitValue: " + exitVal);
        } catch (IOException | InterruptedException t) {
            //System.out.println(t);
        }
    }
}
