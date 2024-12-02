/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import javax.swing.*;
/**
 *
 * @author joana
 */
public class Sala {
    private String[][] asientos;

    public Sala(int filas, int columnas) {
        asientos = new String[filas][columnas];
        inicializarAsientos();
    }

    private void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = "D"; // "D" para disponible
            }
        }
    }

    public void mostrarAsientos() {
        StringBuilder mapa = new StringBuilder("Estado de los asientos: ");
        for (String[] fila : asientos) {
            for (String asiento : fila) {
                mapa.append(asiento).append(" ");
            }
            mapa.append("\n");
        }
        JOptionPane.showMessageDialog(null, mapa.toString());
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna].equals("D")) {
                asientos[fila][columna] = "X";
                return true;
            }
        }
        return false;
    }
}


