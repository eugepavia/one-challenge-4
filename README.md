# Foro Hub

![Created](https://img.shields.io/badge/Created-Ene_2025-248f24)
![Version](https://img.shields.io/badge/Version-1.0-c42121)
![Made with](https://img.shields.io/badge/Made_with-Java-255074)



## :memo: Descripción

API REST de un foro de dudas sobre temas de programación básica.

> Este trabajo fue elaborado como parte del curso Java y Spring Framework (Challenge) de Oracle Next Education (ONE).

## :dart: Funcionalidades
- Login de usuario
- Autenticación de usuario por medio de tokens
  - El token se genera en el login
- Registro de tópicos en el foro
- Revisión de la lista completa de tópicos registrados
- Revisión de tópicos específicos
- Actualización de tópicos existentes
- Eliminación de tópicos existentes

FUNCIÓN | ENDPOINT    | REQUIERE                               | DEVUELVE
--------|-------------|----------------------------------------|---------
Login | POST /login | _usuario_ y _contrasena_               | token
Registro | POST /topicos | _titulo_, _mensaje_, _autorId_ y _curso_ | _titulo_, _mensaje_ y _fechaCreacion_
Revisión de lista | GET /topicos | -                                      | lista de tópicos con _titulo_, _mensaje_, _fechaCreacion_, _status_, _autor_ y _curso_
Revisión de tópico | GET /topicos/{id} | ID del tópico en la ruta | _titulo_, _mensaje_, _fechaCreacion_, _status_, _autor_ y _curso_
Actualización | POST /topicos/{id} | ID del tópico en la ruta, _mensaje_ y/o _status_ | _titulo_, _mensaje_, _fechaCreacion_, _status_, _autor_ y _curso_
Eliminación | DELETE /topicos/{id} | ID del tópico en la ruta | -


### Consideraciones
- Las interacciones con la API se realizan en formato JSON y requieren de un token para su autorización.
  - El token se genera al acceder al login.
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

## :white_check_mark: Requisitos
- Base de datos MySQL.
  - Su nombre por defecto es "challenge4". Para modificarlo ir al archivo _application.properties_ y cambiar la variable _spring.datasource.url_.
- Registrar usuarios en la tabla correspondiente de la base de datos.
- Variables de entorno para los siguientes datos:
  - DB_HOST: Dirección de la base de datos
  - DB_USER: Nombre de usuario de la base de datos
  - DB_PASSWORD: Contraseña de la base de datos
  - API_SECRET: Clave secreta de la API

## :wave: Sobre mí
¡Hola! Me llamo Eugenia. Soy una entusiasta del aprendizaje con gusto en la ciencia, matemáticas y tecnología.

Actualmente soy parte del programa Oracle Next Education, con el propósito de expandir mis conocimientos y desarrollarme profesionalmente en el mundo de la programación Back-End.


