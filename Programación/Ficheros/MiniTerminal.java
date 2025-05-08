package terminal;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
class MiniFileManager{
	//Atributos
	private File f;
	//Constructor
	public MiniFileManager() {
		super();
		//Directamente empieza en el directorio del usuario
		this.f = new File(System.getProperty("user.dir"));
	}
	//Métodos
	public File getF() {
		return f;
	}
	public void setF(File f) {
		this.f = f;
	}
	public String getPWD() {
		return f.getAbsolutePath();
	}
	public boolean changeDir(String dir) {
		File newDir;
		if (new File(dir).isAbsolute()) {
			newDir = new File(dir); //Por si utilizan rutas absolutas
		} else {
			newDir = new File(f,dir); //Por si utilizan rutas relativas
		}

		if(newDir.exists() && newDir.isDirectory()) {
			setF(newDir);
			return true;
		} else {
			System.out.println("Directorio no válido");
			return false;
		}
	}
	public void printList(boolean info) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		File[] lista = f.listFiles();
		if(lista == null) {
			System.out.println("No se puede acceder al contenido de la ruta");
			return;
		}
		//Ordenamos alfabéticamente
		Arrays.sort(lista,(a,b) -> a.getName().compareToIgnoreCase(b.getName()));
		//Primero directorios
		for (File file : lista) {
			if(file.isDirectory()) {
				if(info) {
					System.out.println("[*] " + file.getName() + " - " +
							file.length() + " bytes - " +
							sdf.format(new Date(file.lastModified())));
				} else {
					System.out.println("[*] " + file.getName());
				}
			}
		}
		//Ahora archivos
		for (File file : lista) {
			if(file.isFile()) {
				if(info) {
					System.out.println("[F] " + file.getName() + " - " +
							file.length() + " bytes - " +
							sdf.format(new Date(file.lastModified())));
				} else {
					System.out.println("[F] " + file.getName());
				}
			}
		}
	}
	public void createDir(String dir) {
		File carpeta = new File(f, dir);
		if (!carpeta.exists()) {
			carpeta.mkdir();
		} else {
			System.out.println("El directorio ya existe");
		}
	}
	//Método de apoyo al que borra
	public boolean remove(String ruta, boolean all) {
		File dir;
		File rutaFile = new File(ruta);
		//si es absoluta, no problema
		if(rutaFile.isAbsolute()) {
			dir = rutaFile;
		} else {
			//Si es relativa, la unimos al directorio actual
			dir = new File(f, ruta);
		}
		return removePrinc(dir, all);
	}

	//Método que borra
	public boolean removePrinc(File dir, boolean all) {
		if(!dir.exists()) {
			System.out.println("Error: Ruta Incorrecta");
			return false;
		}
		//Si es un archivo, lo borra sin mas
		if(dir.isFile()) {
			dir.delete();
			return true;
		}
		if (all){
			//Si es un directorio, borra su contenido recursivamente
			File[] lista = dir.listFiles();
			if (lista !=null) {
				for (File file : lista) {
					boolean borrado = removePrinc(file,true);
					if(!borrado) {
						System.out.println("No se pudo borrar: " + file.getPath());
						return false;
					}
				}
			}

		}
		if(!all) {
			File[] lista = dir.listFiles();
			for (File file : lista) { //Borramos los archivos que tiene dentro, dejamos las subcarpetas intactas
				file.delete();
			}
			System.out.println("Se han borrado los archivos, pero las subcarpetas siguen existiendo");
			return true;
		}
		//Sea como sea, devuelve el booleano "delete"
		return dir.delete();
	}
	//Método para mover/renombrar archivos
	public boolean rename(String dir1, String dir2) {
		//Al loro con esto, que no se me ha ocurrido a mi y por eso no lo pongo, pero mira que guapo
		//File origen = new File(dir1).isAbsolute() ? new File(dir1) : new File(f, dir1);
		//File destino = new File(dir2).isAbsolute() ? new File(dir2) : new File(f, dir2);
		//Esta comprobación para el file de origen
		File newDir1;
		if (new File(dir1).isAbsolute()) {
			newDir1 = new File(dir1); //Por si utilizan rutas absolutas
		} else {
			newDir1 = new File(f,dir1); //Por si utilizan rutas relativas
		}
		//Esta para el de destino
		File newDir2;
		if (new File(dir2).isAbsolute()) {
			newDir2 = new File(dir2); //Por si utilizan rutas absolutas
		} else {
			newDir2 = new File(f,dir2); //Por si utilizan rutas relativas
		}

		if(!newDir1.exists()) {
			System.out.println("Error:El archivo de origen no existe");
			return false;
		}
		if(newDir2.exists()) {
			System.out.println("Error: El destino ya existe");
			return false;
		}
		boolean res = newDir1.renameTo(newDir2);
		if(!res) {
			System.out.println("Error: No se pudo mover o renombrar el archivo");
			return false;
		}
		return res;
	}
	//Método de ayuda
	public void help() {
		System.out.println("● pwd: Muestra cual es la carpeta actual.\r\n"
				+ "● cd <DIR>: Cambia la carpeta actual a ‘DIR’. Con .. cambia a la carpeta superior.\r\n"
				+ "● ls: Muestra la lista de directorios y archivos de la carpeta actual (primero directorios, luego\r\n"
				+ "archivos, ambos ordenados alfabéticamente).\r\n"
				+ "● ll: Como ls pero muestra también el tamaño y la fecha de última modificación.\r\n"
				+ "● mkdir <DIR>: Crea el directorio ‘DIR’ en la carpeta actual.\r\n"
				+ "● rm <FILE>: Borra ‘FILE’. Si es una carpeta, borrará primero sus archivos y luego la carpeta. Si\r\n"
				+ "tiene subcarpetas, las dejará intactas y mostrará un aviso al usuario.\r\n"
				+ "● mv <FILE1><FILE2>: Mueve o renombra ‘FILE1’ a ‘FILE2’.\r\n"
				+ "● help: Muestra una breve ayuda con los comandos disponibles.\r\n"
				+ "● exit: Termina el programa.");
	}
}
public class MiniTerminal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String selector;
		MiniFileManager consola = new MiniFileManager();
		while (true) {
			System.out.println("> "); //rollo terminal
			selector = sc.nextLine();
			String[] partes = selector.split(" ");
			String comando = partes[0];
			switch (comando) {
			case "pwd": System.out.println(consola.getPWD());break;

			case "cd":
				if (partes.length < 2) {
					System.out.println("Falta el nombre del directorio");
					break;
				}else {
					consola.changeDir(partes[1]);
					break;
				}

			case "ls": consola.printList(false);break;

			case "ll": consola.printList(true);break;

			case "mkdir":
				if (partes.length < 2) {
					System.out.println("Falta el nombre del directorio");
					break;
				}else {
					consola.createDir(partes[1]);
					break;
				}

			case "rm":
				if(partes.length < 2) {
					System.out.println("Falta el nombre del directorio");
					break;
				}
				if(partes[1].equals("-a")){
					if(partes.length < 3) {
						System.out.println("Falta el nombre del directorio");
						break;
					}
					consola.remove(partes[2], true);
					break;
				}
				else {
					consola.remove(partes[1],false);
					break;
				}

			case "mv":
				if(partes.length < 3) {
					System.out.println("Faltan argumentos");
					break;
				}
				else {
					consola.rename(partes[1], partes[2]);
					break;
				}

			case "help":consola.help();break;

			case "exit": sc.close(); return;

			default: System.out.println("Comando no encontrado"); break;
			}
		}
	}

}
