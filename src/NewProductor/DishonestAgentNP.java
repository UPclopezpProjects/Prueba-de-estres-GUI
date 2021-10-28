package NewProductor;

import Interfaz.MD5;
import Interfaz.Respuesta;
import UCreation.HonestAgent;
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
import javax.swing.JTextArea;
import org.json.JSONObject;

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
    //exclusivo merchant
    private String nameMerchant;
    private String puerto = "80";
    String response;

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
        this.token = token;
        //userCreation(position);
        dataProductorC(position);
    }

    public DishonestAgentNP(String fId, String ubication, String nameProduction, String previousStage, String currentStage,
            String image, String description, String code, String driverName, String origin, String destination, String plates,
            String productPhotos, String vehiclePhotos, String tracking, String token, String ip, /*JTextArea caja, */ int position) {
        System.out.println("DishonestAgentNP/constructor de carrier");
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
        //userCreationCarrier(position);
        dataCarrierC(position);
    }

    public DishonestAgentNP(String fId, String ubication, String nameAcopio, String previousStage, String currentStage, String image, String description, String code,
            String arrivalDate, String quantity, String measure, String whoReceives, String token, String ip, int position) {
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
        //userCreationAcopio(position);
        dataAcopioC(position);
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
        //userCreationMerchant(position);
        dataMerchantC(position);
    }

    public void dataProductorC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";

        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameProduction + "\",\"harvestDate\":\"" + harvestD + "\",\"caducationDate\":\"" + caducationD + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"documentation\":\"" + documentation + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&harvestDate=" + harvestD + "&caducationDate=" + caducationD + "&previousStage=" + previousS + "&currentStage=" + currentS + "&description=" + description + "&image=" + image + "&documentation=document.pdf&code=" + code + "&hashX=" + hashX;
        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;
        try {
            url = new URL("http://" + this.ip + "/productorsData");

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
            response = "DishonestAgent/dataProductor --> Date: " + strDate3 + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("DishonestAgent/dataProductor/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("DishonestAgent/dataProductor <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("DishonestAgent/dataProductor <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("DishonestAgent/dataProductor/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Logger.getLogger(HonestAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dataCarrierC(int position) {
        HttpURLConnection connection = null;
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"name\":\"" + nameProduction + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"driverName\":\"" + driverName + "\",\"origin\":\"" + origin + "\",\"destination\":\"" + destination + "\",\"plates\":\"" + plates + "\",\"tracking\":\"" + tracking + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&previousStage=" + previousS + "&currentStage=" + currentS + "&image=" + image + "&description=" + description + "&code=" + code + "&driverName=" + driverName + "&origin=" + origin + "&destination=" + destination + "&plates=" + plates + "&productPhotos=" + productPhotos + "&vehiclePhotos=" + vehiclePhotos + "&tracking=" + tracking + "&hashX=" + hashX;

        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;
        try {
            url = new URL("http://" + this.ip + "/carriersData");

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
            response = "DishonestAgent/dataCarrier --> Date: " + strDate3 + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("DishonestAgent/dataCarrier/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("DishonestAgent/dataCarrier <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("DishonestAgent/dataCarrier <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("DishonestAgent/dataCarrier/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Logger.getLogger(HonestAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dataAcopioC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameAcopio + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"clasification\":\"" + "Hass" + "\",\"quantity\":\"" + quantity + "\",\"measure\":\"" + measure + "\",\"whoReceives\":\"" + whoReceives + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameAcopio + "&previousStage=" + previousS + "&currentStage=" + currentS + "&image=" + image + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&clasification=Hass" + "&quantity=" + quantity + "&measure=" + measure + "&whoReceives=" + whoReceives + "&hashX=" + hashX;

        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;
        try {
            url = new URL("http://" + this.ip + "/acopiosDataIn");

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
            response = "DishonestAgent/dataAcopio --> Date: " + strDate3 + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("DishonestAgent/dataAcopio/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("DishonestAgent/dataAcopio <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("DishonestAgent/dataAcopio <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("DishonestAgent/dataAcopio/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Logger.getLogger(HonestAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dataMerchantC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameMerchant + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"quantity\":\"" + quantity + "\"}";
        System.out.println("NewPhase/userCreationMerchant/jsonData: " + jsonData);
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameMerchant + "&previousStage=" + previousS + "&currentStage=" + currentS + "&image=" + image + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&quantity=" + quantity + "&hashX=" + hashX;
        
        byte[] postData = rootCreation.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;
        try {
            url = new URL("http://" + this.ip + "/merchantsDataIn");

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
            response = "DishonestAgent/dataMerchant --> Date: " + strDate3 + "; Request: {" + rootCreation + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("DishonestAgent/dataMerchant/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("DishonestAgent/dataMerchant <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("DishonestAgent/dataMerchant <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("DishonestAgent/dataMerchant/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Logger.getLogger(HonestAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
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

            String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameProduction + "\",\"harvestDate\":\"" + harvestD + "\",\"caducationDate\":\"" + caducationD + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"documentation\":\"" + documentation + "\"}";
            String hashX = MD5.getMd5(jsonData);

            //String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameProduction + "\" -F \"harvestDate=" + harvestD + "\" -F \"caducationDate=" + caducationD + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"description=" + description + "\" -F \"image=@" + image + "\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code=" + code + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":80/productorsData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameProduction + "\" -F \"harvestDate=" + harvestD + "\" -F \"caducationDate=" + caducationD + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"description=" + description + "\" -F \"image=" + image + "\" -F \"documentation=document.pdf\" -F \"code=" + code + "\" -F \"hashX=" + hashX + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":80/productorsData";
            // 
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Productor/AgentHonest --> Date: " + strDate3 + "; CURL: " + rootCreation2;
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
                        response = "New Productor/AgentHonest <-- Date: " + strDate4 + "; Response: " + line;
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

            String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"name\":\"" + nameProduction + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"driverName\":\"" + driverName + "\",\"origin\":\"" + origin + "\",\"destination\":\"" + destination + "\",\"plates\":\"" + plates + "\",\"tracking\":\"" + tracking + "\"}";
            System.out.println("NewPhase/jsonData: " + jsonData);
            String hashX = MD5.getMd5(jsonData);
            System.out.println("NewPhase/hash: " + hashX);

            //String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameProduction + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"nameOfCompany=Transportadora de aguacates 3 S.A. de C.V." + "\" -F \"image=@" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"driverName=" + driverName + "\" -F \"origin=" + origin + "\" -F \"destination=" + destination + "\" -F \"plates=" + plates + "\" -F \"productPhotos=@" + productPhotos + "\" -F \"vehiclePhotos=@" + vehiclePhotos + "\" -F \"tracking=" + tracking + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/carriersData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameProduction + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"image=" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"driverName=" + driverName + "\" -F \"origin=" + origin + "\" -F \"destination=" + destination + "\" -F \"plates=" + plates + "\" -F \"productPhotos=" + productPhotos + "\" -F \"vehiclePhotos=" + vehiclePhotos + "\" -F \"tracking=" + tracking + "\" -F \"hashX=" + hashX + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/carriersData";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Productor/AgentHonest Carrier --> Date: " + strDate3 + "; CURL: " + rootCreation2;
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
                        response = "New Productor/AgentHonest Carrier <-- Date: " + strDate4 + "; Response: " + line;
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

            String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameAcopio + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"clasification\":\"" + "Hass" + "\",\"quantity\":\"" + quantity + "\",\"measure\":\"" + measure + "\",\"whoReceives\":\"" + whoReceives + "\"}";
            System.out.println("NewPhase/userCreationAcopio/jsonData: " + jsonData);
            String hashX = MD5.getMd5(jsonData);

            //String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameAcopio + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"nameOfCompany=Empresa Acopio" + "\" -F \"image=@" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"arrivalDate=" + arrivalDate + "\" -F \"clasification=Hass" + "\" -F \"quantity=" + quantity + "\" -F \"measure=" + measure + "\" -F \"whoReceives=" + whoReceives + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/acopiosDataIn";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameAcopio + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"image=" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"arrivalDate=" + arrivalDate + "\" -F \"clasification=Hass" + "\" -F \"quantity=" + quantity + "\" -F \"measure=" + measure + "\" -F \"whoReceives=" + whoReceives + "\" -F \"hashX=" + hashX + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/acopiosDataIn";

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String response = "New Acopio/AgentHonest Acopio --> Date: " + strDate3 + "; CURL: " + rootCreation2;
            /*if (position == -1) {
                caja.append(response + "\n");
            } else {*/
            System.out.println("HonestAgentNP/userCreationAcopio/ response 1:" + response + ", position:" + position);
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
                        System.out.println("HonestAgentNP/userCreationAcopio/ response 1:" + response + ", position:" + position);
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
        System.out.println("Creación merchant");
        String[] firstname = {"firstname1", "firstname2", "firstname3", "firstname4", "firstname5",
            "firstname6", "firstname7", "firstname8", "firstname9", "firstname10"};
        String[] lastname = {"lastname1", "lastname2", "lastname3", "lastname4", "lastname5",
            "lastname6", "lastname7", "lastname8", "lastname8", "lastname10"};
        try {
            Random rand = new Random();
            int randomNum1 = rand.nextInt(firstname.length);
            int randomNum2 = rand.nextInt(firstname.length);
            String documentation = "document.pdf";

            String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameMerchant + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"quantity\":\"" + quantity + "\"}";
            System.out.println("NewPhase/userCreationMerchant/jsonData: " + jsonData);
            String hashX = MD5.getMd5(jsonData);

            //String rootCreation2 = "curl -F \"fid="+fId+"\" -F \"name="+nameProduction+"\" -F \"harvestDate="+harvestD+"\" -F \"caducationDate="+caducationD+"\" -F \"previousStage="+previousS+"\" -F \"currentStage="+currentS+"\" -F \"description="+description+"\" -F \"image=@"+image+"\" -F \"documentation=document.pdf\" -F \"nameOfCompany=Productora de aguacates 3 S.A. de C.V.\" -F \"code="+code+"\" -F \"origin="+origin+"\" -F \"destination="+destination+"\" -H \"Authorization:"+token+"\" -X POST http://"+ip+":80/productorsData";
            String rootCreation2 = "curl -F \"fid=" + fId + "\" -F \"ubication=" + ubication + "\" -F \"name=" + nameMerchant + "\" -F \"previousStage=" + previousS + "\" -F \"currentStage=" + currentS + "\" -F \"image=" + image + "\" -F \"description=" + description + "\" -F \"code=" + code + "\" -F \"arrivalDate=" + arrivalDate + "\" -F \"quantity=" + quantity + "\" -F \"hashX=" + hashX + "\" -H \"Authorization:" + token + "\" -X POST http://" + ip + ":" + puerto + "/merchantsDataIn";

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
