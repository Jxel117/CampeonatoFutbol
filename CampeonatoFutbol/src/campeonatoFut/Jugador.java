package campeonatoFut;

public class Jugador {
    private String dni;

    public Jugador(String dni) {
        this.dni = dni;
    }

    public void jugar() {
        // Lógica de juego
    }

    public EstadisticasJugador estadisticas() {
        return new EstadisticasJugador();
    }
}
