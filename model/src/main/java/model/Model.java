package model;


import java.sql.SQLException;
import java.util.Observable;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */


public class Model extends Observable implements IModel {

	/** The message. */
	private String message;
	/** the maps'array */
	public char[][] map2 = new char[12][20];
	/** the player */
	private Player player;
	/** the permeability (true or false) */
	public boolean permeability;
	/** the monster A */
	private MonsterA monsterA;
	/** the monster B */
	private MonsterB monsterB;
	/** the monster C */
	private MonsterC monsterC;
	/** the monster D */
	private MonsterD monsterD;
	private FireBall fireball;
	public int lastKey=1;
	public boolean isShot = false;

	/** return the player position */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Return the monster position
	 */
	public MonsterA getMonsterA(){
		return monsterA;
	}
	/**
	 * Return the monster position
	 */
	public MonsterB getMonsterB(){
		return monsterB;
	}
	
	/**
	 * Return the monster position
	 */
	public MonsterC getMonsterC(){
		return monsterC;
	}
	
	/**
	 * Return the monster position
	 */
	public MonsterD getMonsterD(){
		return monsterD;
	}
	
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
		this.player = new Player();
		this.monsterA = new MonsterA();
		this.monsterB = new MonsterB();
		this.monsterC = new MonsterC();
		this.monsterD = new MonsterD();
		
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
	
	/**
	 * Fill the 2D array with the map'elements
	 */
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
						this.getMonsterA().setAlive(true);
					break;
					
					case 'U':
						this.map2[i][j] = 'U';
					break;
					
					case 'B':
						this.map2[i][j] = 'B';
						this.getMonsterB().setX(j);
						this.getMonsterB().setY(i);
						this.getMonsterB().setAlive(true);
					break;
					
					case 'C':
						this.map2[i][j] = 'C';
						this.getMonsterC().setX(j);
						this.getMonsterC().setY(i);
						this.getMonsterC().setAlive(true);
					break;
					
					case 'D':
						this.map2[i][j] = 'D';
						this.getMonsterD().setX(j);
						this.getMonsterD().setY(i);
						this.getMonsterD().setAlive(true);
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
	
	/** the map ID */
	public int mapID=0;
	
	/**
	 * Get the 2D array 
	 */
	public char[][] getMap2(){
		return this.map2;
	}
	
	/**
	 * Get the map ID
	 */
	public int getMapID(){
		return this.mapID;
	}
	
	/**
	 * Set the map ID
	 */
	public void setMapID(int mapID){
		this.mapID = mapID;
	}
	
	/**
	 * the score
	 */
	public int score=0;

