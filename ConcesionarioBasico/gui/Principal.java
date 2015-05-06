/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import concesionarioCochesCompleto.AccionFichero;
import concesionarioCochesCompleto.Concesionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 * Clase Principal.
 */
public class Principal {
	/**
	 * Campo frame.
	 */
	private JFrame frame;
	/**
	 * Campo menuBar.
	 */
	private JMenuBar menuBar;
	/**
	 * Campo mnFicheros.
	 */
	private JMenu mnFicheros;
	/**
	 * Campo mntmNuevo.
	 */
	private JMenuItem mntmNuevo;
	/**
	 * Campo mntmAbrir.
	 */
	private JMenuItem mntmAbrir;
	/**
	 * Campo mntmGuardar.
	 */
	private JMenuItem mntmGuardar;
	/**
	 * Campo mntmGuardarComo.
	 */
	private JMenuItem mntmGuardarComo;
	/**
	 * Campo separator_1.
	 */
	private JSeparator separator_1;
	/**
	 * Campo mntmSalir.
	 */
	private JMenuItem mntmSalir;
	/**
	 * Campo mnCoches.
	 */
	private JMenu mnCoches;
	/**
	 * Campo mntmAadir.
	 */
	private JMenuItem mntmAadir;
	/**
	 * Campo mntmEliminar.
	 */
	private JMenuItem mntmEliminar;
	/**
	 * Campo separator_2.
	 */
	private JSeparator separator_2;
	/**
	 * Campo mnBuscar.
	 */
	private JMenu mnBuscar;
	/**
	 * Campo mntmPorMatrcula.
	 */
	private JMenuItem mntmPorMatrcula;
	/**
	 * Campo mntmPorColor.
	 */
	private JMenuItem mntmPorColor;
	/**
	 * Campo separator_3.
	 */
	private JSeparator separator_3;
	/**
	 * Campo mntmContarCoches.
	 */
	private JMenuItem mntmContarCoches;
	/**
	 * Campo mntmMostrarconcesionario.
	 */
	private JMenuItem mntmMostrarconcesionario;
	/**
	 * Campo mnAyuda.
	 */
	private JMenu mnAyuda;
	/**
	 * Campo mntmVerAyuda.
	 */
	private JMenuItem mntmVerAyuda;
	/**
	 * Campo separator.
	 */
	private JSeparator separator;
	/**
	 * Campo mntmAcercaDe.
	 */
	private JMenuItem mntmAcercaDe;
	/**
	 * Archivo selecci&oacute;n.
	 */
	static File seleccion;
	/**
	 * Objeto concesionario.
	 */
	static Concesionario concesionario = new Concesionario();
	/**
	 * Campo annadir.
	 */
	private Annadir annadir;
	/**
	 * Campo eliminar.
	 */
	private Eliminar eliminar;
	/**
	 * Campo buscarMatricula.
	 */
	private BuscarPorMatricula buscarMatricula;
	/**
	 * Campo buscarColor.
	 */
	private SeleccionarColor buscarColor;
	/**
	 * Campo mostrarCompleto.
	 */
	private MostrarCompleto mostrarCompleto;
	/**
	 * Campo contarCoches.
	 */
	private ContarCoches contarCoches;
	/**
	 * Campo abrirArchivo.
	 */
	private AbrirArchivo abrirArchivo;
	/**
	 * Campo acercaDe.
	 */
	private AcercaDe acercaDe;
	/**
	 * Campo guardado.
	 */
	private static boolean guardado;
	/**
	 * Campo parentComponent.
	 */
	private static Component parentComponent;

