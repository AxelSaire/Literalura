# Gestor de Libros 📚

Este proyecto fue desarrollado como parte del *Challenge de Gestión de Libros*, propuesto por Alura Latam en colaboración con Oracle dentro del programa ONE, como parte de la especialización en *Back-End*.

## Descripción 📝

El **Gestor de Libros** es una aplicación desarrollada en Java que permite gestionar información sobre libros y autores. A través de la aplicación, puedes:

- Buscar libros por título.
- Buscar autores por nombre.
- Listar libros y autores registrados.
- Consultar estadísticas generales sobre la base de datos de libros.
- Obtener información sobre libros y autores a través de una API externa (Gutendex).

La aplicación interactúa tanto con una base de datos local para almacenar libros y autores como con una API externa para obtener información adicional sobre libros y autores.

## Características principales ✨

- **Búsqueda avanzada:** Realiza consultas de libros por título, autores por nombre, y mucho más.
- **Listados detallados:** Accede a la lista de libros y autores registrados, incluyendo estadísticas de descargas y otros detalles relevantes.
- **Filtrado por características:** Filtra libros por idioma o consulta autores nacidos o fallecidos en un año específico.
- **API externa:** Consumo de la API **Gutendex** para obtener información sobre libros y autores.
- **Estadísticas generales:** Obtén métricas generales sobre los libros registrados.

## Tecnologías Utilizadas 💻

- **Lenguaje de Programación:** Java
- **API Externa:** [Gutendex](https://www.gutendex.com/) para obtener información sobre libros y autores.
- **Spring Framework:** Para gestionar la inyección de dependencias, servicios y acceso a la base de datos.
- **Base de Datos:** Base de datos local (por ejemplo, H2 o MySQL) para almacenar y gestionar la información de libros y autores.
- **Control de Versiones:** Git y GitHub para gestionar el código y colaborar.
- **IDE:** IntelliJ IDEA para escribir, depurar y ejecutar el código Java.

## Estructura del Proyecto 📂

### Clases principales

- **`Principal.java`**
  Punto de entrada de la aplicación. Gestiona la interacción con el usuario a través de la consola y presenta un menú para realizar las consultas sobre libros y autores.

  **Funcionalidades principales:**
  - Buscar libros por título.
  - Buscar autores por nombre.
  - Listar libros y autores registrados.
  - Listar autores vivos en un año determinado.
  - Listar libros por idioma.
  - Obtener estadísticas generales de la base de datos.
  - Listar los 10 libros más descargados.
  - Listar autores nacidos o fallecidos en algún año específico.

- **`ConsumoApi.java`**
  Clase encargada de realizar las consultas a la API externa (Gutendex) para obtener información sobre libros y autores.

- **`ConvierteDatos.java`**
  Se encarga de convertir la información obtenida desde la API externa en un formato adecuado para la aplicación, convirtiendo JSON a objetos Java.

- **`AutorRepository.java`**
  Repositorio que maneja las operaciones relacionadas con los autores en la base de datos, implementando las operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

### Clases Modelo y Mapeo de Entidades 🗃️

El proyecto utiliza varias clases modelo que representan las entidades del dominio, como **Libro** y **Autor**, mapeadas a tablas de la base de datos mediante JPA (Java Persistence API).

#### **`Autor.java`**
Representa a la entidad **Autor** en la base de datos, incluyendo atributos como nombre, fecha de nacimiento y fallecimiento, y una lista de libros asociados.

**Atributos principales:**
- `id`: Identificador único del autor.
- `nombre`: Nombre completo del autor.
- `fechaDeNacimiento`: Fecha de nacimiento del autor.
- `fechaDeFallecimiento`: Fecha de fallecimiento (si aplica).
- `libros`: Lista de libros escritos por el autor.

#### **`Datos.java`**
Esta clase mapea la respuesta JSON de la API. Contiene el total de resultados y una lista de objetos que representan los libros obtenidos desde la API.

**Atributos principales:**
- `total`: Número total de resultados devueltos por la API.
- `libros`: Lista de objetos **DatosLibro** que representan los libros.

#### **`DatosLibro.java`**
Representa la información detallada de un libro obtenida desde la API. Incluye atributos como el título, los autores, los idiomas y el número de descargas.

**Atributos principales:**
- `titulo`: Título del libro.
- `autores`: Lista de autores asociados al libro.
- `idiomas`: Idiomas en los que el libro está disponible.
- `numeroDeDescargas`: Número de descargas del libro.

## Mapeo de Entidades con JPA 📊

Las entidades del dominio (como **Autor** y **Libro**) se mapean a tablas de la base de datos utilizando las siguientes anotaciones de JPA:

- **`@Entity`**: Marca la clase como una entidad persistente.
- **`@Table`**: Especifica la tabla en la base de datos con la que se mapea la entidad.
- **`@Id`**: Marca el campo como la clave primaria de la entidad.
- **`@GeneratedValue`**: Define cómo se generarán los valores de la clave primaria.
- **`@Column`**: Especifica el mapeo de una columna en la base de datos.
- **`@OneToMany`**: Define una relación de uno a muchos entre dos entidades, como la relación entre un autor y sus libros.

Estas anotaciones permiten una gestión eficiente de las entidades en la base de datos, facilitando la interacción mediante repositorios y servicios de Spring.
