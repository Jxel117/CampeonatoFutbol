package campeonatoFut;

public class Clasificacion {
    private int equipoMasPuntos;
    private int equipoMenosPuntos;

    public String equipoMasPuntos() {
        // Lógica para obtener el equipo con más puntos
        return "Equipo con más puntos";
    }

    public String equipoMenosPuntos() {
        // Lógica para obtener el equipo con menos puntos
        return "Equipo con menos puntos";
    }

    public void actualizarClasificacion(Partido partido) {
        // Actualizar la clasificación según el resultado del partido
    }
}
