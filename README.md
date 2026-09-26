# Parcial 1 Programación 2 412

**Integrantes:**
* JOHHAN GONZÁLEZ.
* SANTIAGO PALMA.

---

### 1. Construya el diagrama UML de clases del ejercicio anterior.

```mermaid
classDiagram
    class Libro {
        - String titulo
        - String autor
        - int numeroEjemplares
        - int numeroEjemplaresPrestados
        + Libro()
        + Libro(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados)
        + getTitulo() : String
        + setTitulo(String titulo) : void
        + getAutor() : String
        + setAutor(String autor) : void
        + getNumeroEjemplares() : int
        + setNumeroEjemplares(int numeroEjemplares) : void
        + getNumeroEjemplaresPrestados() : int
        + setNumeroEjemplaresPrestados(int numeroEjemplaresPrestados) : void
        + prestamo() : boolean
        + devolucion() : boolean
        + toString() : String
    }

    class LibroTexto {
        - String curso
        + LibroTexto()
        + LibroTexto(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso)
        + getCurso() : String
        + setCurso(String curso) : void
        + toString() : String
    }

    class Novela {
        - String tipo
        + Novela()
        + Novela(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String tipo)
        + getTipo() : String
        + setTipo(String tipo) : void
        + toString() : String
    }

    class LibroTextoUNIAC {
        - String facultad
        + LibroTextoUNIAC()
        + LibroTextoUNIAC(String titulo, String autor, int numeroEjemplares, int numeroEjemplaresPrestados, String curso, String facultad)
        + getFacultad() : String
        + setFacultad(String facultad) : void
        + toString() : String
    }

2. Algoritmo en Java implementado (Código fuente)
El código fuente completo con estructura Maven se encuentra en la ruta:

src/main/java/com/biblioteca/

Libro.java: Superclase base con encapsulamiento, constructores sobrecargados, getters/setters y los métodos de negocio prestamo() y devolucion().

LibroTexto.java: Subclase que hereda de Libro y agrega el atributo curso.

LibroTextoUNIAC.java: Subclase que hereda de LibroTexto y añade el atributo facultad.

Novela.java: Subclase que hereda de Libro y gestiona el atributo tipo (género literario).

Main.java: Clase de ejecución principal.

3. Construcción de los 4 objetos y pruebas en Main.java
Objeto libro1: Creado utilizando el constructor con parámetros.

Objeto libro2: Creado con el constructor por defecto y captura de datos por consola (Scanner).

Objeto libroTextoUNIAC: Creado con todos sus atributos (heredados y propios).

Objeto novela: Creado especificando su tipo/género literario.

Pruebas de métodos: Se ejecutan los métodos prestamo() y devolucion() validando los límites de ejemplares disponibles y prestados.

    Libro <|-- LibroTexto
    Libro <|-- Novela
    LibroTexto <|-- LibroTextoUNIAC


    4. Dentro de su código identifique 2 situaciones en las que no se podría realizar la herencia. (por ejemplo: modificadores de acceso, clases finales, entre otras).
Situación 1: Uso del modificador final en la clase base:

R// public final class Libro { // Atributos y métodos }

Falla / Explicación: La palabra clave final impide explícitamente que una clase sea extendida por otra. Si la clase Libro se declara como final, las subclases como LibroTexto o Novela generarán un error de compilación (cannot inherit from final Libro).

Situación 2: Constructor privado o sin visibilidad de superclase disponible:

R// public class Libro { private Libro() { // Constructor privado } }

Falla / Explicación: Al declarar un único constructor con visibilidad privada en la clase Libro, las subclases (LibroTexto, Novela) no podrán invocar explícitamente ni implícitamente a super(). Como resultado, el compilador emitirá un error indicando que Libro() tiene acceso privado en Libro.

5. Mencione dos nuevos atributos que se puedan agregar al ejercicio y un método adicional que tengan sentido y se puedan implementar.
R// Nuevos Atributos:

isbn (String): Identificador único internacional normalizado del libro para evitar confusiones entre ediciones o libros con títulos homónimos.

precioAlquiler (double): Costo asociado al préstamo diario del libro para el cálculo de cobros en biblioteca.

Método Adicional:

calcularMulta(int diasRetraso, double tarifaPorDia):

Descripción: Calcula y retorna la sanción económica aplicable cuando un usuario devuelve un libro fuera de la fecha límite estipulada (diasRetraso * tarifaPorDia).
