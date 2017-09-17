package junioMP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscadorArchivosGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDirectorio;
	private JTextField textFieldBuscar;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorArchivosGui frame = new BuscadorArchivosGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscadorArchivosGui() {
		setTitle("BuscadorGui");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		textFieldDirectorio = new JTextField();
		panel_1.add(textFieldDirectorio);
		textFieldDirectorio.setColumns(40);
		
		JButton btnDirectorio = new JButton("Directorio");
		btnDirectorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		panel_1.add(btnDirectorio);
	
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		textFieldBuscar = new JTextField();
		panel_2.add(textFieldBuscar);
		textFieldBuscar.setColumns(20);
		
		JButton btnBuscar = new JButton("Buscar");
		panel_2.add(btnBuscar);
		
	}
	
	private void abrir() {
		JFileChooser fch = new JFileChooser(); 
		    fch.setCurrentDirectory(new java.io.File("."));
		    fch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    fch.setAcceptAllFileFilterUsed(false);
		 
		if (fch.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			textFieldDirectorio.setText(fch.getSelectedFile().toString());
		}
		     
	}

}
