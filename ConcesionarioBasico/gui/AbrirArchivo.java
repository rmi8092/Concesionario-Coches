/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.obj", "obj");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
	}
}
