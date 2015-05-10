/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.obj", "obj");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
        int respuesta = fileChooser.showSaveDialog(this);
        
        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
	}
}
