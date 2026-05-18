import java.time.LocalDateTime;

// Autorización de acceso
public class AccesoEvento {

    private int id;

    private Usuario usuario;
    private Evento evento;

    private LocalDateTime fechaRegistro;

    private boolean habilitado;
    private String tipoAcceso;

    private PlanSuscripcion planRequerido;
    private boolean accesoPrioritario;

    // Constructor
    public AccesoEvento(int id,
                        Usuario usuario,
                        Evento evento,
                        LocalDateTime fechaRegistro,
                        boolean habilitado,
                        String tipoAcceso,
                        PlanSuscripcion planRequerido,
                        boolean accesoPrioritario) {

        this.id = id;
        this.usuario = usuario;
        this.evento = evento;

        this.fechaRegistro = fechaRegistro;

        this.habilitado = habilitado;
        this.tipoAcceso = tipoAcceso;

        this.planRequerido = planRequerido;
        this.accesoPrioritario = accesoPrioritario;
    }

    // Valida autorización
    public boolean validarIngreso() {
        return habilitado;
    }

    // Valida plan
    public boolean validarPlanUsuario() {
        return usuario.getPlan().getNivel()
                >= planRequerido.getNivel();
    }

    // Autoriza acceso
    public void autorizarAcceso() {
        habilitado = true;
    }

    // Rechaza acceso
    public void rechazarAcceso() {
        habilitado = false;
    }
}