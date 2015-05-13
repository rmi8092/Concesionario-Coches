/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesCompleto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase AccionFichero.
 * Prueba de colaboración. Emanuel Galván.
 */
public class AccionFichero {
	/**
	 * Objeto fichero.
	 */
	static File fichero;
	
	/**
	 * M&eacute;todo que crea un flujo de lectura del objeto que contiene el fichero.
	 * @param fichero el fichero.
	 * @return leerObjeto el arraylist de tipo Concesionario que contiene el flujo de lectura del objeto que contiene el fichero.
	 */
	public static Concesionario abrirFichero(File fichero) throws IOException, ClassNotFoundException, NullPointerException {
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(comprobarExtension(fichero))))){
			return ((Concesionario)leerObjeto.readObject());
		}
	}
	
	/**
	 * M&eacute;todo que crea un flujo de escritura del objeto que contiene el fichero.
	 * @param concesionario el arraylist que contiene el arraylist de coches.
	 * @param fichero el fichero.
	 */
	public static void guardarComoFichero(Concesionario concesionario, File fichero) throws IOException {
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(comprobarExtension(fichero))))){
			escribirObjeto.writeObject(concesionario);
		}
	}
	
	public static File comprobarExtension(File fichero){
		if((fichero.getPath().endsWith(".obj")))
			return fichero;
		else
			return new File (fichero + ".obj");
	}
}
