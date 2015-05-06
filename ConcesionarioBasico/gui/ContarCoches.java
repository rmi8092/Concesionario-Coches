/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import concesionarioCochesCompleto.Concesionario;

/**
 * Clase ContarCoches.
 */
public class ContarCoches extends JDialog {
	/**
	 * Campo textField.
	 */
	private JTextField textField;
	/**
	 * Campo concesionario.
	 */
	private Concesionario concesionario;

	/**
	 * Contruye el di&aacute;logo.
	 * @param concesionario 
	 */
	public ContarCoches(Concesionario concesionario) {
		setBounds(100, 100, 265, 151);
		setTitle("Contar Coches");
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(136, 46, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalCoches = new JLabel("TOTAL COCHES:");
		lblTotalCoches.setBounds(24, 49, 102, 14);
		getContentPane().add(lblTotalCoches);
		
		textField.setText(Integer.toString(concesionario.size()));
	}
}
