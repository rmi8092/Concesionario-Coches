/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import concesionarioCochesCompleto.Coche;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase BuscarPorColor.
 */
public class BuscarPorColor extends VentanaPadre {
	/**
	 * Campo &iacute;ndiceCoche.
	 */
	private int indiceCoche=0;
	/**
	 * Campo coche con el primer elemento del concesionario que re&uacute;ne los coches del color seleccionado.
	 */
	Coche coche = SeleccionarColor.cochesColor.get(0);
	
	/**
	 * Construye el di&aacute;logo.
	 */
	public BuscarPorColor() {
		super();
		setBounds(100, 100, 450, 251);
		setTitle("Buscar Por Color");
		botonAccion.setText("Buscar");
		botonAccion.setEnabled(false);
		etiquetaMatricula.setEnabled(false);
		datoMatricula.setEnabled(false);
		etiquetaMarca.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		etiquetaModelo.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		botonAzul.setEnabled(false);
		botonPlata.setEnabled(false);
		botonRojo.setEnabled(false);
		botoneraColores.setEnabled(false);
		botonPrevio.setEnabled(true);
		botonPosterior.setEnabled(true);
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
		buscarCoche(coche);
		finBotones();
	}

	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarCoche y finBotones cuando se pulsa el bot&eacute;n de retroceso.
	 */
	protected void botonPrevio() {
		buscarCoche(SeleccionarColor.cochesColor.get(--indiceCoche));
		finBotones();
	}

	/**
	 * M&eacute;todo que ejecuta los m&eacute;todos buscarCoche y finBotones cuando se pulsa el bot&eacute;n de avance.
	 */
	protected void botonPosterior() {
		buscarCoche(SeleccionarColor.cochesColor.get(++indiceCoche));
		finBotones();
	}
	
	/**
	 * M&eacute;todo para inhabilitar los botones de avance y retroceso en la b&uacute;squeda una vez alcanzados la primera y &uacute;ltima posici&oacute;n.
	 */
	private void finBotones() {
		if (indiceCoche == SeleccionarColor.cochesColor.size() -1)
			botonPosterior.setEnabled(false);
		else
			botonPosterior.setEnabled(true);
		if (indiceCoche == 0)
			botonPrevio.setEnabled(false);
		else
			botonPrevio.setEnabled(true);
	}

	/**
	 * M&eacute;todo que rellena los campos y botonera con las caracter&iacute;sticas del coche en una posici&oacute;n dada del concesionario.
	 */
	private void buscarCoche(Coche coche) {
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
}
