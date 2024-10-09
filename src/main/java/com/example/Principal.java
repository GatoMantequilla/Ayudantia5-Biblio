package com.example;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        Libro libro1 = new Libro("La llamada de Cthulhu", "H. P. Lovecraft", "Terror", "12345", 3);
        Libro libro2 = new Libro("Papaíto piernas largas", "Jean Webster", "Literatura juvenil", "67890", 10);

        biblioteca.agregarLibroPublico(libro1);
        biblioteca.agregarLibroPublico(libro2);

        System.out.println("Libros disponibles:");
        biblioteca.mostrarLibrosDisponiblesPublico();

        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        System.out.println("\nDespués de prestar un libro:");
        biblioteca.mostrarLibrosDisponiblesPublico();

        biblioteca.devolverLibroPublico("Papaíto piernas largas");
        System.out.println("\nDespués de devolver el libro:");
        biblioteca.mostrarLibrosDisponiblesPublico();

        System.out.println("\nBuscando libro por título:");
        Libro libroBuscado = biblioteca.buscarLibroPorTituloPublico("Papaíto piernas largas");
        if (libroBuscado != null) {
            libroBuscado.mostrarInformacion();
        }

        System.out.println("\nBuscando libros por autor:");
        ArrayList<Libro> librosPorAutor = biblioteca.buscarLibrosPorAutorPublico("Gabriel García Márquez");
        for (Libro libro : librosPorAutor) {
            libro.mostrarInformacion();
        }

        biblioteca.eliminarLibroPublico("La llamada de Cthulhu");
        System.out.println("\nDespués de eliminar un libro:");
        biblioteca.mostrarLibrosDisponiblesPublico();
    }
}
