let menu, nDiscos, origen, destino, btnResolver, btnreset, movimientos,
    nDiscosJuego, posteOrigen, posteDestino, posteAux,canvas;
window.addEventListener("load", function () {
    //Definimos las variables
    btnreset = document.getElementById("reset");
    menu = document.getElementById("menu");
    nDiscos = document.getElementById("nDiscos");
    origen = document.getElementById("origen");
    destino = document.getElementById("destino");
    btnResolver = document.getElementById("resolver");
    movimientos = document.getElementById("movimientos");
    canvas = document.getElementById("canvas");
    //Asignamos los eventos
    btnreset.addEventListener("click", resetear);
    btnResolver.addEventListener("click", resolver);
    origen.addEventListener("change", pintarDiscosOrigen);//Al loro con el change
    nDiscos.addEventListener("change", pintarDiscosOrigen);
    //Llamamos a las funciones que haga falta
    pintarPostes();
    
})
function resetear() {
    nDiscos.value = 3;
    origen.options[0].selected = true;
    destino.options[0].selected = true;
    movimientos.innerHTML = "";
    if (canvas.getContext) {
        let ctx = canvas.getContext("2d");
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        cargarPostes();
    }
}

function resolver() {
    movimientos.innerHTML = "";
    nDiscosJuego = nDiscos.value;
    posteOrigen = origen.value;
    posteDestino = destino.value;
    if (posteDestino != destino.options[0].value && posteDestino !== posteOrigen && posteOrigen != origen.options[0].value) {
        aux();
        hanoi(nDiscosJuego, posteOrigen, posteAux, posteDestino);
        pintarDiscosDestino();
    } else {
        alert("Los postes deben ser diferentes, o estar seleccionados");
    }
}
function aux() {
    if (posteDestino || posteOrigen !== "A") {
        posteAux = "A";
    }
    if (posteDestino || posteOrigen !== "B") {
        posteAux = "B";
    }
    if (posteDestino || posteOrigen !== "C") {
        posteAux = "C";
    }

}

function hanoi(nDiscosJuego, posteOrigen, posteAux, posteDestino) {

    if (nDiscosJuego === 1) {
        movimientos.innerHTML += " Mover de " + posteOrigen + " a " + posteDestino;
    } else {
            hanoi(nDiscosJuego - 1, posteOrigen, posteDestino, posteAux);
            movimientos.innerHTML += "<br>"+" Mover de " + posteOrigen + " a " + posteDestino +"<br>";
            hanoi(nDiscosJuego - 1, posteAux, posteOrigen, posteDestino);
        
    }
}

function pintarPostes() {
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
    if (origen.value === "Elige") return;
    let colores = ["red", "pink", "blue", "green", "yellow"];
    if (canvas.getContext) {
        let ctx = canvas.getContext("2d");
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        pintarPostes(); //para que se vuelvas a pintar los postes
        switch (origen.value) {
            case "A":
                for (let i = 0; i < nDiscos.value; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(20 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                } break;
            case "B":
                for (let i = 0; i < nDiscos.value; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(115 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                } break;
            case "C":
                for (let i = 0; i < nDiscos.value; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(215 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                } break;
                
        }
    }
}
function pintarDiscosDestino() {
    if (destino.value === "Elige") return;
    let colores = ["red", "pink", "blue", "green", "yellow"];
    if (canvas.getContext) {
        console.log(destino.value);
        let ctx = canvas.getContext("2d");
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        pintarPostes(); //para que se vuelvas a pintar los postes
        switch (destino.value) {
            case "A":
                for (let i = 0; i < nDiscos.value; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(20 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                } break;
            case "B":
                for (let i = 0; i < nDiscos.value; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(115 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                } break;
            case "C":
                for (let i = 0; i < nDiscos.value; i++) {
                    ctx.fillStyle = colores[i];
                    ctx.fillRect(215 + (i * 5), 130 - (i * 20), 70 - (i * 10), 20);
                } break;

        }
    }
}