package examenObjetosEstructuras;

/**
 * @author Rafael Miranda Ibanez
 */

import java.util.ArrayList;

public class ListaCoches {

	ArrayList<Coche> lista;
	
	public ListaCoches() {
		setLista(new ArrayList<Coche>());
	}

	ArrayList<Coche> getLista() {
		return lista;
	}

	void setLista(ArrayList<Coche> lista) {
		this.lista = lista;
	}
	
	void annadirCoche(Color color, Modelo modelo, String matricula){
		Coche coche = Coche.instanciarCoche(color, modelo, matricula);
		if(coche == null || lista.contains(coche))
			return;
		lista.add(coche);
	}
	
	void eliminarCoche(String matricula){
		Coche coche = new Coche(matricula);
		lista.remove(coche);
	}
	
	int tamaño(){
		return lista.size();
	}

	@Override
	public String toString() {
		return "ListaCoches [lista=" + lista + "]";
	}
}
