/**
 * 
 */
package utilidades;

import java.io.File;
import java.io.IOException;

import modelo.Cliente;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import vista.Menu;

/**
 * @author Camilo Ignacio Lavado
 * @date 16/10/2022
 * @version 2.0.3
 */
public class Utilidad {
	
	
	//Metodo para dejar la pantalla en blanco
		public static void limpiezadePantalla() {
			for (int i = 0; i < 50; i++) {
				System.out.println("        ");
			}
			System.out.println();
			System.out.flush();
		}
	//Metodo de confirmación de operacion exitosa
		public static void Cierrefuncion() throws InterruptedException{
			Thread.sleep(300);
			System.out.println("Operación completada.");
			System.out.println("volviendo al menú principal.");
		}
	
	
	public static boolean validarExistenciaArchivo(String ruta, String nombreArchivo) {
		String directorio = ruta.isEmpty() ? null : ruta;

		if (directorio != null) {
			File directorio1 = new File(ruta);
			if (!directorio1.exists()) {
				System.out.println("\n------" + "Mensaje" + "------\n"+"La carpeta o ruta \"" + ruta + "\" no existe.\n");
				return false;
			}
		}
		
		File archivo = new File(directorio, nombreArchivo);
		if (!archivo.exists()) {
			System.out.println("\n------" + "Mensaje" + "------\n"+"el archivo \"" + nombreArchivo + "\" no existe.\n");
			return false;
		}
		
		return true;
	}
	
	public static boolean CreaDirectorio(String ruta) {
		if (ruta != null) {
			File directorio1 = new File(ruta);
			if (!directorio1.exists()) {
				if (!directorio1.mkdirs()) {
					System.out.println("Se ha producido un error\n "+ "No se pudo crear la carpeta \"" + ruta + "\n.");
					return false;
				}
			}
		}
		return true;
	}

	public static String DatosDeClientePorPantalla(Cliente cliente, boolean despliegaNum) {
		String num1 = despliegaNum ? "1.- " : "";
		String num2 = despliegaNum ? "2.- " : "";
		String num3 = despliegaNum ? "3.- " : "";
		String num4 = despliegaNum ? "4.- " : "";
		String categoria = despliegaNum ? "" : "\nCategoría del Cliente: " + cliente.getNombreCategoria().name();
		return num1 + "RUN del Cliente: " + cliente.getRunCliente() + "\n" + num2 + "Nombre del Cliente: "
				+ cliente.getNombreCliente() + "\n" + num3 + "Apellido del Cliente: " + cliente.getApellidoCliente()
				+ "\n" + num4 + "Años como Cliente: " + cliente.getAniosCliente() + " años" + categoria;
	}

	public static void Pausa(int tiempoMilSeg) {
		try {
			Thread.sleep(tiempoMilSeg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

	

	


