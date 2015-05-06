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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

/**
 * Clase AcercaDe.
 */
public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Construye el di&aacute;logo.
	 */
	public AcercaDe() {
		setTitle("Acerca De...");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnProgramaDesarrolladoPor = new JTextPane();
		txtpnProgramaDesarrolladoPor.setFont(new Font("Verdana", Font.BOLD, 13));
		txtpnProgramaDesarrolladoPor.setBackground(SystemColor.control);
		txtpnProgramaDesarrolladoPor.setForeground(Color.BLACK);
		txtpnProgramaDesarrolladoPor.setBounds(26, 11, 381, 40);
		txtpnProgramaDesarrolladoPor.setText("Autor: Rafael Miranda Ib\u00E1\u00F1ez.\r\n\u00C1mbito: Asignatura de Programaci\u00F3n de 1\u00BA de DAW.");
		contentPanel.add(txtpnProgramaDesarrolladoPor);
		{
			JTextPane txtpnVersion = new JTextPane();
			txtpnVersion.setText("Version 1.0\t\tFecha: 03/05/2015");
			txtpnVersion.setForeground(Color.BLACK);
			txtpnVersion.setFont(new Font("Verdana", Font.BOLD, 13));
			txtpnVersion.setBackground(SystemColor.menu);
			txtpnVersion.setBounds(26, 56, 365, 29);
			contentPanel.add(txtpnVersion);
		}
		{
			JTextPane txtpnElAutorNo = new JTextPane();
			txtpnElAutorNo.setBackground(SystemColor.control);
			txtpnElAutorNo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 11));
			txtpnElAutorNo.setForeground(new Color(102, 0, 0));
			txtpnElAutorNo.setText("El autor no se hace responsable de que el coche \"salga malo\", de la conducci\u00F3n temeraria del usuario, ni de que a Esperanza Aguirre le dieran el carnet en la t\u00F3mbola de al lado de \"Hamburguesas La Tere\".\r\nNo haga uso de este programa sin consultar previamente con su farmac\u00E9utico.\r\n\r\nP.D. Disfruten del viaje!!");
			txtpnElAutorNo.setBounds(10, 97, 414, 120);
			contentPanel.add(txtpnElAutorNo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
