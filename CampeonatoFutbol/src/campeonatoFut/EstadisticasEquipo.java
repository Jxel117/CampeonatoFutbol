package campeonatoFut;

public class EstadisticasEquipo {
    private int puntosTotales;

    public EstadisticasEquipo() {
        this.puntosTotales = 0;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public void sumarPuntos(int puntos) {
        this.puntosTotales += puntos;
    }
}
