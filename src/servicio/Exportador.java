package servicio;
/**
 * @author Camilo Ignacio Lavado
 * @date 17/01/2022
 * @version 2.0.3
 */

import java.util.List;

import modelo.Cliente;

public abstract class Exportador {
	
	public abstract boolean exportar(String ruta, String fileName, List<Cliente> listaClientes);
	

}
