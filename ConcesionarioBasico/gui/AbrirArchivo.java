/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 * Clase AbrirArchivo.
 */
public class AbrirArchivo extends JDialog {
	/**
	 * Campo contentPanel.
	 */
	JComponent contentPanel;

	/**
	 * Construye el di&aacute;logo.
	 */
	public AbrirArchivo() {
		JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
        
	}
}
