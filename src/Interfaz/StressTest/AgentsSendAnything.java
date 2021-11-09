package Interfaz.StressTest;

//import Interfaz.InterfazG;
//import Interfaz.StressTest.Hilo;
import Interfaz.MD5;
import Interfaz.Respuesta;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.*;
import java.util.Random;
//import javax.swing.JTextArea;

public final class AgentsSendAnything extends Hilo {

    String[] anything = {"1", "dos", "tr3s", "anything", "cualquier",
        "cosa", "999", "666", "0", "null", "none", "undefined"};
    Random r = new Random();
    int randomAnything1 = r.nextInt(anything.length);
    int randomAnything2 = r.nextInt(anything.length);
    int randomAnything3 = r.nextInt(anything.length);
    int randomAnything4 = r.nextInt(anything.length);
    int randomAnything5 = r.nextInt(anything.length);
    String email;
    String password;
    String nombre;
    String apellidoP;
    String apellidoM;
    String tipoU;
    String response;
    String ip;
    String publicK;
    String dp;
    Respuesta mensaje;
    String puerto = "80";

    long t1, t2, dif;
    String cad;
    BigDecimal startTime, endTime;

    public AgentsSendAnything(String email, String password, String nombre, String apellidoP, String apellidoM, String tipoU, String ip, String publicK, String dp, int position) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoU = tipoU;
        this.ip = ip;
        this.publicK = publicK;
        this.dp = dp;
        //getInitialNonce(position);
        getInitialNonce2(position);
    }

    public void getInitialNonce2(int position) {
        double randomNumber = Math.random();
        String getInitialNonce = "na=" + randomNumber + "&position=" + position;
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now3 = new Date();
        String strDate3 = sdf3.format(now3);
        HttpURLConnection connection = null;
        response = "Root/AgentSendAnything/getInitialNonce --> Date: " + strDate3 + "; NA: " + randomNumber + "; Request: {" + getInitialNonce + "}";
        byte[] postData = getInitialNonce.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        try {
            URL url = new URL("http://" + this.ip + "/getInitialNonce");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            connection.setRequestProperty("Session", "165");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaRoot(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(getInitialNonce);
            wr.close();
            //empieza la consulta al servidor
            Calendar ahora1 = Calendar.getInstance();
            ahora1.getTime();
            t1 = ahora1.getTimeInMillis();
            //System.out.println("El agente honesto número " + position + " empezó en: " + t1);
            Respuesta.setConsultaRoot("El agente honesto número " + position + " empezó en: " + t1 + "\n", position);

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

                //response = "Root/AgentHonest/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line;
                response.append(line);
                Respuesta.setConsultaRoot("Root/AgentSendAnything/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
                startTime = (BigDecimal) jsonObject.get("startTime");
                Respuesta.setConsultaRoot("El servidor empezó la consulta del agente honesto número " + position + " en: " + startTime + "\n", position);
                String message = jsonObject.get("message").toString();
                System.out.println("AgentsSendAnything/getInitialNonce/message: " + message);
                if (message.equals("deny")) {
                    System.out.println("AgentsSendAnything/getInitialNonce/message: " + message);
                    //userCreation("null", "null", randomNumber, position);
                    userCreation2("null", "null", randomNumber, position);
                } else {
                    System.out.println("AgentsSendAnything/getInitialNonce/message: " + message);
                    String session = jsonObject.get("A").toString();
                    System.out.println("AgentsSendAnything/getInitialNonce/session: " + session);
                    String na = jsonObject.get("NA").toString();
                    String nb = jsonObject.get("NB").toString();
                    String nanb = na + nb;
                    String token = MD5.getMd5('"' + nanb + '"');
                    System.out.println("AgentsSendAnything/getInitialNonce/token: " + token);
                    //userCreation(token, session, randomNumber, position);
                    userCreation2(anything[randomAnything1], anything[randomAnything2], randomNumber, position);
                }
                response.append('\r');
            }
            rd.close();
            //return response.toString();
        } catch (Exception e) {
            Respuesta.setConsultaRoot(e.toString(), position);
            System.out.println("AgentSendAnything/getInitialNonce2/Exception: " + e);
        }
    }
    
    public void userCreation2(String token, String session, double randomNumber, int position) {
        String email = anything[randomAnything3];
        String password = anything[randomAnything4];
        String surnameA = this.apellidoP;
        String surnameB = this.apellidoM;
        String nameOfUser = anything[randomAnything5];
        String typeOfUser = this.tipoU;
        String status = "true";
        String creationDate = "xx/xx/xxxx";
        String typeOfOperation = "create";
        String nameOfOperation = "createRoot";
        String dpHashX = "{\\\"createAdministrator\\\":true,\\\"createTUser\\\":true,\\\"updateMe\\\":true,\\\"updateAdministrator\\\":true,\\\"updateTUser\\\":true,\\\"deleteMe\\\":true,\\\"deleteAdministrator\\\":true,\\\"deleteTUser\\\":true,\\\"readMe\\\":true,\\\"readAdministrator\\\":true,\\\"readTUser\\\":true,\\\"loginUser\\\":true}";
        String dp = this.dp;
        String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"addressU\":\"" + publicK + "\",\"gas\":\"" + "900000" + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + "\",\"dp\":\"" + dpHashX + "\"}";
        //System.out.println("AgentsSendAnything"+jsonData);
        String hashX = MD5.getMd5(jsonData);
        HttpURLConnection connection = null;
        String rootCreation = "email=" + email + "&"
                + "position=" + position + "&"
                + "password=" + password + "&"
                + "surnameA=" + surnameA + "&"
                + "surnameB=" + surnameB + "&"
                + "nameOfUser=" + nameOfUser + "&"
                + "typeOfUser=" + typeOfUser + "&"
                + "status=" + status + "&"
                + "creationDate=" + creationDate + "&"
                + "dp=" + dp + "&"
                + "addressU=" + publicK + "&"
                + "typeOfOperation=" + typeOfOperation + "&"
                + "hashX=" + hashX + "&"
                + "gas=" + "900000" + "&"
                + "nameOfOperation=" + nameOfOperation;
        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        try {
            URL url = new URL("http://" + this.ip + "/userCreation");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

            connection.setRequestProperty("Authorization", token);
            connection.setRequestProperty("Session", session);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            response = "Root/AgentSendAnything/userCreation --> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaRoot(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

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

                //response = "Root/AgentHonest/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line;
                response.append(line);
                Respuesta.setConsultaRoot("Root/AgentSendAnything/userCreation <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
                endTime = (BigDecimal) jsonObject.get("endTime");
                BigDecimal duracion = endTime.subtract(startTime);
                Respuesta.setConsultaRoot("El servidor terminó la consulta del agente honesto número " + position + " en:" + endTime + "\n", position);
                Respuesta.setConsultaRoot("El tiempo que le tomó al servidor procesar la consulta fue: " + duracion + " segundos \n", position);
                response.append('\r');
            }
            //terminan las dos consultas
            Calendar ahora2 = Calendar.getInstance();
            t2 = ahora2.getTimeInMillis();
            //System.out.println("El agente honesto número " + position + " terminó en: " + t2);
            Respuesta.setConsultaRoot("El agente honesto número " + position + " terminó en: " + t2 + "\n", position);
            dif = t2 - t1;
            //System.out.println("El agente honesto número " + position + " ha tardado: " + dif + " milisegundos \n");
            Respuesta.setConsultaRoot("El agente honesto número " + position + " ha tardado: " + dif + " milisegundos \n", position);
            rd.close();
            //return response.toString();
        } catch (Exception e) {
            Respuesta.setConsultaRoot(e.toString(), position);
            System.out.println("AgentSendAnything/userCreation2/Exception: " + e);
        }
    }
}
