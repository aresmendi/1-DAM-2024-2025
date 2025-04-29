import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Cuenta {
	//Atributos
	private String nombre;
	private String cuenta;
	private double saldo;
	private double tipoDeInteres;
	//Constructor
	public Cuenta(String nombre, String cuenta, double saldo, double tipoDeInteres) throws Exception {
		super();
		if (nombre.length() <3) {
			throw new Exception("El nombre no puede estar vacío, ni ser inferior a 3 caracteres");
		}
		if(!esCuentaValida(cuenta)) {
			throw new Exception("Cuenta inválida, debe tener al menos una letra y un número, y ser superior a 8 caracteres");
		}
		if(saldo < 0) {
			throw new Exception("Saldo nunca puede ser un número negativo");
		}
		if(tipoDeInteres < 0) {
			throw new Exception("Tipo de interés nunca puede ser un número negativo");
		}
		this.nombre = nombre;
		this.cuenta = cuenta;
		this.saldo = saldo;
		this.tipoDeInteres = tipoDeInteres;
	}
	//Auxiliar del Constructor
	private boolean esCuentaValida(String cuenta) {
		if(cuenta.length() < 8) return false;

		boolean tieneLetra = false;
		boolean tieneNumero = false;

		for (char c : cuenta.toCharArray()) {
			if (Character.isLetter(c)) tieneLetra = true;
			if (Character.isDigit(c)) tieneNumero = true;
		}
		return tieneLetra && tieneNumero;
	}
	//Métodos
	public void setNombre(String nombre) throws Exception {
		this.nombre = nombre;
	}
	public void setCuenta(String cuenta) throws Exception {
		this.cuenta = cuenta;
	}
	public void setSaldo(double saldo) throws Exception {
		this.saldo = saldo;
	}
	public void ingreso(double cantidad)  throws Exception{
		if(cantidad <0) {
			throw new Exception("Error: Cantidad no puede ser negativa");
		}
		else { 
			saldo+=cantidad;
		}
	}
	public void reintegro(double cantidad)  throws Exception {
		if(cantidad <0) {
			throw new Exception("Error: Cantidad no puede ser negativa");
		}

		if(saldo - cantidad < 0) {
			throw new Exception("Error: Cantidad mayor que saldo");
		} 
		saldo -= cantidad;
	}

	public String getCuenta() {
		return cuenta;
	}
	@Override
	public String toString() {
		return "********************\r\n"
				+ "Nombre:"+ nombre +"\r\n"
				+ "Cuenta:"+ cuenta + "\r\n"
				+ "Saldo:" + saldo + "\r\n"
				+ "Tipo de Interes:" + tipoDeInteres + "r\n"
				+ "********************\r\n"
				+ "";
	}
}
public class CuentasBancarias {
	//Variables Globales
	static ArrayList<Cuenta> listacuentas = new ArrayList<Cuenta>();
	static Scanner sc = new Scanner(System.in);
	//Métodos
	public static void menu() {
		System.out.println("1.- Alta de cuentas\r\n"
				+ "2.- Consulta de una cuenta\r\n"
				+ "3.- Ingresar dinero\r\n"
				+ "4.- Retirar dinero\r\n"
				+ "5.- Anular cuentas\r\n"
				+ "6.- Listado de cuentas\r\n"
				+ "0.- Salir");
	}
	public static void altaCuenta() {
		System.out.println("Nombre:");
		String nombre = sc.nextLine();
		System.out.println("Número de cuenta:");
		String cuenta = sc.nextLine();
		System.out.println("Saldo inicial:");
		double saldo = sc.nextDouble();
		sc.nextLine();
		System.out.println("Tipo de interés");
		double tipoDeInteres = sc.nextDouble();
		sc.nextLine();
		try {
			listacuentas.add(new Cuenta(nombre, cuenta, saldo, tipoDeInteres));
			System.out.println("Cuenta creada exitósamente");
		} catch (Exception e) {
			System.out.println("Ha habido un error al crear la cuenta, inténtelo de nuevo");
		}
	}
	public static void consultaCuenta() {
		System.out.println("Introduzca el número de cuenta:");
		String cuenta = sc.nextLine();
		boolean encontrado = false;
		for (Cuenta cuenta2 : listacuentas) {
			if(cuenta2.getCuenta().equalsIgnoreCase(cuenta)) {
				System.out.println(cuenta2.toString());
				encontrado = true;
				break;
			}
		} if (!encontrado) {
			System.out.println("La cuenta que busca no existe");
		}
	}
	public static void ingresarDinero() {
		System.out.println("Número de cuenta");
		String cuenta = sc.nextLine();
		boolean encontrado = false;
		for (Cuenta cuenta2 : listacuentas) {
			if(cuenta2.getCuenta().equalsIgnoreCase(cuenta)) {
				encontrado = true;
				System.out.println("Cantidad a ingresar:");
				double cantidad = 0;
				try {
					cantidad = sc.nextDouble();
					sc.nextLine();
					cuenta2.ingreso(cantidad);
					System.out.println("Ingreso realizado correctamente");
				}catch (InputMismatchException e) {
					System.out.println("Error: Introduzca un número válido");
					sc.nextLine();
				} catch(Exception e) {
					System.out.println("Cantidad no puede ser negativa");
				}
				break;
			}
		} 
		if(!encontrado) {
			System.out.println("Cuenta no encontrada");
		}
	}
	public static void retirarDinero() {
		System.out.println("Número de cuenta");
		String cuenta = sc.nextLine();
		boolean encontrado = false;
		for (Cuenta cuenta2 : listacuentas) {
			if(cuenta2.getCuenta().equalsIgnoreCase(cuenta)) {
				encontrado = true;
				System.out.println("Cantidad a retirar:");
				double cantidad = 0;
				try {
					cantidad = sc.nextDouble();
					sc.nextLine();
					cuenta2.reintegro(cantidad);
					System.out.println("Reintegro realizado correctamente");
				} catch (InputMismatchException e) {
					// TODO Auto-generated catch block
					System.out.println("Error: Introduzca un número válido");
					sc.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error: Cantidad mayor que saldo");
					sc.nextLine();
				}
				break;
			}
		} 
		if(!encontrado) {
			System.out.println("Cuenta no encontrada");
		}
	}
	public static void anularCuenta() {
		System.out.println("Número de cuenta:");
		String cuenta = sc.nextLine();
		boolean encontrado = false;
		for (Cuenta cuenta2 : listacuentas) {
			if(cuenta2.getCuenta().equalsIgnoreCase(cuenta)) {
				encontrado = true;
				listacuentas.remove(cuenta2);
				System.out.println("Cuenta eliminada con éxito");
				break;
			}
		} 
		if(!encontrado) {
			System.out.println("Cuenta no encontrada");
		}
	}
	public static void listadoCuentas() {
		for (Cuenta cuenta : listacuentas) {
			System.out.println(cuenta.toString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			menu();
			System.out.println("Seleccione una opción");
			int selector = -1;
			try{
				selector = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido");
				sc.nextLine();
				continue;
			}
			switch (selector) {
			case 1:altaCuenta(); break;
			case 2:consultaCuenta();break;
			case 3:ingresarDinero();break;
			case 4:retirarDinero();break;
			case 5:anularCuenta();break;
			case 6:listadoCuentas();break;
			case 0:System.out.println("Saliendo..."); return;
			default:System.out.println("Elija una opción correcta");break;
			}
		}
	}

}
