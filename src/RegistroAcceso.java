import java.time.LocalDateTime;

public class RegistroAcceso {

    private Usuario usuario;
    private Evento evento;

    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;

    private boolean exitoso;
    private String motivoRechazo;

    // Constructor
    public RegistroAcceso(Usuario usuario,
                          Evento evento,
                          boolean exitoso,
                          String motivoRechazo) {

        this.usuario = usuario;
        this.evento = evento;

        this.exitoso = exitoso;
        this.motivoRechazo = motivoRechazo;

        this.fechaHoraIngreso =
                LocalDateTime.now();
    }

    // Guarda resultado
    public void guardarRegistro() {

        if (exitoso) {

            System.out.println(
                    "Ingreso registrado."
            );

        } else {

            System.out.println(
                    "Acceso rechazado: "
                            + motivoRechazo
            );
        }
    }
}




