/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesCompleto;

/**
 * Enumeraci&oacute;n Color
 */
public enum Color {
	/**
	 * Color Plata
	 */
	PLATA,
	/**
	 * Color Rojo
	 */
	ROJO,
	/**
	 * Color Azul
	 */
	AZUL;

	/**
	 * Campo constante Values.
	 */
	private static final Color[] VALUES = Color.values();

	/**
	 * Genera las diferentes opciones del men&uacute;.
	 * @return un array con las diferentes opciones del men&uacute;.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Obtiene los valores de la enumeraci&oacute;n.
	 * @return el valor de la enumeraci&oacute;n.
	 */
	public static Color[] getValues() {
		return VALUES;
	}
}
