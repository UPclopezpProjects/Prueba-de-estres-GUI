/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewProductor;

import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class DishonestAgentNP {
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
    private String image;
    private String ip;
    private JTextArea caja;

    public DishonestAgentNP(String ubication, String harvestD, String caducationD, String description, String nameCompany, String fId, String nameProduction, String previousS, String currentS, String code, String image, String ip, JTextArea caja) {
        this.ubication = ubication;
        this.harvestD = harvestD;
        this.caducationD = caducationD;
        this.description = description;
        this.nameCompany = nameCompany;
        this.fId = fId;
        this.nameProduction = nameProduction;
        this.previousS = previousS;
        this.currentS = currentS;
        this.code = code;
        this.image = image;
    }
}
