package vista;
/**
 * @author Camilo Ignacio Lavado
 * @date 16/01/2022
 * @version 2.0.3
 */

import java.util.Scanner;

import utilidades.Utilidad;

public abstract class MenuTemplate {

	protected Scanner scanner = new Scanner(System.in);

	public abstract void listarCliente();

	public abstract void agregarCliente();

	public abstract void editarCliente();

	public abstract void importarCliente();

	public abstract void exportarCliente();

	public abstract void terminarPrograma();
	

	public final void iniciarMenu() {
		String opcionmenu="";
		do {
			System.out.println("___________________________");
			System.out.println("MENÚ");
			System.out.println("__________________________________");
			System.out.println("1. Listar Clientes\r\n" + "2. Agregar Clientes\r\n" + "3. Editar Clientes\r\n"
					+ "4. Cargar Datos\r\n" + "5. Exportar Datos\r\n" + "6. Salir\r\n" + "Ingrese una opción:");
			opcionmenu = scanner.nextLine();

			switch (opcionmenu) {
			case "1":
				listarCliente();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente();
				break;
			case "4":
				importarCliente();
				break;
			case "5":
				exportarCliente();
				break;
			case "6":
				terminarPrograma();
				Utilidad.Pausa(1000);
				Menu.salir();
				break;
			default:
				System.out.println("Se ha producido un error\n" + "Opción invalida\n");
			}
		} while(opcionmenu!="6");
		
	}

}
