/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author joana
 */

public class JoanaHernandez_ProyectoFinal_Programacion1 {

    /**
     * @param args the command line arguments
     */  
   public static void main(String[] args) {
        Cine cine = new Cine();
        Sala sala = new Sala(5, 5);
        Usuario usuario = new Usuario();
        Dulceria dulceria = new Dulceria();
        Pago pago = new Pago();

        String[] opciones = {"Inicio Sesion", "Seleccionar Pelicula y Horario", "Seleccionar Asientos", "Dulceria", "Pagar", "Salir"};
        boolean continuar = true;

        String peliculaSeleccionada = null;
        String horarioSeleccionado = null;

        while (continuar) {
            int seleccion = JOptionPane.showOptionDialog(null, "Menu Principal\nPuntos acumulados: " + usuario.getPuntos(),
                    "Bienvenido/a al sistema de reservas no-oficial de UNITEC", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0 -> usuario.iniciarSesion();

                case 1 -> {
                    // Mostrar lista numerada de películas
                    StringBuilder peliculas = new StringBuilder("Selecciona una pelicula:\n");
                    int index = 1;
                    for (String pelicula : cine.getPeliculas()) {
                        peliculas.append(index++).append(". ").append(pelicula).append("\n");
                    }

                    String seleccionPelicula = JOptionPane.showInputDialog(peliculas.toString());
                    try {
                        int peliculaIndex = Integer.parseInt(seleccionPelicula) - 1;
                        if (peliculaIndex >= 0 && peliculaIndex < cine.getPeliculas().size()) {
                            peliculaSeleccionada = cine.getPeliculas().get(peliculaIndex);

                            // Mostrar lista numerada de horarios
                            StringBuilder horarios = new StringBuilder("Selecciona un horario para " + peliculaSeleccionada + ":\n");
                            List<String> horariosDisponibles = cine.getHorarios(peliculaSeleccionada);
                            index = 1;
                            for (String horario : horariosDisponibles) {
                                horarios.append(index++).append(". ").append(horario).append("\n");
                            }

                            String seleccionHorario = JOptionPane.showInputDialog(horarios.toString());
                            int horarioIndex = Integer.parseInt(seleccionHorario) - 1;

                            if (horarioIndex >= 0 && horarioIndex < horariosDisponibles.size()) {
                                horarioSeleccionado = horariosDisponibles.get(horarioIndex);
                                JOptionPane.showMessageDialog(null, "Has seleccionado: " + peliculaSeleccionada + " a las " + horarioSeleccionado);
                            } else {
                                JOptionPane.showMessageDialog(null, "Horario no valido.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Pelicula no valida.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no valida.");
                    }
                }

                case 2 -> {
                    if (peliculaSeleccionada == null || horarioSeleccionado == null) {
                        JOptionPane.showMessageDialog(null, "Primero debes seleccionar una pelicula y un horario.");
                        continue;
                    }

                    sala.mostrarAsientos();
                    String filaStr = JOptionPane.showInputDialog("Selecciona la fila del asiento (1-5):");
                    String columnaStr = JOptionPane.showInputDialog("Selecciona la columna del asiento (1-5):");
                    try {
                        int fila = Integer.parseInt(filaStr) - 1;
                        int columna = Integer.parseInt(columnaStr) - 1;
                        if (sala.reservarAsiento(fila, columna)) {
                            JOptionPane.showMessageDialog(null, "Asiento reservado correctamente para " +
                                    peliculaSeleccionada + " a las " + horarioSeleccionado);
                            usuario.agregarPuntos(10);
                        } else {
                            JOptionPane.showMessageDialog(null, "El asiento ya esta reservado.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no valida.");
                    }
                }

                case 3 -> dulceria.comprarCombos(usuario);
                case 4 -> pago.procesarPago();
                case 5 -> {
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Disfruta tu pelicula!");
                }
            }
        }
    }
}
