package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches '1', '2', '3', '4' ou '5', pour afficher la carte de votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
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
	 * the map ID
	 */
	public int mapID=0;

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Map1:
				this.model.loadMessage("01");
				this.model.setMapID(1);
				break;
			case Map2:
				this.model.loadMessage("02");
				this.model.setMapID(2);
				break;
			case Map3:
				this.model.loadMessage("03");
				this.model.setMapID(3);
				break;
			case Map4:
				this.model.loadMessage("04");
				this.model.setMapID(4);
				break;
			case Map5:
				this.model.loadMessage("05");
				this.model.setMapID(5);
				break;
			case MoveUp:
				this.model.moveUp();
				break;
			case MoveDown:
				this.model.moveDown();
				break;
			case MoveRight:
				this.model.moveRight();
				break;
			case MoveLeft:
				this.model.moveLeft();
				break;
			default:
				break;
		}
	}
	
	/**
	 * get the map ID
	 */
	public int getMapID() {
		return mapID;
	}
	
	/**
	 * set the map ID
	 */
	public void setMapID(int mapID) {
		this.mapID = mapID;
	}

}
