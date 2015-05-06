/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesConExcepciones;

/**
 * Enumeraci&oacute;n Modelo
 */
public enum Modelo {
	/**
	 * Modelo SERIE1
	 * @param marca BMW
	 */
	SERIE1(Marca.BMW),
	/**
	 * Modelo SERIE2
	 * @param marca BMW
	 */
	SERIE2(Marca.BMW),
	/**
	 * Modelo SERIE3
	 * @param marca BMW
	 */
	SERIE3(Marca.BMW),
	/**
	 * Modelo SERIE5
	 * @param marca BMW
	 */
	SERIE5(Marca.BMW),
	/**
	 * Modelo CORDOBA
	 * @param marca SEAT
	 */
	CORDOBA(Marca.SEAT),
	/**
	 * Modelo IBIZA
	 * @param marca SEAT
	 */
	IBIZA(Marca.SEAT),
	/**
	 * Modelo TOLEDO
	 * @param marca TOLEDO
	 */
	TOLEDO(Marca.SEAT);
	
	/**
	 * Campo marca
	 */
	private Marca marca;

	/**
	 * M&eacute;todo setter para asignar marca al modelo
	 * @param marca La marca correspondiente.
	 */
	private Modelo(Marca marca) {
		this.marca = marca;
	}

	/**
	 * M&eacute;todo getter para obtener la marca.
	 * @return la marca correspondiente.
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * Convierte en cadena una sucesi&oacute;n de cadenas y objetos.
	 * @return el modelo y la marca a la que pertenece.
	 */
	public String toString() {
		return name();

	}

	// Para el menú-------------------------------------------------
	
	/**
	 * Campo constante de tipo array y nombre Values.
	 */
	private static final Modelo[] VALUES = Modelo.values();

	/**
	 * Genera las diferentes opciones del men&uacute;.
	 * @return un array con las diferentes opciones del men&uacute;
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Obtiene los valores de la enumeraci&oacute;n
	 * @return el valor de la enumeraci&oacute;n
	 */
	public static Modelo[] getValues() {
		return VALUES;
	}
	// -------------------------------------------------
}
