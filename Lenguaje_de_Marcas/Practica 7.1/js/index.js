function letraDNI() {
    let posiblesLetras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
        'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'];
    let numDNI = prompt('Introduzca número de DNI');
    if (numDNI < 0 || numDNI > 99999999) {
        alert('Número incorrecto, saliendo del programa');
        return;
    }
    let letraDNI = prompt('Introduzca letra de DNI').toUpperCase();
    let letraCorrespondiente = posiblesLetras[numDNI % 23];
    letraCorrespondiente === letraDNI
        ? alert('El número y la letra son correctos')
        : alert('La letra indicada no es correcta');
    
}
function factorial() {
    let numUsuario = prompt('Introduzca número a factorizar');
    if (numUsuario < 1 || numUsuario > 15) {
        alert('Número Inválido');
        return;
    }
    let mult = 1;
    for (let i = 1; i <= numUsuario; i++) {
        mult *= i;
    }
    alert('El factorial es ' + mult);
}

function queDiaEsHoy() {
    let hoy = new Date();
    let diaSemana = ['domingo', 'lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado'];
    let mes = ['enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio', 'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'];
    let year = hoy.getYear() + 1900;
    let fecha = 'Hoy es ' + diaSemana[hoy.getDay()] + ', ' + hoy.getDate() + ' de ' + mes[hoy.getMonth()] + ' de ' + year;
    alert(fecha);
}