/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesConExcepciones;

/**
 * Excepción lanzada en el caso de que el coche no exista en el concesionario.
 */
public class CocheNoExisteException extends Exception {

	public CocheNoExisteException(String arg0) {
		super(arg0);
	}
}
