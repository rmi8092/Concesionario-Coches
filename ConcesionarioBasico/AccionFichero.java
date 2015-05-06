package concesionarioCochesConExcepciones;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccionFichero {
	static File fichero;
	
	public static Concesionario abrirFichero(String nombre) throws IOException, ClassNotFoundException{
		if(incluirExtension(nombre))
			fichero = new File(nombre);
		else 
			fichero = new File(nombre + ".obj");
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			return ((Concesionario)leerObjeto.readObject());
		}
	}
	
	public static void guardarComoFichero(Concesionario concesionario, String nombre) throws IOException {
		if(incluirExtension(nombre))
			fichero = new File(nombre);
		else 
			fichero = new File(nombre + ".obj");
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
			escribirObjeto.writeObject(concesionario);
		}
	}
	
	private static boolean incluirExtension(String nombre){
		return nombre.contains(".obj");
	}
}
