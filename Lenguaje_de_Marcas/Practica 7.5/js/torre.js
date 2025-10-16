document.addEventListener("DOMContentLoaded", function () {
    botonReset();
    botonResolver();
    cargarPostes();
    document.getElementById("origen").addEventListener("change", pintarDiscosOrigen);
    document.getElementById("nDiscos").addEventListener("change", pintarDiscosOrigen);
});
function botonReset() {
    let origen = document.getElementById("origen");
    let destino = document.getElementById("destino");
    let nDiscos = document.getElementById("nDiscos");
    let botonReset = document.getElementById("reset");
    let movimientos = document.getElementById("movimientos");
    let canvas = document.getElementById("canvas");
    botonReset.addEventListener("click", function () {
        origen.options[0].selected = true;
        destino.options[0].selected = true;
        nDiscos.value = 3;
        movimientos.innerHTML = "";
        if (canvas.getContext) {
            let ctx = canvas.getContext("2d");
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            cargarPostes();
        }
    });
    
}

function botonResolver() {

    let movimientos = document.getElementById("movimientos");
    let botonResolver = document.getElementById("resolver");

    botonResolver.addEventListener("click", function () {
        //Recogemos los datos
        let origen = document.getElementById("origen").value;
        let destino = document.getElementById("destino").value;
        let nDiscos = parseInt(document.getElementById("nDiscos").value);
        //Validación
        if (origen === "Elige" || destino === "Elige") {
            alert("Elige un origen y un destino");
            return;
        }
        if (origen === destino) {
            alert("El origen y el destino no pueden ser iguales");
            return;
        }
        // Obtener poste auxiliar
        let auxiliar = obtenerPosteAuxiliar(origen, destino);

        //Función Hanoi
        hanoi(nDiscos, origen, auxiliar, destino);

        //Pintar discos en el destino
        pintarDiscosDestino();
    });
    function obtenerPosteAuxiliar(origen, destino) {
        let postes = ["A", "B", "C"];
        for (let i = 0; i < postes.length; i++) {
            let p = postes[i];
            if (p !== origen && p !== destino) {
                return p;
            }
        }
    }
    function hanoi(nDiscos, origen, auxiliar, destino) {
        if (nDiscos === 1) {
            movimientos.innerHTML += `Mover disco de ${origen} a ${destino}<br>`;
            return;
        } else {
            hanoi(nDiscos - 1, origen, destino, auxiliar);
            movimientos.innerHTML += `Mover disco de ${origen} a ${destino}<br>`;
            hanoi(nDiscos - 1, auxiliar, origen, destino);
        }

    }
}

function cargarPostes() {
    let canvas = document.getElementById("canvas");
    if (canvas.getContext) {
        let ctx = canvas.getContext("2d");
        ctx.fillStyle = "yellow";
        ctx.beginPath();
        ctx.fillRect(50, 50, 10, 150);
        ctx.fillRect(145, 50, 10, 150);
        ctx.fillRect(245, 50, 10, 150);
        ctx.closePath();

        ctx.fillStyle = "black";
        ctx.textAlign = "center";
        ctx.font = "20px Arial";
        ctx.strokeText("A", 55, 30);
        ctx.strokeText("B", 150, 30);
        ctx.strokeText("C", 250, 30);

    }
}

function pintarDiscosOrigen() {
    let origen = document.getElementById("origen").value;
    if (origen === "Elige") return;
    let nDiscos = parseInt(document.getElementById("nDiscos").value);
    let canvas = document.getElementById("canvas");
    let colores = ["red", "pink", "blue", "green", "yellow"];
    if (canvas.getContext) {
        let ctx = canvas.getContext("2d");
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        cargarPostes();
        switch (origen) {
            case "A":
                for (let i = 0; i < nDiscos; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(20 + (i * 5), 130 - (i * 20), 70 - (i*10), 20);
                }
                break;
            case "B":
                for (let i = 0; i < nDiscos; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(115 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                }
                break;
            case "C":
                for (let i = 0; i < nDiscos; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(215 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                }
                break;
        }
    }
}
function pintarDiscosDestino() {
    let destino = document.getElementById("destino").value;
    if (destino === "Elige") return;
    let nDiscos = parseInt(document.getElementById("nDiscos").value);
    let canvas = document.getElementById("canvas");
    let colores = ["red", "pink", "blue", "green", "yellow"];
    if (canvas.getContext) {
        let ctx = canvas.getContext("2d");
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        cargarPostes();
        switch (destino) {
            case "A":
                for (let i = 0; i < nDiscos; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(20 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                }
                break;
            case "B":
                for (let i = 0; i < nDiscos; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(115 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                }
                break;
            case "C":
                for (let i = 0; i < nDiscos; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(215 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                }
                break;
        }
    }
}
