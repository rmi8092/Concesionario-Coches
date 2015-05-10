/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import concesionarioCochesCompleto.AccionFichero;
import concesionarioCochesCompleto.Concesionario;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Clase Nuevo.
 */
public class Nuevo extends JDialog {
	/**
	 * Campo parentComponent.
	 */
	private static Component parentComponent;
	/**
	 * Objeto contentPanel.
	 */
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Construye el di&aacute;logo.
	 */
	public Nuevo() {
		setTitle("Continuar sin guardar?");
		setBounds(100, 100, 388, 128);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Si");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoSinGuardar();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(35, 51, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoGuardando();
				setVisible(false);
			}
		});
		btnNo.setBounds(134, 51, 89, 23);
		contentPanel.add(btnNo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(233, 51, 89, 23);
		contentPanel.add(btnCancelar);
		
		JTextPane txtpnAlCrearUn = new JTextPane();
		txtpnAlCrearUn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAlCrearUn.setForeground(Color.BLACK);
		txtpnAlCrearUn.setBackground(SystemColor.control);
		txtpnAlCrearUn.setText("Desea continuar sin guardar el concesionario anterior?");
		txtpnAlCrearUn.setBounds(35, 11, 304, 29);
		contentPanel.add(txtpnAlCrearUn);
	}

	/**
	 * M&eacute;todo que sale de la ventana de creaci&oacute;n de un nuevo concesionario.
	 */
	protected void cancelar() {
		JOptionPane.showMessageDialog(parentComponent, "Se ha anulado la creación de un nuevo concesionario");
		setVisible(false);
	}

	/**
	 * M&eacute;todo que crea un nuevo concesionario guardadndo previamente la informaci&oacute;n generada.
	 */
	protected void nuevoGuardando() {
		GuardarComo guardarComo= new GuardarComo();
		try {
			AccionFichero.guardarComoFichero(Principal.concesionario, Principal.seleccion);
			crearNuevoConcesionario();
			Principal.modificado = false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
		}		
	}

	/**
	 * M&eacute;todo que crea un nuevo concesionario sin guardar previamente la informaci&oacute;n generada.
	 */
	protected void nuevoSinGuardar() {
		crearNuevoConcesionario();
		Principal.modificado  = false;
	}
	
	/**
	 * M&eacute;todo que crea un nuevo concesionario.
	 * @param concesionario 
	 */
	static void crearNuevoConcesionario() {
		Principal.concesionario = new Concesionario();
		JOptionPane.showMessageDialog(parentComponent, "Se ha creado un nuevo concesionario");
		Principal.guardado = false;
	}
}
