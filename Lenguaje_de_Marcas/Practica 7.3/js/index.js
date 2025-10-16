// Esperamos a que el contenido de la página se cargue completamente antes de ejecutar la función
window.addEventListener("load", readFromXml);
// Función principal que lee y procesa el archivo XML
function readFromXml() {
    // Creamos un nuevo objeto XMLHttpRequest para hacer la solicitud
    let xmlhttp = new XMLHttpRequest();
    // Abrimos la solicitud GET para obtener el archivo XML
    xmlhttp.open("GET", "xml/anime.xml", false); // Usamos 'false' para que la solicitud sea síncrona
    xmlhttp.send(); // Enviamos la solicitud

    // Obtenemos el documento XML de la respuesta
    let xmlDoc = xmlhttp.responseXML;
    // Extraemos todos los elementos <linea> (cada anime)
    let animes = xmlDoc.getElementsByTagName("linea");
    // Obtenemos el elemento donde vamos a insertar los animes (la lista)
    let lista = document.getElementById("listaAnime");

    // Recorremos todos los animes en el archivo XML
    for (let i = 0; i < animes.length; i++) {
        let anime = animes[i];
        // Extraemos los datos de cada anime usando getElementsByTagName y getAttribute
        let id = anime.getAttribute("id");
        let titulo_original = anime.getElementsByTagName("titulo_original")[0].textContent;
        let titulo_ingles = anime.getElementsByTagName("titulo_ingles")[0].textContent;
        let tipo = anime.getElementsByTagName("tipo")[0].textContent;
        let episodios = anime.getElementsByTagName("episodios")[0].textContent;
        let nota = anime.getElementsByTagName("nota")[0].textContent;
        let fecha = anime.getElementsByTagName("fecha_inicio")[0].textContent;
        let imagen = anime.getElementsByTagName("imagen")[0].textContent;

        // Recoger todos los géneros en un array y los convertimos a una cadena de texto separada por comas
        let generos = Array.from(anime.getElementsByTagName("genero"))
            .map(g => g.textContent)
            .join(", ");
        // Recoger todos los estudios de la misma forma
        let estudios = Array.from(anime.getElementsByTagName("estudio"))
            .map(e => e.textContent)
            .join(", ");
        // Creamos un nuevo elemento <li> para cada anime
        let li = document.createElement("li");
        // Insertamos el contenido del anime en el <li> (HTML dinámico)
        li.innerHTML = `
            <strong>${titulo_original}</strong> (${titulo_ingles})<br>
      <em>ID:</em> ${id} | <em>Tipo:</em> ${tipo} | <em>Episodios:</em> ${episodios}<br>
      <em>Nota:</em> ${nota} | <em>Inicio:</em> ${fecha}<br>
      <em>Géneros:</em> ${generos}<br>
      <em>Estudios:</em> ${estudios}<br>
      <img src="${imagen}" alt="Imagen de ${titulo_original}">
    `;
        // Agregamos el nuevo <li> a la lista en el HTML
        lista.appendChild(li);
    }
}