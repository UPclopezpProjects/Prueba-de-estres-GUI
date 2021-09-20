package Interfaz;

public class Respuesta {
    
    //para la creación de roots
    public static int tamanio;
    public static String consultaRoot[];
    //para la creación de usuarios automáticos
    public static int tamanioUC;
    public static String consultaUC[];

    public static String getConsultaUC(int position) {
        return Respuesta.consultaUC[position];
    }

    public static void setConsultaUC(String consultaUC, int position) {
        //System.out.println("Respuesta/setConsultaUC: "+consultaUC+", "+position);
        Respuesta.consultaUC[position] += consultaUC;
    }
    
    public static void setTamanioUC(int tamanioUC) {
        Respuesta.tamanioUC = tamanioUC;
        Respuesta.consultaUC = new String[tamanioUC];
    }

    public static void setConsultaRoot(String consultaRoot, int position) {
        //System.out.println("Respuesta/setConsultaRoot: "+consultaRoot+", "+position);
        Respuesta.consultaRoot[position] += consultaRoot+ "\n";
    }
    
    public static String getConsultaRoot(int position){
        //System.out.println("Respuesta/getConsultaRoot: "+Respuesta.consultaRoot[position]);
        return Respuesta.consultaRoot[position];
    }
    
    public static void setTamanio(int tamanio){
        //System.out.println("Respuesta/setTamanio: "+tamanio);
        Respuesta.tamanio = tamanio;
        Respuesta.consultaRoot= new String[tamanio];
    }
            
    
}
