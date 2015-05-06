/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.io.File;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFileChooser;

/**
 * Clase GuardarComo.
 */
public class GuardarComo extends JDialog {
	/**
	 * Campo contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Construye el di&aacute;logo.
	 */
	public GuardarComo() {
		JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showSaveDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
	}
}
