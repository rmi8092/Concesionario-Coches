/**
 * Paquete contenedor de las clases que implementan la interfaz gr&aacute;fica.
 */
package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import concesionarioCochesCompleto.Coche;
import concesionarioCochesCompleto.Color;
import concesionarioCochesCompleto.Concesionario;
import concesionarioCochesCompleto.Marca;
import concesionarioCochesCompleto.Modelo;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase Annadir.
 */
public class Annadir extends VentanaPadre {
	
	/**
	 * Construye el di&aacute;logo.
	 */
	public Annadir(Concesionario concesionario) {
		super();
		datoMatricula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!Coche.esValida(datoMatricula.getText()))
					datoMatricula.setForeground(java.awt.Color.RED);
				else
					datoMatricula.setForeground(java.awt.Color.BLACK);
			}
		});
		setModal(true);
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		botonAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Principal.concesionario.annadir(datoMatricula.getText(), getColor(),
							(Modelo) comboBoxModelo.getSelectedItem());
					datoMatricula.setForeground(java.awt.Color.BLACK);
				} catch (Exception e1) {
					datoMatricula.setForeground(java.awt.Color.RED);
					JOptionPane.showMessageDialog(contenedor, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonAccion.setText("A\u00F1adir");
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		setTitle("Añadir Coche");
		setBounds(100, 100, 450, 251);
		botonPrevio.setEnabled(false);
		botonPosterior.setEnabled(false);
	}

	/**
	 * M&eacute;todo para obtener los posibles modelos coche.
	 */
	protected static Object[] getModelo(JComboBox comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList modeloCoche = new ArrayList();
		for (Modelo mod : Modelo.values()) {
			if (mod.getMarca() == marca)
				modeloCoche.add(mod);
		}
		return modeloCoche.toArray();
	}
	
	/**
	 * M&eacute;todo para obtener el color del coche.
	 */
	private Color getColor(){
		if(botonAzul.isSelected())
			return Color.AZUL;
		if(botonPlata.isSelected())
			return Color.PLATA;
		if(botonRojo.isSelected())
			return Color.ROJO;
		return null;
	}
}
