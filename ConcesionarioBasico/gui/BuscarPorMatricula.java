/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JOptionPane;
import concesionarioCochesCompleto.Coche;
import concesionarioCochesCompleto.CocheNoExisteException;
import concesionarioCochesCompleto.MatriculaNoValidaException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase BuscarPorMatr&iacute;cula.
 */
public class BuscarPorMatricula extends VentanaPadre {

	/**
	 * Construye el di&aacute;logo.
	 */
	public BuscarPorMatricula() {
		super();
		setTitle("Buscar Por Matrícula");
		botonAccion.setText("Buscar");
		setBounds(100, 100, 450, 251);
		botonPrevio.setEnabled(false);
		botonPosterior.setEnabled(false);
		etiquetaMarca.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		etiquetaModelo.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		botonPrevio.setEnabled(false);
		botonPosterior.setEnabled(false);
		botonAzul.setEnabled(false);
		botonPlata.setEnabled(false);
		botonRojo.setEnabled(false);
		botoneraColores.setEnabled(false);
		botonAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Coche coche;
				try {
					coche = Principal.concesionario.get(datoMatricula.getText());
					buscarCoche(coche);
					datoMatricula.setForeground(java.awt.Color.BLACK);
				} catch (MatriculaNoValidaException | CocheNoExisteException e) {
					datoMatricula.setForeground(Color.RED);
					JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * M&eacute;todo que rellena los campos y botonera con las caracter&iacute;sticas del coche que responde a una matr&iacute;cula especificada.
	 */
	private void buscarCoche(Coche coche) {
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
		switch (coche.getColor()) {
		case AZUL:
			botonAzul.setSelected(true);
			break;
		case PLATA:
			botonPlata.setSelected(true);
			break;
		case ROJO:
			botonRojo.setSelected(true);
			break;
		}
	}
}
