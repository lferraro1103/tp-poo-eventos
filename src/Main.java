import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase principal de prueba
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista de usuarios registrados
        List<Usuario> usuariosRegistrados =
                new ArrayList<>();

        // Usuarios iniciales
        Usuario usuario1 = new Usuario(
                1,
                "Lucia",
                PlanSuscripcion.PREMIUM
        );

        Usuario usuario2 = new Usuario(
                2,
                "Leandro",
                PlanSuscripcion.VIP
        );

        Usuario usuario3 = new Usuario(
                3,
                "Nicolas",
                PlanSuscripcion.FREE
        );

        // Agregar usuarios iniciales
        usuariosRegistrados.add(usuario1);
        usuariosRegistrados.add(usuario2);
        usuariosRegistrados.add(usuario3);

        // ID incremental
        int siguienteId = 4;

        // Crear recital
        RecitalEnVivo recital = new RecitalEnVivo(
                100,
                "Rock en Vivo",
                "Recital exclusivo online",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                EstadoEvento.PROGRAMADO,
                5,
                PlanSuscripcion.PREMIUM,
                "Buenos Aires",
                true,
                true
        );

        // Iniciar evento
        recital.iniciarEvento();

        int opcion;

        do {

            System.out.println(
                    "\n===== MENU EVENTOS EN VIVO ====="
            );

            System.out.println(
                    "1. Registrar usuario"
            );

            System.out.println(
                    "2. Ver usuarios registrados"
            );

            System.out.println(
                    "3. Dar acceso al usuario para ingresar al evento"
            );

            System.out.println(
                    "4. Ver usuarios conectados"
            );

            System.out.println(
                    "5. Expulsar usuario"
            );

            System.out.println(
                    "6. Ver capacidad del evento"
            );

            System.out.println(
                    "7. Finalizar evento"
            );

            System.out.println(
                    "0. Salir"
            );

            System.out.print(
                    "Seleccione una opcion: "
            );

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print(
                            "Ingrese nombre del usuario: "
                    );

                    String nombre =
                            scanner.nextLine();

                    System.out.println(
                            "Seleccione plan:"
                    );

                    System.out.println("1 - FREE");
                    System.out.println("2 - PREMIUM");
                    System.out.println("3 - VIP");

                    int opcionPlan =
                            scanner.nextInt();

                    PlanSuscripcion plan;

                    switch (opcionPlan) {

                        case 1:
                            plan = PlanSuscripcion.FREE;
                            break;

                        case 2:
                            plan = PlanSuscripcion.PREMIUM;
                            break;

                        case 3:
                            plan = PlanSuscripcion.VIP;
                            break;

                        default:

                            System.out.println(
                                    "Plan invalido."
                            );

                            break;
                    }

                    Usuario nuevoUsuario =
                            new Usuario(
                                    siguienteId,
                                    nombre,
                                    opcionPlan == 1
                                            ? PlanSuscripcion.FREE
                                            : opcionPlan == 2
                                              ? PlanSuscripcion.PREMIUM
                                              : PlanSuscripcion.VIP
                            );

                    usuariosRegistrados.add(
                            nuevoUsuario
                    );

                    System.out.println(
                            "Usuario registrado correctamente."
                    );

                    System.out.println(
                            "ID asignado: "
                                    + siguienteId
                    );

                    siguienteId++;

                    break;

                case 2:

                    System.out.println(
                            "\nUsuarios registrados:"
                    );

                    for (Usuario usuario :
                            usuariosRegistrados) {

                        System.out.println(
                                "ID: "
                                        + usuario.getId()
                                        + " | Nombre: "
                                        + usuario.getNombre()
                                        + " | Plan: "
                                        + usuario.getPlan()
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "\nUsuarios registrados:"
                    );

                    for (Usuario usuario :
                            usuariosRegistrados) {

                        System.out.println(
                                "ID: "
                                        + usuario.getId()
                                        + " | Nombre: "
                                        + usuario.getNombre()
                                        + " | Plan: "
                                        + usuario.getPlan()
                        );
                    }

                    System.out.print(
                            "Ingrese ID de usuario: "
                    );

                    int idIngreso =
                            scanner.nextInt();

                    Usuario usuarioIngreso = null;

                    for (Usuario usuario :
                            usuariosRegistrados) {

                        if (usuario.getId()
                                == idIngreso) {

                            usuarioIngreso = usuario;
                            break;
                        }
                    }

                    if (usuarioIngreso == null) {

                        System.out.println(
                                "Usuario inexistente."
                        );

                        break;
                    }

                    // Crear acceso
                    AccesoEvento acceso =
                            new AccesoEvento(
                                    10,
                                    usuarioIngreso,
                                    recital,
                                    LocalDateTime.now(),
                                    true,
                                    "VIP",
                                    PlanSuscripcion.PREMIUM,
                                    true
                            );

                    // Validar acceso
                    if (acceso.validarIngreso()
                            && acceso.validarPlanUsuario()) {
                        try {
                            recital.permitirIngreso(
                                    usuarioIngreso
                            );
                            RegistroAcceso registro =
                                    new RegistroAcceso(
                                            usuarioIngreso,
                                            recital,
                                            true,
                                            ""
                                    );

                            registro.guardarRegistro();

                            System.out.println(
                                    "Ingreso autorizado."
                            );
                        } catch (
                                AccesoDenegadoException e) {
                            RegistroAcceso registro =
                                    new RegistroAcceso(
                                            usuarioIngreso,
                                            recital,
                                            false,
                                            e.getMessage()
                                    );
                            registro.guardarRegistro();
                            System.out.println(
                                    e.getMessage()
                            );
                        }

                    } else {

                        RegistroAcceso registro =
                                new RegistroAcceso(
                                        usuarioIngreso,
                                        recital,
                                        false,
                                        "Acceso denegado"
                                );

                        registro.guardarRegistro();

                        System.out.println(
                                "El usuario no posee autorización."
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                            "\nUsuarios conectados:"
                    );

                    for (Usuario usuario :
                            recital.getUsuariosConectados()) {

                        System.out.println(
                                "ID: "
                                        + usuario.getId()
                                        + " | Nombre: "
                                        + usuario.getNombre()
                                        + " | Plan: "
                                        + usuario.getPlan()
                        );
                    }

                    break;

                case 5:

                    System.out.print(
                            "Ingrese ID de usuario a expulsar: "
                    );

                    int idExpulsion =
                            scanner.nextInt();

                    Usuario usuarioEliminar = null;

                    for (Usuario usuario :
                            recital.getUsuariosConectados()) {

                        if (usuario.getId()
                                == idExpulsion) {

                            usuarioEliminar = usuario;
                            break;
                        }
                    }

                    if (usuarioEliminar != null) {

                        recital.expulsarUsuario(
                                usuarioEliminar
                        );

                        System.out.println(
                                "Usuario expulsado."
                        );

                    } else {

                        System.out.println(
                                "Usuario no encontrado."
                        );
                    }

                    break;

                case 6:

                    int conectados =
                            recital.getUsuariosConectados().size();

                    int capacidad =
                            recital.getCapacidadMaxima();

                    System.out.println(
                            "Capacidad actual: "
                                    + conectados
                                    + "/" + capacidad
                    );

                    break;

                case 7:

                    recital.finalizarEvento();

                    System.out.println(
                            "Evento finalizado."
                    );

                    break;

                case 0:

                    System.out.println(
                            "Programa finalizado."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida."
                    );
            }

        } while (opcion != 0);

        scanner.close();
    }
}