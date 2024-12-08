/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author joana
 */
public class Dulceria {
    public void comprarCombos(Usuario usuario) {
        String[] combos = {"Combo para 2 personas - $10", "Combo para 4 personas - $18"};
        List<String> seleccionados = new ArrayList<>();
        int continuar;

        do {
            String combo = (String) JOptionPane.showInputDialog(null, "Selecciona un combo:",
                    "Dulceria", JOptionPane.QUESTION_MESSAGE, null, combos, combos[0]);

            if (combo != null) {
                seleccionados.add(combo);
                JOptionPane.showMessageDialog(null, "Has aniadido: " + combo);
            }

            continuar = JOptionPane.showConfirmDialog(null, "Quieres comprar otro combo?");
        } while (continuar == JOptionPane.YES_OPTION);

        if (!seleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Resumen de tu compra:\n" + String.join("\n", seleccionados));
            usuario.agregarPuntos(5); // Recompensa por compra
        }
    }
}


