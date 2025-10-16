let xmlDoc, listaBebidas, listaPic, listaBebidasEs, listaBebidasIt, listaIdioma, listaRadios;
let arrayTarjetas = [];
let idioma="es";
let seleccionada;
const h1_it="SCEGLI LA TUA BEVANDA";
const h1_es="ELIGE TU BEBIDA";
const az_es="Azúcar";
const az_it="Zucchero";
const desc_es="Descafeinado";
const desc_it="Deccaffeinato";

window.addEventListener("load", cargaPagina);

//acciones al cargar la página en el navegador
function cargaPagina() {
	//ocultar la tarjeta descriptiva
	document.getElementById("card").style.display="none";

	//registrar eventos (ejercicios 2, 3 y 4)
	registraEventos();
	
	//leer el fichero XML
	xmlDoc = cargaXml("xml/cafe.xml");
	
	//rellenar colecciones con las ramas del fichero XML
	listaBebidas=xmlDoc.getElementsByTagName("bebidas");
	listaBebidasEs=listaBebidas[0];
	listaBebidasIt=listaBebidas[1];
	listaPics = xmlDoc.getElementsByTagName("pics")[0];
	
	//comprobar la selección de idioma y rellenar el panel a partir de la colección correspondiente
	idioma=getIdioma(listaRadios);
	rellenaPanel(idioma);
}

//registra los eventos con addEventListener; algunos podrían registrarse inline
function registraEventos(){
		//los radios están dentro del primer <div> del código; registro el evento change para ambos
		listaRadios=document.getElementsByTagName("div")[0].getElementsByTagName("input");
		for (let radio of listaRadios) {
			radio.addEventListener("change", rellenaPanelEvento);
		}
		
		//las celdas que disparan eventos son las 9 primeras <td> del <div id=panel>
		let listaCeldas=document.querySelectorAll("#panel td");
		for (let i=0; i<9; i++){
			listaCeldas[i].addEventListener("mouseenter", muestraTarjeta);
			listaCeldas[i].addEventListener("mouseleave", ocultaTarjeta);
			listaCeldas[i].addEventListener("click", seleccionaBebida);
		}
}

//conecta con el fichero XML y devuelve el objeto Document con todo su contenido
function cargaXml(uri) {
	let xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET",uri, false);
	xmlhttp.send();
	return xmlhttp.responseXML;
}

//función auxiliar para no tener que usar una función anónima
//event.target es quien dispara el evento que aquí se maneja (el radio)
//mi rellenaPanel() requiere el código del idioma como argumento
function rellenaPanelEvento(event) {
	rellenaPanel(event.target.value);
}

//rellena la tabla con la información del fichero XML y las constantes
function rellenaPanel(lang) {
	//elección de la rama de bebidas y rotulación adicional
	switch (lang) {
		case "es":
			listaIdioma = listaBebidasEs;
			document.getElementsByTagName("h1")[0].innerHTML=h1_es;
			document.getElementsByTagName("span")[9].innerHTML=az_es;
			document.getElementsByTagName("span")[10].innerHTML=desc_es;
			break;
		case "it":
			listaIdioma = listaBebidasIt;
			document.getElementsByTagName("h1")[0].innerHTML=h1_it;
			document.getElementsByTagName("span")[9].innerHTML=az_it;
			document.getElementsByTagName("span")[10].innerHTML=desc_it;
	}
	
	let listaCeldasPanel = document.getElementById("panel").getElementsByTagName("td");
	let listaSpan = document.getElementsByTagName("span");
	//sólo las 9 primeras celdas <td> presentan bebidas
	for(let i=0; i<9; i++){
		//eliminar imágenes, si ya había
		if (listaCeldasPanel[i].getElementsByTagName("img").length>0) {
			for(let imagen of listaCeldasPanel[i].getElementsByTagName("img")){
				imagen.remove();
			}
		}
		
		//obtener datos del DOM XML y ponerlos en la tabla de bebidas
		let uriImagen = buscaImagen(listaIdioma.getElementsByTagName("pic")[i].childNodes[0].nodeValue);
		let nombre=listaIdioma.getElementsByTagName("nombre")[i].childNodes[0].nodeValue;
		listaCeldasPanel[i].innerHTML+="<img src='"+uriImagen+"' alt="+i+">";
		let descrip=listaIdioma.getElementsByTagName("descrip")[i].childNodes[0].nodeValue;
		listaSpan[i].innerHTML=nombre;	
		
		//rellenar el array auxiliar de objetos para la tabla descriptiva (ejercicio 3)
		let objeto= {uri: uriImagen, nombre:nombre, descrip:descrip};
		arrayTarjetas[i]=objeto;
	}
}

//devuelve el código del idioma marcado, que está como valor de los radios
function getIdioma() {
	let listaRadios=document.getElementsByTagName("div")[0].getElementsByTagName("input");
	for(let radio of listaRadios) {
		if (radio.checked) {
			return radio.value;
		}
	}
}

//devuelve la ruta de un imagen a partir del identificador
function buscaImagen(id) {
	for (let pic of listaPics.getElementsByTagName("pic_src")) {
		if (pic.getAttribute("id")==id){
			return pic.childNodes[0].nodeValue;
		}
	}
}

//visibiliza la tarjeta descriptiva de la bebida, tras ser activada con la entrada del puntero del ratón
function muestraTarjeta(event) {
	let card=document.getElementById("card");	
	let pos = event.target.getElementsByTagName("img")[0].alt;	
	card.getElementsByTagName("img")[0].src=arrayTarjetas[pos].uri;	
	document.getElementById("nombre").innerHTML=arrayTarjetas[pos].nombre;
	document.getElementById("descrip").innerHTML=arrayTarjetas[pos].descrip;
	
	card.style.display= "table";
}

//oculta la tarjeta descriptiva de la bebida, tras la salida del puntero del ratón
function ocultaTarjeta() {
	document.getElementById("card").style.display="none";
}

//construye el mensaje de confirmación de la selección de una bebida y lo muestra con alert()
function seleccionaBebida(event) {
	let nivelAzucar = document.getElementsByName("rngAz")[0].value;
	let isDescafChecked=document.getElementsByName("chkDesc")[0].checked;
	let pos=event.target.alt;
	let hasBebidaCafe=listaIdioma.getElementsByTagName("bebida")[pos].getAttribute("cafe");
	
	let cadena="Has seleccionado un " +arrayTarjetas[pos].nombre.toLowerCase() +" con " +nivelAzucar+ " de azúcar";
	if (isDescafChecked==true && hasBebidaCafe==true) {
		cadena+= " y descafeinado.";
	} else {
		cadena+=".";
	}
	alert(cadena);
}
