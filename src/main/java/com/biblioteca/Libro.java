package com.biblioteca;

public class Libro {
    // Encapsulamiento: atributos privados
    private String titulo;
    private String autor;
    private int numeroEjemplares;
    private int numeroEjemplaresPrestados;

    // Constructor por defecto
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.numeroEjemplares = 0;
        this.numeroEjemplaresPrestados = 0;
    }

    // Constructor con parámetros
    public Libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroEjemplares = numeroEjemplares;
        this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public int getNumeroEjemplaresPrestados() {
        return numeroEjemplaresPrestados;
    }

    public void setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados) {
        this.numeroEjemplaresPrestados = numeroEjemplaresPrestados;
    }

    // Lógica de préstamo: solo se presta si hay ejemplares disponibles
    public boolean prestamo() {
        if (this.numeroEjemplaresPrestados < this.numeroEjemplares) {
            this.numeroEjemplaresPrestados++;
            return true;
        }
        return false;
    }

    // Lógica de devolución: solo se devuelve si hay ejemplares prestados
    public boolean devolucion() {
        if (this.numeroEjemplaresPrestados > 0) {
            this.numeroEjemplaresPrestados--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               " | Autor: " + autor +
               " | Ejemplares totales: " + numeroEjemplares +
               " | Prestados: " + numeroEjemplaresPrestados +
               " | Disponibles: " + (numeroEjemplares - numeroEjemplaresPrestados);
    }
}