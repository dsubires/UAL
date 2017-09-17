package org.mp.sesion09;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AnalisisDatos extends JFrame {

	private String[] nombresColumnas;
	private Object[][] datos;
	private JTable jTable1;
	private JPanel panel;
	private JLabel jLabel;
	private JMenuBar menuBar;

	public AnalisisDatos() {
		String directorioEntrada = System.getProperty("user.dir");

		directorioEntrada = directorioEntrada + File.separator + "test"
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "sesion07" + File.separator;

		String nombreArchivo = directorioEntrada + "temperaturas.txt";
		
		FileReader fr;
		String aux;
		String[] aux2;
		int nLineas = 0;
		int count = 0;
		
		try {
			fr = new FileReader(nombreArchivo);
			BufferedReader br = new BufferedReader(fr);
			// procesamos cabecera
			nombresColumnas = br.readLine().split(";");
			// procesamos nº de lineas
			while(br.readLine() != null){
				nLineas++;
			}
			br.close();
			// inicializamos matriz de datos
			datos = new Object[nLineas][nombresColumnas.length];
			fr = new FileReader(nombreArchivo);
			br = new BufferedReader(fr);
			br.readLine();
			while((aux = br.readLine()) != null){
				aux2 = aux.split(";");
				// procesamos los datos
				for(int i=0; i<nombresColumnas.length; i++){
					datos[count][i] = aux2[i];
				}
				
				count++;
			}			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		// creamos panel y añadimos elementos
		panel = new JPanel(new BorderLayout());
		DefaultTableModel tableModel = new DefaultTableModel(datos, nombresColumnas);
		jTable1 = new JTable(tableModel);
		
		jLabel = (new JLabel(nombreArchivo));
		jLabel.setForeground(Color.blue);
		
		panel.add(jLabel,
				BorderLayout.WEST);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu archivo= new JMenu("Archivo");
		JMenu ayuda= new JMenu ("Ayuda");
		
		menuBar.add(archivo);
		menuBar.add(ayuda);

		
		
		JMenuItem accionSalir = new JMenuItem("Salir");
		accionSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		archivo.add(accionSalir);

		getContentPane().add(panel, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(jTable1);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	
	}
	

	public static void main(String[] args) {
		AnalisisDatos frame = new AnalisisDatos();
		frame.setDefaultCloseOperation(3);
		frame.setTitle("AnalisisDatos");
		frame.setSize(500, 420);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

