package servicio;
/**
 * @author Camilo Ignacio Lavado
 * @date 18/01/2022
 * @version 2.0.3
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;


public class ArchivoServicio extends Exportador {
	
	@Override
	public boolean exportar(String ruta, String fileName, List<Cliente> listaClientes) {
		return true;
	}
	
	
	public List<Cliente> cargarDatos(String ruta, String fileName, List<Cliente> listaClientes1) {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String directorio = ruta.isEmpty() ? null : ruta;
		
		try {
			String noSeCar = "";
			File archivo = new File(directorio, fileName);
			BufferedReader bR = new BufferedReader(new FileReader(archivo));
			String lines;
			while((lines=bR.readLine()) != null) {
				String[] datosCliente = lines.split(",");
				String run = datosCliente[0];
				String nombre = datosCliente[1];
				String apellidos = datosCliente [2];
				String anios = datosCliente[3].replaceAll("[^-?0-9]+", " ").trim(); //Se utiliza el replaceAll, para dejar los rut tipo 18.234.123-4 como cadena de datos tipo 182341234
				String categoria = datosCliente[4];
				
				CategoriaEnum catEnum = categoria.toUpperCase().equals("ACTIVO")?CategoriaEnum.ACTIVO:CategoriaEnum.INACTIVO;
				Cliente cliente1 = listaClientes1.stream().filter(c -> c.getRunCliente().equals(run)).findAny().orElse(null);
				if(cliente1==null) {
					Cliente cliente = new Cliente(run, nombre, apellidos, anios, catEnum);
					listaClientes.add(cliente);
				}else {
					noSeCar += "El cliente con Run \"" + run + "\" ya existe en la base datos\n";
				}
			}
			if (!noSeCar.isEmpty()) {
				System.out.println("No se cargaron datos\n "+ noSeCar);
			}
			bR.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido un error\n "+"El error producido es: "+e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido un error\n "+"El error producido es: "+e.getLocalizedMessage());
		}
	
		return listaClientes;
	}

}
