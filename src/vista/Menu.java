package vista;
/**
 * @author Camilo Ignacio Lavado
 * @date 16/01/2022
 * @version 2.0.3
 */

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ClienteServicioImp;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {

	private ClienteServicio clienteServicio = new ClienteServicioImp();
	private ArchivoServicio archivoServicio = new ArchivoServicio();
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	private String Scanner(String infoPantalla) {
		System.out.print(infoPantalla);
		String teclado = scanner.nextLine();
		return teclado;
	}

	@Override
	public void listarCliente() {
		if (clienteServicio.getListaClientes().size() > 0) {
			clienteServicio.retornoListarClientes().stream().forEach(c -> {
				System.out.println("\n--------------------" + "Datos del Cliente" + "--------------------\n");
				System.out.println(Utilidad.DatosDeClientePorPantalla(c,false));
				System.out.println("\n---------------------------------------------------------");
			});
		} else {
			System.out.println("Listar Clientes\n"+ "Aún no hay clientes registrados\n");
		}

	}

	
	@Override
	public void agregarCliente() {
		System.out.println("\n--------------------" + "Agregar Cliente" + "--------------------\n");
		String run = Scanner("Ingrese RUN del Cliente: ");
		if (!run.isEmpty()) {
			Cliente cli = clienteServicio.getListaClientes().stream().filter(c -> c.getRunCliente().equals(run)).findAny().orElse(null);
			if (cli!=null) { //Comprobamos si hay algún run repetido.
				System.out.println("Se ha producido un error\n" + "El RUN ya existe en la lista.");
			}else {
				String nombre = Scanner("Ingrese Nombre del Cliente: ");
				if (!nombre.isEmpty()) {
					String apellido = Scanner("Ingrese Apellido del Cliente: ");
					if (!apellido.isEmpty()) {
						String anios = Scanner("Ingrese años como Cliente: ");
						if (!anios.isEmpty()) {
							Cliente cliente = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
							clienteServicio.agregarCliente(cliente);
							System.out.println("\n------" + "Mensaje" + "------\n"+"Cliente agregado a la lista");
						} else {
							System.out.println("Se ha producido un error\n" + "Por favor ingrese la cantidad de años como cliente.");
						}
					} else {
						System.out.println("Se ha producido un error\n" + "Por favor ingrese el apellido del cliente.");
					}
				} else {
					System.out.println("Se ha producido un error\n" + "Por favor ingrese el nombre del cliente.");
				}
			}
		} else {
			System.out.println("Se ha producido un error\n" + "Por favor ingrese el rut del cliente.");
			
	}}

	
	@Override
	public void editarCliente() {
		String run = "";
		Cliente cliente;

		if (clienteServicio.getListaClientes().size() > 0) {
			System.out.println("\n--------------------" + "Editar Cliente" + "--------------------\n");
			String opcion = Scanner("Seleccione que desea hacer:\n" + "1.- Cambiar el estado del Cliente\n"
					+ "2.- Editar los datos ingresados del cliente\n\n" + "Ingrese opción: ");
			switch (opcion) {
			case "1":
				System.out.println("\n--------------------" + "Cambiar Estado de un Cliente" + "--------------------\n");
				run = Scanner("Ingrese RUN del cliente a editar: ");
				cliente = clienteServicio.retornoCliente(run);
				if (cliente != null) {
					System.out.println("\nEl estado actual del cliente \"" + cliente.getRunCliente() + "\" es : "
							+ cliente.getNombreCategoria().name());
					String respuesta = Scanner("¿Esta seguro de modificar el estado del cliente [Y/N]?: ");
					if (respuesta.toUpperCase().equals("Y")) {
						editarDatosCliente("5", String.valueOf(cliente.getNombreCategoria().ordinal()), cliente.getRunCliente());
					} else {
						System.out.println("\n------" + "Mensaje" + "------\n"+"El estado del cliente no fue modificado.");
					}
				} else {
					System.out.println("\n------" + "Mensaje" + "------\n"+"El run del cliente no existe");
				}
					
				break;
			case "2":
				System.out.println("\n--------------------" + "Editar Datos Cliente" + "--------------------\n");
				run = Scanner("Ingrese RUN del cliente a editar: ");
				cliente = clienteServicio.retornoCliente(run);
				if (cliente != null) {
					System.out.println("\n---------------------------------------------------------\n");
					System.out.println(Utilidad.DatosDeClientePorPantalla(cliente, true));
					System.out.println("\n---------------------------------------------------------\n");
					String opcion1 = Scanner("Ingrese opción a editar de los datos del cliente: ");
					String nuevoDato = "";
					switch (opcion1) {
					case "1":
						String nuevoRun = Scanner("\nIngrese nuevo RUN del Cliente: ");
						if (!nuevoRun.isEmpty()) {
							Cliente cliente1 = clienteServicio.getListaClientes().stream().filter(c -> c.getRunCliente().equals(nuevoRun)).findAny().orElse(null);
							if (cliente1==null) { //No existe el RUN en la lista
								editarDatosCliente(opcion1, nuevoDato, run);
							}else { //El RUN existe y debiera ser único.
								System.out.println("Se ha producido un error\n" + "El RUN ya existe en la lista. No fue modificado\n");
								
							}
						} else {
							System.out.println("Se ha producido un error\n" + "No puede ingresar un RUN vacío.\n");
						}
						break;
					case "2":
						nuevoDato = Scanner("'\nIngrese nuevo Nombre del Cliente: ");
						if (!nuevoDato.isEmpty()) {
							editarDatosCliente(opcion1, nuevoDato, run);
						} else {
							System.out.println("Se ha producido un error\n" + "No puede ingresar un nombre vacío.\n");
						}
						break;
					case "3":
						nuevoDato = Scanner("\nIngrese nuevo Apellido del Cliente: ");
						if (!nuevoDato.isEmpty()) {
							editarDatosCliente(opcion1, nuevoDato, run);
						} else {
							System.out.println("Se ha producido un error\n" + "No puede ingresar un Apellido vacío.\n");
						}
						break;
					case "4":
						nuevoDato = Scanner("\nIngrese la nueva cantidad de Años del Cliente: ");
						if (!nuevoDato.isEmpty()) {
							editarDatosCliente(opcion1, nuevoDato, run);
						} else {
							System.out.println("Se ha producido un error\n" + "No puede ingresar una cantidad de años vacía.\n");
						}
						break;
					default:
						System.out.println("Se ha producido un error\n" + "Opción invalida\n");
					}
		
				} else {
					System.out.println("\n------" + "Mensaje" + "------\n"+"El run del cliente no existe");
				}
				break;
			default:
				System.out.println("Se ha producido un error\n" + "Opción invalida\n");
			}
				
		} else {
			System.out.println("\n------" + "Editar Clientes" + "------\n"+"No existen Clientes para editar");
		}

	}

	private void editarDatosCliente(String opcionAModificar, String valorNuevo, String run) {
		ArrayList<String> datosYaEditados = new ArrayList<String>();
		datosYaEditados.add(opcionAModificar);
		datosYaEditados.add(valorNuevo);
		clienteServicio.editarCliente(run, datosYaEditados);
		System.out.println("\n------" + "Mensaje" + "------\n"+"Dato modificado con éxito.\n");
	}
		

	@Override
	public void importarCliente() {
		System.out.println("\n--------------------" + "Cargar Datos CSV" + "--------------------\n");
		String ruta = Scanner("Ingresa la ruta en donde se encuentra el archivo \"DBClientes.csv\" [Solo ENTER directorio raíz del proyecto]: ");
		if(Utilidad.validarExistenciaArchivo(ruta,"DBClientes.csv")) {
			List<Cliente> listaCliente = archivoServicio.cargarDatos(ruta, "DBClientes.csv", clienteServicio.getListaClientes());
			
			if (listaCliente != null) {
				listaCliente.forEach(c -> clienteServicio.agregarCliente(c));
			}
			System.out.println("\n------" + "Mensaje" + "------\n"+"Datos cargados correctamente en la lista.\n");
		}
	}

	@Override
	public void exportarCliente() {
		String ruta = "";
		if (clienteServicio.getListaClientes().size() > 0) {
			System.out.println("\n--------------------" + "Exportar Archivo" + "--------------------\n");
			String opcion = Scanner("Seleccione el formato a exportar:\n" + "1.- Formato Csv\n"
					+ "2.- Formato Txt\n\n" + "Ingrese una opción para exportar: ");
			switch (opcion) {
			case "1":
				System.out.println("\n--------------------" + "Exportar CSV" + "--------------------\n");
				ruta = Scanner("Ingrese la ruta en donde desea exportar el archivo \"Clientes.csv\".\n"
						+ "Si la ruta no existe, esta será creada: ");
				if(exportadorCsv.exportar(ruta, "Clientes.csv", clienteServicio.getListaClientes())) {
					System.out.println("\n------" + "Mensaje" + "------\n"+"Datos de clientes exportados correctamente en formato csv.\n");
				}
				break;
			case "2":
				System.out.println("\n--------------------" + "Exportar TXT" + "--------------------\n");
				ruta = Scanner("Ingrese la ruta en donde desea exportar el archivo \"Clientes.txt\". \n"
						+ "Si la ruta no existe, esta será creada: ");
				if (exportadorTxt.exportar(ruta, "Clientes.txt", clienteServicio.getListaClientes())) {
					System.out.println("\n------" + "Mensaje" + "------\n"+"Datos de clientes exportados correctamente en formato txt.\n");
				}
				break;
			default:
				System.out.println("Se ha producido un error\n" + "Opción invalida\n");
			}
				
		} else {
			System.out.println("\n------" + "Mensaje" + "------\n"+"No existen Clientes para exportar\n");
		}

	}

	@Override
	public void terminarPrograma() {
		System.out.println("\n------" + "Saliendo" + "------\n"+"Está saliendo del sistema\n");
		
	}
	public static void salir() {
		Utilidad.limpiezadePantalla();
		System.exit(0);
	}

	

}
