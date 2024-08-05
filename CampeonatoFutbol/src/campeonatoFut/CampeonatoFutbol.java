package campeonatoFut;

import java.util.ArrayList;
import java.util.List;

public class CampeonatoFutbol {
    private String nombre;
    private int equiposMax;
    private String fechaInicio;
    private String fechaFin;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private Clasificacion clasificacion;

    public CampeonatoFutbol(String nombre, int equiposMax, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.equiposMax = equiposMax;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.clasificacion = new Clasificacion(this);
    }

    public void inscribirEquipo(Equipo equipo) {
        if (equipos.size() < equiposMax) {
            equipos.add(equipo);
        }
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
        clasificacion.actualizar(partido);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
