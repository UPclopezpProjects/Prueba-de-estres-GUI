/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyName;

import Interfaz.MD5;
import Interfaz.Respuesta;
import UCreation.HonestAgent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.json.JSONObject;

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
    String response;

    public Company(String email, String companyName, String token, String ip, String stage, int position/*, JTextArea caja*/) {
        this.email = email;
        this.companyName = companyName;
        this.token = token;
        this.ip = ip;
        this.stage = stage;
        this.position = position;
        //this.caja = caja;
        userCreation2();
    }

    public void userCreation2() {
        HttpURLConnection connection = null;
        String rootCreation = "email=" + email + "&nameOfCompany=" + companyName;
        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;
        try {
            if (stage == "Productor") {
                url = new URL("http://" + this.ip + "/productorsCompany");
            }

            if (stage == "Carrier") {
                url = new URL("http://" + this.ip + "/carriersCompany");
            }

            if (stage == "Acopio") {
                url = new URL("http://" + this.ip + "/acopiosCompany");
            }

            if (stage == "Merchant") {
                url = new URL("http://" + this.ip + "/merchantsCompany");
            }

            //url = new URL("http://" + this.ip + "/userCreation");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

            connection.setRequestProperty("Authorization", token);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            response = "New Company --> Date: " + strDate3 + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaCompany(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("Company name/error Stream: " + connection.getErrorStream());
                InputStream is = connection.getErrorStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    JSONObject jsonObject = new JSONObject(line);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    Date now2 = new Date();
                    String strDate2 = sdf2.format(now2);

                    //response = "Root/AgentHonest/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line;
                    response.append(line);
                    Respuesta.setConsultaCompany("Root/AgentHonest/userCreation <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
                    response.append('\r');
                    
                }
                
            } else {
                //Get Response
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;

                while ((line = rd.readLine()) != null) {
                    JSONObject jsonObject = new JSONObject(line);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    Date now2 = new Date();
                    String strDate2 = sdf2.format(now2);
                    response.append(line);
                    //System.out.println("Crear usuario/HonestAgent/line: "+line);
                    Respuesta.setConsultaCompany("New Company <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("New Company/Exception: " + e);
            Respuesta.setConsultaUC("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Logger.getLogger(HonestAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createCompanyName() {
        try {
            if (stage == "Productor") {
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/productorsCompany";
            }

            if (stage == "Carrier") {
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/carriersCompany";
            }

            if (stage == "Acopio") {
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/acopiosCompany";
            }

            if (stage == "Merchant") {
                rootCreation2 = "curl -F \"email=" + email + "\" -F \"nameOfCompany=" + companyName + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/merchantsCompany";
            }

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Company --> Date: " + strDate3 + "; CURL: " + rootCreation2;

            Respuesta.setConsultaCompany(response + "\n", position);

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
