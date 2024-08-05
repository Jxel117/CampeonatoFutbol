package campeonatoFut;

public class Jugador {
    private String dni;
    private String nombre;
    private EstadisticasJugador estadisticas;

    public Jugador(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.estadisticas = new EstadisticasJugador();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadisticasJugador getEstadisticas() {
        return estadisticas;
    }

    public int getGolesTotales() {
        return estadisticas.getGolesTotales();
    }
}
