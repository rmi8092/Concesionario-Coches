package gui;

import concesionarioCochesCompleto.Coche;
import concesionarioCochesCompleto.Color;
import concesionarioCochesCompleto.Concesionario;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SeleccionarColor extends VentanaPadre {

	private BuscarPorColor buscarPorColor;
	private Component contentPanel;
	static ArrayList<Coche> cochesColor;

	/**
	 * Create the dialog.
	 * @param concesionario2 
	 */
	public SeleccionarColor() {
		super();
		botonAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (seleccionarColor() != null) {
					cochesColor = Principal.concesionario.getCochesColor(seleccionarColor());
					if (cochesColor.isEmpty()) {
						JOptionPane.showMessageDialog(contentPanel, "No hay ningún coche del color seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					buscarPorColor = new BuscarPorColor();
					buscarPorColor.setVisible(true);
				} 
				else
					JOptionPane.showMessageDialog(contentPanel, "Selecciona un color, por favor.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		setTitle("Elegir Color");
		botonAccion.setText("Buscar");
		setBounds(100, 100, 450,251);
		etiquetaMatricula.setEnabled(false);
		datoMatricula.setEnabled(false);
		etiquetaMarca.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		etiquetaModelo.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		botonPrevio.setEnabled(false);
		botonPosterior.setEnabled(false);	
	}
	
	Color seleccionarColor(){
		if(botonAzul.isSelected())
			return Color.AZUL;
		if(botonPlata.isSelected())
			return Color.PLATA;
		if(botonRojo.isSelected())
			return Color.ROJO;
		return null;
	}
}
