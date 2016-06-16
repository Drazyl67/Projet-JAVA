package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 */
	public static void main(final String[] args) {
		final Model model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		controller.control();
		
		
		
		
		
		/*JLabel image = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
		JLabel image2 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/purse.png"));
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		for(int i = 0; i<240;i++){
		   JPanel ptest = new JPanel();
		   ptest.setBorder(blackline);
		   pan.add(ptest);
		   ptest.setVisible(true);
		}
		pan.setBorder(blackline);
		t.add(pan);
		t.setVisible(true);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setResizable(false);
		t.setSize(1000,800);
		t.setLocationRelativeTo(null);
//		ImagePanel(image);*/
	}
}