// Planes de suscripción
public enum PlanSuscripcion {

    FREE(1),
    PREMIUM(2),
    VIP(3);

    // Nivel para comparar permisos
    private final int nivel;

    PlanSuscripcion(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {

        return nivel;
    }
}