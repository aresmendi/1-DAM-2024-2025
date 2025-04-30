package deber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CuentasBancarias {
	//Variables globales
	public static ArrayList<Cuenta> listaCuentas = new ArrayList(); 
	public static Scanner sc = new Scanner(System.in); 

	public static void main(String[] args) {
		//Variables
		int opcion=-1;
		Cuenta c1;

		mostrarMenu(); 
		do {
			System.out.println("\nSelecciona una opción");
			try {
				opcion = sc.nextInt();
				sc.nextLine();
				switch(opcion) {
				case 1:
					//Alta de cuentas
					añadirCuenta();	
					break;
				case 2:
					//Consulta de una cuenta
					c1 = buscarCuenta();
					System.out.println(c1);
					break;
				case 3:
					//Ingresar dinero
					ingresarDinero();
					break;
				case 4:
					//Retirar dinero
					retirarDinero();
					break;
				case 5:
					//anular cuentas
					c1 = buscarCuenta();
					listaCuentas.remove(c1); 
					break;
				case 6:
					//listado de cuentas, recorremos el arrayList e imprimimos los datos
					for (Cuenta cuenta : listaCuentas) {
						System.out.println(cuenta);
					}
					break;
				case 0:
					System.out.println("Hasta luego");
					break;
				default: 
					System.out.println("Opción no válida");
				}
			}
			catch(InputMismatchException ie) {
				System.err.println("Error: esa cantidad no es un numero");
				sc.nextLine();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(opcion!=0);
	}

	public static void ingresarDinero() {
		double cantidad;
		Cuenta c1; 

		try {
			//Buscamos la cuenta
			c1 = buscarCuenta(); 
			//Solicitamos la cantidad a ingresar y verificamos que es válida
			cantidad = leerDouble("Cantidad a ingresar: ");
			//Ingresamos la cantidad si es válida
			c1.ingreso(cantidad);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void retirarDinero() throws Exception {
		double cantidad;
		Cuenta c1;
			//Buscamos la cuenta
			c1 = buscarCuenta(); 
			//Solicitamos la cantidad a retirar y verificamos que es válida
			cantidad = leerDouble("Cantidad a retirar: ");
			//Retiramos la cantidad si es válida
			c1.reintegro(cantidad);
	}

	static void añadirCuenta() {
		String nombre, numCuenta;
		double saldo, tipoDeInteres; 

		try {
			//Pedimos los datos
			System.out.print("Nombre: ");
			nombre = sc.nextLine();
			System.out.print("Número de cuenta: ");
			numCuenta = sc.nextLine();
			//Verificamos que los doubles se introduzcan correctamente
			saldo = leerDouble("Saldo inicial: ");
			tipoDeInteres = leerDouble("Tipo de interes: ");

			//Creamos la cuenta
			Cuenta c1 = new Cuenta(nombre, numCuenta, saldo, tipoDeInteres);
			//Si no lanza ninguna excepción se añade al ArrayList de cuentas
			listaCuentas.add(c1); 
			System.out.println("Cuenta creada exitosamente");
		} catch(Exception e) {
			System.err.println("Error: no se pudo crear la cuenta - " + e.getMessage());
		}
	}

	static Cuenta buscarCuenta() throws Exception {
		String numCuenta; 
		
		//Pedimos el numero de cuenta
		System.out.print("Número de cuenta: ");
		numCuenta = sc.nextLine();

		//Lo buscamos en el arrayList
		for (Cuenta cuenta : listaCuentas) {
			if(numCuenta.equals(cuenta.getCuenta())) {
				//si hay coincidencia devuelve la cuenta
				return cuenta;
			}
		}
		// si no hay coincidencia lanza la excepción
			throw new Exception ("Cuenta no encontrada");
	}

	static void mostrarMenu() {
		System.out.println("1.- Alta de cuentas\r\n"
				+ "2.- Consulta de una cuenta\r\n"
				+ "3.- Ingresar dinero\r\n"
				+ "4.- Retirar dinero\r\n"
				+ "5.- Anular cuentas\r\n"
				+ "6.- Listado de cuentas\r\n"
				+ "0.- Salir");
	}

	static double leerDouble(String mensaje) {
		//Se repite mientras el dato introducido no sea válido
		while (true) {
			try {
				System.out.print(mensaje);
				double valor = sc.nextDouble();
				sc.nextLine(); // limpiar buffer
				return valor;
			} catch (InputMismatchException e) {
				System.err.println("Error: esa cantidad no es un número");
				sc.nextLine(); // 
			}
		}
	}
}

class Cuenta {
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipoDeInteres;


	public Cuenta (String nombre, String cuenta, double saldo, double tipoDeInteres) throws Exception{
		//Llamamos a los métodos para verificar y agregar los datos
		setNombre(nombre);
		setCuenta(cuenta); 
		setSaldo(saldo);
		setTipoDeInteres(tipoDeInteres); 
	}

	@Override
	public String toString() {
		return "********************\r\n"
				+ "Nombre: " + this.nombre +"\r\n"
				+ "Cuenta: " + this.cuenta + "\r\n"
				+ "Saldo: " + this.saldo + "\r\n"
				+ "Tipo de Interes: " + this.tipoDeInteres + "\r\n"
				+ "********************";
	}

	public String getNombre() {
		return nombre;
	}

	//• Nombre no puede ser un campo vacío ni menor de 3 letras.
	public void setNombre(String nombre) throws Exception{
		if(nombre.equals("")){
			throw new Exception("El nombre " + nombre + " es una cadena vacía"); 
		}

		if(nombre.length()<3) {
			throw new Exception("El nombre " + nombre + " debe tener al menos 3 carácteres"); 
		}

		this.nombre = nombre;
	}

	public String getCuenta() {
		return cuenta;
	}

	/*• Un identificador de cuenta formado por números y letras (Al menos debe haber uno de cada) 
	 * y un tamaño mayor de 8.*/
	public void setCuenta(String cuenta) throws Exception{
		int cuentaNumeros=0, cuentaLetras=0;

		if(cuenta.length()<=8) {
			throw new Exception("La cuenta " + cuenta + " debe tener minimo 8 caracteres");
		}

		//Recorremos la cuenta
		for(int i = 0; i<cuenta.length(); i++) {
			//Contamos el núm de digitos para verificar si es mayor o igual a 1
			if(Character.isDigit(cuenta.charAt(i))){
				cuentaNumeros++;
			}
			//Contamos el núm de letras para verificar si es mayor o igual a 1
			if(Character.isLetter(cuenta.charAt(i))){
				cuentaLetras++;
			}
		}

		if(cuentaNumeros<1) {
			throw new Exception("El identificador de la cuenta " + cuenta + " debe tener al menos un numero");
		}

		if(cuentaLetras<1) {
			throw new Exception("El identificador de la cuenta " + cuenta + " debe tener al menos una letra");
		}

		this.cuenta = cuenta; 
	}

	public double getSaldo() {
		return saldo;
	}

	//• Saldo nunca puede quedar en negativo, se deberá anular la operación.
	public void setSaldo(double saldo) throws Exception{
		if(saldo < 0) {
			throw new Exception("El saldo no puede ser negativo");
		};
		
		this.saldo = saldo; 
	}

	public double getTipoDeInteres() {
		return tipoDeInteres;
	}

	//• El tipo de interés no puede ser negativo
	public void setTipoDeInteres(double tipoDeInteres) throws Exception {
		if(tipoDeInteres<0) {
			throw new Exception("El tipo de interes no puede ser negativo"); 
		}
		this.tipoDeInteres = tipoDeInteres;
	}

	public void ingreso(double cantidad) throws Exception{
		if(cantidad < 0) {
			throw new Exception("Error: Ingreso negativo"); 
		}
		//Si la cantidad no es negativa se añade al saldo
		this.saldo+=cantidad; 
	}

	public void reintegro(double cantidad) throws Exception{
		if(cantidad>this.saldo) {
			throw new Exception("Error: Cantidad mayor que saldo"); 
		}
		//Si la cantidad es correcta se resta del saldo
		setSaldo(this.saldo - cantidad);
	}
}
