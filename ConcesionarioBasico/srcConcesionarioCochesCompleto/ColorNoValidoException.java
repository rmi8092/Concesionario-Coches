/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesCompleto;

/**
 * Excepción lanzada en el caso de que el color del coche no sea valido.
 */
public class ColorNoValidoException extends Exception {

	public ColorNoValidoException(String arg0) {
		super(arg0);
	}
}