	/**
	 * Main de la aplicaci�n.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la clase Principal.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializa la interfaz de la aplicaci&oacute;n.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 405);
		frame.setTitle("Concesionario Rafa Miranda");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFicheros = new JMenu("Ficheros");
		mnFicheros.setMnemonic('F');
		menuBar.add(mnFicheros);
		
		mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoArchivo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmNuevo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirArchivo();
				mostrarCompleto();
			}
		});
		mnFicheros.add(mntmAbrir);
		
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmAbrir);
		
		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmGuardar);
		
		mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnFicheros.add(mntmGuardarComo);
		
		separator_1 = new JSeparator();
		mnFicheros.add(separator_1);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFicheros.add(mntmSalir);
		
		mnCoches = new JMenu("Coches");
		mnCoches.setMnemonic('C');
		menuBar.add(mnCoches);
		
		mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirCoche();
			}
		});
		mnCoches.add(mntmAadir);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		mnCoches.add(mntmEliminar);
		
		separator_2 = new JSeparator();
		mnCoches.add(separator_2);
		
		mnBuscar = new JMenu("Buscar");
		mnCoches.add(mnBuscar);
		
		mntmPorMatrcula = new JMenuItem("Por Matr\u00EDcula");
		mntmPorMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorMatricula();
			}
		});
		mnBuscar.add(mntmPorMatrcula);
		
		mntmPorColor = new JMenuItem("Por Color");
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorColor();
			}
		});
		mnBuscar.add(mntmPorColor);
		
		separator_3 = new JSeparator();
		mnCoches.add(separator_3);
		
		mntmContarCoches = new JMenuItem("Contar Coches");
		mntmContarCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contarCoches();
			}
		});
		mnCoches.add(mntmContarCoches);
		
		mntmMostrarconcesionario = new JMenuItem("Mostrar Concesionario");
		mntmMostrarconcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCompleto();
			}
		});
		mnCoches.add(mntmMostrarconcesionario);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
		
		mntmVerAyuda = new JMenuItem("Ver Ayuda");
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(parentComponent,
						"Consultar en la siguiente URL: file:///C:/Users/rafael/ProgramacionPrimeroDaw/GUI/doc/index.html");
			}
		});
		mntmVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK));
		mnAyuda.add(mntmVerAyuda);
		
		separator = new JSeparator();
		mnAyuda.add(separator);
		
		mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acercaDe();
			}
		});
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnAyuda.add(mntmAcercaDe);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/8.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 639, 345);
		frame.getContentPane().add(lblNewLabel);
	}

	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica para a�adir un nuevo coche.
	 */
	protected void annadirCoche() {
		annadir = new Annadir(concesionario);
		annadir.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica para eliminar un nuevo coche.
	 */
	protected void eliminar() {
		eliminar = new Eliminar();
		eliminar.setVisible(true);
	}

	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica para buscar por el n&uacute;mero de matr&iacute;cula un coche.
	 */
	protected void buscarPorMatricula() {
		buscarMatricula = new BuscarPorMatricula();
		buscarMatricula.setVisible(true);
	}

	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica para buscar por el color un coche.
	 */
	protected void buscarPorColor() {
		buscarColor = new SeleccionarColor();
		buscarColor.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica para mostrar al completo todos los coches de un concesionario.
	 */
	protected void mostrarCompleto() {
		try{
			mostrarCompleto = new MostrarCompleto(concesionario);
			mostrarCompleto.setVisible(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(parentComponent, "El concesionario aun esta vacio", "Error.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica para hacer un recuento de todos los coches del concesionario.
	 */
	protected void contarCoches() {
		contarCoches = new ContarCoches(concesionario);
		contarCoches.setVisible(true);
	}
	
	/**
	 * M&eacute;todo que rellena los campos y botonera con las caracter&iacute;sticas del coche que responde a una matr&iacute;cula especificada.
	 */
	protected void nuevoArchivo() {
		if(sobrescribirFichero()){
			guardado=false;
			crearNuevoConcesionario();
			return;
		}
		if(quieresGuardar()){
			if(guardado){
				try {
					if(sobrescribirFichero()){ 
						AccionFichero.guardarComoFichero(concesionario, seleccion);
						crearNuevoConcesionario();
					}
				} catch (IOException e) {
					JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				GuardarComo guardarComo= new GuardarComo();
				try {
					AccionFichero.guardarComoFichero(concesionario, seleccion);
					crearNuevoConcesionario();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}	
		}
	}
	
	/**
	 * M&eacute;todo que abre un archivo ya guardado previamente.
	 */
	protected void abrirArchivo() {
		try {
			AbrirArchivo abrir= new AbrirArchivo();
			concesionario=(Concesionario)AccionFichero.abrirFichero(seleccion);
			guardado=true;
		} catch(ClassNotFoundException | IOException e1){
			JOptionPane.showMessageDialog(parentComponent, e1, "Error.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M&eacute;todo que guarda un archivo nuevo que no ex&iacute;stia previamente.
	 */
	protected void guardarComo() {
		GuardarComo guardarComo = new GuardarComo();
		try {
			if(seleccion != null){
				AccionFichero.guardarComoFichero(concesionario, seleccion);
				guardado=true;
			}
			else
				JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * M&eacute;todo que guarda un archivo que ya ex&iacute;stia previamente o no. El programa detecta esta circunstancia.
	 */
	protected void guardar() {
		if(guardado){
			try {
				if(sobrescribirFichero())
					AccionFichero.guardarComoFichero(concesionario, seleccion);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			GuardarComo guardarComo = new GuardarComo();
			try {
				if(seleccion != null){
					AccionFichero.guardarComoFichero(concesionario, seleccion);
					guardado=true;
				}
				else
					JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	/**
	 * M&eacute;todo que advierte de la posibilidad de machacar informaci�n no guardada.
	 */
	private static boolean sobrescribirFichero() {
		int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Puede que se pierda informaci�n (en el caso de que tuviera un archivo abierto)."
				+ " A�n as� desea continuar?",
				"Sobrescritura", JOptionPane.YES_NO_OPTION);
		if(eleccion == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
	
	/**
	 * M&eacute;todo que crea un nuevo concesionario.
	 */
	private static void crearNuevoConcesionario() {
		concesionario = new Concesionario();
		JOptionPane.showMessageDialog(parentComponent, "Se ha creado un nuevo concesionario");
		guardado = false;
	}
	
	/**
	 * M&eacute;todo que ofrece la posibilidad de guardar o no un concesionario antes de crear otro.
	 */
	private static boolean quieresGuardar() {
		int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Quieres guardar el fichero creado previamente antes de crear un concesionario nuevo?",
				"Sobrescritura", JOptionPane.YES_NO_OPTION);
		if(eleccion == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}

	/**
	 * M&eacute;todo que crea y hace visible la interfaz gr&aacute;fica que ofrece informaci&oacute;n y ayuda sobre la aplicaci&oacute;n.
	 */
	protected void acercaDe() {
		acercaDe = new AcercaDe();
		acercaDe.setVisible(true);
	}
}
