package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	String getMessage();

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMessage(String key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	char[][] getMap2();
	
	/**
	 * Fill the map in array
	 *
	 */
	void remplissage();
	
	/**
	 * move the player up
	 *
	 */
	void moveUp();
	
	/**
	 * move the player left
	 *
	 */
	void moveLeft();
	
	/**
	 * move the player right
	 *
	 */
	void moveRight();
	
	/**
	 * move the player down
	 *
	 */
	void moveDown();
	
	/**
	 * the IA of the monster
	 *
	 */
	void monsterA();
	/**
	 * the IA of the monster
	 *
	 */
	void monsterB();
	/**
	 * the IA of the monster
	 *
	 */
	void monsterC();
	/**
	 * the IA of the monster
	 *
	 */
	void monsterD();
	
	/**
	 * set the map ID
	 *	@param i
	 *			
	 */
	void setMapID(int i);

	void fireball();
	public int getLastKey();
	public void setLastKey(int lastKey);


}
