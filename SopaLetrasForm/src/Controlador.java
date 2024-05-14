
public class Controlador {

    private Modelo modelo;
    private Form vista;
    private SopaLetras sopa;

    public Controlador(Modelo modelo, Form vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.sopa = new SopaLetras(this);
    }

    public String generarSopa() {
        SopaLetras sopa = new SopaLetras(this);
        return sopa.obtenerSopaComoTexto();
    }

    public String controladorObtenerPalabras() {
        return modelo.obtenerPalabras();
    }

    public void añadirPalabra(String palabra) {
        modelo.agregarPalabra(palabra);
    }

    public void borrarPalabra(String palabra) {
        modelo.deletePalabra(palabra);
    }

    public int obtenerCuentapalabras() {
        return modelo.consultaNumeropalabras();
    }

}
