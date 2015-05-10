/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import concesionarioCochesCompleto.Marca;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase VentanaPadre.
 */
public class VentanaPadre extends JDialog {

	protected final JPanel contenedor = new JPanel();
	protected JTextField datoMatricula;
	protected final ButtonGroup grupoBotones = new ButtonGroup();
	protected JLabel etiquetaMatricula;
	protected JComboBox comboBoxMarca;
	protected JLabel etiquetaMarca;
	protected JComboBox comboBoxModelo;
	protected JLabel etiquetaModelo;
	protected JPanel botoneraColores;
	protected JRadioButton botonAzul;
	protected JRadioButton botonPlata;
	protected JRadioButton botonRojo;
	protected JPanel botoneraInferior;
	protected JButton botonPrevio;
	protected JButton botonPosterior;
	protected JButton botonAccion;
	protected JButton botonSalir;

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setModal(true);
		setBounds(100, 100, 450, 251);
		getContentPane().setLayout(new BorderLayout());
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(null);
		{
			datoMatricula = new JTextField();
			datoMatricula.setBounds(133, 48, 86, 20);
			contenedor.add(datoMatricula);
			datoMatricula.setColumns(10);
		}
		
		etiquetaMatricula = new JLabel("Matr\u00EDcula:");
		etiquetaMatricula.setBounds(65, 51, 58, 14);
		contenedor.add(etiquetaMatricula);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxMarca.setBounds(154, 82, 65, 20);
		contenedor.add(comboBoxMarca);
		{
			etiquetaMarca = new JLabel("Marca:");
			etiquetaMarca.setBounds(65, 85, 58, 14);
			contenedor.add(etiquetaMarca);
		}
			
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setModel(new DefaultComboBoxModel(Annadir.getModelo(comboBoxMarca)));
		comboBoxModelo.setBounds(127, 116, 92, 20);
		contenedor.add(comboBoxModelo);
		
		etiquetaModelo = new JLabel("Modelo:");
		etiquetaModelo.setBounds(65, 119, 46, 14);
		contenedor.add(etiquetaModelo);
		
		botoneraColores = new JPanel();
		botoneraColores.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)), "Color", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		botoneraColores.setBounds(291, 31, 92, 105);
		contenedor.add(botoneraColores);
		botoneraColores.setLayout(null);
		
		botonAzul = new JRadioButton("Azul");
		botonAzul.setBounds(18, 18, 65, 23);
		botoneraColores.add(botonAzul);
		grupoBotones.add(botonAzul);
		
		botonPlata = new JRadioButton("Plata");
		botonPlata.setBounds(18, 44, 58, 23);
		botoneraColores.add(botonPlata);
		grupoBotones.add(botonPlata);
		
		botonRojo = new JRadioButton("Rojo");
		botonRojo.setBounds(18, 70, 58, 23);
		botoneraColores.add(botonRojo);
		grupoBotones.add(botonRojo);
		{
			botoneraInferior = new JPanel();
			botoneraInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(botoneraInferior, BorderLayout.SOUTH);
			
			botonPrevio = new JButton("<<");
			botoneraInferior.add(botonPrevio);
			
			botonPosterior = new JButton(">>");
			botonPosterior.setHorizontalAlignment(SwingConstants.LEFT);
			botoneraInferior.add(botonPosterior);
			{
				botonAccion = new JButton("Acci\u00F3n");
				botoneraInferior.add(botonAccion);
				getRootPane().setDefaultButton(botonAccion);
			}
			{
				botonSalir = new JButton("Salir");
				botonSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				botoneraInferior.add(botonSalir);
			}
		}
	}
}
