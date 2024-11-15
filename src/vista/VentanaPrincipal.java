package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public JTextField txtEquipo;
    public JTextField txtCiudad;
    public JTextField txtEntrenador;
    public JButton btnAgregar;
    public JButton btnEliminar;
    public JButton btnIniciarPartidos;
    public JTable tablaEquipos;
    private DefaultTableModel modeloTabla;
    public JTextArea textResultados; // JTextArea para mostrar resultados

    public VentanaPrincipal() {
        setTitle("Gestión de Torneo");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para ingresar equipos
        JPanel panelIngreso = new JPanel();
        panelIngreso.setLayout(new GridLayout(4, 2));

        txtEquipo = new JTextField();
        txtCiudad = new JTextField();
        txtEntrenador = new JTextField();
        btnAgregar = new JButton("Agregar Equipo");
        btnEliminar = new JButton("Eliminar Equipo");
        btnIniciarPartidos = new JButton("Iniciar Partidos");

        // Colores de los botones
        btnAgregar.setBackground(new Color(76, 175, 80)); // Verde para agregar
        btnAgregar.setForeground(Color.WHITE);
        btnEliminar.setBackground(Color.RED); // Rojo para eliminar
        btnEliminar.setForeground(Color.WHITE);

        panelIngreso.add(new JLabel("Equipo:"));
        panelIngreso.add(txtEquipo);
        panelIngreso.add(new JLabel("Ciudad:"));
        panelIngreso.add(txtCiudad);
        panelIngreso.add(new JLabel("Entrenador:"));
        panelIngreso.add(txtEntrenador);
        panelIngreso.add(btnAgregar);
        panelIngreso.add(btnEliminar);

        add(panelIngreso, BorderLayout.NORTH);

        // Tabla para mostrar equipos
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Equipo");
        modeloTabla.addColumn("Ciudad");
        modeloTabla.addColumn("Entrenador");
        tablaEquipos = new JTable(modeloTabla);

        add(new JScrollPane(tablaEquipos), BorderLayout.CENTER);
        
        // Panel para el botón de iniciar partidos
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(btnIniciarPartidos);

        add(panelBotones, BorderLayout.SOUTH);
        
        // Inicialización del JTextArea para mostrar resultados
        textResultados = new JTextArea(10, 40);
        textResultados.setEditable(false);
        JScrollPane scrollResultados = new JScrollPane(textResultados);
        
        add(scrollResultados, BorderLayout.EAST); // Agregar el JTextArea a la ventana
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
