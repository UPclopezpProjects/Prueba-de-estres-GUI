/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCreation;

import Interfaz.MD5;
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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javax.swing.JTextArea;
import org.json.JSONException;*/
import org.json.JSONObject;

/**
 *
 * @author frank
 */
public class DishonestAgentB {

    String[] anything = {"1", "dos", "tr3s", "anything", "cualquier",
        "cosa", "999", "666", "0", "null", "none", "undefined"};
    Random r = new Random();
    int randomAnything1 = r.nextInt(anything.length);
    int randomAnything2 = r.nextInt(anything.length);
    int randomAnything3 = r.nextInt(anything.length);
    int randomAnything4 = r.nextInt(anything.length);
    int randomAnything5 = r.nextInt(anything.length);

    private String email;
    private String password;
    private String typeU;
    private String addressU;
    private String authorization;
    private String fatherS;
    private String name;
    private String motherS;
    private int nRequest;
    private int aHonest;
    private int aDishonest;
    private String typeConsult;
    private String ip;
    //private JTextArea caja;
    private String dp;
    private String gas;
    private String puerto = "80";
    String response;

    public DishonestAgentB(String email, String password, String typeU, String addressU, String authorization, String fatherS, String name, String motherS, int nRequest, int aHonest, int aDishonest, String typeConsult, String ip, /*JTextArea caja, */ String dp, String gas, int position) {
        this.email = email;
        this.password = password;
        this.typeU = typeU;
        this.addressU = addressU;
        this.authorization = authorization;
        this.fatherS = fatherS;
        this.name = name;
        this.motherS = motherS;
        this.nRequest = nRequest;
        this.aHonest = aHonest;
        this.aDishonest = aDishonest;
        this.typeConsult = typeConsult;
        this.ip = ip;
        //this.caja = caja;
        this.dp = dp;
        this.gas = gas;
        //userCreation(position);
        userCreation2(position);
    }

