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

public class Usuario {
    private String nombre;
    private String correo;
    private String telefono;
    private int puntos;

    public Usuario() {
        this.puntos = 0; // Inicia con 0 puntos
    }

    public void iniciarSesion() {
        String[] opciones = {"Crear Cuenta", "Iniciar como Invitado"};
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opcion:", "Inicio de Sesion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            crearCuenta();
        } else if (seleccion == 1) {
            JOptionPane.showMessageDialog(null, "Has iniciado sesion como invitado.");
        } else {
            JOptionPane.showMessageDialog(null, "Inicio de sesion cancelado.");
        }
    }

    public void crearCuenta() {
        nombre = JOptionPane.showInputDialog("Ingresa tu nombre:");
        correo = JOptionPane.showInputDialog("Ingresa tu correo electronico (recuerda poner el @):");
        telefono = JOptionPane.showInputDialog("Ingresa tu numero de teléfono (8 digitos) :");

        if (nombre != null && correo != null && telefono != null && 
            !nombre.isEmpty() && correo.contains("@") && telefono.length()==8) {
            JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.\nBienvenido, " + nombre + "!");
        } else {
            JOptionPane.showMessageDialog(null, "Datos invalidos. Intenta nuevamente.");
            crearCuenta();
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }
}