	/**
	 * Move up the player
	 */
	public void moveUp(){
		if ((map2[this.getPlayer().getY()-1][this.getPlayer().getX()]) == 'V'){
			
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setY(this.getPlayer().getY()-1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if ((map2[this.getPlayer().getY()-1][this.getPlayer().getX()]) == '1'){
			score+=100;
			System.out.println("Votre score: " + score);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()-1][this.getPlayer().getX()] == 'Q'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
			map2[6][18] = 'U';
			break;
			case 2:
			map2[4][19] = 'U';
			break;
			case 3:
			map2[5][4] = 'U';
			break;
			case 4:
			map2[10][12] = 'U';
			break;
			case 5:
			map2[11][10] = 'U';
			break;
			}
		}
		else if (map2[this.getPlayer().getY()-1][this.getPlayer().getX()] == 'U'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
				this.loadMessage("02");
				break;
			case 2:
				this.loadMessage("03");
				break;
			case 3:
				this.loadMessage("04");
				break;
			case 4:
				this.loadMessage("05");
				break;
			}
		}
		else if (map2[this.getPlayer().getY()-1][this.getPlayer().getX()] == 'F'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			this.isShot = false;
		}
	}
	/**
	 * Move down the player
	 */
	public void moveDown(){
		if (map2[this.getPlayer().getY()+1][this.getPlayer().getX()] == 'V'){
		
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setY(this.getPlayer().getY()+1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()+1][this.getPlayer().getX()] == '1'){
			score+=100;
			System.out.println("Votre score: " + score);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()+1][this.getPlayer().getX()] == 'Q'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
			map2[6][18] = 'U';
			break;
			case 2:
			map2[4][19] = 'U';
			break;
			case 3:
			map2[5][4] = 'U';
			break;
			case 4:
			map2[10][12] = 'U';
			break;
			case 5:
			map2[11][10] = 'U';
			break;
			}
		}
		else if (map2[this.getPlayer().getY()+1][this.getPlayer().getX()] == 'U'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
				this.loadMessage("02");
				break;
			case 2:
				this.loadMessage("03");
				break;
			case 3:
				this.loadMessage("04");
				break;
			case 4:
				this.loadMessage("05");
				break;
			}
		}
		else if (map2[this.getPlayer().getY()+1][this.getPlayer().getX()] == 'F'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setY(this.getPlayer().getY()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			this.isShot = false;
		}
	}
	/**
	 * Move right the player
	 */
	public void moveRight(){
		if (map2[this.getPlayer().getY()][this.getPlayer().getX()+1] == 'V'){
		
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setX(this.getPlayer().getX()+1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()+1] == '1'){
			score+=100;
			System.out.println("Votre score: " + score);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()+1] == 'Q'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
			map2[6][18] = 'U';
			break;
			case 2:
			map2[4][19] = 'U';
			break;
			case 3:
			map2[5][4] = 'U';
			break;
			case 4:
			map2[10][12] = 'U';
			break;
			case 5:
			map2[11][10] = 'U';
			break;
			
			}
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()+1] == 'U'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
				
				this.loadMessage("02");
				break;
			case 2:
				this.loadMessage("03");
				break;
			case 3:
				this.loadMessage("04");
				break;
			case 4:
				this.loadMessage("05");
				break;
			}
			
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()+1] == 'F'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()+1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			this.isShot = false;
		}
	}
	/**
	 * Move left the player
	 */
	public void moveLeft(){
		if (map2[this.getPlayer().getY()][this.getPlayer().getX()-1] == 'V'){
		
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
		this.getPlayer().setX(this.getPlayer().getX()-1);
		this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()-1] == '1'){
			score+=100;
			System.out.println("Votre score: " + score);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()-1] == 'Q'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
			map2[6][18] = 'U';
			break;
			case 2:
			map2[4][19] = 'U';
			break;
			case 3:
			map2[5][4] = 'U';
			break;
			case 4:
			map2[10][12] = 'U';
			break;
			case 5:
			map2[11][10] = 'U';
			break;
			}
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()-1] == 'U'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			switch (mapID){
			case 1:
				this.loadMessage("02");
				break;
			case 2:
				this.loadMessage("03");
				break;
			case 3:
				this.loadMessage("04");
				break;
			case 4:
				this.loadMessage("05");
				break;
			}
		}
		else if (map2[this.getPlayer().getY()][this.getPlayer().getX()-1] == 'F'){
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = 'V';
			this.getPlayer().setX(this.getPlayer().getX()-1);
			this.map2[this.getPlayer().getY()][this.getPlayer().getX()] = '@';
			this.isShot = false;
		}
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
	/** 
	 * 
	 * the monster A IA
	 */
