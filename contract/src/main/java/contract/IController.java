package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
	/**
	 * 
	 * @return mapID
	 */
	public int getMapID();
	/**
	 * Set map ID
	 *
	 * @param mapID
	 *          the map ID
	 */
	public void setMapID(int mapID);
	
	public int getLastKey();
	public void setLastKey(int lastKey);
}
