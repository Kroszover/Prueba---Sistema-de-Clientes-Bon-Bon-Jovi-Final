package modelo;
/**
 * @author Camilo Ignacio Lavado
 * @date 16/01/2022
 * @version 2.0.3
 */

public class Cliente {
	//Parametros Solicitados
	
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	//Constructor
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	
	//GETTERS Y SETTERS
	public String getRunCliente() {
		return runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	
	//Metodo TOSTRING
	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	
	
}
