/**
 * Paquete contenedor de las clases que implementan la interfaz gráfica.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase VerAyuda.
 */
public class VerAyuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Construye el di&aacute;logo.
	 */
	public VerAyuda() {
		setTitle("Ver Ayuda");
		setBounds(100, 100, 552, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(0, 0, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnConcesionarioDeCoches = new JTextPane();
		txtpnConcesionarioDeCoches.setBackground(SystemColor.control);
		txtpnConcesionarioDeCoches.setText("La aplicaci\u00F3n es un sencillo gentor de altas y bajas de coches para crear diferentes lotes de concesionarios que se pueden archivar para su posterior recuperaci\u00F3n y consulta.\r\nPermite a su vez la b\u00FAsqueda a trav\u00E9s de matr\u00EDcula o color para facilitar la operatividad en la gesti\u00F3n.\r\n\r\nActualmente solo permite gestionar modelos de las marcas SEAT y BMW.\r\nLa aplicaci\u00F3n est\u00E1 preparada para solo poder aceptar matr\u00EDculas no duplicadas, v\u00E1lidas y conforme a la legislaci\u00F3n actual. A saber, numeros de 0000 a 9999 y tres letras, comenzando por BBB y terminando por ZZZ, excluyendo vocales, la LL, la \u00D1 y la Q.\r\n \r\nMatr\u00EDculas v\u00E1lidas: 0000-BBB, 0000 BBB, 0000BBB, 1234ZZZ.\r\nMatr\u00EDculas inv\u00E1lidas: 000_BBB, 9999-BBQ, 0000-B\u00D1B, 0000-DEF, 0000 bbb, 0000 AAA\r\nDe lo contrario se sombrear\u00E1 de color rojo y no dejar\u00E1 hacer ninguna operaci\u00F3n con el coche de esa matr\u00EDcula.");
		txtpnConcesionarioDeCoches.setBounds(10, 52, 514, 266);
		contentPanel.add(txtpnConcesionarioDeCoches);
		{
			JTextPane txtpnConcesionarioDeCoches_1 = new JTextPane();
			txtpnConcesionarioDeCoches_1.setForeground(new Color(0, 0, 139));
			txtpnConcesionarioDeCoches_1.setBackground(SystemColor.control);
			txtpnConcesionarioDeCoches_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			txtpnConcesionarioDeCoches_1.setText("CONCESIONARIO DE COCHES - GUIA DE USUARIO");
			txtpnConcesionarioDeCoches_1.setBounds(87, 21, 327, 20);
			contentPanel.add(txtpnConcesionarioDeCoches_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
