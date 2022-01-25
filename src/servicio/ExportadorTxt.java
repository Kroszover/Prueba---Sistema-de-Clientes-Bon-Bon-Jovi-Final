package servicio;
/**
 * @author Camilo Ignacio Lavado
 * @date 20/01/2022
 * @version 2.0.3
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;
import utilidades.Utilidad;

public class ExportadorTxt extends Exportador {

	@Override
	public boolean exportar(String ruta, String fileName, List<Cliente> listaClientes) {
		String directorio = ruta.isEmpty()?null:ruta;
		File archivo = new File(directorio, fileName);
		
		if (!Utilidad.CreaDirectorio(directorio)) {
			return false;
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			for (Cliente cliente : listaClientes) {
				bw.write("--------------------Datos del Cliente--------------------\n\n");
				bw.write(Utilidad.DatosDeClientePorPantalla(cliente,false));
				bw.write("\n\n---------------------------------------------------------\n\n");
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un error\n "+"El error producido es: "+e.getLocalizedMessage());
			return false;
		}
		
		return true;
	}

}
