package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		//this.setSize(640,384);
		/*JLabel image = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
		JLabel image2 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/purse.png"));
		JLabel image3 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/gate_open.png"));
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		
		this.setLayout(new GridLayout(12,20));
		for(int i = 0; i<240;i++){*/
		   //JPanel ptest = new JPanel();
		   //ptest.setBorder(blackline);
		   //this.add(image,0,0);
		   
		//   this.add(image3,0,2);
		
		}
		
		//this.add(new JButton(),1);
		
		/*viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setResizable(false);
		viewFrame.setSize(1000,800);
		viewFrame.setLocationRelativeTo(null);*/
	

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
//	JLabel image = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
//	JLabel image2 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/purse.png"));
	//final BufferedImage image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g); //paint background
       // if (image != null) { //there is a picture: draw it
           // int height = this.getSize().height;
           // int width = this.getSize().width;
          //  g.drawImage(image, 0, 0, 32, 32, null, null); //use image size          
            //graphics.drawImage(image,0,0, width, height, this);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
	}
}

