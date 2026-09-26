# Sistema de Gestión de Biblioteca - Parcial I (Programación II)

**Asignatura:** Programación II  
**Tema:** POO - Abstracción, Encapsulamiento y Herencia con Maven + Git  
**Grupo:** G412  
**Integrantes:**  
* Johhan González  
* Santiago Palma  

---

## 1. Descripción del Proyecto

Este proyecto implementa un sistema orientado a objetos en Java bajo el gestor de dependencias **Apache Maven** y versionado con **Git/GitHub**. El sistema administra el inventario, préstamo y devolución de distintos tipos de libros aplicando los principios fundamentales de la Programación Orientada a Objetos:

* **Abstracción:** Modelado de las características y comportamientos esenciales del mundo real (`Libro`, `LibroTexto`, `LibroTextoUNIAC`, `Novela`).
* **Encapsulamiento:** Protección del estado interno de los objetos mediante visibilidad `private` y acceso controlado a través de métodos `get` y `set`.
* **Herencia:** Reutilización y jerarquización de código extendiendo las funcionalidades de la clase base `Libro` hacia clases especializadas mediante `extends` y llamadas al constructor padre con `super()`.

---

## 2. Diagrama de Clases UML (0.5)

```mermaid
classDiagram
    class Libro {
        -String titulo
        -String autor
        -int numeroEjemplares
        -int numeroEjemplaresPrestados
        +Libro()
        +Libro(String titulo, String autor, int ejemplares, int prestados)
        +getTitulo() String
        +setTitulo(String titulo) void
        +getAutor() String
        +setAutor(String autor) void
        +getNumeroEjemplares() int
        +setNumeroEjemplares(int numeroEjemplares) void
        +getNumeroEjemplaresPrestados() int
        +setNumeroEjemplaresPrestados(int prestados) void
        +prestamo() boolean
        +devolucion() boolean
        +toString() String
    }

    class LibroTexto {
        -String curso
        +LibroTexto()
        +LibroTexto(String titulo, String autor, int ejemplares, int prestados, String curso)
        +getCurso() String
        +setCurso(String curso) void
        +toString() String
    }

    class LibroTextoUNIAC {
        -String facultad
        +LibroTextoUNIAC()
        +LibroTextoUNIAC(String titulo, String autor, int ejemplares, int prestados, String curso, String facultad)
        +getFacultad() String
        +setFacultad(String facultad) void
        +toString() String
    }

    class Novela {
        -String tipo
        +Novela()
        +Novela(String titulo, String autor, int ejemplares, int prestados, String tipo)
        +getTipo() String
        +setTipo(String tipo) void
        +toString() String
    }

    Libro <|-- LibroTexto : extends
    LibroTexto <|-- LibroTextoUNIAC : extends
    Libro <|-- Novela : extends
