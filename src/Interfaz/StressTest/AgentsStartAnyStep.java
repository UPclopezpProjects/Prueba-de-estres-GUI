package Interfaz.StressTest;

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

public final class AgentsStartAnyStep extends Hilo {

    String line;
    String n;
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

    Long t1 = null, t2 = null, dif = null;
    String cad;
    BigDecimal startTime, endTime;

    public AgentsStartAnyStep(String email, String password, String nombre, String apellidoP, String apellidoM, String tipoU, int numberRequest, String ip, String publicK, String dp, int position) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoU = tipoU;
        this.ip = ip;
        this.publicK = publicK;
        this.dp = dp;

        double randomNumber = Math.random();
        Random rand = new Random();
        int randomNum = rand.nextInt(numberRequest);
        if (randomNum >= 0 && randomNum < ((numberRequest) * .5)) {
            getInitialNonce2(position);
        } else {
            userCreation2("token", "session", randomNumber, position);
        }
    }

    public void getInitialNonce2(int position) {
        double randomNumber = Math.random();
        String getInitialNonce = "na=" + randomNumber + "&position=" + position;
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now3 = new Date();
        String strDate3 = sdf3.format(now3);
        HttpURLConnection connection = null;
        response = "Root/AgentsStartAnyStep/getInitialNonce --> Date: " + strDate3 + "; NA: " + randomNumber + "; Request: {" + getInitialNonce + "}";
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

            Respuesta.setConsultaRoot(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(getInitialNonce);
            wr.close();
            //empieza la consulta al servidor
            Calendar ahora1 = Calendar.getInstance();
            ahora1.getTime();
            t1 = ahora1.getTimeInMillis();
            Respuesta.setConsultaRoot("El agente honesto número " + position + " empezó en: " + t1 + "\n", position);

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("Root/AgentsStartAnyStep/getInitialNonce/error Stream: " + connection.getErrorStream());
                InputStream is = connection.getErrorStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
                String line;
                while ((line = rd.readLine()) != null) {
                    JSONObject jsonObject = new JSONObject(line);
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    Date now2 = new Date();
                    String strDate2 = sdf2.format(now2);

                    response.append(line);
                    Respuesta.setConsultaRoot("Root/AgentsStartAnyStep/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaRoot("Root/AgentsStartAnyStep/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
                    

                    Respuesta.setConsultaRoot("El servidor empezó la consulta del agente honesto número " + position + " en: " + startTime + "\n", position);
                    String message = jsonObject.get("message").toString();
                    System.out.println("AgentsStartAnyStep/getInitialNonce/message: " + message);
                    if (message.equals("deny")) {
                        System.out.println("AgentsStartAnyStep/getInitialNonce/message: " + message);
                        userCreation2("null", "null", randomNumber, position);
                    } else {
                        System.out.println("AgentsStartAnyStep/getInitialNonce/message: " + message);
                        String session = jsonObject.get("A").toString();
                        System.out.println("AgentsStartAnyStep/getInitialNonce/session: " + session);
                        String na = jsonObject.get("NA").toString();
                        String nb = jsonObject.get("NB").toString();
                        String nanb = na + nb;
                        String token = MD5.getMd5('"' + nanb + '"');
                        System.out.println("AgentsStartAnyStep/getInitialNonce/token: " + token);
                        userCreation2(token, session, randomNumber, position);
                    }
                    response.append('\r');
                }
                rd.close();
            }
            //return response.toString();
        } catch (Exception e) {
            Respuesta.setConsultaRoot(e.toString(), position);
            System.out.println("AgentStartAnyStep/getInitialNonce2/Exception: " + e);
        }
    }

    public void userCreation2(String token, String session, double randomNumber, int position) {
        String email = this.email;
        String password = this.password;
        String surnameA = this.apellidoP;
        String surnameB = this.apellidoM;
        String nameOfUser = this.nombre;
        String typeOfUser = this.tipoU;
        String status = "true";
        String creationDate = "xx/xx/xxxx";
        String typeOfOperation = "create";
        String nameOfOperation = "createRoot";
        String dpHashX = "{\\\"createAdministrator\\\":true,\\\"createTUser\\\":true,\\\"updateMe\\\":true,\\\"updateAdministrator\\\":true,\\\"updateTUser\\\":true,\\\"deleteMe\\\":true,\\\"deleteAdministrator\\\":true,\\\"deleteTUser\\\":true,\\\"readMe\\\":true,\\\"readAdministrator\\\":true,\\\"readTUser\\\":true,\\\"loginUser\\\":true}";
        String dp = this.dp;
        String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"addressU\":\"" + publicK + "\",\"gas\":\"" + "900000" + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + "\",\"dp\":\"" + dpHashX + "\"}";
        //System.out.println("AgentsStartAnyStep"+jsonData);
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
            response = "Root/AgentsStartAnyStep/userCreation --> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaRoot(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            //inició consulta
            if (t1 == null) {
                Calendar ahora1 = Calendar.getInstance();
                t1 = ahora1.getTimeInMillis();
                //System.out.println("El agente deshonesto número " + position + " empieza en algún paso empezó(userCreation) en: " + t1);
                Respuesta.setConsultaRoot("El agente deshonesto número " + position + " empieza en algún paso empezó(userCreation) en: " + t1 + "\n", position);
            }

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("Root/AgentsStartAnyStep/userCreation/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaRoot("Root/AgentsStartAnyStep/userCreation <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaRoot("Root/AgentsStartAnyStep/userCreation <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
                    if (startTime == null) {
                        startTime = (BigDecimal) jsonObject.get("startTime");
                        Respuesta.setConsultaRoot("El servidor empezó la consulta del agente honesto número " + position + " en: " + startTime + "\n", position);
                    }
                    endTime = (BigDecimal) jsonObject.get("endTime");
                    System.out.println("Root/AgentsStartAnyStep/userCreation/endTime: " + endTime);
                    System.out.println("Root/AgentsStartAnyStep/userCreation/startTime: " + startTime);
                    BigDecimal duracion = endTime.subtract(startTime);
                    Respuesta.setConsultaRoot("El servidor terminó la consulta del agente honesto número " + position + " en:" + endTime + "\n", position);
                    Respuesta.setConsultaRoot("El tiempo que le tomó al servidor procesar la consulta fue: " + duracion + " segundos \n", position);
                    response.append('\r');
                }
                //terminan las dos consultas
                Calendar ahora2 = Calendar.getInstance();
                t2 = ahora2.getTimeInMillis();
                Respuesta.setConsultaRoot("El agente honesto número " + position + " terminó en: " + t2 + "\n", position);
                dif = t2 - t1;
                Respuesta.setConsultaRoot("El agente honesto número " + position + " ha tardado: " + dif + " milisegundos \n", position);
                rd.close();
            }
            //return response.toString();
        } catch (Exception e) {
            Respuesta.setConsultaRoot(e.toString(), position);
            System.out.println("AgentStartAnyStep/userCreation2/Exception: " + e);
        }
    }
}
