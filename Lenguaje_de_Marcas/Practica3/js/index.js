let id,tituloOriginal, tituloIngles, tipo, episodios, nota, fechaInicio; 
let estudios, img, generos;
let tdsPanel;
window.addEventListener("load", function () {
    //Recogemos los datos del xml
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "xml/anime.xml", false);
    xmlhttp.send();
    let xmlDoc = xmlhttp.responseXML;
    //cada elemento linea estará dentro del Array animes[]
    let animes = xmlDoc.getElementsByTagName("linea");
    //cada td está en el Array tdsPanel(los seleccionamos con el query, desde el elemento que tiene
    // id panel, baja al tbody, luego al tr, y luego coge TODOS/ALL/ sus tds)
    tdsPanel = document.querySelectorAll("#panel tbody tr td");

    for (let i = 0; i < animes.length; i++) {
        //Recogemos cada uno de los datos de cada linea
        id = animes[i].getAttribute("id");
        tituloOriginal = animes[i].getElementsByTagName("titulo_original")[0].innerHTML;
        tituloIngles = animes[i].getElementsByTagName("titulo_ingles")[0].innerHTML;
        tipo = animes[i].getElementsByTagName("tipo")[0].innerHTML;
        episodios = animes[i].getElementsByTagName("episodios")[0].innerHTML;
        nota = animes[i].getElementsByTagName("nota")[0].innerHTML;
        fechaInicio = animes[i].getElementsByTagName("fecha_inicio")[0].innerHTML;
        img = animes[i].getElementsByTagName("imagen")[0].innerHTML;
        //Esto son colecciones de datos que comparten Tag
        estudios = animes[i].getElementsByTagName("estudio");
        generos = animes[i].getElementsByTagName("genero");
        //Estos arrays los usaremos para tranformar las colecciones,
        // o mejor dicho, su contenido, en algo que podemos usar
        let listaEstudios = [];
        let listaGeneros = [];
        for (const args of estudios) {
            listaEstudios.push(args.innerHTML);
        }
        for (const args2 of generos) {
            listaGeneros.push(args2.innerHTML);
        }
        //Trazas
        console.log("Estudios es:" + estudios);
        console.log("Generos es:" + generos);
        console.log("Episodios es:" + episodios);
        console.log("Imagen es:" + img);
        //Mostramos los datos
        tdsPanel[i].innerHTML = "<img src='" + img + "' alt='" + tituloIngles + "'> <td> " +
            tituloOriginal + "/" + tituloIngles + ". " + tipo + ". Número de Episodios: " + episodios
            + " Nota: " + nota + ". Comenzó en " + fechaInicio + ". Estudios implicados: " +
            listaEstudios.join(" y ") + ". Géneros:" + listaGeneros.join(" y ") + "</td>"
    }
   
})