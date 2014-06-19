package smartfridge.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.controller.LeftButtonMenuController;
import smartfridge.controller.MenuController;
import smartfridge.controller.RightProductMenuController;
import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftButtonMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private MenuController menu;

	protected FridgeManager fridge;

	public RightProductMenuController getRightProductMenuController() {
		return this.menu.getRightControl();
	}

	public LeftButtonMenuController getLeftButtonMenuController() {
		return this.menu.getLeftControl();
	}

	public LeftButtonMenuView getLeftButtonMenuView() {
		return this.menu.getLeftControl().getView();
	}

	public RightProductMenuView getRightProductMenuView() {
		return this.menu.getRightControl().getView();
	}

	public MainMenu(FridgeManager fridge) {

		/* Ajout des 2 parties de la fenêtre */

		this.fridge = fridge;
		menu = new MenuController(fridge);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		// left = new LeftButtonMenuView();
		// menu.getLeftControl().getView().setLayout(new SpringLayout());
		// SpringUtilities.makeCompactGrid(this.menu.getLeftControl().getView(),
		// 4, 1, 3, 3, 3, 3);

		mainPanel.add(this.menu.getLeftControl().getView());

		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		mainPanel.add(this.menu.getRightControl().getView());

		this.add(mainPanel);

		setVisible(true);
	}

}
