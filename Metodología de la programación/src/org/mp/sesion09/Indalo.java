package org.mp.sesion09;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Dibuja un Indalo y lo muestra
 * @author David Subires Parra
 *
 */
public class Indalo extends JFrame {


		public Indalo() {
			setTitle("Indalo");
			add(new IndaloPanel());
		}

		public static void main(String[] args) {
			Indalo indalo = new Indalo();
			indalo.setLocationRelativeTo(null);
			indalo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			indalo.setSize(300, 300);
			indalo.setVisible(true);
		}		
}
/**
 * Dibuja un Indalo
 * @author David Subires Parra
 *
 */
class IndaloPanel extends JPanel {
	protected void paintComponent(Graphics g){
	super.paintComponent(g);
	
	int width = getWidth();
	int height = getHeight();
	
	g.setColor(Color.red);
	g.setFont(new Font("Times New Roman",Font.BOLD,16));
	System.out.println();
	g.drawString("Indalo", (int) (width *0.43 ),(int) (height*0.95));	
	g.setColor(Color.BLACK);
	//pie izq
	g.drawLine(width/2-(width/6), height-(height/6), width/2, height/2 + (height / 10));
	//pie dcho
	g.drawLine(width/2, height/2 + (height / 10), width/2+(width/6), height-(height/6));
	//cuerpo
	g.drawLine(width/2, height/2 + (height / 10), width/2, height/2 - (height/4));
	// cabeza
	g.drawOval((int) (width*0.465), (int) (height*0.18), width/14 , height/14 );
	// linea semicirculo 
	g.drawLine((int) (width*0.25), (int) (height*0.3), (int) (width*0.75), (int) (height*0.3));
	// semicirculo
	g.drawArc((int) (width*0.25), (int) (height*0.05), (int) (width*0.5), (int) (height*0.5), 0, 180);
	}
}

