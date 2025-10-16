document.addEventListener("DOMContentLoaded", function () {
    cargarImagen();
    dibujarLogo();
});
function cargarImagen() {
    let canvas2 = document.getElementById("canvas2");

    if (canvas2.getContext) {
        let ctx2 = canvas2.getContext("2d");
        let imagen = new Image();
        imagen.src = "img/logomislata.jpg";
        imagen.onload = imgLoadHandler;
        function imgLoadHandler() {
            ctx2.drawImage(imagen, 0, 0, canvas2.width, canvas2.height);
        };
    }
}
function dibujarLogo() {
    let canvas1 = document.getElementById("canvas1");

    if (canvas1.getContext) {
        let ctx1 = canvas1.getContext("2d");
        ctx1.strokeStyle = "#444444";
        ctx1.lineWidth = 2;
        ctx1.arc(150,150, 75, 0, Math.PI*2);
        ctx1.stroke();
        ctx1.arc(150, 150, 80, 0, Math.PI * 2);
        ctx1.stroke();
        //vertical
        ctx1.beginPath();
        ctx1.lineTo(150, 65);
        ctx1.lineTo(150, 235);
        ctx1.stroke();
        ctx1.closePath();
        //horizontal
        ctx1.beginPath();
        ctx1.lineTo(50, 150);
        ctx1.lineTo(250, 150);
        ctx1.stroke();
        ctx1.closePath();
        //diagonal larga
        ctx1.beginPath();
        ctx1.lineTo(60, 65);
        ctx1.lineTo(240, 235);
        ctx1.stroke();
        ctx1.closePath();
        //diagonal corta
        ctx1.beginPath();
        ctx1.lineTo(150,150);
        ctx1.lineTo(65, 245);
        ctx1.stroke();
        ctx1.closePath();
        //poligono gris
        ctx1.fillStyle = "grey";
        ctx1.beginPath();
        ctx1.lineTo(115, 190);
        ctx1.lineTo(154, 180);
        ctx1.lineTo(135, 167);
        ctx1.lineTo(120, 146);
        ctx1.fill();
        
        //poligono azul
        ctx1.fillStyle = "darkblue";
        ctx1.beginPath();
        ctx1.lineTo(142, 159);
        ctx1.lineTo(214, 211);
        ctx1.lineTo(178, 150);
        ctx1.lineTo(213, 80);
        ctx1.lineTo(150, 122);
        ctx1.lineTo(87, 91);
        ctx1.fill();
        
    }
}

