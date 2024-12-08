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
        StringBuilder mapa = new StringBuilder();
        
        // Agregar pantalla en la parte superior
        mapa.append("      Pantalla\n ");
        
        // Agregar las filas de asientos
        mapa.append("   ");
        for (int j = 0; j < asientos[0].length; j++) {
            mapa.append(j + 1).append(" ");
        }
        mapa.append("\n");

        for (int i = 0; i < asientos.length; i++) {
            mapa.append(i + 1).append("  ");
            for (int j = 0; j < asientos[i].length; j++) {
                mapa.append(asientos[i][j]).append(" ");
            }
            mapa.append("\n");
        }
        
        // Mostrar el mapa completo
        JOptionPane.showMessageDialog(null, mapa.toString());
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna].equals("D")) {
                asientos[fila][columna] = "X"; // "X" para reservado
                return true;
            }
        }
        return false;
    }

    public int contarAsientosReservados() {
        int count = 0;
        for (String[] fila : asientos) {
            for (String asiento : fila) {
                if (asiento.equals("X")) {
                    count++;
                }
            }
        }
        return count;
    }
}
