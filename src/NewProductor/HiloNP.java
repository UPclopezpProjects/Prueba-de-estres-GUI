/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewProductor;

import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String nameProductor;
    private String previousS;
    private String currentS;
    private String code;
    
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

    public void setfId(String fId) {
        this.fId = fId;
    }

    public void setNameProductor(String nameProductor) {
        this.nameProductor = nameProductor;
    }

    public void setPreviousS(String previousS) {
        this.previousS = previousS;
    }

    public void setCurrentS(String currentS) {
        this.currentS = currentS;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void loop1() throws InterruptedException {

    }

    public void run() {
        try {
            loop1();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloNP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
