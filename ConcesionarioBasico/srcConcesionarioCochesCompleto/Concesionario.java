/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesCompleto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Concesionario.
 */
public class Concesionario implements Serializable{
	/**
	 * Colecci&oacute;n de coches.
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**
	 * Campo nombre del concesionario.
	 */
	private final String nombre = "IES Gran Capitán";

	/**
	 * Añade un coche a la colecci&oacute;n de coches.
	 * @param matr&iacute;cula Matr&iacute;cula del coche.
	 * @param color Color del coche.
	 * @param modelo Modelo del coche.
	 * @return true si a&ntilde;ade el coche, false si no lo a&ntilde;ade por ser
	 * nulo o ya existir en la colecci&oacute;n.
	 * @throws CocheYaExisteException 
	 * @throws MatriculaNoValidaException 
	 * @throws ModeloNoValidoException 
	 * @throws ColorNoValidoException 
	 */
	public boolean annadir(String matricula, Color color, Modelo modelo) throws Exception{//throws CocheYaExisteException, MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		Coche coche = new Coche(matricula, color, modelo);
		if (almacen.contains(coche))
			throw new CocheYaExisteException("El coche ya existe en su almacen");
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche de la colecci&oacute;n de coches.
	 * @param matr&iacute;cula Matr&iacute;cula del coche.
	 * @return true si elimina el coche, false si no lo elimina por no existir en la colecci&oacute;n.
	 * @throws MatriculaNoValidaException 
	 * @throws CocheNoExisteException 
	 */
	public void eliminar(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		if(almacen.remove(new Coche(matricula)))
			return ;
		else
			throw new CocheNoExisteException("El coche no existe en el concesionario.");
	}

	/**
	 * Calcula el tama&ntilde;o de una colecci&oacute;n de objetos.
	 * @return El tama&ntilde;o de la colecci&oacute;n.
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el Coche del almac&eacute;n indicado por la matr&iacute;cula.
	 * @param matr&iacute;cula Matr&iaccute;cula a buscar.
	 * @return el coche contenido en el almac&eacute;n, o null si no existe.
	 * @throws MatriculaNoValidaException 
	 * @throws CocheNoExisteException 
	 */
	public Coche get(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = new Coche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		throw new CocheNoExisteException("El coche no existe en su concesionario");
	}

	public Coche get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return almacen.get(index);
	}
	
	/**
	 * Convierte en cadena una sucesi&oacute;n de cadenas y objetos.
	 * @return los objetos contenidos en la colecci&oacute;n.
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}
	
	/**
	 * Devuelve una colecci&oacute;n de coches con el mismo color.
	 * @param color Color a buscar.
	 * @return la colecci&oacute;n de coches que comparten el color especificado por par&aacute;metro.
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}
}
