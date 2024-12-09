/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;

import java.awt.GridLayout;
import javax.swing.*;

/**
 * Clase que gestiona el procesamiento del pago.
 * @author joana
 */
public class Pago {

    // Método estático que procesa el pago
    public static void procesarPago(JFrame parent) {
        // Panel para contener los campos de entrada
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10)); // Usamos GridLayout para organizar los componentes

        // Campos de texto para ingresar el número de tarjeta y el CVV
        JTextField txtTarjeta = new JTextField();
        JTextField txtCVV = new JTextField();

        // Añadir los componentes al panel
        panel.add(new JLabel("Número de Tarjeta (8 digitos):")); // Etiqueta para el número de tarjeta
        panel.add(txtTarjeta); // Campo para ingresar el número de tarjeta
        panel.add(new JLabel("CVV (3 digitos):")); // Etiqueta para el CVV
        panel.add(txtCVV); // Campo para ingresar el CVV

        // Mostrar el cuadro de diálogo con el panel de entrada
        int result = JOptionPane.showConfirmDialog(parent, panel, "Procesar Pago", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario presiona OK, se procesan los datos ingresados
        if (result == JOptionPane.OK_OPTION) {
            String tarjeta = txtTarjeta.getText(); // Obtener el texto del campo de tarjeta
            String cvv = txtCVV.getText(); // Obtener el texto del campo de CVV

            // Validar que la tarjeta tenga 8 dígitos y el CVV 3 dígitos
            if (tarjeta.length() == 8 && cvv.length() == 3) {
                // Si los datos son válidos, se muestra un mensaje de éxito
                JOptionPane.showMessageDialog(parent, "Pago procesado exitosamente. Disfruta tu pelicula!");
            } else {
                // Si los datos son incorrectos, se muestra un mensaje de error
                JOptionPane.showMessageDialog(parent, "Datos de pago invalidos. Por favor, verifica la informacion.");
            }
        }
    }
}

