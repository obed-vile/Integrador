<h1>🛒 Ecommerce App</h1>
<h2>Descripción</h2>
Esta es una plataforma de e-commerce desarrollada en Java usando Spring Boot. Permite a los usuarios registrarse, iniciar sesión, ver productos, realizar compras y gestionar pedidos.

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- MySQL 8.0
- Thymeleaf
- jQuery 3.7.1

## ⚙️ Instalación y Configuración

##### Clonar el repositorio:
~~~
git clone https://github.com/obed-vile/integrador.git
~~~
##### Configurar la base de datos:

##### Configura application.properties:
~~~
spring.datasource.url=jdbc:mysql://localhost:3306/leahome
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
~~~


##### Construir y ejecutar la aplicación:
~~~
mvn clean install
mvn spring-boot:run
~~~

##📂 Estructura del Proyecto
src
├── main
│   ├── java
│   │   └── com.tuapp.ecommerce
│   │       ├── controller       # Controladores de rutas y lógica de interfaz
│   │       ├── model            # Entidades y modelos de datos
│   │       ├── repository       # Repositorios para acceder a la base de datos
│   │       ├── service          # Servicios con lógica de negocio
│   │       └── EcommerceApplication.java   # Clase principal
│   └── resources
│       ├── static               # Archivos estáticos como CSS y JS
│       ├── templates            # Plantillas HTML Thymeleaf
│       └── application.properties # Configuraciones de la aplicación


## 🌐 Endpoints y Rutas
~~~
/usuario/registro - Formulario para registrar un nuevo usuario.
/usuario/login - Página de inicio de sesión.
/producto/{id} - Detalle de un producto específico.
/orden/comprar - Endpoint para realizar una compra.
~~~
## 🛠️ Uso
##### Registro de Usuario:
~~~
Accede a http://localhost:8080/usuario/registro y completa el formulario.
~~~
##### Inicio de Sesión:
~~~
Ve a http://localhost:8080/usuario/login, ingresa tus credenciales y comienza a explorar.
~~~
## 🤝 Contribuciones
##### ¿Quieres contribuir? ¡Eres bienvenido! Sigue estos pasos

- Haz un fork del proyecto.
- Crea una nueva rama (git checkout -b nueva-funcionalidad).
- Realiza los cambios y haz un commit (git commit -m 'Añadir nueva funcionalidad').
- Envía un pull request.

## 📄 Licencia
Este proyecto está bajo la licencia MIT.

## 🎉 Créditos
Este proyecto fue desarrollado como una práctica de desarrollo en Spring Boot. ¡Gracias por explorar nuestro código! 🙌
