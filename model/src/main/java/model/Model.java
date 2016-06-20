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
	private Player player;
	public boolean permeability;
	private MonsterA monsterA;
	public int o;
	
	public Player getPlayer() {
		return player;
	}
	
	public MonsterA getMonsterA(){
		return monsterA;
	}
	
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
		this.player = new Player();
		this.monsterA = new MonsterA();
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
			for (int j=0; j<map[i].length(); j++){
				
				switch (map[i].charAt(j)){
				
					case 'V':
						this.map2[i][j] = 'V';
					break;
					
					case 'O':
						this.map2[i][j] = 'O';
					break;
					
					case '-':
						this.map2[i][j] = '-';
					break;
					
					case 'I':
						this.map2[i][j] = 'I';
					break;
					
					case '@':
						this.map2[i][j] = '@';
						this.getPlayer().setX(j);
						this.getPlayer().setY(i);
					break;
					
					case 'Q':
						this.map2[i][j] = 'Q';
					break;
					
					case 'Y':
						this.map2[i][j] = 'Y';
					break;
					
					case '1':
						this.map2[i][j] = '1';
					break;
					
					case 'A':
						this.map2[i][j] = 'A';
						this.getMonsterA().setX(j);
						this.getMonsterA().setY(i);
					break;
					
					case 'U':
						this.map2[i][j] = 'U';
					break;
					
					case 'B':
						this.map2[i][j] = 'B';
					break;
					
					case 'C':
						this.map2[i][j] = 'C';
					break;
					
					case 'D':
						this.map2[i][j] = 'D';
					break;
				}
			}
		}
		
	}
	
/*	public int posP(){
		for(int x=0;x<map2.length;x++){
			for (int y=0; y<map2[x].length;y++){
				posX = x;
				posY = y;
				System.out.println(x);
				System.out.println(y);
			//	positionP[posX][posY];
				
				
			}
		}*/
	
	public char[][] getMap2(){
		return this.map2;
	}
	
	public void moveUp(){
		if ((map2[this.getPlayer().getY()-1][this.getPlayer().getX()]) != 'O' && (map2[this.getPlayer().getY()-1][this.getPlayer().getX()]) != '-' && (map2[this.getPlayer().getY()-1][this.getPlayer().getX()]) != 'I'){
			
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setY(this.getPlayer().getY()-1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else;
	}
	
	public void moveDown(){
		if (map2[this.getPlayer().getY()+1][this.getPlayer().getX()] != 'O' && map2[this.getPlayer().getY()+1][this.getPlayer().getX()] != '-' && map2[this.getPlayer().getY()+1][this.getPlayer().getX()] != 'I'){
		
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setY(this.getPlayer().getY()+1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else;
	}
	
	public void moveRight(){
		if (map2[this.getPlayer().getY()][this.getPlayer().getX()+1] != 'O' && map2[this.getPlayer().getY()][this.getPlayer().getX()+1] != '-' && map2[this.getPlayer().getY()][this.getPlayer().getX()+1] != 'I'){
		
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setX(this.getPlayer().getX()+1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else;
	}
	
	public void moveLeft(){
		if (map2[this.getPlayer().getY()][this.getPlayer().getX()-1] != 'O' && map2[this.getPlayer().getY()][this.getPlayer().getX()-1] != '-' && map2[this.getPlayer().getY()][this.getPlayer().getX()-1] != 'I'){
		
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setX(this.getPlayer().getX()-1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else;
	}

	/*public void monsterAMove(){
			
		
		
		while (map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'O' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= '-' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'I'){
			
			this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
			this.getMonsterA().setX(this.getMonsterA().getX()+1);
			this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
			//System.out.println(this.getMonsterA().getX());
			//this.viewFrame.getModel().setO(this.viewFrame.getModel().getO() +1);
		}
	}}*/
	
public void monsterA() {
  //  if (this.getO() == 3) {
         {
            int mx = getMonsterA().getX();
            int hx = getPlayer().getX();
            int my = getMonsterA().getY();
            int hy = getPlayer().getY();
            /** if x is lower than lorann's increments it**/
            if (mx < hx && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'O' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= '-' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'I') {
            	this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setX(this.getMonsterA().getX()+1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            /** if x is higher than lorann's decrement it**/
            if (mx > hx && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= 'O' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= '-' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= 'I') {
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setX(this.getMonsterA().getX()-1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            /** if y is lower than lorann's increments it**/
            if (my < hy && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= 'O' && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= '-' && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= 'I') {
            	this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setY(this.getMonsterA().getY()+1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            /** if y is higher than lorann's decrement it **/
            if (my > hy && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= 'O' && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= '-' && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= 'I') {
            	this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setY(this.getMonsterA().getY()-1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
        }
    }
//}
	public int getO(){
		return o;
	}

	public void monsterAMove() {
		// TODO Auto-generated method stub
		
	}
}