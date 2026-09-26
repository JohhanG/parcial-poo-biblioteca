package com.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 1. Creación de libro1 (con constructor parametrizado) ===");
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 3, 1);
        System.out.println(libro1);

        System.out.println("\n=== 2. Creación de libro2 (por defecto y lectura por consola) ===");
        Libro libro2 = new Libro();

        System.out.print("Ingrese el título: ");
        libro2.setTitulo(scanner.nextLine());

        System.out.print("Ingrese el autor: ");
        libro2.setAutor(scanner.nextLine());

        System.out.print("Ingrese el total de ejemplares: ");
        libro2.setNumeroEjemplares(Integer.parseInt(scanner.nextLine()));

        System.out.print("Ingrese el número de ejemplares prestados: ");
        libro2.setNumeroEjemplaresPrestados(Integer.parseInt(scanner.nextLine()));

        System.out.println("\nDatos ingresados para libro2:");
        System.out.println(libro2);

        System.out.println("\n=== 3. Creación de libroTextoUNIAC ===");
        LibroTextoUNIAC libroUNIAC = new LibroTextoUNIAC(
            "Cálculo Diferencial", 
            "James Stewart", 
            5, 
            2, 
            "Cálculo I", 
            "Facultad de Ingeniería"
        );
        System.out.println(libroUNIAC);

        System.out.println("\n=== 4. Creación de novela indicando su tipo ===");
        Novela novela1 = new Novela(
            "Fundación", 
            "Isaac Asimov", 
            2, 
            1, 
            "Ciencia ficción"
        );
        System.out.println(novela1);

        System.out.println("\n=== PRUEBAS DE PRÉSTAMO Y DEVOLUCIÓN ===");
        
        // Prueba de préstamo con novela1 (tenía 2 ejemplares, 1 prestado -> 1 disponible)
        System.out.println("\nPréstamo 1 en novela1: " + novela1.prestamo()); // true (quedan 0 disp.)
        System.out.println(novela1);
        System.out.println("Préstamo 2 en novela1 (no hay disponibles): " + novela1.prestamo()); // false
        
        // Prueba de devolución
        System.out.println("\nDevolución 1 en novela1: " + novela1.devolucion()); // true
        System.out.println(novela1);

        scanner.close();
    }
}