/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyName;

import Interfaz.Respuesta;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Company(String email, String companyName, String token, String ip, String stage, int position) {
        this.email = email;
        this.companyName = companyName;
        this.token = token;
        this.ip = ip;
        this.stage = stage;
        this.position = position;
        //this.caja = caja;
        companyCreation();
    }

    public void companyCreation() {
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
            Respuesta.setConsultaCompany("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Respuesta.setConsultaCompany(ex.toString(), position);
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
