/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesCompleto;

/**
 * Excepción lanzada en el caso de que la matricula del coche no sea válida.
 */
public class MatriculaNoValidaException extends Exception {

	public MatriculaNoValidaException(String arg0) {
		super(arg0);
	}
}
