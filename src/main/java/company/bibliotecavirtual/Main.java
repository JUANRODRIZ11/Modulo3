/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package company.bibliotecavirtual;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 50496
 */
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Añadir algunos libros a la biblioteca
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605, "Novela");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "Novela");
        Libro libro3 = new Libro("1984", "George Orwell", 1949, "Distopía");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Menú interactivo
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú de Biblioteca Virtual:");
            System.out.println("1. Mostrar libros disponibles");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Agregar un libro");
            System.out.println("5. Buscar un libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("\nLibros disponibles en la biblioteca:");
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro que desea prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    if (biblioteca.prestarLibro(tituloPrestar)) {
                        System.out.println("'" + tituloPrestar + "' ha sido prestado correctamente.");
                    } else {
                        System.out.println("'" + tituloPrestar + "' no está disponible.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro que desea devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    if (biblioteca.devolverLibro(tituloDevolver)) {
                        System.out.println("'" + tituloDevolver + "' ha sido devuelto correctamente.");
                    } else {
                        System.out.println("'" + tituloDevolver + "' no estaba prestado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título del nuevo libro: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del nuevo libro: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del nuevo libro: ");
                    int nuevoAnio = scanner.nextInt();
                    scanner.nextLine(); // Consumir nueva línea
                    System.out.print("Ingrese el género del nuevo libro: ");
                    String nuevoGenero = scanner.nextLine();
                    Libro nuevoLibro = new Libro(nuevoTitulo, nuevoAutor, nuevoAnio, nuevoGenero);
                    biblioteca.agregarLibro(nuevoLibro);
                    System.out.println("Libro '" + nuevoTitulo + "' agregado correctamente.");
                    break;
                case 5:
                    System.out.println("Buscar un libro por:");
                    System.out.println("1. Título");
                    System.out.println("2. Autor");
                    System.out.println("3. Año de publicación");
                    System.out.print("Seleccione una opción: ");
                    int opcionBusqueda = scanner.nextInt();
                    scanner.nextLine(); // Consumir nueva línea

                    ArrayList<Libro> resultados = new ArrayList<>();
                    switch (opcionBusqueda) {
                        case 1:
                            System.out.print("Ingrese el título del libro: ");
                            String tituloBusqueda = scanner.nextLine();
                            resultados = biblioteca.buscarLibroPorTitulo(tituloBusqueda);
                            break;
                        case 2:
                            System.out.print("Ingrese el autor del libro: ");
                            String autorBusqueda = scanner.nextLine();
                            resultados = biblioteca.buscarLibroPorAutor(autorBusqueda);
                            break;
                        case 3:
                            System.out.print("Ingrese el año de publicación del libro: ");
                            int anioBusqueda = scanner.nextInt();
                            resultados = biblioteca.buscarLibroPorAnio(anioBusqueda);
                            break;
                        default:
                            System.out.println("Opción de búsqueda no válida. Intente nuevamente.");
                            continue;
                    }

                    System.out.println("Resultados de la búsqueda:");
                    for (Libro libro : resultados) {
                        System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Año: " + libro.getAnioPublicacion() + ", Género: " + libro.getGenero());
                    }
                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron libros que coincidan con la búsqueda.");
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo de la biblioteca virtual...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
