/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * @author joana
 * Clase que gestiona la informacion del usuario y sus puntos.
 */
public class Usuario {

    // Método que muestra la pantalla de inicio de sesión y permite elegir entre ingresar con cuenta o como invitado
    public static String mostrarInicioSesion(JFrame parent) {
        // Opciones de inicio de sesión
        Object[] opciones = {"Ingresar con cuenta", "Ingresar como invitado"};
        
        // Cuadro de diálogo para que el usuario seleccione una opción
        int seleccion = JOptionPane.showOptionDialog(parent,
                "Como deseas ingresar?", // Mensaje del cuadro de diálogo
                "Inicio de Sesion", // Título del cuadro de diálogo
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]); // Opciones para elegir

        // Si el usuario selecciona "Ingresar con cuenta"
        if (seleccion == 0) {
            return iniciarSesionConCuenta(parent);  // Llamar al método para iniciar sesión con cuenta
        } else {
            return "Invitado";  // Si elige "Ingresar como invitado", se retorna "Invitado"
        }
    }

    // Método para manejar el inicio de sesión con cuenta, solicitando nombre, correo y teléfono
    private static String iniciarSesionConCuenta(JFrame parent) {
        // Crear un panel con un diseño de cuadrícula (4 filas y 2 columnas)
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        // Crear campos de texto para nombre, correo y teléfono
        JTextField txtNombre = new JTextField();
        JTextField txtCorreo = new JTextField();
        JTextField txtTelefono = new JTextField();

        // Añadir etiquetas y campos de texto al panel
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Correo (incluye @):"));
        panel.add(txtCorreo);
        panel.add(new JLabel("Telefono (8 digitos):"));
        panel.add(txtTelefono);

        // Mostrar cuadro de diálogo con el formulario de inicio de sesión
        int result = JOptionPane.showConfirmDialog(parent, panel, "Inicio de Sesion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario presiona "OK", se verifican los datos ingresados
        if (result == JOptionPane.OK_OPTION) {
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();
            String telefono = txtTelefono.getText();

            // Verificar que el nombre no esté vacío, que el correo contenga "@" y que el teléfono tenga 8 dígitos
            if (!nombre.isEmpty() && correo.contains("@") && telefono.length() == 8) {
                return nombre;  // Si los datos son válidos, se retorna el nombre del usuario
            } else {
                // Si los datos no son válidos, mostrar un mensaje y reiniciar el proceso de inicio de sesión
                JOptionPane.showMessageDialog(parent, "Datos invalidos. Por favor, completa correctamente el formulario.");
                return iniciarSesionConCuenta(parent); // Reiniciar el proceso de inicio de sesión
            }
        }
        return null; // Si el usuario cancela el inicio de sesión, retornar null
    }
}
