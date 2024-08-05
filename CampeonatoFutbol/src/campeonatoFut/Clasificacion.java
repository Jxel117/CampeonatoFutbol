package campeonatoFut;

import java.util.Comparator;
import java.util.List;

public class Clasificacion {
    private CampeonatoFutbol campeonato;

    public Clasificacion(CampeonatoFutbol campeonato) {
        this.campeonato = campeonato;
    }

    public List<Equipo> getEquipos() {
        List<Equipo> equipos = campeonato.getEquipos();
        // Usar el nuevo método getPuntosTotales() para ordenar los equipos
        equipos.sort(Comparator.comparingInt(Equipo::getPuntosTotales).reversed());
        return equipos;
    }

    public void actualizar(Partido partido) {
        if (partido.ganador() != null) {
            partido.ganador().getEstadisticas().sumarPuntos(3);
        } else {
            partido.getEquipo1().getEstadisticas().sumarPuntos(1);
            partido.getEquipo2().getEstadisticas().sumarPuntos(1);
        }
    }
}
