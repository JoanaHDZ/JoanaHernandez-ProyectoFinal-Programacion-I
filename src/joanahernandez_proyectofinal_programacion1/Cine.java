/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author joana
 */
public class Cine {
    private List<String> peliculas;
    private List<String> horarios;

    public Cine() {
        peliculas = new ArrayList<>();
        horarios = new ArrayList<>();
        generarPeliculasYHorarios();
    }

    private void generarPeliculasYHorarios() {
        String[] peliculasBase = {"Accion Explosiva", "Romance en Paris", "Terror en la Noche", "Comedia Divertida", "Fantasía epica"};
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            peliculas.add(peliculasBase[random.nextInt(peliculasBase.length)]);
        }
        horarios.add("12:00 PM");
        horarios.add("3:00 PM");
        horarios.add("6:00 PM");
        horarios.add("9:00 PM");
    }

    public List<String> getPeliculas() {
        return peliculas;
    }
}


