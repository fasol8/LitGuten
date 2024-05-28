# LitGuten

Este es un proyecto de ejemplo que muestra cómo trabajar con libros y autores en una aplicación de biblioteca.

## Descripción

LitGuten es una aplicación en consola de biblioteca que permite administrar libros y autores. Proporciona endpoints para obtener información sobre los libros, los autores y realizar algunas consultas específicas.

## Requisitos

- Java 8 o superior
- Maven
- MySQL

## Configuración

1. Clona este repositorio en tu máquina local.
2. Configura la base de datos MySQL. Ejecuta el script `database.sql` proporcionado en el directorio `db` para crear la base de datos y las tablas necesarias.
3. Actualiza el archivo `application.properties` en el directorio `src/main/resources` con la configuración de tu base de datos MySQL.

## Endpoints

- `/book`: Busca y guarda un libro en la base de datos.
- `/books`: Obtiene todos los libros en la base de datos.
- `/authors`: Obtiene todos los autores en la base de datos.
- `/authors/birthyear/{year}`: Obtiene los autores nacidos a partir de un año dado.
- `/books/{language}/count`: Obtiene el número de libros por idioma.

## Ejemplos de Uso

### Busca y guarda libro
<img src="URL_DE_LA_IMAGEN" alt="Captura de pantalla del Litguten menu 1">

### Obtener todos los libros
<img src="URL_DE_LA_IMAGEN" alt="Captura de pantalla del Litguten menu 2">


### Obtener todos los autores
<img src="URL_DE_LA_IMAGEN" alt="Captura de pantalla del Litguten menu 3">


### Obtener los autores nacidos a partir de un año dado
<img src="URL_DE_LA_IMAGEN" alt="Captura de pantalla del Litguten menu 4">

### Obtener el número de libros por idioma
<img src="URL_DE_LA_IMAGEN" alt="Captura de pantalla del Litguten menu 5">