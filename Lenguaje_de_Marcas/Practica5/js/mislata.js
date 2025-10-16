let canvas1, canvas2;
window.addEventListener("load", function () {
    canvas1 = document.getElementById("canvas1");
    canvas2 = document.getElementById("canvas2");
    cargarImg();
    pintarCanvas();
})
function cargarImg() {
    if (canvas2.getContext) {
        let ctx2 = canvas2.getContext("2d");
        let img = new Image();
        console.log = ("La imagen está: ", img);
        img.src = "img/logomislata.jpg";
        console.log = ("La imagen está: ", img);
        img.onload = function () { //NO TE PUEDES AHORRAR ESTA FUNCIÓN
            ctx2.drawImage(img, 0, 0, canvas2.width, canvas2.height);
        }
    }
}
function pintarCanvas() {
    if (canvas1.getContext) {
        let ctx1 = canvas1.getContext("2d");

        //Círculos
        ctx1.beginPath();
        ctx1.arc(150, 150, 75, 0, Math.PI * 2, true);
        ctx1.stroke();
        ctx1.beginPath();
        ctx1.arc(150, 150, 80, 0, Math.PI * 2, true);
        ctx1.stroke();
        //Lineas
        ctx1.beginPath();
        ctx1.moveTo(150, 65);
        ctx1.lineTo(150, 235);
        ctx1.stroke();

        ctx1.beginPath();
        ctx1.moveTo(50, 150);
        ctx1.lineTo(250, 150);
        ctx1.stroke();

        ctx1.beginPath();
        ctx1.moveTo(60, 65);
        ctx1.lineTo(240, 235);
        ctx1.stroke();

        ctx1.beginPath();
        ctx1.moveTo(150, 150);
        ctx1.lineTo(65, 245);
        ctx1.stroke();

        //Poligonos
        ctx1.beginPath();
        ctx1.moveTo(115, 190);
        ctx1.lineTo(154, 180);
        ctx1.lineTo(135, 167);
        ctx1.lineTo(120, 146);
        ctx1.fillStyle = "grey";
        ctx1.fill();

        ctx1.beginPath();
        ctx1.moveTo(142, 149);
        ctx1.lineTo(214, 211);
        ctx1.lineTo(178, 150);
        ctx1.lineTo(213, 80);
        ctx1.lineTo(150, 122);
        ctx1.lineTo(87, 91);
        ctx1.fillStyle = "blue";
        ctx1.fill();
    }
}