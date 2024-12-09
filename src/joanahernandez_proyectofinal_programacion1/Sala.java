/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import javax.swing.*;
import java.awt.*;

/**
 * @author joana
 * Clase que gestiona la sala de cine, incluyendo los asientos disponibles.
 */
public class Sala {

    // Método para seleccionar una película y su horario
    public static void seleccionarPelicula(JFrame parent) {
        // Lista de películas disponibles
        String[] peliculas = {"Robot Salvaje", "La Idea De Ti", "Deadpool & Wolverine", "La Sustancia", "Alien: Romulus"};
        
        // Horarios correspondientes a cada película
        String[][] horarios = {
            {"12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"},
            {"1:00 PM", "4:00 PM", "7:00 PM"},
            {"11:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"},
            {"10:00 AM", "1:30 PM", "4:30 PM"},
            {"12:30 PM", "3:30 PM", "6:30 PM", "9:30 PM"}
        };

        // Creación de los ComboBoxes para seleccionar película y horario
        JComboBox<String> cmbPeliculas = new JComboBox<>(peliculas);
        JComboBox<String> cmbHorarios = new JComboBox<>();

        // Acción cuando se selecciona una película
        cmbPeliculas.addActionListener(e -> {
            // Limpiar horarios anteriores
            cmbHorarios.removeAllItems();
            int index = cmbPeliculas.getSelectedIndex(); // Obtener índice de la película seleccionada
            // Agregar los horarios correspondientes a la película seleccionada
            for (String horario : horarios[index]) {
                cmbHorarios.addItem(horario);
            }
        });

        // Establecer la primera película como seleccionada por defecto
        cmbPeliculas.setSelectedIndex(0);

        // Panel para mostrar los JComboBoxes
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Selecciona una Pelicula:"));
        panel.add(cmbPeliculas);
        panel.add(new JLabel("Selecciona un Horario:"));
        panel.add(cmbHorarios);

        // Mostrar el cuadro de diálogo para seleccionar película y horario
        int result = JOptionPane.showConfirmDialog(parent, panel, "Seleccionar Pelicula", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario acepta la selección, mostrar la película y el horario seleccionados
        if (result == JOptionPane.OK_OPTION) {
            String peliculaSeleccionada = (String) cmbPeliculas.getSelectedItem();
            String horarioSeleccionado = (String) cmbHorarios.getSelectedItem();
            JOptionPane.showMessageDialog(parent, "Has seleccionado: " + peliculaSeleccionada + " a las " + horarioSeleccionado);
        }
    }

    // Método para seleccionar un asiento en la sala
    public static void seleccionarAsiento(JFrame parent) {
        // Panel principal con diseño BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        // Etiqueta para representar la pantalla
        JLabel lblPantalla = new JLabel("****************** PANTALLA ******************", SwingConstants.CENTER);
        panel.add(lblPantalla, BorderLayout.NORTH);

        // Panel para los asientos (matriz de botones)
        JPanel panelAsientos = new JPanel(new GridLayout(6, 6, 5, 5)); // 6 filas x 6 columnas de asientos
        JButton[][] asientos = new JButton[5][5]; // 5 filas y 5 columnas de asientos

        // Crear los botones de los asientos y asignarles acción
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                asientos[i][j] = new JButton("D"); // "D" significa disponible
                asientos[i][j].setBackground(Color.GREEN); // Color verde para asientos disponibles

                // Acción para cambiar el estado del asiento al hacer clic
                int fila = i, columna = j;
                asientos[i][j].addActionListener(e -> {
                    if (asientos[fila][columna].getText().equals("D")) {
                        // Si el asiento está disponible, se reserva
                        asientos[fila][columna].setText("X");
                        asientos[fila][columna].setBackground(Color.RED); // Cambiar a color rojo para indicar que está reservado
                    } else {
                        // Si el asiento ya está reservado, mostrar mensaje
                        JOptionPane.showMessageDialog(parent, "Asiento ya reservado.");
                    }
                });
                // Agregar el botón del asiento al panel de asientos
                panelAsientos.add(asientos[i][j]);
            }
        }

        // Agregar el panel de asientos al panel principal
        panel.add(panelAsientos, BorderLayout.CENTER);

        // Mostrar el cuadro de diálogo para seleccionar un asiento
        int result = JOptionPane.showConfirmDialog(parent, panel, "Seleccionar Asiento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario acepta la selección, mostrar mensaje de éxito
        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(parent, "Asiento reservado con éxito.");
        }
    }
}
