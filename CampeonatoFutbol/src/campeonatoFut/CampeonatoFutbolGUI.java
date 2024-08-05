package campeonatoFut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CampeonatoFutbolGUI {
    private JFrame frame;
    private JPanel panelMain, panelEquipo, panelJugador, panelPartido;
    private JTextField textFieldNombreEquipo, textFieldMaxJugadores, textFieldMinJugadores;
    private JTextField textFieldDniJugador, textFieldNombreJugador;
    private JButton btnAddEquipo, btnAddJugador, btnAddPartido, btnShowClasificacion;
    private JTextArea textAreaOutput;

    private CampeonatoFutbol campeonato;
    private Equipo equipoActual;

    public CampeonatoFutbolGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Campeonato de Fútbol");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        campeonato = new CampeonatoFutbol("Liga", 10, "2024-07-01", "2024-12-31");

        panelMain = new JPanel(new GridLayout(4, 1));
        panelEquipo = new JPanel(new GridLayout(4, 2));
        panelJugador = new JPanel(new GridLayout(3, 2));
        panelPartido = new JPanel(new GridLayout(3, 2));

        textFieldNombreEquipo = new JTextField();
        textFieldMaxJugadores = new JTextField();
        textFieldMinJugadores = new JTextField();
        textFieldDniJugador = new JTextField();
        textFieldNombreJugador = new JTextField();

        btnAddEquipo = new JButton("Agregar Equipo");
        btnAddJugador = new JButton("Agregar Jugador");
        btnAddPartido = new JButton("Registrar Partido");
        btnShowClasificacion = new JButton("Mostrar Clasificación");

        textAreaOutput = new JTextArea();
        textAreaOutput.setEditable(false);

        // Panel Equipo
        panelEquipo.add(new JLabel("Nombre Equipo:"));
        panelEquipo.add(textFieldNombreEquipo);
        panelEquipo.add(new JLabel("Máx Jugadores:"));
        panelEquipo.add(textFieldMaxJugadores);
        panelEquipo.add(new JLabel("Mín Jugadores:"));
        panelEquipo.add(textFieldMinJugadores);
        panelEquipo.add(btnAddEquipo);

        // Panel Jugador
        panelJugador.add(new JLabel("DNI Jugador:"));
        panelJugador.add(textFieldDniJugador);
        panelJugador.add(new JLabel("Nombre Jugador:"));
        panelJugador.add(textFieldNombreJugador);
        panelJugador.add(btnAddJugador);

        // Panel Partido
        panelPartido.add(btnAddPartido);
        panelPartido.add(btnShowClasificacion);

        panelMain.add(panelEquipo);
        panelMain.add(panelJugador);
        panelMain.add(panelPartido);
        panelMain.add(new JScrollPane(textAreaOutput));

        frame.add(panelMain, BorderLayout.CENTER);

        // Add action listeners
        btnAddEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEquipo();
            }
        });

        btnAddJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addJugador();
            }
        });

        btnAddPartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPartido();
            }
        });

        btnShowClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarClasificacion();
            }
        });

        frame.setVisible(true);
    }

    private void addEquipo() {
        String nombre = textFieldNombreEquipo.getText();
        int maxJugadores = Integer.parseInt(textFieldMaxJugadores.getText());
        int minJugadores = Integer.parseInt(textFieldMinJugadores.getText());
        equipoActual = new Equipo(nombre, maxJugadores, minJugadores);
        campeonato.inscribirEquipo(equipoActual);
        textAreaOutput.append("Equipo agregado: " + nombre + " con max. " + maxJugadores + " jugadores.\n");
    }

    private void addJugador() {
        if (equipoActual == null) {
            textAreaOutput.append("Primero debes agregar un equipo.\n");
            return;
        }

        String dni = textFieldDniJugador.getText();
        String nombre = textFieldNombreJugador.getText();
        Jugador jugador = new Jugador(dni, nombre);
        equipoActual.agregarJugador(jugador);
        textAreaOutput.append("Jugador agregado: " + nombre + " (DNI: " + dni + ") al equipo " + equipoActual.getNombre() + "\n");
    }

    private void registrarPartido() {
        // Verificar que haya al menos dos equipos
        if (campeonato.getEquipos().size() < 2) {
            textAreaOutput.append("Debe haber al menos dos equipos registrados para jugar un partido.\n");
            return;
        }

        // Seleccionar dos equipos aleatoriamente
        Random rand = new Random();
        Equipo equipo1 = campeonato.getEquipos().get(rand.nextInt(campeonato.getEquipos().size()));
        Equipo equipo2 = equipo1;
        while (equipo2 == equipo1) {
            equipo2 = campeonato.getEquipos().get(rand.nextInt(campeonato.getEquipos().size()));
        }

        // Generar resultado aleatorio
        int golesEquipo1 = rand.nextInt(5);
        int golesEquipo2 = rand.nextInt(5);

        Partido partido = new Partido(equipo1, equipo2);
        partido.jugar(golesEquipo1, golesEquipo2);

        campeonato.registrarPartido(partido);

        textAreaOutput.append("Partido registrado: " + equipo1.getNombre() + " " + golesEquipo1 + " - " + golesEquipo2 + " " + equipo2.getNombre() + "\n");
        if (partido.ganador() != null) {
            textAreaOutput.append("Ganador: " + partido.ganador().getNombre() + "\n");
        } else {
            textAreaOutput.append("El partido terminó en empate.\n");
        }

        // Actualizar estadísticas de los jugadores
        actualizarEstadisticasJugadores(equipo1, golesEquipo1);
        actualizarEstadisticasJugadores(equipo2, golesEquipo2);
    }

    private void actualizarEstadisticasJugadores(Equipo equipo, int goles) {
        Random rand = new Random();
        for (Jugador jugador : equipo.getJugadores()) {
            int golesJugador = rand.nextInt(goles + 1);
            jugador.getEstadisticas().setGolesTotales(jugador.getEstadisticas().getGolesTotales() + golesJugador);
        }
    }

    private void mostrarClasificacion() {
        Clasificacion clasificacion = campeonato.getClasificacion();
        textAreaOutput.append("Clasificación:\n");
        for (Equipo equipo : clasificacion.getEquipos()) {
            textAreaOutput.append(equipo.getNombre() + " - " + equipo.getEstadisticas().getPuntosTotales() + " puntos\n");
            for (Jugador jugador : equipo.getJugadores()) {
                textAreaOutput.append("  Jugador: " + jugador.getNombre() + " (DNI: " + jugador.getDni() + ") - Goles: " + jugador.getGolesTotales() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        new CampeonatoFutbolGUI();
    }
}
