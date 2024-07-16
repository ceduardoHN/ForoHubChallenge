# ForoHubChallenge

## Índice

- [Descripción del Challenge](#descripción-del-challenge)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Demostración del sistema](#demostración-del-sistema)
- [Datos Relevantes](#datos-relevantes)

## Descripción del Challenge
API que proporciona endpoints para un foro donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. En este proyecto se utilizan algunas funcionalidades como solicitudes HTTP, manejo y manipulación de objetos de tipo json, modelado y persistencia de datos por medio de [Java Persistence API (JPA)](https://spring.io/projects/spring-data-jpa), junto con la metodología de actualizaciones del modelo de base de datos ([DDL y DML](https://www.ibm.com/docs/es/idr/11.3.3?topic=console-replicating-data-definition-language-ddl-changes)) por medio de migraciones realizadas desde el proyecto de backend, lo cual es utilizado en la actualidad para que el equipo correspondiente se enfoque completamente en las reglas del negocio y los servicios que debe proporcionar la API; además se implementan técnicas de autorización, autenticacion y control de usuarios y peticiones respectivamente, por medio de [Json Web Token (JWT)](https://jwt.io/).

### Documentación de la API<br> 
- Cuenta con los endpoints siguientes:
    - /topicos
        - Métodos soportados:
            - Obtener todos los tópicos.
            - Obtener todos los tópicos con paginación.
            - Obtener top 10 tópicos.
            - Obtener tópico segun su código.
            - Guardar un tópico.
            - Modificar un tópico.
    - /usuarios
        - Métodos soportados:
                - Obtener todos los usuarios.
    - /cursos
        - Métodos soportados:
                - Obtener todos los cursos.
    - /login
        - Métodos soportados:
                - Inicio de sesión de usuarios en la API.
- Para ver información mas detallada ingrese al siguiente link: [ForoHubOpenAPI]()

## Requisitos del Sistema
Como requisito para este proyecto se necesitarón las siguientes herramientas más destacadas:
- IntelliJ IDEA Community Edition
    - Como entorno de desarrollo.
    - [Jetbrains](https://www.jetbrains.com/idea/)
- Postman API Platform
    - Para probar y demostrar la funcionalidad de los endpoints existentes en la API del sistema.
    - [Postman](https://www.postman.com/)
- Flyway
    - Dependencia para manejo de código sql versionado mediante migracoines.
    - [Flyway](https://www.baeldung.com/database-migrations-with-flyway)
- MySQL Community 8.0
    - Como servicio y gestor de base de datos.
    - [MySQL](https://www.mysql.com/)
    - [MySQL Workbench](https://www.mysql.com/products/workbench/)
- Spring Security
    - Para el manejo de autenticación y autorización de usuarios y peticiones a la API, respectivamente.
    - [Spring Security](https://spring.io/projects/spring-security)
- Auth0 java-jwt
    - Para la generación y validación de tokens en los endpoints de la API.
    - [Auth0](https://github.com/auth0/java-jwt)

## Demostración del Sistema
Se recomienda ver el siguiente video para comprender mejor la explicación posterior.<br>
[![Enlace del video](https://img.youtube.com/vi/75LaX6N_Kx4/maxresdefault.jpg)](https://youtu.be/75LaX6N_Kx4)

### 1. El sistema cumple con reglas de negocio específicas.<br> 
- Para el guardado y actualizado de tópicos:
    - Solo los datos título, mensaje, autor y curso deben ser enviados en el cuerpo de la solicitud.
    - Todos los campos son obligatorios, por lo tanto, es necesario verificar si todos los campos se están ingresando correctamente.
    - La API no debe permitir el registro de tópicos duplicados (con el mismo título y mensaje).
    - Verificar si el tópico existe en la base de datos antes de realizar una acción de actualización o eliminación.


## Datos Relevantes
[Alura Badge](https://drive.google.com/file/d/1EeMWFStNPm6-Fg-xHtuuzRD_u_KVbQzv/view?usp=sharing)
<br>
<b>Autor: Eduardo Soriano</b>. <br>
Perfil de Github: [ceduardoHN](https://github.com/ceduardoHN/) <br>

<b>Fecha de Lanzamiento: 16 de julio de 2024</b>