public void monsterA() {
         {
        	 if (this.monsterA.isAlive()== true){
            int mx = getMonsterA().getX();
            int hx = getPlayer().getX();
            int my = getMonsterA().getY();
            int hy = getPlayer().getY();
            /** if x is lower than lorann's increments it**/
            if (mx < hx && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'O' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= '-' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'I'&& map2[this.getMonsterB().getY()][this.getMonsterB().getX()+1]!= 'Q') {
            	this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setX(this.getMonsterA().getX()+1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            /** if x is higher than lorann's decrement it**/
            if (mx > hx && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= 'O' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= '-' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= 'I'&& map2[this.getMonsterB().getY()][this.getMonsterB().getX()-1]!= 'Q') {
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setX(this.getMonsterA().getX()-1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            /** if y is lower than lorann's increments it**/
            if (my < hy && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= 'O' && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= '-' && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= 'I'&& map2[this.getMonsterB().getY()+1][this.getMonsterB().getX()]!= 'Q') {
            	this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setY(this.getMonsterA().getY()+1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            /** if y is higher than lorann's decrement it **/
            if (my > hy && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= 'O' && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= '-' && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= 'I'&& map2[this.getMonsterB().getY()-1][this.getMonsterB().getX()]!= 'Q') {
            	this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'V';
        		this.getMonsterA().setY(this.getMonsterA().getY()-1);
        		this.map2[this.getMonsterA().getY()][this.getMonsterA().getX()] = 'A';
            }
            if (mx == hx && my == hy){
         	   this.loadMessage("06");
         	   this.monsterA.setAlive(false);
         	  this.monsterB.setAlive(false);
         	 this.monsterC.setAlive(false);
         	this.monsterD.setAlive(false);
            }
        }}
    }
public void monsterB() {
    {
    	 if (this.monsterB.isAlive()== true){
       int mx = getMonsterB().getX();
       int hx = getPlayer().getX();
       int my = getMonsterB().getY();
       int hy = getPlayer().getY();
       /** if x is lower than lorann's increments it**/
       if (mx < hx && map2[this.getMonsterB().getY()][this.getMonsterB().getX()+1]!= 'O' && map2[this.getMonsterB().getY()][this.getMonsterB().getX()+1]!= '-' && map2[this.getMonsterB().getY()][this.getMonsterB().getX()+1]!= 'I' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()+1]!= 'A' && map2[this.getMonsterB().getY()][this.getMonsterB().getX()+1]!= 'Q') {
       	this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'V';
   		this.getMonsterB().setX(this.getMonsterB().getX()+1);
   		this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'B';
       }
       /** if x is higher than lorann's decrement it**/
       if (mx > hx && map2[this.getMonsterB().getY()][this.getMonsterB().getX()-1]!= 'O' && map2[this.getMonsterB().getY()][this.getMonsterB().getX()-1]!= '-' && map2[this.getMonsterB().getY()][this.getMonsterB().getX()-1]!= 'I' && map2[this.getMonsterA().getY()][this.getMonsterA().getX()-1]!= 'A' && map2[this.getMonsterB().getY()][this.getMonsterB().getX()-1]!= 'Q') {
   		this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'V';
   		this.getMonsterB().setX(this.getMonsterB().getX()-1);
   		this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'B';
       }
       /** if y is lower than lorann's increments it**/
       if (my < hy && map2[this.getMonsterB().getY()+1][this.getMonsterB().getX()]!= 'O' && map2[this.getMonsterB().getY()+1][this.getMonsterB().getX()]!= '-' && map2[this.getMonsterB().getY()+1][this.getMonsterB().getX()]!= 'I' && map2[this.getMonsterA().getY()+1][this.getMonsterA().getX()]!= 'A'&& map2[this.getMonsterB().getY()+1][this.getMonsterB().getX()]!= 'Q') {
       	this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'V';
   		this.getMonsterB().setY(this.getMonsterB().getY()+1);
   		this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'B';
       }
       /** if y is higher than lorann's decrement it **/
       if (my > hy && map2[this.getMonsterB().getY()-1][this.getMonsterB().getX()]!= 'O' && map2[this.getMonsterB().getY()-1][this.getMonsterB().getX()]!= '-' && map2[this.getMonsterB().getY()-1][this.getMonsterB().getX()]!= 'I' && map2[this.getMonsterA().getY()-1][this.getMonsterA().getX()]!= 'A'&& map2[this.getMonsterB().getY()-1][this.getMonsterB().getX()]!= 'Q') {
       	this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'V';
   		this.getMonsterB().setY(this.getMonsterB().getY()-1);
   		this.map2[this.getMonsterB().getY()][this.getMonsterB().getX()] = 'B';
       }
    	 if (mx == hx && my == hy){
       	   this.loadMessage("06");
       	   this.monsterA.setAlive(false);
       	  this.monsterB.setAlive(false);
       	 this.monsterC.setAlive(false);
       	this.monsterD.setAlive(false);
          }}
   }
}
public void monsterC() {
    {
    	 if (this.monsterC.isAlive()== true){
       int mx = getMonsterC().getX();
       int hx = getPlayer().getX();
       int my = getMonsterC().getY();
       int hy = getPlayer().getY();
       /** if x is lower than lorann's increments it**/
       if (mx < hx && map2[this.getMonsterC().getY()][this.getMonsterC().getX()+1]!= 'O' && map2[this.getMonsterC().getY()][this.getMonsterC().getX()+1]!= '-' && map2[this.getMonsterC().getY()][this.getMonsterC().getX()+1]!= 'I') {
       	this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'V';
   		this.getMonsterC().setX(this.getMonsterC().getX()+1);
   		this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'C';
       }
       /** if x is higher than lorann's decrement it**/
       if (mx > hx && map2[this.getMonsterC().getY()][this.getMonsterC().getX()-1]!= 'O' && map2[this.getMonsterC().getY()][this.getMonsterC().getX()-1]!= '-' && map2[this.getMonsterC().getY()][this.getMonsterC().getX()-1]!= 'I') {
   		this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'V';
   		this.getMonsterC().setX(this.getMonsterC().getX()-1);
   		this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'C';
       }
       /** if y is lower than lorann's increments it**/
       if (my < hy && map2[this.getMonsterC().getY()+1][this.getMonsterC().getX()]!= 'O' && map2[this.getMonsterC().getY()+1][this.getMonsterC().getX()]!= '-' && map2[this.getMonsterC().getY()+1][this.getMonsterC().getX()]!= 'I') {
       	this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'V';
   		this.getMonsterC().setY(this.getMonsterC().getY()+1);
   		this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'C';
       }
       /** if y is higher than lorann's decrement it **/
       if (my > hy && map2[this.getMonsterC().getY()-1][this.getMonsterC().getX()]!= 'O' && map2[this.getMonsterC().getY()-1][this.getMonsterC().getX()]!= '-' && map2[this.getMonsterC().getY()-1][this.getMonsterC().getX()]!= 'I') {
       	this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'V';
   		this.getMonsterC().setY(this.getMonsterC().getY()-1);
   		this.map2[this.getMonsterC().getY()][this.getMonsterC().getX()] = 'C';
       }
  	 if (mx == hx && my == hy){
     	   this.loadMessage("06");
     	   this.monsterA.setAlive(false);
     	  this.monsterB.setAlive(false);
     	 this.monsterC.setAlive(false);
     	this.monsterD.setAlive(false);
        }}
   }
}
public void monsterD() {
    {
    	 if (this.monsterD.isAlive()== true){
       int mx = getMonsterD().getX();
       int hx = getPlayer().getX();
       int my = getMonsterD().getY();
       int hy = getPlayer().getY();
       /** if x is lower than lorann's increments it**/
       if (mx < hx && map2[this.getMonsterD().getY()][this.getMonsterD().getX()+1]!= 'O' && map2[this.getMonsterD().getY()][this.getMonsterD().getX()+1]!= '-' && map2[this.getMonsterD().getY()][this.getMonsterD().getX()+1]!= 'I') {
       	this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'V';
   		this.getMonsterD().setX(this.getMonsterD().getX()+1);
   		this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'A';
       }
       /** if x is higher than lorann's decrement it**/
       if (mx > hx && map2[this.getMonsterD().getY()][this.getMonsterD().getX()-1]!= 'O' && map2[this.getMonsterD().getY()][this.getMonsterD().getX()-1]!= '-' && map2[this.getMonsterD().getY()][this.getMonsterD().getX()-1]!= 'I') {
   		this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'V';
   		this.getMonsterD().setX(this.getMonsterD().getX()-1);
   		this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'A';
       }
       /** if y is lower than lorann's increments it**/
       if (my < hy && map2[this.getMonsterD().getY()+1][this.getMonsterD().getX()]!= 'O' && map2[this.getMonsterD().getY()+1][this.getMonsterD().getX()]!= '-' && map2[this.getMonsterD().getY()+1][this.getMonsterD().getX()]!= 'I') {
       	this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'V';
   		this.getMonsterD().setY(this.getMonsterD().getY()+1);
   		this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'A';
       }
       /** if y is higher than lorann's decrement it **/
       if (my > hy && map2[this.getMonsterD().getY()-1][this.getMonsterD().getX()]!= 'O' && map2[this.getMonsterD().getY()-1][this.getMonsterD().getX()]!= '-' && map2[this.getMonsterD().getY()-1][this.getMonsterD().getX()]!= 'I') {
       	this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'V';
   		this.getMonsterD().setY(this.getMonsterD().getY()-1);
   		this.map2[this.getMonsterD().getY()][this.getMonsterD().getX()] = 'A';
       }
  	 if (mx == hx && my == hy){
     	   this.loadMessage("06");
     	   this.monsterA.setAlive(false);
     	  this.monsterB.setAlive(false);
     	 this.monsterC.setAlive(false);
     	this.monsterD.setAlive(false);
        }}
   }
}

public void fireball(){
	switch (lastKey){
	case 1:
		if (this.isShot == false){
	this.map2[this.getPlayer().getY()-1][this.getPlayer().getX()] = 'F';
	System.out.println(lastKey);
	this.isShot = true;
		}
	break;
	case 2:
		if (this.isShot == false){
	this.map2[this.getPlayer().getY()+1][this.getPlayer().getX()] = 'F';
	System.out.println(lastKey);
	this.isShot = true;}
	break;
	case 3:
		if (this.isShot == false){
	this.map2[this.getPlayer().getY()][this.getPlayer().getX()+1] = 'F';
	System.out.println(lastKey);
	this.isShot = true;}
	break;
	case 4:
		if (this.isShot == false){
	this.map2[this.getPlayer().getY()][this.getPlayer().getX()-1] = 'F';
	System.out.println(lastKey);
	this.isShot = true;}
	break;
}}

public int getLastKey() {
	return this.lastKey;
}

public void setLastKey(int lastKey) {
	this.lastKey = lastKey;
	
}
}