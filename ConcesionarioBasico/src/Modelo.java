package examenObjetosEstructuras;

/**
 * @author Rafael Miranda Ibanez
 */

public enum Modelo {
	SERIE1("BMW"),
	SERIE2("BMW"),
	SERIE3("BMW"),
	SERIE5("BMW"),
	CORDOBA("SEAT"),
	IBIZA("SEAT"),
	TOLEDO("SEAT");
	
	private String marca;

	Modelo(String marca){
		this.marca = marca;
	}

	String getComentario() {
		return marca;
	}

	void setComentario(String marca) {
		this.marca = marca;
	}
	
	Modelo obtenerSERIE1(){
		return Modelo.SERIE1;
	}
	
	Modelo obtenerSERIE2(){
		return Modelo.SERIE2;
	}
	
	Modelo obtenerSERIE3(){
		return Modelo.SERIE3;
	}
	
	Modelo obtenerSERIE5(){
		return Modelo.SERIE5;
	}
	
	Modelo obtenerCORDOBA(){
		return Modelo.CORDOBA;
	}
	
	Modelo obtenerIBIZA(){
		return Modelo.IBIZA;
	}
	
	Modelo obtenerTOLEDO(){
		return Modelo.TOLEDO;
	}
}
