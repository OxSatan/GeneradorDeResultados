package controlador;

import modelo.Equipo;
import modelo.EquipoDAO;
import vista.VentanaPrincipal;
import vista.VentanaPartido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class ControladorEquipo {
    private EquipoDAO equipoDAO;
    private VentanaPrincipal vista;

    public ControladorEquipo(EquipoDAO equipoDAO, VentanaPrincipal vista) {
        this.equipoDAO = equipoDAO;
        this.vista = vista;

        // Configurar listeners para los botones
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEquipo();
            }
        });

        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEquipos();
            }
        });

        this.vista.btnMostrarTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEquipos();
            }
        });

        this.vista.btnIniciarPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegirModoPartido();
            }
        });

        mostrarEquipos();
    }

    private void elegirModoPartido() {
        String[] opciones = {"Aleatorizar", "Manual"};
        int seleccion = JOptionPane.showOptionDialog(vista, "¿Cómo deseas iniciar los partidos?", "Inicializar Partidos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            aleatorizarResultados();
        } else if (seleccion == 1) {
            mostrarVentanaPartido();
        }
    }

    private void mostrarVentanaPartido() {
        VentanaPartido ventanaPartido = new VentanaPartido(equipoDAO.obtenerEquipos());
        ventanaPartido.setVisible(true);
    }

    private void aleatorizarResultados() {
        StringBuilder resultados = new StringBuilder();
        Random rand = new Random();
        List<Equipo> equipos = equipoDAO.obtenerEquipos();

        // Generar partidos (local contra visitante)
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = 0; j < equipos.size(); j++) {
                if (i != j) { // Asegurar que no jueguen contra sí mismos
                    // Generar goles aleatorios independientes para local y visitante
                    int golesLocal = rand.nextInt(5); // Goles del equipo local (0 a 4)
                    int golesVisitante = rand.nextInt(5); // Goles del equipo visitante (0 a 4)

                    // Mostrar el resultado del partido
                    resultados.append(equipos.get(i).getEquipo()).append(" ").append(golesLocal).append(" - ")
                            .append(golesVisitante).append(" ").append(equipos.get(j).getEquipo()).append("\n");
                }
            }
        }

        // Texto adicional debajo de los resultados
        resultados.append("\nEstos son los resultados aleatorizados de los partidos jugados.");

        // Mostrar resultados en el JTextArea de la vista
        vista.textResultados.setText(resultados.toString());
    }

    private void agregarEquipo() {
        String equipo = vista.txtEquipo.getText();
        String ciudad = vista.txtCiudad.getText();
        String entrenador = vista.txtEntrenador.getText();

        if (!equipo.isEmpty() && !ciudad.isEmpty() && !entrenador.isEmpty()) {
            Equipo nuevoEquipo = new Equipo(equipo, ciudad, entrenador);
            if (equipoDAO.agregarEquipo(nuevoEquipo)) {
                JOptionPane.showMessageDialog(vista, "Equipo agregado exitosamente.");
                limpiarCampos();
                mostrarEquipos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar el equipo.");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.");
        }
    }

    private void eliminarEquipos() {
        int[] filasSeleccionadas = vista.tablaEquipos.getSelectedRows(); // Obtener filas seleccionadas
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(vista, "No se seleccionó ningún equipo para eliminar.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar los equipos seleccionados?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                int fila = filasSeleccionadas[i];
                String nombreEquipo = (String) vista.tablaEquipos.getValueAt(fila, 0);
                if (equipoDAO.eliminarEquipoPorNombre(nombreEquipo)) {
                    vista.getModeloTabla().removeRow(fila); // Remover la fila del modelo
                }
            }
            JOptionPane.showMessageDialog(vista, "Equipos eliminados correctamente.");
            mostrarEquipos();
        }
    }

    private void mostrarEquipos() {
        vista.getModeloTabla().setRowCount(0); // Limpiar la tabla
        for (Equipo equipo : equipoDAO.obtenerEquipos()) {
            vista.getModeloTabla().addRow(new Object[]{equipo.getEquipo(), equipo.getCiudad(), equipo.getEntrenador()});
        }
    }

    private void limpiarCampos() {
        vista.txtEquipo.setText("");
        vista.txtCiudad.setText("");
        vista.txtEntrenador.setText("");
    }
}
