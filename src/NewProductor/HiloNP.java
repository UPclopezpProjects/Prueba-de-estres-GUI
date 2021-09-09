/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewProductor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class HiloNP implements Runnable {

    private String ubication;
    private String harvestD;
    private String caducationD;
    private String description;
    private String fId;
    private String nameProduction;
    private String previousS;
    private String currentS;
    private String code;    
    private String typeConsult;
    private String image;
    private String ip;
    private JTextArea caja;
    private String token;
    //carrier
    private String origin;
    private String destination;
    private String driverName;
    private String plates;
    private String productPhotos;
    private String vehiclePhotos;
    private String tracking;

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public void setVehiclePhotos(String vehiclePhotos) {
        this.vehiclePhotos = vehiclePhotos;
    }

    public void setProductPhotos(String productPhotos) {
        this.productPhotos = productPhotos;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setCaja(JTextArea caja) {
        this.caja = caja;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public void setTypeConsult(String typeConsult) {
        this.typeConsult = typeConsult;
    }
    
    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public void setHarvestD(String harvestD) {
        this.harvestD = harvestD;
    }

    public void setCaducationD(String caducationD) {
        this.caducationD = caducationD;
    }

    public void setDescription(int description) {
        this.description = texto(description);
    }

    public void setfId(int fId) {
        this.fId = fatherId(fId);
    }

    public void setNameProduction(int nameProductor) {
        this.nameProduction = texto(nameProductor);
    }

    public void setPreviousS(String previousS) {
        this.previousS = previousS;
    }

    public void setCurrentS(String currentS) {
        System.out.println("HiloNP/currentS: "+currentS);
        this.currentS = currentS;
    }

    public void setCode(int code) {
        this.code = code(code);
    }

    public void loop1() throws InterruptedException {
        if(typeConsult == "Honest"){
            if(currentS=="Carrier"){
                System.out.println("HiloNP/Agente honesto 1");
                HonestAgentNP honesto = new HonestAgentNP(fId,ubication, nameProduction, previousS, currentS, image, description, code, driverName, origin, destination, plates, productPhotos, vehiclePhotos, tracking, token, ip, caja);
            } else {
                System.out.println("HiloNP/Agente honesto 2");
                HonestAgentNP honesto = new HonestAgentNP(ubication, harvestD, caducationD, description, fId, nameProduction, previousS, currentS, code, image, ip, caja, token);
            }
            
        }else{
            if(currentS=="Carrier"){
                System.out.println("HiloNP/Agente deshonesto 1");
                DishonestAgentNP dishonest = new DishonestAgentNP(fId,ubication, nameProduction, previousS, currentS, image, description, code, driverName, origin, destination, plates, productPhotos, vehiclePhotos, tracking, token, ip, caja);
            } else {
                System.out.println("HiloNP/Agente deshonesto 2");
                DishonestAgentNP dishonest = new DishonestAgentNP(ubication, harvestD, caducationD, description, fId, nameProduction, previousS, currentS, code, image, ip, caja, token);
            }
        }
    }
    
    private String texto(int name){
        switch(name){
            case 0: return String.valueOf(letter());
            case 1: return String.valueOf(letter())+String.valueOf(letter());
            case 2: return String.valueOf(letter())+String.valueOf(letter())+String.valueOf(letter());
            case 3: return String.valueOf(letter())+String.valueOf(letter())+String.valueOf(letter())+String.valueOf(letter());
            case 4: return String.valueOf(letter())+String.valueOf(letter())+String.valueOf(letter())+String.valueOf(letter())+String.valueOf(letter());
            default : return String.valueOf(letter());
        }        
    }
    
    private String code(int code){
        switch(code){
            case 0: return String.valueOf(number());
            case 1: return String.valueOf(number())+String.valueOf(number());
            case 2: return String.valueOf(number())+String.valueOf(number())+String.valueOf(number());
            case 3: return String.valueOf(number())+String.valueOf(number())+String.valueOf(number())+String.valueOf(number());
            case 4: return String.valueOf(number())+String.valueOf(number())+String.valueOf(number())+String.valueOf(number())+String.valueOf(number());
            default : return String.valueOf(number());
        } 
    }
    private String fatherId(int id){
        switch(id){
            case 0: return "null";
            case 1: return String.valueOf(number()+number()+number());
            default : return String.valueOf(number());
        }
    }
    
    private char letter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    private int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }

    public void run() {
        try {
            loop1();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
