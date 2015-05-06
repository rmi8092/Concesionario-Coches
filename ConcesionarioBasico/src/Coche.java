package examenObjetosEstructuras;

/**
 * @author Rafael Miranda Ibanez
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coche {

	private static final Pattern reGexMatricula = Pattern.compile("^(\\d{4})(\\-|\\s)?([B-Z[^AEIOUaeiou—Q]]{3})$");
	private String matricula;
	private Color color;
	private Modelo modelo;
		
	Coche(String matricula) {
		setMatricula(matricula);
	}
	
	Coche(Color color, Modelo modelo, String matricula) {
		setColor(color);
		setModelo(modelo);
		setMatricula(matricula);
	}

	Color getColor() {
		return color;
	}

	void setColor(Color color) {
		this.color = color;
	}

	Modelo getModelo() {
		return modelo;
	}

	void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	String getMatricula() {
		return matricula;
	}

	void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	static Coche instanciarCoche(Color color, Modelo modelo, String matricula){
		if(!esValidoMatricula(matricula)||color==null||modelo==null)
			return null;
		else
			return new Coche(color,modelo,matricula);
	}
	
	static boolean esValidoMatricula(String matricula){
		Matcher motor = reGexMatricula.matcher(matricula);
		if(motor.matches())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Coche [\nmatricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

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
}
