package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.controller.DetailMenuController;
import smartfridge.controller.LeftDetailMenuController;
import smartfridge.controller.RightProductMenuController;
import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftDetailMenuView;

public class DetailMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	private DetailMenuController controller;

	public DetailMenu(FridgeManager fridge) {

		/* Ajout des 2 parties de la fenêtre */

		controller = new DetailMenuController(fridge);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		// leftcontrol.getView().setLayout(new SpringLayout());
		// SpringUtilities.makeCompactGrid(leftcontrol.getView(), 5, 1, 2, 2, 2,
		// 2);

		mainPanel.add(controller.getLeftControl().getView());

		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		mainPanel.add(controller.getRightControl().getView());

		this.add(mainPanel);

		setVisible(true);
	}

	public DetailMenuController getController() {
		return controller;
	}

	public void setController(DetailMenuController controller) {
		this.controller = controller;
	}

	public LeftDetailMenuView getLeftDetailMenuView() {
		return controller.getLeftControl().getView();
	}

	public RightProductMenuController getRightProductMenuController() {
		return controller.getRightControl();
	}

	public LeftDetailMenuController getLeftDetailMenuController() {
		return controller.getLeftControl();
	}
}
