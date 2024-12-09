/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
/**
 *
 * @author joana
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class Dulceria {

    // Método para abrir la dulcería y permitir la selección de combos
    public static void abrirDulceria(JFrame parent) {
        // Lista de combos disponibles con sus precios
        String[] combos = {
            "Combo para 2 personas - $10",
            "Combo para 4 personas - $18",
            "Combo familiar - $25",
            "Palomitas y refresco - $7"
        };

        // Crear una lista (JList) que muestra los combos disponibles
        JList<String> listaCombos = new JList<>(combos);
        listaCombos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Permite seleccionar múltiples combos

        // Panel principal con un diseño BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        // Etiqueta informativa en la parte superior del panel
        panel.add(new JLabel("Selecciona los combos que deseas comprar:"), BorderLayout.NORTH);
        
        // Agregar la lista de combos al centro del panel dentro de un JScrollPane (para permitir desplazamiento)
        panel.add(new JScrollPane(listaCombos), BorderLayout.CENTER);

        // Mostrar el cuadro de diálogo con el panel de selección de combos
        int result = JOptionPane.showConfirmDialog(parent, panel, "Dulceria", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario presiona "OK", procesar la selección de combos
        if (result == JOptionPane.OK_OPTION) {
            // Obtener los combos seleccionados
            Object[] seleccionados;
            seleccionados = listaCombos.getSelectedValues();

            // Si se han seleccionado combos, mostrar el resumen
            if (seleccionados.length > 0) {
                StringBuilder mensaje = new StringBuilder("Has comprado:\n");
                // Recorrer los combos seleccionados y agregarlos al mensaje
                for (Object combo : seleccionados) {
                    mensaje.append(combo).append("\n");
                }
                // Mostrar el mensaje con los combos comprados
                JOptionPane.showMessageDialog(parent, mensaje.toString());
            } else {
                // Si no se ha seleccionado ningún combo, mostrar un mensaje de advertencia
                JOptionPane.showMessageDialog(parent, "Quien va sin palomitas al cine?");
            }
        }
    }
}