package concesionarioCochesCompleto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AccionFichero {
	static File fichero;
	
	public static Concesionario abrirFichero(File fichero) throws IOException, ClassNotFoundException{
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			return ((Concesionario)leerObjeto.readObject());
		}
	}
	
	public static void guardarComoFichero(Concesionario concesionario, File fichero) throws IOException {
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
			escribirObjeto.writeObject(concesionario);
		}
	}
}
