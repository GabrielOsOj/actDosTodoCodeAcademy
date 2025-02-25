## Introducción

Este ejercicio es similar al ejercicio numero uno, pero con algunas variantes que voy a detallar a continuación.

## Consignas de la actividad:

Pequeño sistema para la gestion de una clinica veterinaria, consta de la clase mascota y la clase dueño. Se deben realizar:

1. Funciones CRUD para la clase mascota.
2. Funciones CRUD para la clase dueños.
3. Obtener el listado de las mascotas, filtradas por especies y razas a la vez.
4. Obtener un listado de elementos combinados de una mascota y su dueño:
    - nombreMascota.
    - especie.
    - raza.
    - nombreDueño.
    - apellidoDueño.

# Diseño y estructura

La actividad esta diseñado con el patrón MVC y arquitectura de capas.

Las distintas partes del proyecto están separadas según su funcionalidad. Cuenta con 5 paquetes (entity, repository, service, controller y dto), cada clase cuenta con su propio servicio, repositorio y controlador.

### Clase Mascota

la clase mascota cuenta con la siguiente estructura:

```json
{
    "idMascota": Long,
    "nombre": String,
    "especie": String,
    "raza": String,
    "color": String,
    "dueño": {
      "idDueño": Long,
      "nombre": String,
      "apellido": String,
      "celular": int,
      "dni": int
  }
```

### Clase dueño:

```json
{
    "idDueño": Long,
    "nombre": String,
    "apellido": String,
    "celular": int,
    "dni": int
  }
```

### Clase DTOdueñoMascota:

```json
{
  "nombreMascota": "string",
  "especie": "string",
  "raza": "string",
  "nombreDueño": "string",
  "apellidoDueño": "string"
}
```

# Controlador y endpoints

## Clase mascota

La URL base del controlador para mascotas es: 

```bash
http://localhost:8080/mascota
```

cuenta con 3 endpoints del tipo GET, 1 de tipo PUT y 1 tipo DELETE.

### Crear mascota

```bash
http://localhost:8080/mascota/crear
```

‼️ Recibe un objeto del tipo Mascota pero con el idMascota : null

▶️ Es posible asignar un Dueño creado previamente usando solo el idDueño o se puede crear un dueño de cero.

↪️ Si el objeto se crea correctamente, retorna un 201

Ejemplo con el id de un dueño ya creado en la base de datos:

```json
  {
    "idMascota": null,
    "nombre": String,
    "especie": String,
    "raza": String,
    "color": String,
    "dueño": {
      "idDueño": 1
    }
  }
```

▶️ Si el id del dueño no existe en la base de datos retorna un 404 y no guarda la entidad.

Ejemplo dando de alta un nuevo dueño:

```json
 {
    "idMascota": null,
    "nombre": String,
    "especie": String,
    "raza": String,
    "color": String,
    "dueño": {
      "idDueño": null,
      "nombre": String,
      "apellido": String,
      "celular": int,
      "dni": int
    }
  }
```

### Obtener todas las mascotas

Devuelve todas las mascotas almacenadas en la base de datos:

```bash
http://localhost:8080/mascota/obtenerTodas
```

☑️ Petición tipo GET, no requiere parámetros.

☑️ Retorna una lista de objetos del tipo Mascota.

### Obtener mascota y dueño

Devuelve un objeto con información cruzada de la mascota y su dueño:

```bash
http://localhost:8080/mascota/datosMascotaYdueño
```

‼️ Petición tipo GET, requiere un parámetro tipo Long correspondiente a una mascota almacenada en la base de datos.

↪️  Si el id de la mascota es valido retorna un único elemento del tipo DTOdueñoMascota.

🚫 Si el id no es valido retorna un 404.

### Obtener según especie y raza

Devuelve una lista de mascotas que verifiquen en simultaneo la especie y la raza de la mascota:

```bash
http://localhost:8080/mascota/buscarRazaYespecie
```

‼️ Peticion tipo GET, requiere 2 parametros:

 ▶️ especie: tipo String.

 ▶️ raza: tipo String.

↪️ Si se encuentra valores que correspondan con la raza y especie, retorna  una lista del tipo Mascota.

🚫 Retorna un 404 si no hay coincidencias.

Ejemplo de petición con parámetros para buscar por perros de la raza caniche:

```bash
http://localhost:8080/mascota/buscarRazaYespecie?especie=perro&raza=caniche
```

### Editar mascota

Edita una mascota existente en la base de datos:

```bash
http://localhost:8080/mascota/editar
```

‼️ Petición tipo PUT, recibe un objeto del tipo Mascota, el Id mascota del objeto debe pertenecer a una mascota en la base de datos.

