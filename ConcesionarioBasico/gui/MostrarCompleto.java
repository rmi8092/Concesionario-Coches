/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import concesionarioCochesCompleto.Coche;
import concesionarioCochesCompleto.Concesionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase MostrarCompleto.
 */
public class MostrarCompleto extends VentanaPadre {
	/**
	 * Campo &iacute;ndiceCoche.
	 */
	private int indiceCoche;
	/**
	 * Campo concesionario.
	 */
	Concesionario concesionario;

	/**
	 * Construye el di&aacute;logo.
	 */
	public MostrarCompleto(Concesionario concesionario) {
		super();
		this.concesionario = concesionario;
		setTitle("Mostrar Concesionario Completo");
		setBounds(100, 100, 450, 251);
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		botonAzul.setEnabled(false);
		botonPlata.setEnabled(false);
		botonRojo.setEnabled(false);
		botoneraColores.setEnabled(false);
		datoMatricula.setEnabled(false);
		botonPosterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPosterior();
			}
		});
		botonPrevio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPrevio();
			}
		});
		mostrarCoche(concesionario.get(0));
		finBotones();
	}

	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarCoche y finBotones cuando se pulsa el bot&eacute;n de avance.
	 */
	protected void botonPosterior() {
		mostrarCoche(concesionario.get(++indiceCoche));
		finBotones();
	}

	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarCoche y finBotones cuando se pulsa el bot&eacute;n de retroceso.
	 */
	protected void botonPrevio() {
		mostrarCoche(concesionario.get(--indiceCoche));
		finBotones();
	}
	
	/**
	 * M&eacute;todo que rellena los campos y botonera con las caracter&iacute;sticas del coche en una posici&oacute;n dada del concesionario.
	 */
	private void mostrarCoche(Coche coche) {
		datoMatricula.setText(coche.getMatricula());
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
	
	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (concesionario.get(indiceCoche + 1) == null)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);

		if (concesionario.get(indiceCoche - 1) == null)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
	}
}
