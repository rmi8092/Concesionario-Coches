/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesConExcepciones;

/**
 * Excepción lanzada en el caso de que el modelo del coche no sea valido.
 */
public class ModeloNoValidoException extends Exception {

	public ModeloNoValidoException(String arg0) {
		super(arg0);
	}
}
