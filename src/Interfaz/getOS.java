/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author frank
 */
public class getOS {
    private static String OS = System.getProperty("os.name").toLowerCase();
    
    public String getSisOpe(){
        String separator = null;
        if (isWindows()) {
            System.out.println("getOS/getSysOpe: es windows");
            separator = "\\";
        } else if (isMac()) {
            System.out.println("getOS/getSysOpe: es Mac");
            separator = "/";            
        } else if (isUnix()) {
            System.out.println("getOS/getSysOpe: es Unix");
            separator = "/";
        } else if (isSolaris()) {
            System.out.println("getOS/getSysOpe: es Solaris");
            separator = "/";
        } else {
            System.out.println("Sistema operativo no reconocido!!");
        }
        
        return separator;
    }
    
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
 
    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
 
    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
 
    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
}