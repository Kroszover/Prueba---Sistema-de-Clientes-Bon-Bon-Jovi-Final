package servicio;
/**
 * @author Camilo Ignacio Lavado
 * @date 18/01/2022
 * @version 2.0.3
 */

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public interface ClienteServicio {
	//Se utiliza el interface y la clase de implementacion ya que resulta mas sencillo de realizar como en los videos de ayuda para la prueba.
	
	List<Cliente> getListaClientes();
	
	void setListaClientes(List<Cliente> listaClientes);
	
	void agregarCliente(Cliente cliente);
	
	List<Cliente> retornoListarClientes();
	
	void editarCliente(String run, ArrayList<String> arrDatosModificar);
	
	Cliente retornoCliente(String run);
}
