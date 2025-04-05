function generaElementos() {
    //Generar los elementos
    let titulo = document.createElement("h3");
    titulo.id = "titulo";
    let contenidoTitulo = document.createTextNode("Esto es un <h3>");
    let parrafo1 = document.createElement("p");
    parrafo1.id = "parrafo1";
    let contenidoParrafo1 = document.createTextNode("Primer <p>");
    let parrafo2 = document.createElement("p");
    parrafo2.id = "parrafo2";
    let contenidoParrafo2 = document.createTextNode("Segundo <p>");
    titulo.appendChild(contenidoTitulo);
    parrafo1.appendChild(contenidoParrafo1);
    parrafo2.appendChild(contenidoParrafo2);
    //Añadir los elementos al contendor para que sean visibles
    let contenedor = document.getElementById("contenedor");
    contenedor.appendChild(titulo);
    contenedor.appendChild(parrafo1);
    contenedor.appendChild(parrafo2);
    //Ocultar el botón de generar elementos
    document.getElementById("generaElementosBtn").style.display = "none";
    //Mostrar los otros botones
    document.getElementById("deletreoBtn").style.display = "inline";
    document.getElementById("dimeCuantasBtn").style.display = "inline";
    document.getElementById("arrayMovesBtn").style.display = "inline";
}
function deletreo() {
    let texto = prompt("Introduce el texto a deletrear");
    //Toma solo primera palabra
    let primeraPalabra = texto.split(" ")[0];
    let titulo = document.getElementById("titulo");
    titulo.innerHTML = primeraPalabra;
    let parrafo1 = document.getElementById("parrafo1");
    parrafo1.innerHTML = texto;
    let parrafo2 = document.getElementById("parrafo2");
    let arrayTexto = primeraPalabra.split("");
    let contador = 1;
    parrafo2.innerHTML = ""; //Así se vacía el contenido
    for (let letra of arrayTexto) {
        parrafo2.innerHTML += "Letra " + contador + ": " + letra + "<br>";
        contador++;
    }
}
function dimeCuantas() {
    let texto = prompt("Introduce el texto");
    let valido = false;
    let caracter = "";
    while (!valido) {
        caracter = prompt("Introduce el caracter a buscar");
        if (caracter.length === 1) {
            valido = true;
        } else {
            alert("Introduce un único caracter");
        }
    }
    let contador = 0;
    let titulo = document.getElementById("titulo");
    titulo.innerHTML = "dimeCuantas";
    let parrafo1 = document.getElementById("parrafo1");
    parrafo1.innerHTML = texto + "-" + caracter;
    let parrafo2 = document.getElementById("parrafo2");
    for (let letra of texto) {
        if (letra === caracter) {
            contador++;
        }
    }
    parrafo2.innerHTML = "El caracter " + caracter + " aparece " + contador + " veces en el texto";
}
function arrayMoves() {
    let arr = ["dos", "tres", "cuatro", "cinco"];
    alert(arr); //Contenido inicial
    arr.unshift("cero", "uno"); //Añadir al principio cero y uno
    alert(arr);
    arr.push("seis", "siete"); //Añadir al final seis y siete
    alert(arr);
    arr.splice(3, 3); //Eliminar desde la posición 3, 3 elementos
    alert(arr);
    arr.reverse(); //Invertir el array
    alert(arr);
    alert(arr.join(" ==> ")); //Unir los elementos del array con " ==>" en vez de comas
}