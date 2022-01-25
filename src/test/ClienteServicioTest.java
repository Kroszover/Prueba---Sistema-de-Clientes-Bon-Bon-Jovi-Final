package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicioImp;

public class ClienteServicioTest {
	
	private ClienteServicioImp clienteServicio;

	@Before
	public void setup() {
		clienteServicio = new ClienteServicioImp();
	}
	
	@Test
	public void agregarClienteTest() {
		//se agregan elementos a la list
		Cliente cliente = new Cliente("19281974-5", "Mario", "Bros", "1", CategoriaEnum.ACTIVO);
		
		//Llamado al metodo
		clienteServicio.agregarCliente(cliente);
		
		//Comparacion
		Assert.assertNotNull(clienteServicio.retornoCliente("19281974-5"));
	}
	
	@Test
	public void agregarClienteNullTest() {
		//se entrega el dato null
		Cliente cliente = null;
		
		//Llamado al metodo
		clienteServicio.agregarCliente(cliente);
		
		//Comparacion
		Assert.assertEquals(clienteServicio.getListaClientes().size(), 0);
	}

}
