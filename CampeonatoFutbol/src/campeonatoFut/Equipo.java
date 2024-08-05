package campeonatoFut;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private int maxJugadores;
    private int minJugadores;
    private List<Jugador> jugadores;
    private EstadisticasEquipo estadisticas;

    public Equipo(String nombre, int maxJugadores, int minJugadores) {
        this.nombre = nombre;
        this.maxJugadores = maxJugadores;
        this.minJugadores = minJugadores;
        this.jugadores = new ArrayList<>();
        this.estadisticas = new EstadisticasEquipo();
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public int getMinJugadores() {
        return minJugadores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public EstadisticasEquipo getEstadisticas() {
        return estadisticas;
    }

    // Nuevo método para obtener los puntos totales directamente
    public int getPuntosTotales() {
        return estadisticas.getPuntosTotales();
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < maxJugadores) {
            jugadores.add(jugador);
        }
    }
}
