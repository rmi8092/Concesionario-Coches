package examenObjetosEstructuras;

/**
 * @author Rafael Miranda Ibanez
 */

public class TestConcesionario {

	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta coche", "Baja coche", "Mostrar coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Salir" });
	static ListaCoches concesionario = new ListaCoches();

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
		default:
			return;
		}
	}

	private static void altaCoche() {
		Color color = pedirColor();
		Modelo modelo = pedirModelo();
		concesionario.annadirCoche(color, modelo,
				Teclado.leerCadena("Introduzca la matricula de su coche: "));
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
		concesionario.eliminarCoche(Teclado
				.leerCadena("Introduzca la matricula del coche a eliminar: "));
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
		return concesionario.tamaño();
	}

	private static void mostrarMismoColor() {
		Color color = pedirColor();
		for (Coche coche : concesionario.getLista()) {
			if (coche.getColor().equals(color))
				System.out.println(coche.toString());
		}
	}
}
