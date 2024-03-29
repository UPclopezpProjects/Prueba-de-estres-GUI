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
import sun.net.www.http.HttpClient;

/**
 *
 * @author frank
 */
public class HonestAgentNP {

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
    private String token;
    private String origin;
    private String destination;
    private String driverName;
    private String plates;
    private String productPhotos;
    private String vehiclePhotos;
    private String tracking;
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

    public HonestAgentNP(String ubication, String harvestD, String caducationD, String description, String fId, String nameProductor, String previousS, String currentS, String code, String image, String ip, String token, int position) {
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
        dataProductorC(position);
        System.out.println("HonestAgentNP/productor/image: "+image);
    }

    public HonestAgentNP(String fId, String ubication, String nameProduction, String previousStage, String currentStage, String image, String description, String code, String driverName, String origin, String destination, String plates, String productPhotos, String vehiclePhotos, String tracking, String token, String ip, int position, String vehicleName, String productName) {
        System.out.println("HonestAgentNP/constructor de carrier");
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
        System.out.println("HonestAgentNP/carrier/image: "+this.image);
        System.out.println("HonestAgentNP/carrier/productPhotos: " + this.productPhotos);
        System.out.println("HonestAgentNP/carrier/vehiclePhotos: " + this.vehiclePhotos);
    }

    public HonestAgentNP(String fId, String ubication, String nameAcopio, String previousStage, String currentStage, String image, String description, String code, String arrivalDate, String quantity, String measure, String whoReceives, String token, String ip, int position) {
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
        System.out.println("HonestAgentNP/acopio/image: "+image);
    }

    public HonestAgentNP(String fId, String ubication, String nameMerchant, String previousS, String currentS, String image, String description, String code, String arrivalDate, String quantity, String token, String ip, JTextArea caja, int position) {
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
        System.out.println("HonestAgentNP/merchant/image: "+image);
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
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));

            connection.setRequestProperty("Authorization", token);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date now3 = new Date();
            String strDate3 = sdf3.format(now3);
            String request="fid=" + fId + "&ubication=" + ubication + "&name=" + nameProduction + "&harvestDate=" + harvestD + "&caducationDate=" + caducationD + "&previousStage=" + previousS + "&currentStage=" + currentS + "&description=" + description+ "&originalname=Productor1.jpg" + "&documentation=document.pdf&code=" + code + "&hashX=" + hashX;
            response = "HonestAgent/dataProductor --> Date: " + strDate3 + "; Request: {" + request + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            System.out.println("HonestAgent/dataProductor/el cuerpo de la consulta: "+connection);
            
            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("HonestAgent/dataProductor/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("HonestAgent/dataProductor <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("HonestAgent/dataProductor <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("HonestAgent/dataProductor/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Respuesta.setConsultaRoot(ex.toString(), position);
            Logger.getLogger(HonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dataCarrierC(int position) {
        HttpURLConnection connection = null;
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"name\":\"" + nameProduction + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"driverName\":\"" + driverName + "\",\"origin\":\"" + origin + "\",\"destination\":\"" + destination + "\",\"plates\":\"" + plates + "\",\"tracking\":\"" + tracking + "\"}";
        String hashX = MD5.getMd5(jsonData);
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
            response = "HonestAgent/dataCarrier --> Date: " + strDate3 + "; Request: {" + request + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("HonestAgent/dataCarrier/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("HonestAgent/dataCarrier <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("HonestAgent/dataCarrier <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("HonestAgent/dataCarrier/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Respuesta.setConsultaRoot(ex.toString(), position);
            Logger.getLogger(HonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dataAcopioC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameAcopio + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"clasification\":\"" + "Hass" + "\",\"quantity\":\"" + quantity + "\",\"measure\":\"" + measure + "\",\"whoReceives\":\"" + whoReceives + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameAcopio + "&previousStage=" + previousS + "&currentStage=" + currentS + "&originalname=Acopio1.jpg"+"&image=" + image + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&clasification=Hass" + "&quantity=" + quantity + "&measure=" + measure + "&whoReceives=" + whoReceives + "&hashX=" + hashX;
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
            response = "HonestAgent/dataAcopio --> Date: " + strDate3 + "; Request: {" + request + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("HonestAgent/dataAcopio/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("HonestAgent/dataAcopio <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("HonestAgent/dataAcopio <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("HonestAgent/dataAcopio/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Respuesta.setConsultaRoot(ex.toString(), position);
            Logger.getLogger(HonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dataMerchantC(int position) {
        HttpURLConnection connection = null;
        String documentation = "document.pdf";
        String jsonData = "{\"fid\":\"" + fId + "\",\"code\":\"" + code + "\",\"ubication\":\"" + ubication + "\",\"name\":\"" + nameMerchant + "\",\"previousStage\":\"" + previousS + "\",\"currentStage\":\"" + currentS + "\",\"description\":\"" + description + "\",\"arrivalDate\":\"" + arrivalDate + "\",\"quantity\":\"" + quantity + "\"}";
        String hashX = MD5.getMd5(jsonData);
        String rootCreation = "fid=" + fId + "&ubication=" + ubication + "&name=" + nameMerchant + "&previousStage=" + previousS + "&currentStage=" + currentS+ "&originalname=Merchant1.jpg" + "&image=" + image + "&description=" + description + "&code=" + code + "&arrivalDate=" + arrivalDate + "&quantity=" + quantity + "&hashX=" + hashX;
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
            response = "HonestAgent/dataMerchant --> Date: " + strDate3 + "; Request: {" + request + "}";
            //System.out.println(response + ", " + position);

            Respuesta.setConsultaS(response + "\n", position);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(rootCreation);
            wr.close();

            if (connection.getResponseCode() >= 300 && connection.getResponseCode() < 600) {
                System.out.println("HonestAgent/dataMerchant/error Stream: " + connection.getErrorStream());
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
                    Respuesta.setConsultaS("HonestAgent/dataMerchant <-- Date: " + strDate2 + "; Response: " + line + "\n", position);
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
                    Respuesta.setConsultaS("HonestAgent/dataMerchant <-- Date: " + strDate2 + "; Response: " + line + " \n", position);
                    response.append('\r');
                }
                rd.close();
                //return response.toString();
            }

        } catch (java.net.ConnectException e) {
            System.out.println("HonestAgent/dataMerchant/Exception: " + e);
            Respuesta.setConsultaS("No se pudo contactar con el servidor", position);
        } catch (IOException ex) {
            Respuesta.setConsultaRoot(ex.toString(), position);
            Logger.getLogger(HonestAgentNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}