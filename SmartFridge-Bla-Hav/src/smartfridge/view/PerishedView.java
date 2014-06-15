package smartfridge.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import smartfridge.controller.LeftPerishedMenuController;
import smartfridge.controller.PerishedController;
import smartfridge.controller.RightProductMenuController;
import smartfridge.fridge.FridgeManager;
import smartfridge.utils.SpringUtilities;
import smartfridge.view.sides.LeftButtonMenuView;
import smartfridge.view.sides.LeftPerishedMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class PerishedView extends JPanel {

	private static final long serialVersionUID = 1L;
	private PerishedController control;
	private FridgeManager fridge;
	private LeftPerishedMenuController leftControl;
	private RightProductMenuController rightControl;

	public LeftPerishedMenuView getLeftButtonMenuView() {
		return leftControl.getView();
	}

	public RightProductMenuView getRightProductMenuView() {
		return rightControl.getView();
	}
	
	public PerishedView(FridgeManager fridge) {

		/* Ajout des 2 parties de la fenêtre */

		this.fridge= fridge;
		
		this.control = new PerishedController(fridge);
		this.leftControl = new LeftPerishedMenuController(fridge);
		this.rightControl = new RightProductMenuController(fridge, 0);
		this.leftControl.getView().getPerishedLabel().addKeyListener(perishableListener);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		leftControl.getView().setLayout(new SpringLayout());
		SpringUtilities.makeCompactGrid(leftControl.getView(), 4, 1, 3, 3, 3, 3);
		
		mainPanel.add(leftControl.getView());

		mainPanel.add(Box.createRigidArea(new Dimension(30	, 0)));
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);		
		mainPanel.add(separator);
		mainPanel.add(Box.createRigidArea(new Dimension(30, 0)));

		mainPanel.add(rightControl.getView());

		this.add(mainPanel);

		setVisible(true);
	}

	
	private KeyListener perishableListener = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(leftControl.verifText()){
				System.out.println(fridge.showListPerishedProductIn(Integer.parseInt(leftControl.getView().getPerishedLabel().getText())));

				rightControl = new RightProductMenuController(fridge, Integer.parseInt(leftControl.getView().getPerishedLabel().getText()));

				
				
			}
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			

			
		}
	};
	public LeftPerishedMenuController getLeftControl() {
		return leftControl;
	}

	public void setLeftControl(LeftPerishedMenuController leftControl) {
		this.leftControl = leftControl;
	}

	public RightProductMenuController getRightControl() {
		return rightControl;
	}

	public void setRightControl(RightProductMenuController rightControl) {
		this.rightControl = rightControl;
	}
}
