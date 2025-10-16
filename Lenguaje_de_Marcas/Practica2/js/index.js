let boton1, boton2, boton3, boton4;
document.addEventListener("DOMContentLoaded", function () {
    boton1 = document.getElementById("elementos");
    boton2 = document.getElementById("deletreo");
    boton3 = document.getElementById("cuantas");
    boton4 = document.getElementById("mover");
    boton2.style.display = "none";
    boton3.style.display = "none";
    boton4.style.display = "none";
    boton1.addEventListener("click", function () { 
        generar();
    });
    boton2.addEventListener("click", function () { 
        deletreo();
    });
    boton3.addEventListener("click", function () {
        cuantas();
    });
    boton4.addEventListener("click", function () {
        mover();
    });
});
function generar() {
    let h3 = document.createElement("h3");
    h3.id = "titulo";
    let contH3 = document.createTextNode("Esto es un <h3>");//Todo esto podría hacerse con contentText o con innerHtml;
    let p1 = document.createElement("p");
    p1.id = "p1"; 
    let contP1 = document.createTextNode("Primer <p>");
    let p2 = document.createElement("p");
    p2.id = "p2";
    let contP2 = document.createTextNode("Segundo <p>");
    h3.appendChild(contH3);
    boton4.after(h3);
    p1.appendChild(contP1);
    h3.after(p1);
    p2.appendChild(contP2);
    p1.after(p2);
    boton1.style.display = "none";
    boton2.style.display = "inline";
    boton3.style.display = "inline";
    boton4.style.display = "inline";
}

function deletreo() {
    //Si todo esto lo subo, estas variables no las tengo que repetir en cada función
    let h3 = document.getElementById("titulo");
    let p1 = document.getElementById("p1");
    let p2 = document.getElementById("p2");
    let palabra = prompt("Introduzca una palabra");
    h3.innerHTML = "deletreo";
    p1.innerHTML = palabra;
    let palabras = palabra.split(" ");
    let palabraCorrecta = palabras[0];
    let letras = palabraCorrecta.split("");
    p2.innerHTML = ""; // así borramos lo anterior
    for (let i = 1; i <= palabraCorrecta.length; i++) {
        p2.innerHTML += "Letra " + i + ": " + letras[i - 1] + "<br>" // += para ir añadiendo
    }
}

function cuantas() {
    let h3 = document.getElementById("titulo");
    let p1 = document.getElementById("p1");
    let p2 = document.getElementById("p2");
    let texto = prompt("Introduzca texto");
    let caracter = "";
    let valido = false;
    while (!valido) {
        caracter = prompt("Introduzca un carácter");
        if (caracter.length === 1) {
            valido = true;
        } else {
            alert("Solo o al menos un carácter");
            }
        }
    let cuenta = 0;
    for (let l of texto) { //El texto, que es un String, se trata como un array de caracteres
        if (l === caracter) {
            cuenta++;
        }
    }
    h3.innerHTML = "dimeCuantas";
    p1.innerHTML = texto + " - " + caracter;
    p2.innerHTML = cuenta + " veces aparece";
}

function mover() {
    let array = ["dos", "tres", "cuatro", "cinco"];
    alert(array);
    array.unshift("cero", "uno");//añade atras
    alert(array);
    array.push("seis", "siete");//añade delante
    alert(array);
    array.splice(3, 3);//corta desde el tercer elemento, 3 palante
    alert(array);
    array.reverse();//le da la vuelta
    alert(array);
    alert(array.join("==>"));//hace que las comas sean ==>
}