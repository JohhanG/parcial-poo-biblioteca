# Sistema de Gestión de Biblioteca - Parcial I

**Asignatura:** Programación II  
**Tema Evaluado:** POO - Abstracción, Encapsulamiento y Herencia con Maven + Git  
**Grupo:** G412  
**Integrantes:**  
* Johhan González  
* Santiago Palma  

---

## Tabla de Contenido
1. [Marco Teórico Conceptual](#1-marco-teórico-conceptual)
   * 1.1. [Abstracción](#11-abstracción)
   * 1.2. [Encapsulamiento y Modificadores de Acceso](#12-encapsulamiento-y-modificadores-de-acceso)
   * 1.3. [Herencia y Jerarquía de Clases](#13-herencia-y-jerarquía-de-clases)
   * 1.4. [Polimorfismo y Sobrescritura (@Override)](#14-polimorfismo-y-sobrescritura-override)
   * 1.5. [Fundamentos de Apache Maven](#15-fundamentos-de-apache-maven)
   * 1.6. [Control de Versiones con Git y GitHub](#16-control-de-versiones-con-git-y-github)
2. [Diagrama de Clases UML](#2-diagrama-de-clases-uml)
3. [Estructura del Proyecto Maven](#3-estructura-del-proyecto-maven)
4. [Descripción y Responsabilidad de las Clases](#4-descripción-y-responsabilidad-de-las-clases)
5. [Casos de Prueba y Ejecución en Main](#5-casos-de-prueba-y-ejecución-en-main)
6. [Análisis de Escenarios donde Falla la Herencia](#6-análisis-de-escenarios-donde-falla-la-herencia)
7. [Atributos y Métodos Propuestos](#7-atributos-y-métodos-propuestos)
8. [Instrucciones de Compilación y Ejecución](#8-instrucciones-de-compilación-y-ejecución)

---

## 1. Marco Teórico Conceptual

### 1.1. Abstracción
La **abstracción** es el pilar de la POO que consiste en aislar y representar únicamente los atributos y comportamientos relevantes de una entidad del mundo real para el contexto de un sistema informático, descartando los detalles superfluos o irrelevantes.
* **Aplicación en el sistema:** Para la clase `Libro`, se abstrajeron las características fundamentales para la gestión bibliotecaria: `titulo`, `autor`, `numeroEjemplares` y `numeroEjemplaresPrestados`. Se omitieron detalles no operativos como el color de portada o el número de páginas. Asimismo, se abstrajeron las acciones clave a través de métodos funcionales: `prestamo()` y `devolucion()`.

### 1.2. Encapsulamiento y Modificadores de Acceso
El **encapsulamiento** es la técnica mediante la cual se empaquetan los datos (atributos) y el código que opera sobre ellos (métodos) en una sola unidad (clase), restringiendo el acceso directo a los componentes internos del objeto para prevenir inconsistencias y alteraciones indebidas.
* **Modificadores de acceso:**
  * `private`: Visibilidad exclusiva dentro de la misma clase. Garantiza que el estado de los objetos solo sea accesible mediante métodos de control.
  * `public`: Visibilidad accesible desde cualquier otra clase o paquete. Se utiliza en constructores, getters y setters para exponer una interfaz de uso segura.
* **Aplicación en el sistema:** Todos los atributos fueron declarados con visibilidad `private`. Para interactuar con ellos se definieron métodos accesores (`get`) y mutadores (`set`). Además, operaciones críticas como cambiar la cantidad de ejemplares prestados se encapsulan en las reglas de negocio de los métodos `prestamo()` y `devolucion()`.

### 1.3. Herencia y Jerarquía de Clases
La **herencia** permite que una clase derivada (subclase) herede atributos y métodos de una clase preexistente (superclase), promoviendo la reutilización de código y estableciendo una relación semántica del tipo **"es un"** (*is-a*).
* **Mecanismos en Java:**
  * `extends`: Palabra reservada utilizada para declarar que una clase deriva de otra.
  * `super()`: Invocación directa al constructor de la superclase para inicializar los atributos heredados antes de configurar los atributos propios de la subclase.
* **Aplicación en el sistema:** 
  * `LibroTexto` *es un* `Libro` que añade el atributo `curso`.
  * `LibroTextoUNIAC` *es un* `LibroTexto` que añade el atributo `facultad`.
  * `Novela` *es un* `Libro` que añade el atributo `tipo` (género literario).

### 1.4. Polimorfismo y Sobrescritura (@Override)
El **polimorfismo** permite que objetos de diferentes clases pertenecientes a la misma jerarquía respondan al mismo mensaje de manera especializada.
* **Anotación `@Override`:** Indica explícitamente al compilador que un método de la subclase está reemplazando la implementación de la superclase.
* **Aplicación en el sistema:** Se sobrescribió el método `toString()` en cada subclase, invocando `super.toString()` para obtener la representación general del libro y concatenándole la información especializada de cada variante.

### 1.5. Fundamentos de Apache Maven
**Apache Maven** es una herramienta de gestión de proyectos y automatización de compilación para entornos Java. Se basa en el concepto de un **Project Object Model (POM)** definido en el archivo `pom.xml`.
* **Convención sobre configuración:** Maven establece una estructura de directorios estandarizada (`src/main/java` para código fuente y `src/main/resources` para recursos).
* **Ciclo de vida:** Gestiona fases secuenciales como `validate`, `compile`, `test`, `package` e `install`.

### 1.6. Control de Versiones con Git y GitHub
**Git** es un sistema de control de versiones distribuido que rastrea cambios en el código fuente a lo largo del tiempo, facilitando el trabajo colaborativo sin pérdida de datos.
* **Conceptos clave utilizados en el parcial:**
  * **Ramas (*Branches*):** Líneas de desarrollo independientes creadas para cada desarrollador (`Johhan-Gonzalez`, `Santiago-Palma`).
  * **Commits semánticos y atómicos:** Registro individual de cada clase o cambio funcional para evidenciar la contribución de cada integrante.
  * **Merge:** Operación de integración que fusiona los cambios de una rama secundaria dentro de otra rama o de `main`.

---

## 2. Diagrama de Clases UML (0.5)

El siguiente diagrama modela la jerarquía de herencia y especifica los modificadores de acceso (`-` privado, `+` público) junto con los tipos de datos:

```mermaid
classDiagram
    class Libro {
        -String titulo
        -String autor
        -int numeroEjemplares
        -int numeroEjemplaresPrestados
        +Libro()
        +Libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados)
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
        +LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso)
        +getCurso() String
        +setCurso(String curso) void
        +toString() String
    }

    class LibroTextoUNIAC {
        -String facultad
        +LibroTextoUNIAC()
        +LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso, String facultad)
        +getFacultad() String
        +setFacultad(String facultad) void
        +toString() String
    }

    class Novela {
        -String tipo
        +Novela()
        +Novela(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String tipo)
        +getTipo() String
        +setTipo(String tipo) void
        +toString() String
    }

    Libro <|-- LibroTexto : extends
    LibroTexto <|-- LibroTextoUNIAC : extends
    Libro <|-- Novela : extends

    Libro <|-- LibroTexto : extends
    LibroTexto <|-- LibroTextoUNIAC : extends
    Libro <|-- Novela : extends
