import java.util.ArrayList;

public class Controlador {
    
    private Modelo modelo;
    private Form vista;
    private SopaLetras sopa;
    
    public Controlador(Modelo modelo, Form vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public ArrayList<String> controladorObtenerPalabras() {
        return modelo.obtenerPalabras();
    }
    
    public String generarSopa() {
        ArrayList<String> palabras = controladorObtenerPalabras();
        sopa = new SopaLetras(palabras);
        return sopa.obtenerSopaComoTexto(); 
    }
    
    public void añadirPalabra(String palabra){
        modelo.agregarPalabra(palabra);
    }
    
    public void borrarPalabra(String palabra){
        modelo.deletePalabra(palabra);
    }
    
}