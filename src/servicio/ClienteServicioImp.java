package servicio;
/**
 * @author Camilo Ignacio Lavado
 * @date 18/01/2022
 * @version 2.0.3
 */

import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;


public class ClienteServicioImp implements ClienteServicio {

	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	@Override
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public void agregarCliente(Cliente cliente) {
		if (cliente != null) {
			listaClientes.add(cliente);
		}
	}

	@Override
	public List<Cliente> retornoListarClientes() {
		return listaClientes;
	}

	@Override
	public void editarCliente(String run, ArrayList<String> datosEditados) {
		int indice = -1;
		int contador = 0;
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(run)) {
				indice = contador;
				break;
			} else {
				contador++;
			}
		}
		if(indice>=0) {
			if (datosEditados.size() > 0) {
				String opcionEditar = datosEditados.get(0);
				String editarDato = datosEditados.get(1);
				switch (opcionEditar) {
				case "1": // Editar el RUN
					listaClientes.get(indice).setRunCliente(editarDato);
					break;
				case "2": // Editar el Nombre
					listaClientes.get(indice).setNombreCliente(editarDato);
					break;
				case "3": // Editar el Apellido
					listaClientes.get(indice).setApellidoCliente(editarDato);
					break;
				case "4": // Editar los años como cliente
					listaClientes.get(indice).setAniosCliente(editarDato);
					break;
				case "5": // Editar  Categoria
					if(editarDato.equals("0")) {
						listaClientes.get(indice).setNombreCategoria(CategoriaEnum.INACTIVO);
					}else {
						listaClientes.get(indice).setNombreCategoria(CategoriaEnum.ACTIVO);
					}
					break;
				}
			} else {
				System.out.println("Se ha producido un error\n "+"No se ingresaron datos para editar");
			}
		}else {
			System.out.println("Se ha producido un error\n "+"No existe el Run de ese cliente");
		}

	}


	@Override
	public Cliente retornoCliente(String run) {
		return listaClientes.stream().filter(c -> c.getRunCliente().equals(run)).findAny().orElse(null);
	}

}
