package Interfaz.StressTest;

import Interfaz.StressTest.Hilo;
import Interfaz.MD5;
import Interfaz.MD5;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.*;
import java.util.Random;
import javax.swing.JTextArea;

public final class AgentsStartAnyStep extends Hilo {

    String line;
    String n;
    private JTextArea caja;
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
    String acumulado;

    public String getAcumulado() {
        return acumulado;
    }

    public AgentsStartAnyStep(JTextArea caja, String email, String password, String nombre, String apellidoP, String apellidoM, String tipoU, int numberRequest, String ip, String publicK, String dp) {
        this.caja = caja;
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
        //Integer[] any = new Integer[10];
        Random rand = new Random();
        int randomNum = rand.nextInt(numberRequest);
        if (randomNum >= 0 && randomNum < ((numberRequest) * .5)) {
            getInitialNonce();
        } else {
            userCreation("token", "session", randomNumber);
        }
    }

    public void getInitialNonce() {
        double randomNumber = Math.random();
        try {
            String getInitialNonce = "curl -d na=" + randomNumber + " -X POST http://"+ip+":80/getInitialNonce";
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now1 = new Date();
            String strDate1 = sdf1.format(now1);
            //System.out.println("--> Date: " + strDate1 + "; CURL: " + getInitialNonce);
            response = "Root/AgentsStartAnyStep/getInitialNonce --> Date: " + strDate1 + "; CURL: " + getInitialNonce;
            acumulado += response + "\n";
            caja.append(response+ "\n");

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(getInitialNonce);

            InputStream stdIn = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stdIn);
            BufferedReader br = new BufferedReader(isr);

            //System.out.println("<OUTPUT>");
            Boolean intentar = true;
            String line;
            while (intentar) {
                if (br.ready()) {
                    while ((line = br.readLine()) != null) {
                        JSONObject jsonObject = new JSONObject(line);
                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                        Date now2 = new Date();
                        String strDate2 = sdf2.format(now2);
                        //System.out.println("<-- Date: " + strDate2 + "; Response: " + line);
                        response = "Root/AgentsStartAnyStep/getInitialNonce <-- Date: " + strDate2 + "; Response: " + line;
                        acumulado += response+ "\n";
                        caja.append(response+ "\n");
                        String session = jsonObject.get("A").toString();
                        String na = jsonObject.get("NA").toString();
                        String nb = jsonObject.get("NB").toString();
                        String nanb = na + nb;
                        String token = MD5.getMd5('"' + nanb + '"');
                        userCreation(token, session, randomNumber);

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

    public String userCreation(String token, String session, double randomNumber) {
        //System.out.println("Ya entré a start any step - userCreation");

        //System.out.print(token);
        String firstname[] = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String lastname[] = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            //Thread.sleep(500);
            Random rand = new Random();
            int randomNum = rand.nextInt(firstname.length);
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
            //String dp = "{\"\"createAdministrator\"\":true,\"\"createTUser\"\":true,\"\"updateMe\"\":true,\"\"updateAdministrator\"\":true,\"\"updateTUser\"\":true,\"\"deleteMe\"\":true,\"\"deleteAdministrator\"\":true,\"\"deleteTUser\"\":true,\"\"readMe\"\":true,\"\"readAdministrator\"\":true,\"\"readTUser\"\":true,\"\"loginUser\"\":true}";
            String dp = this.dp;
            String jsonData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"surnameA\":\"" + surnameA + "\",\"surnameB\":\"" + surnameB + "\",\"nameOfUser\":\"" + nameOfUser + "\",\"typeOfUser\":\"" + typeOfUser + "\",\"status\":\"" + status + "\",\"creationDate\":\"" + creationDate + "\",\"addressU\":\"" + publicK + "\",\"typeOfOperation\":\"" + typeOfOperation + "\",\"nameOfOperation\":\"" + nameOfOperation + "\",\"dp\":\"" + dpHashX + "\"}";
            //System.out.println("Root/AgentsStartAnyStep"+jsonData);
            String hashX = MD5.getMd5(jsonData);
            //System.out.println(jsonData);
            String rootCreation = "curl -d \"email=" + email + "&"
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
                    + "nameOfOperation=" + nameOfOperation + "\" "
                    + "-H \"Session: " + session + "\" "
                    + "-H \"Authorization: " + token + "\" "
                    + "-X POST http://"+ip+":80/userCreation";
            
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            //System.out.println("--> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; CURL: " + rootCreation2);
            response = "Root/AgentsStartAnyStep/userCreation --> Date: " + strDate3 + "; Token: " + token + "; NA: " + randomNumber + "; CURL: " + rootCreation;
            acumulado += response + "\n";
            caja.append(response+ "\n");

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
                        response = "Root/AgentsStartAnyStep/userCreation <-- Date: " + strDate4 + "; Response: " + line;
                        acumulado += response.replace("null", "") + "\n";
                        caja.append(response+ "\n");
                    }
                    intentar = false;
                }
            }
            //System.out.println("</OUTPUT2>");
            int exitVal = proc.waitFor();
            //System.out.println("AgentsStartAnyStep/acumulado: "+acumulado.replace("null", ""));
            return acumulado;
            //System.out.println("Process exitValue: " + exitVal);
        } catch (IOException | InterruptedException t) {
            //System.out.println(t);
        }
        return null;
    }
}
