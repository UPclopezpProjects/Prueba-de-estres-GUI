/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewProductor;

import Interfaz.MD5;
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
    private JTextArea caja;

    public DishonestAgentNP(String ubication, String harvestD, String caducationD, String description, String fId, String nameProduction, String previousS, String currentS, String code, String image, String ip, JTextArea caja) {
        this.ubication = ubication;
        this.harvestD = harvestD;
        this.caducationD = caducationD;
        this.description = description;
        this.fId = fId;
        this.nameProduction = nameProduction;
        this.previousS = previousS;
        this.currentS = currentS;
        this.code = code;
        this.image = image;
        this.ip = ip;
        this.caja = caja;
        userCreation();
    }
    
    public void userCreation() {
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
                    + "-X POST http://"+ip+":80/productorsData";
            
            String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"ubication="+ubication+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -X POST http://"+ip+":80/productorsData";
            //String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"ubication="+ubication+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -H \"Authorization=\"-X POST http://"+ip+":80/productorsData";

            
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            //System.out.println("--> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; CURL: " + rootCreation2);
            String response = "New Productor/DishonestAgent --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            caja.append(response+ "\n");

            //hace la petición como en CMD
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(rootCreation);

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
                        response = "New Productor/DishonestAgent <-- Date: " + strDate4 + "; Response: " + line;
                        caja.append(response+ "\n \n");
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
