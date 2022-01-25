package main;
/**
 * @author Camilo Ignacio Lavado
 * @date 16/10/2022
 * @version 2.0.3
 */

public class Requerimientos {/*
	
	[X]	1. Crear un proyecto nuevo a travÃ©s de eclipse como proyecto Java:
		â—� Nuevo Proyecto > Proyecto Java > Ingresar nombre proyecto > Finalizar.
	
	[X]	2. Crear 6 paquetes sobre los cuales trabajaremos:
		â—� Package main
		â—� Package modelo
		â—� Package servicio
		â—� Package test
		â—� Package utilidades
		â—� Package vista
	
	[X]	3. Crear el enum CategorÃ­aEnum en el package Modelo, la cual contendrÃ¡ 2 posibles
		valores: Activo e Inactivo.
	
	[X]	4. Crear la clase Cliente en package modelo, con los siguientes requisitos:
		â—� String runCliente
		â—� String nombreCliente
		â—� String apellidoCliente
		â—� String aniosCliente (se puede cambiar a int si lo desea)
		â—� CategoriaEnum nombreCategoria
		â—� Generar el constructor con parÃ¡metros
		â—� Generar los getter y setter correspondientes
		â—� Generar el toString para los parÃ¡metros
	
	[X]	5. Crear la clase Main con mÃ©todo public static void en el package main, la cual usarÃ¡
		una instancia para iniciar el menÃº.
		B) Utilizar Ciclos y mÃ©todos (2 Puntos)
	
	[X]	6. Crear clase Menu en el package vistas, que debe contener los siguientes atributos:
		â—� clienteServicio, instancia de ClienteServicio.
		â—� archivoServicio, instancia de ArchivoServicio.
		â—� exportadorCsv, instancia de ExportarCsv.
		â—� exportarTxt, instancia de ExportarTxt.
		â—� Definir un String fileName = â€œClientesâ€� (para exportar el archivo)
		â—� Definir un String fileName1 = â€œDBClientes.csvâ€� (para importar el archivo)
		â—� scanner, instancia de Scanner para recibir valores a travÃ©s del teclado.
		â—� iniciarMenu, muestra el menu principal y recibe la entrada del teclado a travÃ©s
		del scanner. Contiene la lÃ³gica para denotar los demÃ¡s mÃ©todos en base a la
		entrada del teclado.
	
	[X]	7. La clase Menu debe contener los siguientes mÃ©todos para la construcciÃ³n y
		selecciÃ³n del menu:
		â—� listarCliente.
		â—� agregarCliente.
		â—� editarCliente.
		â—� importarDatos.
		â—� exportarDatos.
		â—� terminarPrograma.
	
	[X]	8. Se deben sobreescribir los mÃ©todos nombrados previamente en el punto 7, dentro de
		la misma clase Menu de la siguiente manera:
		â—� listarClientes, muestra lista de clientes agregados, ya sea por importaciÃ³n o
		agregando a mano.
		â—� agregarCliente, solicita ingreso de datos y llena objeto de tipo Cliente.
		â—� editarCliente, permite la ediciÃ³n de algÃºn cliente en caso de requerirlo o
		cambiar el estado del cliente.
		â—� cargarDatos, ejecuta la carga de datos del archivo â€œDBClientes.csvâ€�.
		â—� exportarDatos, llama a mÃ©todo para exportar clientes en formato â€œ.txtâ€� o
		â€œ.csvâ€�.
		â—� terminarPrograma, el cual finaliza la ejecuciÃ³n del sistema.
		Hint: El Ãºnico mÃ©todo que no se debe sobreescribir es iniciarMenu, ya que contiene su
		implementaciÃ³n al inicio de la clase para formar el menÃº.
		C) Utilizar Arreglos y archivos (2 Puntos)
	
	* [X]	9. Crear la clase ClienteServicio en el package servicio con los siguientes requisitos:
		â—� Crear un atributo llamado List<Cliente> listaClientes.
		â—� Generar un constructor de ClienteServicio que tenga esta listaClientes como
		una nueva ArrayList.
		â—� Generar el mÃ©todo pÃºblico sin valor de retornolistarClientes e implementar el
		ciclo mÃ¡s idÃ³neo para recorrer cada uno de los clientes.
		â—� Generar un public void del mÃ©todo agregarCliente y pasarle los parÃ¡metros de
		la clase Cliente. Utiliza este mÃ©todo para guardar clientes en una instancia de
		cliente.
		â—� Generar un public void del mÃ©todo editarCliente y pasarle los parÃ¡metros de
		la clase Cliente.
		â—� Crear un getter de listaCliente y que pueda retornar una listaClientes.
		D) Aplicar Polimorfismo y Herencia segÃºn el Paradigma Orientado a Objetos (POO)
		(2 Puntos)
	
	[X]	10. Crear una clase abstracta de nombre Exportador en package Servicio, que contenga
		un mÃ©todo abstracto para exportar, cuyos parÃ¡metros serÃ¡n String fileName y
		List<Cliente> listaClientes.
	
	[X]*	11. Crear una clase ExportadorCsv en el package servicio, que contenga un mÃ©todo
		exportar, cuyos parÃ¡metros serÃ¡n String fileName y una List<Cliente> listaClientes.
		Se deben realizar las implementaciones correspondientes al interior del mÃ©todo
		usando PrintWriter y Filewriter para la exportaciÃ³n de archivos.
	
	[X]*	12. Crear una clase ExportadorTxt en el package servicio, que contenga un mÃ©todo
		exportar, cuyos parÃ¡metros serÃ¡n String fileName y una List<Cliente> listaClientes.
		Se deben realizar las implementaciones correspondientes al interior del mÃ©todo
		usando PrintWriter y Filewriter para exportaciÃ³n de archivos.
		
		Hint: Los pasos 8, 9 y 10 buscan tener una clase abstracta (Exportador), con un solo
		mÃ©todo exportar, cuyas clases ExportadorCsv y ExportadorTxt extienden de esta
		clase e implementan su mÃ©todo. Por lo tanto, los mÃ©todos declarados serÃ¡n
		pertenecientes a cada Exportador bajo el concepto de herencia. Al utilizarlo, se
		instancia alguno de los exportadores en la clase menu ocupando polimorfismo.
		E) Aplicar instancias al Paradigma Orientado a Objetos (POO) (2 Puntos)
	
	[X]*	13. Crear la clase ArchivoServicio en el package servicio que extiende a la clase
		Exportador. Esta contiene los siguientes requisitos:
		â—� Crear el mÃ©todo cargarDatos que recibe por parÃ¡metro un String fileName, el
		cual indica el nombre del archivo a cargar. Se deben realizar las
		implementaciones correspondientes al interior del mÃ©todo usando FileReader
		y BufferedReader (para lectura de archivos).
		â—� Crear el mÃ©todo exportar que serÃ¡ una herencia proveniente de la clase
		Exportador, cuyos parÃ¡metros serÃ¡n los mismos que se van a implementar en
		el paso 8.
	
	[X]	14. Crear una clase Utilidad en package utilidades, que contenga mÃ©todos reutilizables
		para el menÃº como limpiar pantalla, mostrar mensajes, etc.
		F) Aplicar pruebas unitarias(1 Punto)
	
	[X]	15. AÃ±adir dependencias para pruebas Unitarias, ver ejemplo en apartado Anexos al final
		del documento.
	
	[X]	16. Escribir pruebas unitarias para ClienteServicio.
		â—� MÃ©todo agrearClienteTest para verificar el funcionamiento de agregarCliente
		(se debe agregar un cliente para que el test corra de manera correcta).
		â—� MÃ©todo agrearClienteNullTest para verificar el funcionamiento de
		agregarCliente en caso que vengan casos nulos (se debe agregar un cliente
		nulo para que el test corra de manera correcta).

*/}