▶️ Si se editan los atributos de la clase dueño ubicada dentro de la clase mascota también se editan estos datos en la base de datos.

↪️ Si el id es valido retorna un 204.

🚫 Si el id no es valido retorna un 404.

### Eliminar mascota

Elimina una mascota de la base de datos:

```bash
http://localhost:8080/mascota/borrar
```

‼️ Petición tipo DELETE, recibe un id tipo Long, este debe pertenecer a una mascota en la base de datos.

▶️ Si se elimina una mascota de la base de datos, también se elimina el dueño de la mascota de la base de datos.

↪️ Si el id es valido, retorna un 204.

🚫 Si el id no es valido, retorna un 404

## Clase dueño

La URL base es:

```bash
http://localhost:8080/dueño
```

### Crear dueño

Se da de alta un dueño de mascota en la base de datos.

```bash
http://localhost:8080/dueño/crear
```

‼️ Petición del tipo POST, recibe un objeto del tipo Dueño, el id debe ser null.

↪️ Retorna un 200 si los datos son validos.

### Obtener todos los dueños

Devuelve una lista con los dueños de la base de datos.

```bash
http://localhost:8080/dueño/obtenerTodos
```

☑️ Petición del tipo GET, no requiere parámetros.

↪️ Retorna una lista de objetos tipo Dueño, si no hay ningún Dueño, retorna una lista vacía.

### Editar dueño existente

Permite editar un miembro de la base de datos existente.

```bash
http://localhost:8080/dueño/editar
```

‼️ Petición del tipo PUT, requiere un objeto del tipo Dueño, el id dentro del objeto debe pertenecer a una clase en la base de datos.

↪️ Retorna un 200 si la edición se realizo correctamente.

🚫 Retorna un 404 si el id del dueño no existe en la base de datos.

### Eliminar dueño

Elimina a un dueño de la base de datos.

```bash
http://localhost:8080/dueño/borrar
```

‼️ Petición tipo DELETE, requiere el ID de un dueño valido en la base de datos.

↪️ Retorna un 204 si se elimino el usuario correctamente.

🚫 Retorna un 404 si el id no es valido.

# Probar el proyecto

para probar el proyecto correctamente, se necesitan ciertos pasos previos:

1. Este proyecto utiliza una base de datos MySQL desplegada usando XAMPP
2. Una vez que instales XAMPP, inicia el servidor MySQL e ingresa usando phpMyAdmin (también puedes usar MySQLWorkwrench, que es como lo hice yo, pero necesitas la descarga, instalación y configuración del programa), necesitas crear una nueva base de datos con el nombre de tu preferencia:

```sql
CREATE DATABASE actividadDosTDC;
```

1. con XAMPP y MySQL configurados y luego de haber creado la base de datos, vamos a crear un nuevo archivo .txt llamado application
2. dentro de este archivo, vamos a configurar los datos de acceso para la base de datos:

```bash
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/actividadDosTDC
spring.datasource.username=usuario
spring.datasource.password=contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

- jdbc:mysql://127.0.0.1:3308/actividadTDC esto se divide en 3
- 127.0.0.1:3306 es la dirección de tu [localHost](http://localhost/) y el puerto que usa MySQL
- actividadTDC es el nombre que tiene la base de datos que creaste usando phpMyAdmin
- username y password son el usuario y contraseña de tu base de datos, si no tiene contraseña, se deja vacio, los nombres NO van entre comillas
- los demás son configuraciones necesarias para spring, se dejan asi como están

Una vez creado el txt y haber añadido los cambios, guardamos y tenemos que cambiar la terminación del archivo, de .txt a .properties, el nombre del archivo final debe ser:

▶️ application.properties

Este archivo lo vamos a usar mas adelante.

Ademas para compilar el proyecto, es necesario que cuentes con el jdk y maven correctamente configurado.

Descargamos el proyecto desde github, podemos descargarlo en formato zip o clonarlo de la siguiente forma:

1. creamos una nueva carpeta en donde vamos a clonar el proyecto.
2. ejecutamos la consola de Windows en ese directorio, si utilizas Windows puedes hacer click en la barra de navegación y escribir cmd, esto ejecuta una consola en el directorio actual.
3. clonamos el repositorio usando:

```bash
git clone "https://github.com/GabrielOsOj/actDosTodoCodeAcademy.git"

```

Una vez descargado el repositorio, (si lo bajaste comprimido, lo descomprimís). Nos dirigimos a la carpeta:

src → main → resources

y dentro colocamos el archivo application.properties

Finalmente, nos dirigimos al directorio principal y ejecutamos el archivo iniciar.bat

si todo funciono correctamente, podemos ir a la ruta:

```bash
http://localhost:8080/swagger-ui/index.html

```

donde podemos probar los distintos endpoints mediante swagger.