const { mostrarMensaje } = require("./mostrarMensaje");

// Función para mostrar mensajes
function mostrarMensaje(mensaje, esError) {
    const mensajeElement = document.createElement('div');
    mensajeElement.className = mensaje ${esError ? 'error' : 'exito'};
    mensajeElement.textContent = mensaje;
    document.body.appendChild(mensajeElement);

    setTimeout(() => {
        mensajeElement.remove();
    }, 3000);
}

// Función para registrar usuario que se conecta con el controlador REST
async function registrarUsuario(event) {
    event.preventDefault();

    const usuario = {
        nombre: document.getElementById('nombre').value,
        apellido: document.getElementById('apellido').value,
        direccion: document.getElementById('direccion').value,
        telefono: document.getElementById('telefono').value,
        dni: document.getElementById('dni').value,
        correo: document.getElementById('correo').value,
        contraseña: document.getElementById('contraseña').value
    };

    try {
        const response = await fetch('/api/usuarios/registro', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(usuario)
        });

        const data = await response.json();

        if (response.ok) {
            mostrarMensaje('Registro exitoso', false);
            document.getElementById('registroForm').reset();
            // Cambiar al formulario de login
            container.classList.remove("right-panel-active");
        } else {
            mostrarMensaje(data.error || 'Error en el registro', true);
        }
    } catch (error) {
        console.error('Error:', error);
        mostrarMensaje('Error al conectar con el servidor', true);
    }
}

// Añadir evento de submit al formulario de registro
document.getElementById('registroForm').addEventListener('submit', registrarUsuario);