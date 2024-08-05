package campeonatoFut;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private Resultado resultado;

    public enum Resultado {
        GANADOR_EQUIPO1, GANADOR_EQUIPO2, EMPATE
    }

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void jugar(int golesEquipo1, int golesEquipo2) {
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        if (golesEquipo1 > golesEquipo2) {
            resultado = Resultado.GANADOR_EQUIPO1;
        } else if (golesEquipo1 < golesEquipo2) {
            resultado = Resultado.GANADOR_EQUIPO2;
        } else {
            resultado = Resultado.EMPATE;
        }
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public Equipo ganador() {
        if (resultado == Resultado.GANADOR_EQUIPO1) {
            return equipo1;
        } else if (resultado == Resultado.GANADOR_EQUIPO2) {
            return equipo2;
        } else {
            return null; // Empate
        }
    }
}
