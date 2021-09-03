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
    private String nameCompany;
    private String fId;
    private String nameProduction;
    private String previousS;
    private String currentS;
    private String code;    
    private String typeConsult;
    private String image;
    private String ip;
    private JTextArea caja;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void setfId(int fId) {
        this.fId = fatherId(fId);
    }

    public void setNameProduction(int nameProductor) {
        this.nameProduction = name(nameProductor);
    }

    public void setPreviousS(String previousS) {
        this.previousS = previousS;
    }

    public void setCurrentS(String currentS) {
        this.currentS = currentS;
    }

    public void setCode(int code) {
        this.code = code(code);
    }

    public void loop1() throws InterruptedException {
        if(typeConsult == "Honest"){
            HonestAgentNP honesto = new HonestAgentNP(ubication, harvestD, caducationD, description, nameCompany, fId, nameProduction, previousS, currentS, code, image, ip, caja);
        }else{
            DishonestAgentNP dishonest = new DishonestAgentNP(ubication, harvestD, caducationD, description, nameCompany, fId, nameProduction, previousS, currentS, code, image, ip, caja);
        }
    }
    
    private String name(int name){
        switch(name){
            case 0: return String.valueOf(letter());
            case 1: return String.valueOf(letter()+letter());
            case 2: return String.valueOf(letter()+letter()+letter());
            case 3: return String.valueOf(letter()+letter()+letter()+letter());
            case 4: return String.valueOf(letter()+letter()+letter()+letter()+letter());
            default : return String.valueOf(letter());
        }        
    }
    
    private String code(int code){
        switch(code){
            case 0: return String.valueOf(number());
            case 1: return String.valueOf(number()+number());
            case 2: return String.valueOf(number()+number()+number());
            case 3: return String.valueOf(number()+number()+number()+number());
            case 4: return String.valueOf(number()+number()+number()+number()+number());
            default : return String.valueOf(number());
        } 
    }
    private String fatherId(int id){
        switch(id){
            case 0: return "";
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
