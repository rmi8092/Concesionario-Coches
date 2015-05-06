package concesionarioCochesConExcepciones;

import java.io.IOException;

/**
 * @author Rafael Miranda Ibanez
 */

public class TestConcesionario {

	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta coche", "Baja coche", "Mostrar coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Ficheros", "Salir" });
	static Concesionario concesionario = new Concesionario();
	static boolean modificado = false;
	private static String nombre;

	public static void main(String[] args) {

		do {
			int opcion = menu.gestionar();
			ejecutarMenu(opcion);
		} while (true);
	}

	static void ejecutarMenu(int opcion) {
		switch (opcion) {
		case 1:
			altaCoche();
			break;
		case 2:
			bajaCoche();
			break;
		case 3:
			mostrarCoche();
			break;
		case 4:
			System.out.println(concesionario);
			break;
		case 5:
			System.out.println(contarCoches());
			break;
		case 6:
			mostrarMismoColor();
			break;
		case 7:
			gestionarFicheros();
			break;
		default:
			return;
		}
	}

	private static void gestionarFicheros() {
		Menu menuFicheros = new Menu("Menu Ficheros", new String[] {"Nuevo",
				"Abrir", "Guardar", "Guardar como", "Salir"});
		String nuevoNombre;

		int opcion = menuFicheros.gestionar();
		switch (opcion) {
		case 1:
			if(sobrescribirFichero()){
				crearNuevoConcesionario();
				break;
			}
			if(quieresGuardar()){
				if(modificado){
					try {
						if(sobrescribirFichero()){
							AccionFichero.guardarComoFichero(concesionario, nombre);
							System.out.println("Se ha guardado el fichero con el nombre: " + nombre);
							crearNuevoConcesionario();
						}
					} catch (IOException e) {
						System.out.println(e.getMessage());
						System.err.println("No se ha podido guardar el fichero");
					}
				}
				else {
					try {
						nuevoNombre = Teclado.leerCadena("Con que nombre quiere guardar su fichero?");
						AccionFichero.guardarComoFichero(concesionario, nuevoNombre);
						System.out.println("Se ha guardado el fichero con el nombre: " + nuevoNombre);
						crearNuevoConcesionario();
					} catch (IOException e) {
						System.out.println(e.getMessage());
						System.err.println("No se ha podido guardar el fichero");
					}
				}	
			}
			break;
		case 2:
			try {
				concesionario = AccionFichero.abrirFichero(Teclado.leerCadena("Cual es el nombre del fichero a abrir?"));
				System.out.println("Se ha abierto el fichero");
			} catch (ClassNotFoundException | IOException e) {
				System.out.println(e.getMessage());
				System.err.println("No se ha podido abrir el fichero");
			}
			break;
		case 3:
			if(modificado){
				try {
					if(sobrescribirFichero()){
						AccionFichero.guardarComoFichero(concesionario, nombre);
						System.out.println("Se ha guardado el fichero con el nombre: " + nombre);
					}
					else
						break;
				} catch (IOException e) {
					System.out.println(e.getMessage());
					System.err.println("No se ha podido guardar el fichero");
				}
			}
			else {
				try {
					nuevoNombre = Teclado.leerCadena("Con que nombre quiere guardar su fichero?");
					guardarConcesionario(nuevoNombre);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					System.err.println("No se ha podido guardar el fichero");
				}
			}
			break;
		case 4:
			nuevoNombre = Teclado.leerCadena("Con que nombre quiere guardar su fichero?");
			if(!nombre.equals(nuevoNombre)){
				try {
					guardarConcesionario(nuevoNombre);
				} catch (IOException e) {
					System.out.println(e.getMessage());
					System.err.println("No se ha podido guardar el fichero");
				}
			}
			else {
				try {
					AccionFichero.guardarComoFichero(concesionario, nombre);
					System.out.println("Se ha guardado el fichero con el nombre: " + nombre);
					modificado =true;
				} catch (IOException e) {
					System.out.println(e.getMessage());
					System.err.println("No se ha podido guardar el fichero");
				}
			}
			break;
		default:
			return;
		}
	}

	private static void guardarConcesionario(String nuevoNombre)
			throws IOException {
		AccionFichero.guardarComoFichero(concesionario, nuevoNombre);
		System.out.println("Se ha guardado el fichero con el nombre: " + nuevoNombre);
		modificado = true;
		nombre = nuevoNombre;
	}

	private static void crearNuevoConcesionario() {
		concesionario = new Concesionario();
		System.out.println("Se ha creado en concesionario: " + concesionario);
		modificado = false;
		nombre = "";
	}

	private static boolean quieresGuardar() {
		do{
			char opcion = Teclado.leerCaracter("Quieres guardar el fichero creado previamente antes de crear un concesionario nuevo? y/n");
			if(opcion == 'y'||opcion == 'Y')
				return true;
			if(opcion == 'n'||opcion == 'N')
				return false;
			else{
				System.err.println("Debe introducir una opcion correcta.");
			}
		}while(true);
	}

	private static boolean sobrescribirFichero() {
		char opcion = Teclado.leerCaracter("Se perderá información. Aún así quieres continuar? y/n");
		if(opcion == 'y'||opcion == 'Y')
			return true;
		if(opcion == 'n'||opcion == 'N')
			return false;
		else{
			System.err.println("Debe introducir una opcion correcta.");
			return sobrescribirFichero();
		}	
	}

	private static void altaCoche() {
		Color color = pedirColor();
		Modelo modelo = pedirModelo();
		try {
			concesionario.annadir(Teclado.leerCadena("Introduzca la matricula de su coche: "), color, modelo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Color pedirColor() {
		Menu menuColor = new Menu("Elige color", new String[] { "Plata",
				"Rojo", "Azul", "Salir" });

		int opcion = menuColor.gestionar();
		switch (opcion) {
		case 1:
			return Color.PLATA;
		case 2:
			return Color.ROJO;
		case 3:
			return Color.AZUL;
		default:
			return null;
		}
	}

	private static Modelo pedirModelo() {
		Menu menuModelo = new Menu("Elige modelo", new String[] { "Serie1",
				"Serie2", "Serie3", "Serie5", "Cordoba", "Ibiza", "Toledo",
				"Salir" });

		int opcion = menuModelo.gestionar();
		switch (opcion) {
		case 1:
			return Modelo.SERIE1;
		case 2:
			return Modelo.SERIE2;
		case 3:
			return Modelo.SERIE3;
		case 4:
			return Modelo.SERIE5;
		case 5:
			return Modelo.CORDOBA;
		case 6:
			return Modelo.IBIZA;
		case 7:
			return Modelo.TOLEDO;
		default:
			return null;
		}
	}

	private static void bajaCoche() {
		try {
			concesionario.eliminar(Teclado
					.leerCadena("Introduzca la matricula del coche a eliminar: "));
		} catch (MatriculaNoValidaException | CocheNoExisteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void mostrarCoche() {
		String matricula = Teclado
				.leerCadena("Introduzca la matricula del coche que quieres mostrar:");
		for (Coche coche : concesionario.getLista()) {
			if (coche.getMatricula().equals(matricula))
				System.out.println(coche.toString());
		}
	}

	private static int contarCoches() {
		return concesionario.size();
	}

	private static void mostrarMismoColor() {
		Color color = pedirColor();
		for (Coche coche : concesionario.getCochesColor(color)) {
			if (coche.getColor().equals(color))
				System.out.println(coche.toString());
		}
	}
}