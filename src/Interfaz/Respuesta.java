package Interfaz;

public class Respuesta {
    
    public static int tamanio;
    public static String consultaRoot[];

    public String[] getConsultaRoot() {
        System.out.println("Respuesta/getConsultaRoot");
        return consultaRoot;
    }

    public static void setConsultaRoot(String consultaRoot, int position) {
        System.out.println("Respuesta/setConsultaRoot: "+consultaRoot+", "+position);
        Respuesta.consultaRoot[position] += consultaRoot+ "\n";
    }
    
    public static String getConsultaRoot(int position){
        System.out.println("Respuesta/getConsultaRoot: "+Respuesta.consultaRoot[position]);
        return Respuesta.consultaRoot[position];
    }
    
    public static void setTamanio(int tamanio){
        System.out.println("Respuesta/setTamanio: "+tamanio);
        Respuesta.tamanio = tamanio;
        Respuesta.consultaRoot= new String[tamanio];
    }
            
    
}
