import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

// Evento en vivo
public class RecitalEnVivo extends Evento {

    private PlanSuscripcion planMinimoRequerido;
    private String ubicacion;

    private boolean esStreaming;
    private boolean exclusivo;

    // Usuarios conectados
    private Set<Usuario> usuariosConectados;

    // Constructor
    public RecitalEnVivo(int id,
                         String titulo,
                         String descripcion,
                         LocalDateTime fechaHoraInicio,
                         LocalDateTime fechaHoraFin,
                         EstadoEvento estado,
                         int capacidadMaxima,
                         PlanSuscripcion planMinimoRequerido,
                         String ubicacion,
                         boolean esStreaming,
                         boolean exclusivo) {

        super(id,
                titulo,
                descripcion,
                fechaHoraInicio,
                fechaHoraFin,
                estado,
                capacidadMaxima);

        this.planMinimoRequerido = planMinimoRequerido;
        this.ubicacion = ubicacion;

        this.esStreaming = esStreaming;
        this.exclusivo = exclusivo;

        this.usuariosConectados = new HashSet<>();
    }

    // Verifica capacidad
    public boolean verificarCapacidad() {
        return usuariosConectados.size() < getCapacidadMaxima();
    }

    // Permite ingreso
    public void permitirIngreso(Usuario usuario)
            throws AccesoDenegadoException {

        // Verifica capacidad máxima
        if (!verificarCapacidad()) {

            throw new AccesoDenegadoException(
                    "Capacidad agotada."
            );
        }

        // Verifica si el usuario ya está conectado
        if (usuariosConectados.contains(usuario)) { //uso de contains //recorre el set usando equals

            throw new AccesoDenegadoException(
                    "El usuario ya se encuentra conectado."
            );
        }

        // Agrega usuario al recital
        usuariosConectados.add(usuario);
    }

    // Expulsa usuario
    public void expulsarUsuario(Usuario usuario) {
        usuariosConectados.remove(usuario);
    }

    // Getter usuarios conectados
    public Set<Usuario> getUsuariosConectados() {

        return usuariosConectados;
    }

    // Cambia estado
    @Override
    public void iniciarEvento() {
        setEstado(EstadoEvento.EN_CURSO);
    }

    @Override
    public void finalizarEvento() {
        setEstado(EstadoEvento.FINALIZADO);
    }
}