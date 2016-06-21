package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
	/** the 1D map array */
	private char[][] map;

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
		this.viewFrame.getModel().remplissage();
		this.repaint();
	}
//	JLabel image = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
//	JLabel image2 = new JLabel( new ImageIcon( "C:/Users/Drazyl Dul/Desktop/sprite/purse.png"));
	//final BufferedImage image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));

	private boolean isAlive1 = false;
	private boolean isAlive2 = false;
	private boolean isAlive3 = false;
	private boolean isAlive4 = false;
	public boolean isAlive1() {
		return isAlive1;
	}

	public void setAlive1(boolean isAlive1) {
		this.isAlive1 = isAlive1;
	}

	public boolean isAlive2() {
		return isAlive2;
	}

	public void setAlive2(boolean isAlive2) {
		this.isAlive2 = isAlive2;
	}

	public boolean isAlive3() {
		return isAlive3;
	}

	public void setAlive3(boolean isAlive3) {
		this.isAlive3 = isAlive3;
	}

	public boolean isAlive4() {
		return isAlive4;
	}

	public void setAlive4(boolean isAlive4) {
		this.isAlive4 = isAlive4;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	
	protected void paintComponent(final Graphics g) {
		
		
		
	/*	BufferedImage image = null;
		try {
			image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/pd.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}*/
		super.paintComponent(g); //paint background
		g.setColor(Color.BLACK);
		
		this.viewFrame.getModel().monsterA();
		this.viewFrame.getModel().monsterB();
		this.viewFrame.getModel().monsterC();
		this.viewFrame.getModel().monsterD();
		
		
		
       // if (image != null) { //there is a picture: draw it
           // int height = this.getSize().height;
           // int width = this.getSize().width;
          //  g.drawImage(image, 0, 0, 32, 32, null, null); //use image size          
            //graphics.drawImage(image,0,0, width, height, this);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	//	g.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
		
		this.map = this.viewFrame.getModel().getMap2();
		
		for (int i=0;i<this.map.length; i++){
			for (int j=0; j<this.map[i].length; j++){
				
				switch (this.map[i][j]){
				
					case 'V':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/Vide.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'O':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/rocher.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case '-':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/horizontal_bone.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'I':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/vertical_bone.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case '@':
						g.drawImage((new ImageIcon("C:/Users/Drazyl Dul/Desktop/sprite/lorann_gif.gif")).getImage(),32*j,32*i, this);						
					break;
					
					case 'Q':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/crystal_ball.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'Y':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/gate_closed.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'U':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/gate_open.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case '1':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/purse.png"));
							g.drawImage(image, 32*j, 32*i, this);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'A':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/monster_1.png"));
							g.drawImage(image, 32*j, 32*i, this);
							this.isAlive1 = true;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'B':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/monster_2.png"));
							g.drawImage(image, 32*j, 32*i, this);
							this.isAlive2 = true;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'C':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/monster_3.png"));
							g.drawImage(image, 32*j, 32*i, this);
							this.isAlive3 = true;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'D':
						try {
							Image image = ImageIO.read(new File("C:/Users/Drazyl Dul/Desktop/sprite/monster_4.png"));
							g.drawImage(image, 32*j, 32*i, this);
							this.isAlive4 = true;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
					
					case 'F':
						g.drawImage((new ImageIcon("C:/Users/Drazyl Dul/Desktop/sprite/Fireball.gif")).getImage(),32*j,32*i, this);						
					break;
					
						
				}
			}
		}
	}
}


