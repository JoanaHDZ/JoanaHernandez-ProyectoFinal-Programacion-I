/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import javax.swing.*;
/**
 *
 * @author joana
 */
public class JoanaHernandez_ProyectoFinal_Programacion1 {

    /**
     * @param args the command line arguments
     */

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine();
        Sala sala = new Sala(5, 5);
        Usuario usuario = new Usuario();
        Dulceria dulceria = new Dulceria();
        Pago pago = new Pago();

        String[] opciones = {"Inicio Sesión", "Seleccionar Pelicula", "Seleccionar Asientos", "Dulceria", "Pagar", "Salir"};
        boolean continuar = true;

        while (continuar) {
            int seleccion = JOptionPane.showOptionDialog(null, "Menu Principal Puntos acumulados: " + usuario.getPuntos(),
                    "Sistema de Reservas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0 -> usuario.iniciarSesion();
                case 1 -> {
                    StringBuilder peliculas = new StringBuilder("Películas disponibles:\n");
                    for (String pelicula : cine.getPeliculas()) {
                        peliculas.append("- ").append(pelicula).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, peliculas.toString());
                }
                case 2 -> {
                    sala.mostrarAsientos();
                    String filaStr = JOptionPane.showInputDialog("Selecciona la fila del asiento (1-5):");
                    String columnaStr = JOptionPane.showInputDialog("Selecciona la columna del asiento (1-5):");
                    try {
                        int fila = Integer.parseInt(filaStr) - 1;
                        int columna = Integer.parseInt(columnaStr) - 1;
                        if (sala.reservarAsiento(fila, columna)) {
                            JOptionPane.showMessageDialog(null, "Asiento reservado correctamente.");
                            usuario.agregarPuntos(10);
                        } else {
                            JOptionPane.showMessageDialog(null, "El asiento ya está reservado.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no válida.");
                    }
                }
                case 3 -> dulceria.comprarCombos(usuario);
                case 4 -> pago.procesarPago();
                case 5 -> {
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                }
            }
        }
    }
}

    
}
