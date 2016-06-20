package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import contract.IController;
import contract.IModel;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(655,420);
		this.setLocationRelativeTo(null);
		
	 
	
		/*JLabel image = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
		JLabel image2 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/purse.png"));
		JLabel image3 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/lorann_r.png"));
		JLabel image4 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/lorann_u.png"));
		JLabel image5 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/lorann_l.png"));
		JLabel image6 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/lorann_bl.png"));
		JLabel image7 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/lorann_br.png"));
		GridLayout grille = new GridLayout(6,1);
		this.setLayout(grille);*/
		
		/*JFrame t = new JFrame();
		JPanel pan = new JPanel (new GridLayout (12,20));
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		for(int i = 0; i<240;i++){
		   JPanel ptest = new JPanel();
		   ptest.setBorder(blackline);
		   pan.add(ptest);
		   ptest.setVisible(true);
		}
		pan.setBorder(blackline);
		t.add(pan);
		t.setVisible(true);*/
		
	}
		/*this.add(image);
		this.add(image2);
		this.add(image3);
		this.add(image4);
		this.add(image5);
		this.add(image6);
		this.add(image7);*/
		

		/*JPanel cell1 = new JPanel();
	    cell1.setBackground(Color.YELLOW);
	    this.add(cell1);
	    JPanel cell2 = new JPanel();
	    cell2.setBackground(Color.red);
	    this.add(cell2);*/
		

	

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {
		//this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		//this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}
}
