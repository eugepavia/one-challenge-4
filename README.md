# Foro Hub

![Created](https://img.shields.io/badge/Created-Ene_2025-248f24)
![Version](https://img.shields.io/badge/Version-1.1-c42121)
![Made with](https://img.shields.io/badge/Made_with-Java-255074)



## :memo: Descripción

API REST de un foro de dudas sobre temas de programación básica.

> Este trabajo fue elaborado como parte del curso Java y Spring Framework (Challenge) de Oracle Next Education (ONE).

## :dart: Funcionalidades
- Registro y login de usuario
- Autenticación de usuario por medio de tokens
  - El token se genera en el login
- Registro de tópicos en el foro
- Revisión de la lista completa de tópicos registrados
- Revisión de tópicos específicos
- Actualización de tópicos existentes
- Eliminación de tópicos existentes

| MÉTODO | ENDPOINT      | FUNCIÓN                                |
|--------|---------------|----------------------------------------|
| POST   | /registro     | Registro de usuario nuevo              |
| POST   | /login        | Login para usuarios registrados        |
| POST   | /topicos      | Registro de un tópico nuevo            |
| GET    | /topicos      | Revisión de lista de todos los tópicos |
| GET    | /topicos/{id} | Revisión de un tópico por su ID        |
| POST   | /topicos/{id} | Actualización de un tópico por su ID   |
| DELETE | /topicos/{id} | Eliminación de un tópico por su ID     |
 
### Consideraciones
- Las interacciones con los tópicos requieren de un token para su autorización.
  - El token se genera al acceder al login.
- El usuario sólo puede editar y eliminar tópicos de su autoría.
- No se permite el registro o actualización de tópicos duplicados (con el mismo título y/o nombre).
- En el registro de tópicos es obligatorio llenar todos los campos solicitados.
- En la actualización de tópicos no es obligatorio llenar todos los campos solicitados.
  - Si se desea establecer esta regla, sacar de comentarios las líneas 3, 8 y 10 de la clase _TopicoActualizacionDTO_.
- Sobre la creación de tokens:
  - Se utilizó el algoritmo HMAC-256.
  - El tiempo de expiración por defecto es de 3 horas. Para modificarlo ir al archivo _application.properties_ y cambiar la variable _token.expiration_.
- Cursos permitidos:
  - HTTP en la web
  - Introducción a Java
  - Springboot Framework
  - POO con Javascript
  - HTML y CSS en la web
  - Lógica de programación
  - Buenas prácticas
  - Otros
- Status de resolución permitidos:
  - Sin resolver
  - Resuelto

## :key: Acceso
Para probar los endpoints, ejecutar el programa e ingresar en el puerto de su preferencia la ruta _/swagger-ui/index.html_

Los endpoints relacionados con los tópicos requieren un token de autenticación. Para probarlos:
1. Hacer login con un usuario registrado (o en su defecto, registrar un usuario nuevo y hacer el login con este)
2. Copiar el token generado como respuesta al login.
3. Ir a la parte superior de la página y seleccionar el botón _Authorize_ (o bien, hacer click sobre cualquier ícono de candado a un costado de los endpoints).
4. Pegar el token en la casilla y seleccionar "Authorize"

## :white_check_mark: Requisitos
- Base de datos MySQL.
  - Crear la base de datos de manera local
- Duplicar el archivo _application.example.properties_ de la carpeta resources, renombrar a _application.properties_ y agregar las variables de entorno correspondientes:
  - spring.datasource.url: Añadir el nombre del host y de la base de datos local 
  - spring.datasource.username: Nombre de usuario de MySQL
  - spring.datasource.password: Contraseña de MySQL
  - API_SECRET: Clave secreta de la API

## :wave: Sobre mí
¡Hola! Soy Eugenia, programadora Backend en crecimiento. Empecé como profesora de matemáticas, pero mi interés por el desarrollo de software me llevó a formarme en tecnologías Backend.

Me entusiasma seguir aprendiendo, compartir mis conocimientos y poner mis habilidades al servicio de proyectos que aporten valor. ¿Empezamos?