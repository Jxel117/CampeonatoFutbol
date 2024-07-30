package campeonatoFut;

import java.util.ArrayList;
import java.util.List;

public class CampeonatoFutbol {
    private String nombre;
    private int equiposMax;
    private String fechaInicio;
    private String fechaFin;
    private Object sistema;
    private List<Equipo> equipos;
    private Clasificacion clasificacion;

    public CampeonatoFutbol(String nombre, int equiposMax, String fechaInicio, String fechaFin, Object sistema) {
        this.nombre = nombre;
        this.equiposMax = equiposMax;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sistema = sistema;
        this.equipos = new ArrayList<>();
        this.clasificacion = new Clasificacion();
    }

    public String ganador() {
        return clasificacion.equipoMasPuntos();
    }

    public void inscribirEquipo(Equipo equipo) {
        if (equipos.size() < equiposMax) {
            equipos.add(equipo);
        }
    }

    public void registrarResultado(Partido partido) {
        clasificacion.actualizarClasificacion(partido);
    }
}
