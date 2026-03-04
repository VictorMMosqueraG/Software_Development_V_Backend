# Software Development V
El propósito principal de este proyecto es exhibir los conocimientos adquiridos en arquitectura de software, patrones de diseño, soluciones escalables y eficientes. En lugar de resolver un problema nuevo, nos enfocamos en refactorizar y optimizar código existente: desde aplicar principios SOLID para mejorar la legibilidad y mantenibilidad, hasta optimizar el rendimiento de consultas (queries) y escalabilidad general del sistema.

Este enfoque no solo valida competencias técnicas, sino que genera valor real, como código más robusto, mantenible y performant, listo para entornos de producción.

## Tabla de Conenidos
- [Desición de la Arquitectura](#desición-de-la-arquitectura)
- [Configuración del proyecto](#configuración-del-proyecto)
- [Correr el proyecto](#correr-el-proyecto)
- [Documentación con Swagger](#swagger)

## Desición de la arquitectura
Decidimos ir con Arquitectura Limpia para este proyecto porque nos permite separar bien la lógica de negocio de los frameworks y detalles técnicos. Es una de las arquitecturas más fáciles de poner en marcha, pero al mismo tiempo deja súper claro cómo se divide todo en componentes independientes.

Imagínate: si mañana queremos cambiar la base de datos o migrar a microservicios, lo hacemos sin tocar el corazón del negocio. Así evitamos ese lío de código acoplado que tanto duele después.

Al final, obtenemos algo testable, fácil de mantener y listo para crecer.

```
└── development
    └── application
        └── cases
        └── dto
    └── domain
        └── model
        └── repository
    └── infrastructure
        └── config
        └── controller
        └── entity
        └── mapper
        └── repository
    └── DevelopmentAplication
```

**Capa de Aplicación**: Aquí vive la lógica de los casos de uso del negocio (aplicación).

- Casos de Uso: Implementa los flujos principales de la app.

- DTO: Objetos para transferir datos entre capas.

**Capa de Dominio**: El corazón de todo. Alberga las reglas de negocio y entidades puras.

- Modelos: Definición de entidades del dominio.

- Repositorios: Interfaces con métodos clave (lógica de negocio).

**Capa de Infraestructura**: Maneja los detalles externos (base de datos, frameworks, etc.).

- Config: Archivos de configuración de Spring y inyección de dependencias.

- Controladores: Controladores REST para la API.

- Entidades: Definiciones JPA/Hibernate para persistencia.

- Mappers: Convierte entre objetos de dominio y persistencia.

- Repositorios: Implementaciones concretas con JPA.


## Configuración del proyecto

### Conección a la base de datos
Para este proyecto se utiliza el motor de base de datos **Mysql**. Mediante el uso de un docker-compose logramos obtener la creación de un conetenedor para poder trabajar con dicha base de datos de manera local, sin la necesidad de instalar ninguna version de Mysql. Para poder correr el contenedor hagalo siguiendo estos pasos.

1. Ajuste de variables de entorno
Para conectarnos a la bae de datos primero debe hacer una copia del archivo ***.env.example***, cambiarle el nombre a ***.env*** y posteriomente asignarle los valores correctos de la base de datos (usuario, contraseña, ruta, etc...).


2. Levantar el contenedor (Si es la primera vez€)
    ```
    docker-compose up -d
    ```

    ***NOTA***: Una vez el comando sea ejecutado con exito revise que el contenedor fue creado y esta funcionando de forma exitosa. Una vez el contenedor sea montado manualmente o mediante comando podra apagarlo, borrarlo o reiniciarlo, segun sea su necesidad.

### Correr el proyecto
Una vez la base de datos este corriendo en nuestro contenedor docker, ya estemos conectado a la base de datos mediante algun gestor de base de datos ya podemos arrancar el proyecto. Este proyecto en java fue creado en **Maven**, para correr el proyecto utilice el siguiente comando:

    mvn spring-boot:run
    

## Documentación con Swagger
Para este proyecto se utilizo swagger, con el fin de documentar las apis, sus posibles respuesta (exitosa y errores), asi como sabes que valores son necesesarios para que cada API funcione exitosamente. Una vez el proyecto esta funcionando y ejecutandose en la maquina local, podras acceder al swagger mediante esta ruta:

```
http://localhost:8080/swagger-ui/index.html
```

