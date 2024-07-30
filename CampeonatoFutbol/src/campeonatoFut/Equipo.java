package campeonatoFut;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private int maxJugadores;
    private int minJugadores;
    private List<Jugador> jugadores;

    public Equipo(String nombre, int maxJugadores, int minJugadores) {
        this.nombre = nombre;
        this.maxJugadores = maxJugadores;
        this.minJugadores = minJugadores;
        this.jugadores = new ArrayList<>();
    }

    public void competir() {
        // Lógica de competición
    }

    public void posicion() {
        // Lógica de posición
    }
}
