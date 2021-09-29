/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyName;

import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author frank
 */
public class HiloCN implements Runnable{
    
    private String stage;
    private String token;
    private String ip;
    private int position;
    private JTextArea caja;

    public void setCaja(JTextArea caja) {
        this.caja = caja;
        System.out.println("setCaja");
    }

    public void setPosition(int position) {
        this.position = position;
        System.out.println("setPosition: "+position);
    }

    public void setIp(String ip) {
        this.ip = ip;
        System.out.println("setIp: "+ip);
    }
    
    public void setStage(String stage) {
        this.stage = stage;
        System.out.println("setStage: "+stage);
    }

    public void setToken(String token) {
        this.token = token;
        System.out.println("setToken: "+token);
    }
    
    public void loop(){  
        Company c = new Company(email(), companyName(), token, ip, stage, position, caja);
    }
    
    private String email(){
        String email = "";
        email = letter()+"_"+LETTER()+number()+"@"+letter()+letter()+letter()+letter()+".com";
        System.out.println(email);
        return email;
    }
    
    private String companyName(){
        String company="";
        company = String.valueOf(LETTER()+letter()+letter()+letter()+letter()+letter());
        return company;
    }

    private char letter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }
    
    private char LETTER() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'A');
        return c;
    }

    private int number() {
        int numero = (int) (Math.random() * 10 + 1);
        return numero;
    }
    
    @Override
    public void run() {
        loop();
    }
}
