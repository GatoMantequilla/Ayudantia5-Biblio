package com.example;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private String ISBN;
    private int cantidadDisponible;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero, String ISBN, int cantidadDisponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ISBN = ISBN;
        this.cantidadDisponible = cantidadDisponible;
        this.disponible = cantidadDisponible > 0; 
    }

    private void prestar() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
            if (cantidadDisponible == 0) {
                disponible = false;
            }
        } else {
            System.out.println("No hay copias disponibles de este libro.");
        }
    }

    private void devolver() {
        cantidadDisponible++;
        disponible = true;
    }

    private void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Cantidad disponible: " + cantidadDisponible);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
    
    public void prestarLibro() {
        prestar();
    }

    public void devolverLibro() {
        devolver();
    }

    public void mostrarInformacion() {
        mostrarInfo();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