    public void userCreation2(int position) {
        String email = this.email;
        String password = this.password;
        String surnameA = this.fatherS;
        String surnameB = this.motherS;
        String nameOfUser = this.name;
        String typeOfUser = this.typeU;
        String status = "true";
        String creationDate = "xx/xx/xxxx";
        String typeOfOperation = "create";
        String nameOfOperation = nameOperation();
        String dpHashX = "{\\\"createAdministrator\\\":true,\\\"createTUser\\\":true,\\\"updateMe\\\":true,\\\"updateAdministrator\\\":true,\\\"updateTUser\\\":true,\\\"deleteMe\\\":true,\\\"deleteAdministrator\\\":true,\\\"deleteTUser\\\":true,\\\"readMe\\\":true,\\\"readAdministrator\\\":true,\\\"readTUser\\\":true,\\\"loginUser\\\":true}";
        String dp = permisosDP();
        //String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"addressU\":\"" + addressU + "\",\"gas\":\"" + "900000" + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + "\",\"dp\":\"" + dpHashX + "\"}";
        String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"initialToken\":\"" + authorization + "\",\"addressU\":\"" + addressU + "\",\"gas\":\"" + gas + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + /*"\",\"dp\":\"" + dpHashX + */ "\"}";
        String hashX = MD5.getMd5(jsonData);
        HttpURLConnection connection = null;
        String rootCreation = "email=" + email + "&"
                + "password=" + password + "&"
                + "surnameA=" + surnameA + "&"
                + "surnameB=" + surnameB + "&"
                + "nameOfUser=" + nameOfUser + "&"
                + "typeOfUser=" + typeOfUser + "&"
                + "status=" + status + "&"
                + "creationDate=" + creationDate + "&"
                + "dp=" + dp + "&"
                + "addressU=" + addressU + "&"
                + "typeOfOperation=" + typeOfOperation + "&"
                + "hashX=" + hashX + "&"
                + "gas=" + gas + "&"
                + "nameOfOperation=" + nameOfOperation;

        Respuesta.setConsultaUC("EMAIL: " + email + "\n", position);
        Respuesta.setConsultaUC("PASSWORD: " + password + "\n", position);
        Respuesta.setConsultaUC("SURNAME A: " + surnameA + "\n", position);
        Respuesta.setConsultaUC("SURNAME B: " + surnameB + "\n", position);
        Respuesta.setConsultaUC("NAME OF USER: " + nameOfUser + "\n", position);
        Respuesta.setConsultaUC("TYPE OF USER: " + typeOfUser + "\n", position);
        Respuesta.setConsultaUC("ADRESS U: " + addressU + "\n", position);
        Respuesta.setConsultaUC("AUTHORIZATION: " + authorization + "\n", position);
        Respuesta.setConsultaUC("DP: " + dp + "\n", position);
        Respuesta.setConsultaUC("STATUS: " + status + "\n", position);
        Respuesta.setConsultaUC("CREATION DATE: " + creationDate + "\n", position);
        Respuesta.setConsultaUC("JSON DATA: " + jsonData + "\n", position);
        Respuesta.setConsultaUC("TYPE OF OPERATION: " + typeOfOperation + "\n", position);
        Respuesta.setConsultaUC("HASH X: " + hashX + "\n", position);
        Respuesta.setConsultaUC("NAME OF OPERATION: " + nameOfOperation + "\n", position);
        Respuesta.setConsultaUC("IP: " + ip + "\n", position);
        Respuesta.setConsultaUC("\n", position);

        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        try {
            URL url = new URL("http://" + this.ip + "/userCreation");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

            connection.setRequestProperty("Authorization", authorization);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            response = "Crear Usuario/DishonestAgentB --> Date:" + strDate3 + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaUC(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

             if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("Crear Usuario/Agente deshonesto B/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaUC("Crear Usuario/Agente deshonesto B <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaUC("Crear Usuario/DishonestAgentB <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("DishonestAgentB/userCreation2/java.net.ConnectException: " + e);
            Respuesta.setConsultaUC("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Logger.getLogger(HonestAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*public void userCreation(int position) {
        try {
            //Thread.sleep(500);
            Random rand = new Random();
            //int randomNum = rand.nextInt(firstname.length);
            String email = this.email;
            String password = this.password;
            String surnameA = this.fatherS;
            String surnameB = this.motherS;
            String nameOfUser = this.name;
            String typeOfUser = this.typeU;
            String status = "true";
            String creationDate = "xx/xx/xxxx";
            String typeOfOperation = "create";
            String nameOfOperation = nameOperation();
            String dpHashX = "{\\\"createAdministrator\\\":true,\\\"createTUser\\\":true,\\\"updateMe\\\":true,\\\"updateAdministrator\\\":true,\\\"updateTUser\\\":true,\\\"deleteMe\\\":true,\\\"deleteAdministrator\\\":true,\\\"deleteTUser\\\":true,\\\"readMe\\\":true,\\\"readAdministrator\\\":true,\\\"readTUser\\\":true,\\\"loginUser\\\":true}";
            //String dp = "{\"\"createAdministrator\"\":false,\"\"createTUser\"\":false,\"\"updateMe\"\":false,\"\"updateAdministrator\"\":false,\"\"updateTUser\"\":false,\"\"deleteMe\"\":false,\"\"deleteAdministrator\"\":false,\"\"deleteTUser\"\":false,\"\"readMe\"\":false,\"\"readAdministrator\"\":false,\"\"readTUser\"\":false,\"\"loginUser\"\":false}";
            String dp = permisosDP();
            String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"initialToken\":\"" + authorization + "\",\"addressU\":\"" + addressU + "\",\"gas\":\"" + gas + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + "\"}";
            //System.out.println("jsonData: " + jsonData);
            String hashX = MD5.getMd5(jsonData);
            //System.out.println("hashX: " + hashX);

            Respuesta.setConsultaUC("EMAIL: " + email + "\n", position);
            Respuesta.setConsultaUC("PASSWORD: " + password + "\n", position);
            Respuesta.setConsultaUC("SURNAME A: " + surnameA + "\n", position);
            Respuesta.setConsultaUC("SURNAME B: " + surnameB + "\n", position);
            Respuesta.setConsultaUC("NAME OF USER: " + nameOfUser + "\n", position);
            Respuesta.setConsultaUC("TYPE OF USER: " + typeOfUser + "\n", position);
            Respuesta.setConsultaUC("ADRESS U: " + addressU + "\n", position);
            Respuesta.setConsultaUC("AUTHORIZATION: " + authorization + "\n", position);
            Respuesta.setConsultaUC("DP: " + dp + "\n", position);
            Respuesta.setConsultaUC("STATUS: " + status + "\n", position);
            Respuesta.setConsultaUC("CREATION DATE: " + creationDate + "\n", position);
            Respuesta.setConsultaUC("JSON DATA: " + jsonData + "\n", position);
            Respuesta.setConsultaUC("TYPE OF OPERATION: " + typeOfOperation + "\n", position);
            Respuesta.setConsultaUC("HASH X: " + hashX + "\n", position);
            Respuesta.setConsultaUC("NAME OF OPERATION: " + nameOfOperation + "\n", position);
            Respuesta.setConsultaUC("IP: " + ip + "\n", position);
            Respuesta.setConsultaUC("\n", position);
            //}

            String rootCreation = "curl -d \"email=" + email + "&"
                    + "password=" + password + "&"
                    + "surnameA=" + surnameA + "&"
                    + "surnameB=" + surnameB + "&"
                    + "nameOfUser=" + nameOfUser + "&"
                    + "typeOfUser=" + typeOfUser + "&"
                    + "status=" + status + "&"
                    + "creationDate=" + creationDate + "&"
                    + "dp=" + dp + "&"
                    + "addressU=" + addressU + "&"
                    + "typeOfOperation=" + typeOfOperation + "&"
                    + "hashX=" + hashX + "&"
                    + "gas=" + gas + "&"
                    + "nameOfOperation=" + nameOfOperation + "\" "
                    + "-H \"Authorization: " + authorization + "\" "
                    + "-X POST http://" + ip + ":" + puerto + "/userCreation";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            //System.out.println("--> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; CURL: " + rootCreation2);
            String response = "Crear Usuario/Dishonest agent B --> Date: " + strDate3 + "; CURL: " + rootCreation;
            System.out.println(response);
            //caja.append(response + "\n");
            //if (position != -1) {
            Respuesta.setConsultaUC(response + "\n", position);
            //}

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(rootCreation);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);

            //System.out.println("<OUTPUT2>");
            Boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now4 = new Date();
                        String strDate4 = sdf4.format(now4);
                        //System.out.println("<-- Date: " + strDate4 + "; Response: " + line);
                        response = "Crear Usuario/Dishonest agent B <-- Date: " + strDate4 + "; Response: " + line;
                        System.out.println(response);
                        //caja.append(response + "\n \n");

                        //if (position != -1) {
                        Respuesta.setConsultaUC(response + "\n", position);
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
    }*/

    private String permisosDP() {
        String[] permisos = new String[16];
        for (int x = 0; x < permisos.length; x++) {
            permisos[x] = String.valueOf(randomDP());
        }
        return "{\"createAdministrator\":" + permisos[0] + ",\"createTUser\":" + permisos[1] + ",\"updateMe\":" + permisos[2] + ",\"updateAdministrator\":" + permisos[3] + ",\"updateTUser\":" + permisos[4] + ",\"deleteMe\":" + permisos[5] + ",\"deleteAdministrator\":" + permisos[6] + ",\"deleteTUser\":" + permisos[7] + ",\"readMe\":" + permisos[8] + ",\"readAdministrator\":" + permisos[9] + ",\"readTUser\":" + permisos[10] + ",\"loginUser\":" + permisos[11] + ",\"readData\":" + permisos[12] + ",\"updateData\":" + permisos[13] + ",\"createData\":" + permisos[14] + ",\"deleteData\":" + permisos[15] + "}";
    }

    private boolean randomDP() {
        int nRandom = (int) Math.floor(Math.random() * 101);
        if (nRandom <= 50) {
            return true;
        } else {
            return false;
        }
    }

    public String nameOperation() {
        if (typeU == "Administrator") {
            return "createAdministrator";
        } else {
            if (typeU == "Productor" || typeU == "Acopio" || typeU == "Carrier" || typeU == "Merchant") {
                return "createTUser";
            }
        }
        return "createRoot";
    }
}
