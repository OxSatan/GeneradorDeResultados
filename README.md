Proyecto de Gestión de Torneos de Equipos de Fútbol

Descripción

Este proyecto es una aplicación de gestión de torneos de equipos de fútbol, desarrollada en Java y basada en el patrón de diseño Modelo-Vista-Controlador (MVC). Permite a los usuarios llevar a cabo diversas operaciones sobre los equipos y gestionar los resultados de los partidos.

Características principales:

Agregar, editar y eliminar equipos.

Generación automática de resultados de partidos, con la posibilidad de introducir resultados manualmente.

Interfaz amigable para facilitar la gestión y visualización de los equipos.

Conexión a base de datos mediante JDBC y alojamiento de la base de datos en un entorno XAMPP.

Tecnologías utilizadas

Lenguaje de programación: Java

Patrón de arquitectura: Modelo-Vista-Controlador (MVC)

Base de datos: MySQL (usando XAMPP)

JDBC: para la conexión entre la aplicación y la base de datos

Swing: para la creación de la interfaz gráfica

Estructura del proyecto

El proyecto está dividido en varios paquetes:

controlador: Contiene las clases encargadas de gestionar la lógica de la aplicación y la comunicación entre la vista y el modelo.

modelo: Incluye las clases de acceso a datos (DAO) y los objetos de valor (VO) que representan las entidades.

vista: Contiene las clases de la interfaz de usuario, creadas con Swing.

Requisitos

Java Development Kit (JDK) 8 o superior

XAMPP para alojar la base de datos localmente

Conector JDBC (por ejemplo, mysql-connector-java.jar)

Instalación y configuración

Clona el repositorio:

git clone https://github.com/tu-usuario/nombre-del-repositorio.git

Importa el proyecto en tu IDE preferido (Eclipse, IntelliJ, etc.).

Agrega el conector JDBC a las dependencias del proyecto.

Configura la base de datos:

Asegúrate de que XAMPP esté ejecutando el servidor MySQL.

Importa la base de datos usando el archivo script.sql (incluido en el repositorio).

Ejecuta la aplicación desde tu IDE.



Agregar un equipo: Introduce el nombre del equipo, la ciudad y el entrenador, y haz clic en "Agregar Equipo".

Eliminar un equipo: Selecciona un equipo de la tabla y haz clic en "Eliminar Equipo".

Editar un equipo: Modifica los detalles en los campos de texto y guarda los cambios.

Mostrar resultados: La aplicación permite ver los resultados de los partidos generados.
