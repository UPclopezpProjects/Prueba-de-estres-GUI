package Interfaz.StressTest;

import java.io.*;
import java.text.SimpleDateFormat;
import org.json.*;
import java.util.Random;
import java.util.Date;
import Interfaz.StressTest.Hilo;
import Interfaz.InterfazG;
import Interfaz.MD5;
import Interfaz.MD5;
import Interfaz.Respuesta;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public final class AgentsHonest extends Hilo {

    String line;
    String n;
    //private JTextArea caja;
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
    String puerto = "80";
    long t1, t2, dif;
    String cad;
    BigDecimal startTime, endTime;

    public AgentsHonest(String email, String password, String nombre, String apellidoP, String apellidoM, String tipoU, String ip, String publicK, String dp, int position) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoU = tipoU;
        this.ip = ip;
        this.publicK = publicK;
        this.dp = dp;
        //mensaje = new InterfazG();
        //getInitialNonce(position);
        getInitialNonce2(position);
    }

    public void getInitialNonce(int position) {
        double randomNumber = Math.random();
        try {
            String getInitialNonce = "curl -d na=" + randomNumber + "&position=" + position + " -H 'Session: 165' -X POST http://" + ip + ":" + puerto + "/getInitialNonce";
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now1 = new Date();
            String strDate1 = sdf1.format(now1);
            response = "Root/AgentHonest/getInitialNonce --> Date: " + strDate1 + "; CURL: " + getInitialNonce;
            //System.out.println("AgentHonest/getInitialnonce: "+getInitialNonce);

            Respuesta.setConsultaRoot(response + "\n", position);

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(getInitialNonce);
            //System.out.println("AgentsHonest-Root/getinitialnonce/proc: "+proc.toString());

            //empieza la consulta al servidor
            Calendar ahora1 = Calendar.getInstance();
            ahora1.getTime();
            t1 = ahora1.getTimeInMillis();
            //System.out.println("El agente honesto número " + position + " empezó en: " + t1);
            Respuesta.setConsultaRoot("El agente honesto número " + position + " empezó en: " + t1 + "\n", position);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);

            Boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        JSONObject jsonObject = new JSONObject(line);
                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now2 = new Date();
                        String strDate2 = sdf2.format(now2);

                        response = "Root/AgentHonest/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line;
                        //System.out.println(response + ", " + position);

                        Respuesta.setConsultaRoot(response + "\n", position);
                        startTime = (BigDecimal) jsonObject.get("startTime");
                        Respuesta.setConsultaRoot("El servidor empezó la consulta del agente honesto número " + position + " en: " + startTime + "\n", position);
                        String message = jsonObject.get("message").toString();

                        //System.out.println("el tipo de dato del message es: "+((Object)message).getClass().getSimpleName());
                        if (message.equals("deny")) {
                            System.out.println("AgentsHonest/getInitialNonce/message: " + message);
                            //userCreation("null", "null", randomNumber, position);
                            userCreation2("null", "null", randomNumber, position);
                        } else {
                            System.out.println("AgentsHonest/getInitialNonce/message: " + message);
                            String session = jsonObject.get("A").toString();
                            System.out.println("AgentsHonest/getInitialNonce/session: " + session);
                            String na = jsonObject.get("NA").toString();
                            String nb = jsonObject.get("NB").toString();
                            String nanb = na + nb;
                            String token = MD5.getMd5('"' + nanb + '"');
                            System.out.println("AgentsHonest/getInitialNonce/token: " + token);
                            //userCreation(token, session, randomNumber, position);
                            userCreation2(token, session, randomNumber, position);
                        }

                    }
                    intentar = false;
                }
            }
            //System.out.println("</OUTPUT>");
            int exitVal = proc.waitFor();
            //System.out.println("exitVal: " + exitVal);
        } catch (IOException | InterruptedException | JSONException t) {
            //System.out.println("t: " + t);
        }
    }

    public void getInitialNonce2(int position) {
        double randomNumber = Math.random();
        String getInitialNonce = "na=" + randomNumber + "&position=" + position;
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now3 = new Date();
        String strDate3 = sdf3.format(now3);
        HttpURLConnection connection = null;
        response = "Root/AgentHonest/getInitialNonce --> Date: " + strDate3 + "; NA: " + randomNumber + "; Request: {" + getInitialNonce + "}";
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
                Respuesta.setConsultaRoot("Root/AgentHonest/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
                startTime = (BigDecimal) jsonObject.get("startTime");
                Respuesta.setConsultaRoot("El servidor empezó la consulta del agente honesto número " + position + " en: " + startTime + "\n", position);
                String message = jsonObject.get("message").toString();
                System.out.println("AgentsHonest/getInitialNonce/message: " + message);
                if (message.equals("deny")) {
                    System.out.println("AgentsHonest/getInitialNonce/message: " + message);
                    //userCreation("null", "null", randomNumber, position);
                    userCreation2("null", "null", randomNumber, position);
                } else {
                    System.out.println("AgentsHonest/getInitialNonce/message: " + message);
                    String session = jsonObject.get("A").toString();
                    System.out.println("AgentsHonest/getInitialNonce/session: " + session);
                    String na = jsonObject.get("NA").toString();
                    String nb = jsonObject.get("NB").toString();
                    String nanb = na + nb;
                    String token = MD5.getMd5('"' + nanb + '"');
                    System.out.println("AgentsHonest/getInitialNonce/token: " + token);
                    //userCreation(token, session, randomNumber, position);
                    userCreation2(token, session, randomNumber, position);
                }
                response.append('\r');
            }
            rd.close();
            //return response.toString();
        } catch (Exception e) {
            System.out.println("AgentHonest/getInitialNonce2/Exception: " + e);
        }
    }

    public void userCreation(String token, String session, double randomNumber, int position) {
        System.out.println("Inició userCration()");
        System.out.println("AgentsHonest/userCration/session: " + session);
        System.out.println("AgentsHonest/userCration/authentication: " + token);
        String[] firstname = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String[] lastname = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            Random rand = new Random();
            int randomNum1 = rand.nextInt(firstname.length);
            int randomNum2 = rand.nextInt(firstname.length);
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
            //String dp = "{\"createAdministrator\":true,\"createTUser\":true,\"updateMe\":true,\"updateAdministrator\":true,\"updateTUser\":true,\"deleteMe\":true,\"deleteAdministrator\":true,\"deleteTUser\":true,\"readMe\":true,\"readAdministrator\":true,\"readTUser\":true,\"loginUser\":true}";
            String dp = "{createAdministrator:true,createTUser:true,createData:true,updateMe:true,updateAdministrator:true,updateTUser:true,updateData:true,deleteMe:true,deleteAdministrator:true,deleteTUser:true,deleteData:true,readMe:true,readAdministrator:true,readTUser:true,readData:true,loginUser:true}";
            //String dp = this.dp;
            String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"addressU\":\"" + publicK + "\",\"gas\":\"" + "900000" + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + "\",\"dp\":\"" + dpHashX + "\"}";
            //System.out.println("AgentsHonest"+jsonData);
            String hashX = MD5.getMd5(jsonData);
            //System.out.println(jsonData);
            String rootCreation = "curl -d email=" + email + "&"
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
                    + "nameOfOperation=" + nameOfOperation + " "
                    + "-H \"Session: " + session + "\" "
                    + "-H \"Authorization: " + token + "\" "
                    + "-X POST http://" + ip + ":" + puerto + "/userCreation";

            System.out.println("AgentHonest/userCreation/rootCreation: " + rootCreation);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            response = "Root/AgentHonest/userCreation --> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; CURL1: " + rootCreation;
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaRoot(response + "\n", position);

            Runtime rt = Runtime.getRuntime();
            System.out.println("AgentsHonest/userCreation/antes del Process: " + rootCreation);
            Process proc = rt.exec(rootCreation);
            System.out.println("AgentsHonest/userCreation/después del Process: " + rootCreation);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);

            boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        JSONObject jsonObject = new JSONObject(line);
                        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now4 = new Date();
                        String strDate4 = sdf4.format(now4);
                        response = "Root/AgentHonest/userCreation <-- Date: " + strDate4 + "; Response: " + line;
                        //System.out.println(response + ", " + position);
                        Respuesta.setConsultaRoot(response + "\n", position);
                        endTime = (BigDecimal) jsonObject.get("endTime");
                        BigDecimal duracion = endTime.subtract(startTime);
                        Respuesta.setConsultaRoot("El servidor terminó la consulta del agente honesto número " + position + " en:" + endTime + "\n", position);
                        Respuesta.setConsultaRoot("El tiempo que le tomó al servidor procesar la consulta fue: " + duracion + " segundos \n", position);
                    }
                    intentar = false;
                }
            }

            //terminan las dos consultas
            Calendar ahora2 = Calendar.getInstance();
            t2 = ahora2.getTimeInMillis();
            //System.out.println("El agente honesto número " + position + " terminó en: " + t2);
            Respuesta.setConsultaRoot("El agente honesto número " + position + " terminó en: " + t2 + "\n", position);
            dif = t2 - t1;
            //System.out.println("El agente honesto número " + position + " ha tardado: " + dif + " milisegundos \n");
            Respuesta.setConsultaRoot("El agente honesto número " + position + " ha tardado: " + dif + " milisegundos \n", position);
            //System.out.println("</OUTPUT2>");
            int exitVal = proc.waitFor();
            //System.out.println("AgentHonest/acumulado: "+acumulado.replace("null", ""));
            //System.out.println("Process exitValue: " + exitVal);
        } catch (IOException | InterruptedException t) {
            //System.out.println(t);
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
        //System.out.println("AgentsHonest"+jsonData);
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
            response = "Root/AgentHonest/userCreation --> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; Request: {" + rootCreation + "}";
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
                Respuesta.setConsultaRoot("Root/AgentHonest/userCreation <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
            System.out.println("AgentHonest/userCreation2/Exception: " + e);
        }
    }
}
