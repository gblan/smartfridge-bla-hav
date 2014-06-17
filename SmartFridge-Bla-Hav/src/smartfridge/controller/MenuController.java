package smartfridge.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import smartfridge.fridge.FridgeManager;

public class MenuController {

	private RightProductMenuController rightControl;
	private LeftButtonMenuController leftControl;
	private FridgeManager fridge;
	
	public MenuController( FridgeManager fridge){
		this.rightControl = new RightProductMenuController(fridge);
		this.leftControl = new LeftButtonMenuController(fridge);
		this.fridge = fridge;
		this.leftControl.getView().getUndoButton().setEnabled(false);
		this.leftControl.getView().getRedoButton().setEnabled(false);
		this.leftControl.getView().getUndoButton().addActionListener(buttonUndoListener);
		this.leftControl.getView().getRedoButton().addActionListener(buttonRedoListener);
		this.leftControl.getView().getRemoveButton().addActionListener(buttonRemoveListener);
	}
	
	private ActionListener buttonUndoListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!fridge.undoIsEmpty()){
				fridge.unDoAction();
				leftControl.getView().getRedoButton().setEnabled(true);
				rightControl.refreshData();
				if(fridge.undoIsEmpty()){
					leftControl.getView().getUndoButton().setEnabled(false);
				}
			}

		}
	};
	
	private ActionListener buttonRedoListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!fridge.redoIsEmpty()){
				fridge.reDoAction();
				rightControl.refreshData();
				leftControl.getView().getUndoButton().setEnabled(true);
				if(fridge.redoIsEmpty()){
					leftControl.getView().getRedoButton().setEnabled(false);
				}
			}
			else{
				leftControl.getView().getRedoButton().setEnabled(false);
			}
			
		}
	};
	
	
	private ActionListener buttonRemoveListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(leftControl.getView(), fridge.showListPerishedProductIn(0),"Produits périmés", JOptionPane.WARNING_MESSAGE);
			fridge.deletePerishedProduct();
			rightControl.refreshData();
		}
	};

	public RightProductMenuController getRightControl() {
		return rightControl;
	}

	public void setRightControl(RightProductMenuController rightControl) {
		this.rightControl = rightControl;
	}

	public LeftButtonMenuController getLeftControl() {
		return leftControl;
	}

	public void setLeftControl(LeftButtonMenuController leftControl) {
		this.leftControl = leftControl;
	}
}
