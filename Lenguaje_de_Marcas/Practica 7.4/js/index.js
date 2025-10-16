// Espera a que todo el documento HTML esté cargado antes de ejecutar el código
document.addEventListener("DOMContentLoaded", function () {
    validarCoincidenciaContrasenas();
    validarFechaInicioPosterior();
    validarCamposObligatorios();
    activarValidacionConocimientos();
});
// 1.Validadción de coincidencia de contraseñas
function validarCoincidenciaContrasenas() {
    let password = document.getElementById("password1");
    let confirmPassword = document.getElementById("password2");

    function compararPasswords() {
        if (password.value !== confirmPassword.value) {
            confirmPassword.setCustomValidity("Las contraseñas deben coincidir");
        } else {
            confirmPassword.setCustomValidity("");
        }
    }
    password.addEventListener("input", compararPasswords);
    confirmPassword.addEventListener("input", compararPasswords);
}
// 2. Validación de fecha posterior a la actual
function validarFechaInicioPosterior() {
    let formulario = document.getElementById("registro");
    let fechaInicio = document.getElementById("fechaInicio");

    formulario.addEventListener("submit", function (event) {
        let fechaInicioAsDate = fechaInicio.valueAsDate;
        let fechaActual = new Date();
        fechaActual.setHours(0, 0, 0, 0); // ignorar la hora
        if (!fechaInicioAsDate || fechaInicioAsDate <= fechaActual) {
            alert("La fecha de inicio debe ser posterior a la fecha actual.");
            event.preventDefault(); // prevenir el envío del formulario
        }
    });
}
// 3. Validación visual de campos obligatorios
function validarCamposObligatorios() {
    let camposObligatorios = document.querySelectorAll("#registro input[required]");
    // Selecciona todos los inputs obligatorios dentro del formulario con id "registro"
    camposObligatorios.forEach(function (campo) {
        if (campo.id === "fechaInicio") return; // Excluir el campo de fecha de inicio de esta validación
        campo.addEventListener("input", function () { // Validación al introducir datos
            let img = campo.nextElementSibling.querySelector("img"); // Selecciona la imagen que está al lado del campo
            if (img) {
                if (campo.checkValidity()) {
                    img.src = "img/valid.png";
                    img.alt = "valido";
                } else {
                    img.src = "img/invalid.png";
                    img.alt = "invalido";
                }
            }
        });
    });
}

// 4. Validación del campo conocimientos (rango)
function activarValidacionConocimientos() {
    let conocimientos = document.getElementById("conocimientos");

    conocimientos.addEventListener("input", function () {
        if (conocimientos.validity.valid) {
            conocimientos.style.backgroundColor = "transparent";
        } else {
            conocimientos.style.backgroundColor = "lightcoral";
        }
    });
}
