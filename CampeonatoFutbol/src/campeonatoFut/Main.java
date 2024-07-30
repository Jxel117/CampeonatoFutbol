package campeonatoFut;

public class Main {
    public static void main(String[] args) {
        // Crear y probar objetos de las clases
        CampeonatoFutbol campeonato = new CampeonatoFutbol("Liga", 10, "2024-07-01", "2024-12-31", null);
        Equipo equipo1 = new Equipo("Equipo 1", 11, 5);
        Equipo equipo2 = new Equipo("Equipo 2", 11, 5);
        campeonato.inscribirEquipo(equipo1);
        campeonato.inscribirEquipo(equipo2);

        Partido partido = new Partido(equipo1, equipo2);
        campeonato.registrarResultado(partido);

        System.out.println("Ganador del campeonato: " + campeonato.ganador());
    }
}
