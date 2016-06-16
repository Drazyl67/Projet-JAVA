package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import org.omg.CORBA.SystemException;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */


public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	public char[][] map2 = new char[12][20];
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public void putInTab(int i, int j, char c){
		this.map2[i][j] = c;
	}
	
	public void remplissage(){
		String [] map = this.message.split("\n");
		for (int i=0;i<map.length;i++){
			for (int j=0; j<map[i].length(); i++){
				
				switch (map[i].charAt(j)){
				
					case "V":
						System.out.println(map2[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);	/** displays an image **/
						} catch (IOException e) {
							e.printStackTrace();
						}
					case "O"
				}
			}
		}
		
	}
}
