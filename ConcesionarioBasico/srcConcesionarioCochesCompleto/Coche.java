/**
 * Paquete contenedor de las clases Coche, Color, Concesionario, Marca, y Modelo.
 */
package concesionarioCochesCompleto;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Clase Coche.
 */
public class Coche implements Serializable{
	/**
	 * Campo matr&iacute;cula
	 */
	private String matricula;
	/**
	 * Campo color
	 */
	private Color color;
	/**
	 * Campo modelo
	 */
	private Modelo modelo;
	/**
	 * Campo patr&oacute;n de matr&iacute;cula
	 */
	static final private Pattern patternMatricula = Pattern.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Construye instancias de la clase Coche.
	 * @param matr&iacute;cula Matr&iacute;cula del coche.
	 * @param color Color del coche.
	 * @param modelo Modelo del coche.
	 * @throws MatriculaNoValidaException 
	 * @throws ColorNoValidoException 
	 * @throws ModeloNoValidoException 
	 */
	Coche(String matricula, Color color, Modelo modelo) throws MatriculaNoValidaException, ColorNoValidoException, ModeloNoValidoException {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Construye instancias de la clase Coche.
	 * @param matricula Matr&iacute;cula del coche.
	 * @throws MatriculaNoValidaException 
	 */
	Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Comprueba que la matr&iacute;cula es v&aacute;lida seg&uacute;n el patr&oacute;n creado.
	 * @param matr&iacute;cula Matr&iacute;cula del coche.
	 * @return true si la matr&iacute;cula es v&aacute;lida, false si no lo es.
	 */
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * M&eacute;todo setter para asignar matr&iacute;cula al coche.
	 * @param matr&iacute;cula Matr&iacute;cula del coche.
	 * @throws MatriculaNoValidaException 
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if(esValida(matricula))
			this.matricula = matricula;
		else
			throw new MatriculaNoValidaException("La matricula no es valida");
	}

	/**
	 * M&eacute;todo getter para obtener el color del coche.
	 * @return el color de nuestro coche.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * M&eacute;todo setter para asignar color al coche.
	 * @param color Color del coche.
	 * @throws ColorNoValidoException 
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if(color != null)
			this.color = color;
		else throw new ColorNoValidoException("El color no es valido");
	}

	/**
	 * M&eacute;todo setter para asignar modelo al coche.
	 * @param modelo Modelo del coche.
	 * @throws ModeloNoValidoException 
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if(modelo != null)
			this.modelo = modelo;
		else throw new ModeloNoValidoException("El modelo no es valido");
	}

	/**
	 * Si el m&eacute;todo equals() dice que dos objetos son iguales deben tener el mismo valor hash.
	 * @return el valor hash.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara dos objetos en funci&oacute;n de su matr&iacute;cula.
	 * @param obj El objeto a comparar con nuestro coche.
	 * @return true si son el mismo objeto o de igual matr&iacute;cula, false si no lo son.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Convierte en cadena una sucesi&oacute;n de cadenas y objetos.
	 * @return los valores de los campos del coche, es decir, sus caracter&iacute;sticas.
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}
}
