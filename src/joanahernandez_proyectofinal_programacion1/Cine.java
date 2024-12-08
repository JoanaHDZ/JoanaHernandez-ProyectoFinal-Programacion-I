/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joanahernandez_proyectofinal_programacion1;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *
 * @author joana
 */

public class Cine {
    private Map<String, List<String>> peliculasConHorarios;

    public Cine() {
        peliculasConHorarios = new LinkedHashMap<>(); // Mantener el orden de inserción
        generarPeliculasYHorarios();
    }

    private void generarPeliculasYHorarios() {
        String[] peliculasBase = {"La Sustancia", "Alien: Romulus", "Deadpool & Wolverine", "La Idea De Ti", "Robot Salvaje"};
        String[] horariosBase = {"12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"};

        for (String pelicula : peliculasBase) {
            peliculasConHorarios.put(pelicula, Arrays.asList(horariosBase));
        }
    }

    public List<String> getPeliculas() {
        return new ArrayList<>(peliculasConHorarios.keySet());
    }

    public List<String> getHorarios(String pelicula) {
        return peliculasConHorarios.getOrDefault(pelicula, Collections.emptyList());
    }
}