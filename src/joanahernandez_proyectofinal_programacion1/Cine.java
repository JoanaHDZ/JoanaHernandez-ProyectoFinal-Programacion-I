/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import javax.swing.*;
import java.awt.*;

/**
 * @author joana
 * Clase que gestiona las peliculas y sus horarios disponibles.
 */
public class Cine extends JFrame {

    private String usuario; // Variable para almacenar el nombre del usuario

    // Constructor de la clase Cine
    public Cine() {
        setTitle("Proyecto Final Programacion I - Joana Hernandez"); // Título de la ventana
        setSize(600, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportamiento de cierre de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout()); // Establece el layout de la ventana como BorderLayout

        // Panel de bienvenida
        JPanel panelBienvenida = new JPanel(new BorderLayout());
        JLabel lblBienvenida = new JLabel("<html><h1>Bienvenido/a al Cine</h1></html>", SwingConstants.CENTER); // Etiqueta de bienvenida
        lblBienvenida.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega un borde vacío alrededor de la etiqueta
        panelBienvenida.add(lblBienvenida, BorderLayout.CENTER); // Añade la etiqueta al panel de bienvenida

        // Panel de botones principales
        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 10, 10)); // Configura el panel con un diseño en grid (2 filas y 3 columnas)
        
        // Opciones de botones
        String[] opciones = {"Inicio Sesion", "Seleccionar Pelicula", "Seleccionar Asiento", "Dulceria", "Pagar", "Salir"};
        
        // Se crea un botón para cada opción y se le asigna una acción
        for (String opcion : opciones) {
            JButton btn = new JButton(opcion); // Crear el botón
            btn.addActionListener(e -> manejarBoton(opcion)); // Asigna la funcionalidad a cada botón
            panelBotones.add(btn); // Añade el botón al panel
        }

        // Añadir los paneles a la ventana
        add(panelBienvenida, BorderLayout.NORTH); // Panel de bienvenida en la parte superior
        add(panelBotones, BorderLayout.CENTER); // Panel de botones en el centro
    }

    // Método para iniciar el proceso, comenzando con la opción de inicio de sesión o invitado
    public void iniciarProceso() {
        usuario = Usuario.mostrarInicioSesion(this); // Llama al método para iniciar sesión

        if (usuario != null) {
            // Si el usuario no es nulo, muestra un mensaje de bienvenida y procede a la selección de película
            JOptionPane.showMessageDialog(this, "Bienvenido/a, " + usuario);
            seleccionarPelicula(); // Llama al método para seleccionar una película
        }
    }

    // Método que maneja las acciones de los botones según la opción seleccionada
    private void manejarBoton(String opcion) {
        switch (opcion) {
            case "Inicio Sesion":
                iniciarProceso(); // Iniciar sesión o continuar como invitado
                break;
            case "Seleccionar Pelicula":
                seleccionarPelicula(); // Llama al método para seleccionar una película
                break;
            case "Seleccionar Asiento":
                seleccionarAsiento(); // Llama al método para seleccionar asiento
                break;
            case "Dulceria":
                abrirDulceria(); // Llama al método para abrir la dulcería
                break;
            case "Pagar":
                procesarPago(); // Llama al método para procesar el pago
                break;
            case "Salir":
                System.exit(0); // Cierra la aplicación
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción no valida."); // Muestra un mensaje si la opción no es válida
        }
    }

    // Método para seleccionar una película
    private void seleccionarPelicula() {
        Sala.seleccionarPelicula(this); // Llama al método de la clase Sala para seleccionar una película
    }

    // Método para seleccionar un asiento
    private void seleccionarAsiento() {
        Sala.seleccionarAsiento(this); // Llama al método de la clase Sala para seleccionar un asiento
    }

    // Método para abrir la dulcería
    private void abrirDulceria() {
        Dulceria.abrirDulceria(this); // Llama al método de la clase Dulceria para gestionar la compra de snacks
    }

    // Método para procesar el pago
    private void procesarPago() {
        Pago.procesarPago(this); // Llama al método de la clase Pago para gestionar el pago
    }
}
