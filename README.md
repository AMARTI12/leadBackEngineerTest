# Lead Backend Engineer Test

## Descripción

Este proyecto ha sido desarrollado siguiendo los requerimientos proporcionados en la prueba para el puesto de **Lead Backend Engineer**. Se utilizó **Spring Boot 3.4.5** con **Maven** y **JDK 21**, implementando una arquitectura desacoplada, escalable y resiliente basada en principios **SOLID**, como IDE se trabajó con **Intellij IDEA 2025.1**. En git(Commits) se puede evidenciar el paso a paso del desarrollo de esta prueba, como proceso de transparencia en la realización de la misma.
 
---

## Requerimientos Realizados

### 1. **Operaciones CRUD para Usuarios**
Se implementaron las siguientes operaciones para la gestión de usuarios:
- **Crear Usuario:** Endpoint para la creación de un usuario nuevo con validaciones de campos.
- **Actualizar Usuario:** Endpoint que permite actualizar los datos de un usuario ya existente.
- **Obtener Listado de Usuarios:** Endpoint que retorna una lista de todos los usuarios registrados.
- **Obtener Usuario por ID:** Endpoint para obtener la información de un usuario específico utilizando su identificador único (`UUID`).

### 2. **Operaciones CRUD para Tickets** 🎟️
Se desarrollaron las siguientes operaciones para el manejo de tickets:
- **Crear Ticket:** Endpoint para crear un nuevo ticket, asociado a un usuario específico.
- **Editar Ticket:** Endpoint para actualizar la información de un ticket existente.
- **Eliminar Ticket:** Endpoint para eliminar un ticket por su ID.
- **Obtener Ticket por ID:** Endpoint que permite obtener un ticket específico utilizando su identificador único (`UUID`).
- **Obtener Lista de Tickets:** Endpoint para obtener una lista paginada de tickets, con soporte para filtrado por estatus y usuario.

### 3. **Filtrado de Tickets** 🔎
Los endpoints permiten realizar filtrados detallados y el paginado de los tickets:
- Filtrar tickets por **estatus** (abierto o cerrado).
- Filtrar tickets por **usuario**.
- Combinación de filtros por **estatus** y **usuario** para una búsqueda más específica.

### 4. **Modelo de Datos** 📊
Se definieron dos modelos de datos clave en el sistema, los cuales se crean automaticamente en memoria gracias a H2:
- **Usuario (User):**
    - `id`: Identificador único (UUID)
    - `firstName`: Nombre del usuario
    - `lastName`: Apellidos del usuario
    - `Fecha_Creacion`: Fecha de creación en formato `LocalDateTime`
    - `Fecha_Actualizacion`: Fecha de última actualización en formato `LocalDateTime`
- **Ticket (Ticket):**
    - `id`: Identificador único (UUID)
    - `description`: Descripción del ticket (máx. 500 caracteres)
    - `user`: Usuario asociado al ticket (UUID)
    - `Fecha_Creacion`: Fecha de creación en formato `LocalDateTime`
    - `Fecha_Actualizacion`: Fecha de última actualización en formato `LocalDateTime`
    - `status`: Estatus del ticket (ABIERTO, CERRADO)

### 5. **Validaciones** ⚠️
Se implementaron validaciones para los campos requeridos en todos los modelos:
- Ejemplo: los campos `firstName` y `lastName` son obligatorios.
- La fecha de creación y actualización de los tickets y usuarios se gestionan de forma coherente.

### 6. **Seguridad** 🔐
Se implementó autenticación y autorización utilizando **JWT** para asegurar que los endpoints sensibles solo sean accesibles por usuarios autenticados, en este caso en el archivo Settings del proyecto se definio un usuario y contraseña por defecto, las credenciales son: 
- **Usuurio**: AdminTest
- **Contraseña**: AdminTestDVP2025*

### 7. **Arquitectura y Diseño** 🏗️

Se utilizó una arquitectura **basada en capas**, organizada de la siguiente forma:

- **controllers** → Maneja las solicitudes HTTP y define los endpoints expuestos.
- **domain** → Contiene las entidades y modelos principales del dominio de negocio.
- **dto** → Define los objetos de transferencia de datos usados entre capas, ayudando a separar las entidades internas de las externas.
- **helpers** → Incluye configuraciones, utilidades y clases auxiliares como `SecurityConfig`.
- **repository** → Se encarga de la interacción con la base de datos.
- **service** → Implementa la lógica de negocio, coordinando los datos entre controladores y repositorios.

El punto de entrada de la aplicación es `LeadBackEngineerTestApplication`.

Esta arquitectura permite que el sistema sea fácilmente escalable y flexible, permitiendo la adición de nuevas funcionalidades de forma sencilla.

### 8. **Documentación de la API** 📚
Toda la API fue documentada utilizando **Swagger/OpenAPI**. Cada endpoint tiene su descripción, parámetros y respuestas bien detalladas, lo que facilita su uso e integración con otros sistemas.

---

## Funcionalidades Adicionales ⚙️

### 1. **Método Seed para Precarga de Datos**
Se implementó un método **Seed** que permite la precarga de datos en la base de datos para facilitar las pruebas y la interacción con los endpoints durante el desarrollo.

### 2. **Consola de Administración H2** 🖥️
Para facilitar las pruebas y la verificación de datos, se configuró una **base de datos H2 en memoria** que permite interactuar con los datos a través de una consola administrativa web(http://localhost:8081/api/v1/h2-console):

![Consola H2](https://i.ibb.co/27TMDS5p/Captura-de-pantalla-2025-05-05-144020.png)

### 3. **Swagger UI** 🧑‍💻
La documentación de la API está disponible a través de **Swagger UI**, donde los desarrolladores pueden interactuar con todos los endpoints disponibles de manera visual y sencilla(http://localhost:8081/api/v1/swagger-ui/index.html).

![Swagger UI](https://i.ibb.co/FLPNgNqf/Captura-de-pantalla-2025-05-05-144205.png)

### 4. **Pruebas Unitarias y de Integración** 🧪
Se realizaron pruebas unitarias e integración para los controladores y servicios clave:
- Se cubrieron todos los endpoints para verificar su funcionalidad y asegurar que las operaciones CRUD se realicen correctamente.
- Se utilizaron **MockMvc** y **JUnit** para la ejecución de las pruebas unitarias y de integración.

---

## Ejecución Local 🚀

Este proyecto se ejecuta en **localhost:8081**. Para configurarlo localmente y correr la aplicación, se uso el IDE Intellij IDEA 2025.1:

```bash
mvn spring-boot:run
```

## Postman Collection 📑
Se adjunta una colección de Postman completamente funcional con cada uno de los endpoints de la API, facilitando su uso y pruebas.

Puedes importar la colección de Postman desde el archivo JSON ubicado en la raiz del proyecto.

## Agradecimientos 🙏
Gracias a **Doble V Partners** por brindarme la oportunidad de realizar esta prueba. Fue un reto muy interesante y valioso para mí, y he disfrutado el proceso de desarrollar este sistema. Espero que el desarrollo dee esta prueba cumpla las espectativas y que encuentren valor en la solución que he creado.

## Nota sobre la IA 🤖
Para la realización de este proyecto, se utilizó inteligencia artificial en una capacidad muy limitada. Su uso se restringió principalmente a la generación de comentarios, documentación y automatización de algunas pruebas unitarias. El diseño y la implementación de la lógica de negocio, así como la arquitectura, fueron realizados basándome en mi propio conocimiento y experiencia. La IA no influyó de manera significativa en la toma de decisiones y el desarrollo o en el diseño general del sistema y la logica implementada en el mismo.
