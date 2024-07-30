package campeonatoFut;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int resultadoFinal;
    private static final int GANADOR = 3;
    private static final int EMPATE = 1;
    private static final int PERDEDOR = 0;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public String resultadoFinal() {
        return "Fin del partido: ";
    }

    public int ganador() {
        return GANADOR;
    }

    public int empate() {
        return EMPATE;
    }

    public int perdedor() {
        return PERDEDOR;
    }
}
