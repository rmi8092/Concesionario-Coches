/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JOptionPane;

import concesionarioCochesCompleto.CocheNoExisteException;
import concesionarioCochesCompleto.MatriculaNoValidaException;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase Eliminar.
 */
public class Eliminar extends VentanaPadre {

	/**
	 * Construye el di&aacute;logo.
	 */
	public Eliminar() {
		super();
		setTitle("Eliminar");
		botonAccion.addActionListener(new ActionListener() {
			private Component parentComponent;

			public void actionPerformed(ActionEvent arg0) {
				try {
					int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Confirma que desea eliminar el coche?", "Eliminar", JOptionPane.YES_NO_OPTION);
					if(eleccion == JOptionPane.YES_OPTION){
						Principal.concesionario.eliminar(datoMatricula.getText());
						JOptionPane.showMessageDialog(contenedor, "Has eliminado el coche matricula: " + datoMatricula.getText());
					}
					else
						return;
				} catch (MatriculaNoValidaException | CocheNoExisteException e) {
					JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonAccion.setText("Eliminar");
		setBounds(100, 100, 450, 251);
		etiquetaMarca.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		etiquetaModelo.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		botonAzul.setEnabled(false);
		botonPlata.setEnabled(false);
		botonRojo.setEnabled(false);
		botoneraColores.setEnabled(false);
		botonPrevio.setEnabled(false);
		botonPosterior.setEnabled(false);
	}
}
