
// Espera a que todo el DOM (estructura HTML) esté completamente cargado antes de ejecutar el código
document.addEventListener("DOMContentLoaded", function () {
    // Una vez que el DOM está listo, busca el botón con id="dni" y lo guarda en la variable boton1
    let boton1 = document.getElementById("dni");
    let boton2 = document.getElementById("factorial");
    let boton3 = document.getElementById("fecha");
    // Añade un "escuchador de eventos" al botón.
    // Cuando el usuario haga clic en el botón, se ejecutará la función letraDni().
    boton1.addEventListener("click", function () {
        letraDni();
    });
    boton2.addEventListener("click", function () {
        factorial();
    });
    boton3.addEventListener("click", function () {
        fecha();
    });
});



function letraDni() {
    const letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
        'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'];
    let numDni = prompt("Introduzca número del DNI");
    let letraDNI = prompt("Introduzca la letra del DNI").toUpperCase();
    
    if (numDni < 0 || numDni > 99999999) {
        alert("Error, Introduzca un número válido");
        return;
    } else {
        letras[numDni % 23] === letraDNI ? alert("DNI correcto") : alert("La letra no corresponde");
    }
}
function factorial() {
    let num = prompt("Introduzca un número a factorizar")
    let x = 1;
    if (num < 1 || num > 15) {
        alert("Error, Introduzca un número válido")
        return;
    } else {
        for (let i = 1; i <= num; i++) {
            x *= i;
        }
        alert("El factorial de " + num + " es " + x);
    }
}

function fecha() {
    let hoy = new Date();
    let semana = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"];
    let meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    let diaSemana = semana[hoy.getDay()];
    let diaMes = hoy.getDate();
    let mes = meses[hoy.getMonth()];
    let anio = 1900 + hoy.getYear();
    alert("Hoy es " + diaSemana + ", " + diaMes + " de " + mes + " de " + anio);
}

