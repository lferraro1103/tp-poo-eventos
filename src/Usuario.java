import java.util.Objects;

// Representa un usuario
public class Usuario {

    private int id;
    private String nombre;
    private PlanSuscripcion plan;

    // Constructor
    public Usuario(int id, String nombre, PlanSuscripcion plan) {
        this.id = id;
        this.nombre = nombre;
        this.plan = plan;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PlanSuscripcion getPlan() {
        return plan;
    }

    // Comparación por id
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Usuario usuario = (Usuario) obj;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}