import java.time.LocalDateTime;

// Clase abstracta base para eventos
public abstract class Evento {

    private int id;
    private String titulo;
    private String descripcion;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    private EstadoEvento estado;
    private int capacidadMaxima;

    // Constructor
    public Evento(int id,
                  String titulo,
                  String descripcion,
                  LocalDateTime fechaHoraInicio,
                  LocalDateTime fechaHoraFin,
                  EstadoEvento estado,
                  int capacidadMaxima) {

        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;

        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;

        this.estado = estado;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Métodos abstractos
    public abstract void iniciarEvento();
    public abstract void finalizarEvento();

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}