package NewProductor;

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
    private String vehicleName;
    private String productName;
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
        System.out.println("DishonestAgentNP/productor/image: "+image);
    }

    public DishonestAgentNP(String fId, String ubication, String nameProduction, String previousStage, String currentStage,
            String image, String description, String code, String driverName, String origin, String destination, String plates,
            String productPhotos, String vehiclePhotos, String tracking, String token, String ip, /*JTextArea caja, */ int position, String vehicleName,
            String productName) {
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
        this.vehicleName= vehicleName;
        this.productName= productName;
        //userCreationCarrier(position);
        dataCarrierC(position);
        System.out.println("DishonestAgentNP/carrier/image: "+this.image);
        System.out.println("DishonestAgentNP/carrier/productPhotos: " + this.productPhotos);
        System.out.println("DishonestAgentNP/carrier/vehiclePhotos: " + this.vehiclePhotos);
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
        System.out.println("DishonestAgentNP/acopio/image: "+image);
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
        System.out.println("DishonestAgentNP/merchant/image: "+image);
    }

    public void dataProductorC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";

        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameProduction + "\",\"harvestDate\":\"" + harvestD + "\",\"caducationDate\":\"" + caducationD + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"documentation\":\"" + documentation + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&harvestDate=" + harvestD + "&caducationDate=" + caducationD + "&previousStage=" + previousS + "&currentStage=" + currentS + "&description=" + description+ "&originalname=Productor1.jpg" + "&image=" + image + "&documentation=document.pdf&code=" + code + "&hashX=" + hashX;
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
            String request="fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&harvestDate=" + harvestD + "&caducationDate=" + caducationD + "&previousStage=" + previousS + "&currentStage=" + currentS + "&description=" + description+ "&originalname=Productor1.jpg" + "&documentation=document.pdf&code=" + code + "&hashX=" + hashX;
            response = "DishonestAgent/dataProductor --> Date: " + strDate3 + "; Request: {" + request + "}";
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
            Logger.getLogger(DishonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dataCarrierC(int position) {
        HttpURLConnection connection = null;
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"name\":\"" + nameProduction + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"driverName\":\"" + driverName + "\",\"origin\":\"" + origin + "\",\"destination\":\"" + destination + "\",\"plates\":\"" + plates + "\",\"tracking\":\"" + tracking + "\"}";
        String hashX = MD5.getMd5(jsonData);
        //String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&previousStage=" + previousS + "&currentStage=" + currentS + "&image=" + image + "&description=" + description + "&code=" + code + "&driverName=" + driverName + "&origin=" + origin + "&destination=" + destination + "&plates=" + plates + "&productPhotos=" + productPhotos + "&vehiclePhotos=" + vehiclePhotos + "&tracking=" + tracking + "&hashX=" + hashX;
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&previousStage=" + previousS + "&currentStage=" + currentS + "&originalnameImage=Carrier1.jpg" + "&bufferImage=" + image + "&originalnameProductPhotos=" + productName + "&bufferProductPhotos=" + productPhotos + "&description=" + description + "&code=" + code + "&driverName=" + driverName + "&origin=" + origin + "&destination=" + destination + "&plates=" + plates  + "&bufferVehiclePhotos=" + vehiclePhotos + "&originalnameVehiclePhotos="+ vehicleName + "&tracking=" + tracking + "&hashX=" + hashX;
        
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
            String request = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&previousStage=" + previousS + "&currentStage=" + currentS + "&originalnameImage=Carrier1.jpg" + "&originalnameProductPhotos=" + productName + "&description=" + description + "&code=" + code + "&driverName=" + driverName + "&origin=" + origin + "&destination=" + destination + "&plates=" + plates  + "&originalnameVehiclePhotos="+ vehicleName + "&tracking=" + tracking + "&hashX=" + hashX;
            response = "DishonestAgent/dataCarrier --> Date: " + strDate3 + "; Request: {" + request + "}";
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
            Logger.getLogger(DishonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dataAcopioC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameAcopio + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"clasification\":\"" + "Hass" + "\",\"quantity\":\"" + quantity + "\",\"measure\":\"" + measure + "\",\"whoReceives\":\"" + whoReceives + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameAcopio + "&previousStage=" + previousS + "&currentStage=" + currentS + "&originalname=Acopio1.jpg" + "&image=" + image + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&clasification=Hass" + "&quantity=" + quantity + "&measure=" + measure + "&whoReceives=" + whoReceives + "&hashX=" + hashX;

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
            String request = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameAcopio + "&previousStage=" + previousS + "&currentStage=" + currentS + "&originalname=Acopio1.jpg"+"&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&clasification=Hass" + "&quantity=" + quantity + "&measure=" + measure + "&whoReceives=" + whoReceives + "&hashX=" + hashX;
            response = "DishonestAgent/dataAcopio --> Date: " + strDate3 + "; Request: {" + request + "}";
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
            Logger.getLogger(DishonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dataMerchantC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameMerchant + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"quantity\":\"" + quantity + "\"}";
        System.out.println("NewPhase/userCreationMerchant/jsonData: " + jsonData);
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameMerchant + "&previousStage=" + previousS + "&currentStage=" + currentS + "&originalname=Merchant1.jpg" + "&image=" + image + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&quantity=" + quantity + "&hashX=" + hashX;
        
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
            String request = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameMerchant + "&previousStage=" + previousS + "&currentStage=" + currentS+ "&originalname=Merchant1.jpg" + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&quantity=" + quantity + "&hashX=" + hashX;
            response = "DishonestAgent/dataMerchant --> Date: " + strDate3 + "; Request: {" + request + "}";
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
            Logger.getLogger(DishonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}