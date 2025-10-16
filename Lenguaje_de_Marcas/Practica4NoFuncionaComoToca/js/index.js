let pssw1, pssw2;
let fechaInicio;
let form, conocimiento, requeridos;
window.addEventListener("load", function () {
    pssw1 = document.getElementById("password1");
    pssw2 = document.getElementById("password2");
    pssw1.addEventListener("input", comprobarPssw);
    pssw2.addEventListener("input", comprobarPssw);
    fechaInicio = document.getElementById("fechaInicio");
    form = document.getElementById("registro")
    form.addEventListener("submit", comprobarFecha);
    conocimiento = document.getElementById("conocimientos");
    conocimiento.addEventListener("input", valConocimientos);
    requeridos = document.querySelectorAll("[required]");
    console.log(requeridos);
    for (let i = 0; i < requeridos.length; i++) {
        requeridos[i].addEventListener("input", marcar);
    }
    

    function comprobarPssw() {
        if (pssw1.value !== pssw2.value) {
            pssw1.setCustomValidity("Las Contraseñas deben coincidir");
            pssw2.setCustomValidity("Las Contraseñas deben coincidir");
        } else {
            pssw1.setCustomValidity("");
            pssw2.setCustomValidity("");
        }
    }
    function comprobarFecha(event) {
        let fechaInicioAsDate = fechaInicio.valueAsDate;
        let fechaActual = new Date();
        if (fechaInicioAsDate < fechaActual || !fechaInicioAsDate) {
            fechaInicio.setCustomValidity("La fecha elegida debe ser posterior a la actual");
            event.preventDefault();
            
        } else {
            fechaInicio.setCustomValidity("");
            
        }
        console.log("Fecha seleccionada:", fechaInicio.valueAsDate);
        console.log("Fecha actual:", fechaActual);
        console.log("Es válida:", form.checkValidity());
        
    }
    function marcar(event) {
        let campo = event.target;
        let span = campo.nextElementSibling;
        let imagen = span.getElementsByTagName("img")[0];
        console.log("Validez del campo:"+campo.validity.valid);
        console.log(span);
        console.log(imagen);
        if (campo.checkValidity()) {
            imagen.src = "img/valid.png";
            imagen.alt = "Campo válido"
        }
        if (!campo.checkValidity()) {   
            imagen.src = "img/invalid.png";
            imagen.alt = "Campo no válido";
        }
    }
    function valConocimientos() {
        if (!conocimiento.checkValidity()) {
            conocimiento.style.backgroundColor = "red";
        } else {
            conocimiento.style.backgroundColor = "";
        }
    }
});
