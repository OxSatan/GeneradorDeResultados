package vista;

import modelo.Equipo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class VentanaPartido extends JFrame {
    // Componentes de la interfaz gráfica
    private JComboBox<Equipo> comboBoxLocal;       
    private JComboBox<Equipo> comboBoxVisitante;   
    private JTextField txtGolesLocal;              
    private JTextField txtGolesVisitante;          
    private JButton btnRegistrar;                  
    private JButton btnResultadosAleatorios;       
    private JTextArea txtAreaResultados;           
    private JScrollPane scrollPane;                

    public VentanaPartido(List<Equipo> equipos) {
        setTitle("Seleccionar Equipos para el Partido");
        setSize(400, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); 

        // Inicialización de JComboBox con la lista de equipos recibida
        comboBoxLocal = new JComboBox<>(equipos.toArray(new Equipo[0]));
        comboBoxVisitante = new JComboBox<>(equipos.toArray(new Equipo[0]));
        txtGolesLocal = new JTextField();
        txtGolesVisitante = new JTextField();
        btnRegistrar = new JButton("Registrar Resultado");
        btnResultadosAleatorios = new JButton("Generar Resultados Aleatorios");

        // Configuración del área de resultados y scroll
        txtAreaResultados = new JTextArea(10, 30);  // Muestra los resultados de cada partido
        txtAreaResultados.setEditable(false);       
        scrollPane = new JScrollPane(txtAreaResultados);

        // Panel con diseño  (GridLayout) para los elementos de entrada
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2));
        panelFormulario.add(new JLabel("Equipo Local:"));
        panelFormulario.add(comboBoxLocal);
        panelFormulario.add(new JLabel("Goles Local:"));
        panelFormulario.add(txtGolesLocal);
        panelFormulario.add(new JLabel("Equipo Visitante:"));
        panelFormulario.add(comboBoxVisitante);
        panelFormulario.add(new JLabel("Goles Visitante:"));
        panelFormulario.add(txtGolesVisitante);
        panelFormulario.add(btnRegistrar);
        panelFormulario.add(btnResultadosAleatorios);

        // Añade el panel de formulario y el scroll pane en la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Evento para el botón de registrar resultado manual
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarResultado(); // Llama a la función de registro manual
            }
        });

        // Evento para el botón de resultados aleatorios
        btnResultadosAleatorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarResultadoAleatorio(); // Llama a la función de resultados aleatorios
            }
        });
    }

    private void registrarResultado() {
        Equipo equipoLocal = (Equipo) comboBoxLocal.getSelectedItem();      
        Equipo equipoVisitante = (Equipo) comboBoxVisitante.getSelectedItem(); 

        if (equipoLocal.equals(equipoVisitante)) {
            JOptionPane.showMessageDialog(this, "No se puede jugar un partido contra el mismo equipo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int golesLocal;
        int golesVisitante;

        try {
            golesLocal = Integer.parseInt(txtGolesLocal.getText());
            golesVisitante = Integer.parseInt(txtGolesVisitante.getText());

            if (golesLocal < 0 || golesVisitante < 0) {
                JOptionPane.showMessageDialog(this, "Los goles no pueden ser negativos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Muestra el resultado en el área de texto
            String resultado = String.format("%s %d - %d %s", equipoLocal.getEquipo(), golesLocal, golesVisitante, equipoVisitante.getEquipo());
            txtAreaResultados.append(resultado + "\n");

            // Limpia los campos para otro ingreso
            txtGolesLocal.setText("");
            txtGolesVisitante.setText("");
            comboBoxLocal.setSelectedIndex(0);
            comboBoxVisitante.setSelectedIndex(0);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos para los goles.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarResultadoAleatorio() {
        Equipo equipoLocal = (Equipo) comboBoxLocal.getSelectedItem();      
        Equipo equipoVisitante = (Equipo) comboBoxVisitante.getSelectedItem(); 

        if (equipoLocal.equals(equipoVisitante)) {
            JOptionPane.showMessageDialog(this, "No se puede jugar un partido contra el mismo equipo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Random rand = new Random();
        int golesLocal = rand.nextInt(6);
        int golesVisitante = rand.nextInt(6);

        String resultado = String.format("%s %d - %d %s", equipoLocal.getEquipo(), golesLocal, golesVisitante, equipoVisitante.getEquipo());
        txtAreaResultados.append(resultado + "\n");
    }
}
