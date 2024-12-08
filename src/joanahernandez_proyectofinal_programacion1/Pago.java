/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;

/**
 *
 * @author joana
 */

import javax.swing.*;

public class Pago {
    public void procesarPago() {
        String tarjeta = JOptionPane.showInputDialog("Introduce el numero de tu tarjeta (8 dígitos):");

        if (tarjeta != null && tarjeta.length()==8) {
            JOptionPane.showMessageDialog(null, "Pago procesado exitosamente. Gracias por tu compra!");
        } else {
            JOptionPane.showMessageDialog(null, "Numero de tarjeta invalido.");
        }
    }
}