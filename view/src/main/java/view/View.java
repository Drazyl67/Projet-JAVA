package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.Map1;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.Map2;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.Map3;
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.Map4;
			case KeyEvent.VK_NUMPAD5:
				return ControllerOrder.Map5;
			case KeyEvent.VK_UP:
				return ControllerOrder.MoveUp;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.MoveDown;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.MoveLeft;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.MoveRight;
			default:
				return ControllerOrder.MapInconnu;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
