/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyName;

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
public class Company {

    private String email;
    private String companyName;
    private String token;
    private String ip;
    private int position;
    //private JTextArea caja;
    private String puerto = "80";
    private String rootCreation2;
    private String stage;

    public Company(String email, String companyName, String token, String ip, String stage, int position/*, JTextArea caja*/) {
        this.email = email;
        this.companyName = companyName;
        this.token = token;
        this.ip = ip;
        this.stage = stage;
        this.position = position;
        //this.caja = caja;
        createCompanyName();
    }

    public void createCompanyName() {
        try {
                    
            if(stage =="Productor"){
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/productorsCompany";
            }
            
            if(stage =="Carrier"){
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/carriersCompany";
            }
            
            if(stage =="Acopio"){
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/acopiosCompany";
            }
            
            if(stage =="Merchant"){
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/merchantsCompany";
            }
            
            

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Company --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            System.out.println(response);
            /*if (position == -1) {
                caja.append(response + "\n");
            } else {*/
                Respuesta.setConsultaCompany(response+"\n", position);
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
                        response = "New Company <-- Date: " + strDate4 + "; Response: " + line;
                        /*if (position == -1) {
                            caja.append(response + "\n \n");
                        } else {*/
                            Respuesta.setConsultaCompany(response, position);
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
