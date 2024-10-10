package com.example;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaTest {
    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca("Biblioteca de Pruebas");
        libro1 = new Libro("La llamada de Cthulhu", "H. P. Lovecraft", "Terror", "12345", 3);
        libro2 = new Libro("Papaíto piernas largas", "Jean Webster", "Literatura juvenil", "67890", 10);
    }

    @Test
    void testAgregarLibro() {
        biblioteca.agregarLibroPublico(libro1);
        biblioteca.agregarLibroPublico(libro2);
        assertEquals(libro1, biblioteca.buscarLibroPorTituloPublico("La llamada de Cthulhu"));
        assertEquals(libro2, biblioteca.buscarLibroPorTituloPublico("Papaíto piernas largas"));
    }

    @Test
    void testPrestarLibro() {
        biblioteca.agregarLibroPublico(libro1);
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        assertEquals(2, libro1.getCantidadDisponible());
        assertTrue(libro1.isDisponible()); 
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        assertEquals(0, libro1.getCantidadDisponible());
        assertFalse(libro1.isDisponible()); 
    }

    @Test
    void testDevolverLibro() {
        biblioteca.agregarLibroPublico(libro1);
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        assertEquals(2, libro1.getCantidadDisponible());
        biblioteca.devolverLibroPublico("La llamada de Cthulhu");
        assertEquals(3, libro1.getCantidadDisponible());
        assertTrue(libro1.isDisponible());
    }

    @Test
    void testEliminarLibro() {
        biblioteca.agregarLibroPublico(libro1);
        biblioteca.eliminarLibroPublico("La llamada de Cthulhu");
        assertNotNull(biblioteca.buscarLibroPorTituloPublico("La llamada de Cthulhu"));
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        biblioteca.prestarLibroPublico("La llamada de Cthulhu");
        biblioteca.eliminarLibroPublico("La llamada de Cthulhu");
        assertNull(biblioteca.buscarLibroPorTituloPublico("La llamada de Cthulhu"));
    }

    @Test
    void testBuscarLibroPorAutor() {
        biblioteca.agregarLibroPublico(libro1);
        biblioteca.agregarLibroPublico(libro2);
        ArrayList<Libro> libros = biblioteca.buscarLibrosPorAutorPublico("H. P. Lovecraft");
        assertEquals(1, libros.size());
        assertEquals(libro1, libros.get(0));
        libros = biblioteca.buscarLibrosPorAutorPublico("Gabriel García Márquez");
        assertEquals(0, libros.size());
    }
}
