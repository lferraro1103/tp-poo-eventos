import java.util.ArrayList;
import java.util.List;

// Administra eventos
public class GestorEventosEnVivo {

    private List<Evento> eventos;
    private List<RegistroAcceso> registros;

    // Constructor
    public GestorEventosEnVivo() {

        eventos = new ArrayList<>();
        registros = new ArrayList<>();
    }

    // Agrega evento
    public void crearEvento(
            RecitalEnVivo evento) {

        eventos.add(evento);
    }

    // Lista eventos
    public List<Evento>
    listarEventosDisponibles() {

        return eventos;
    }

    // Guarda registros
    public void registrarAcceso(
            RegistroAcceso registro) {

        registros.add(registro);
    }
}