// Excepción personalizada
public class AccesoDenegadoException extends Exception {

    public AccesoDenegadoException(String mensaje) {
        super(mensaje);
    }
}