package com.example;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    private void agregarLibro(Libro libro) {
        for (Libro l : libros) {
            if (l.getISBN().equals(libro.getISBN())) {
                l.devolverLibro();
                return;
            }
        }
        libros.add(libro);
    }

    private void mostrarLibrosDisponibles() {
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                libro.mostrarInformacion();
                System.out.println();
            }
        }
    }

    private Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private ArrayList<Libro> buscarLibrosPorAutor(String autor) {
        ArrayList<Libro> librosPorAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosPorAutor.add(libro);
            }
        }
        return librosPorAutor;
    }

    private void eliminarLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null && libro.getCantidadDisponible() == 0) {
            libros.remove(libro);
        } else {
            System.out.println("El libro no puede ser eliminado, aún tiene copias disponibles.");
        }
    }

    private void prestarLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null && libro.isDisponible()) {
            libro.prestarLibro();
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    private void devolverLibro(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            libro.devolverLibro();
        }
    }

    //------------------------------------------------

    public void agregarLibroPublico(Libro libro) {
        agregarLibro(libro);
    }

    public void mostrarLibrosDisponiblesPublico() {
        mostrarLibrosDisponibles();
    }

    public Libro buscarLibroPorTituloPublico(String titulo) {
        return buscarLibroPorTitulo(titulo);
    }

    public ArrayList<Libro> buscarLibrosPorAutorPublico(String autor) {
        return buscarLibrosPorAutor(autor);
    }

    public void eliminarLibroPublico(String titulo) {
        eliminarLibro(titulo);
    }

    public void prestarLibroPublico(String titulo) {
        prestarLibro(titulo);
    }

    public void devolverLibroPublico(String titulo) {
        devolverLibro(titulo);
    }

    public void mostrarNombreBiblioteca() {
        System.out.println("Nombre de la Biblioteca: " + nombre);
    }
}
