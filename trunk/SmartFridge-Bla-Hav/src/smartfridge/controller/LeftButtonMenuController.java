package smartfridge.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftButtonMenuView;

public class LeftButtonMenuController{
	
	private FridgeManager fridge;
	private LeftButtonMenuView view;
	

	private ActionListener buttonUndoListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!fridge.undoIsEmpty()){
				fridge.unDoAction();
			}
			else{
				view.getUndoButton().setEnabled(false);
			}
			
		}
	};
	
	private ActionListener buttonRedoListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!fridge.redoIsEmpty()){
				fridge.reDoAction();
			}
			else{
				view.getRedoButton().setEnabled(false);
			}
			
		}
	};
	
	private ActionListener buttonRemoveListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			fridge.deletePerishedProduct();
			JOptionPane.showMessageDialog(view, fridge.showListPerishedProductIn(0),"Produits périmés", JOptionPane.WARNING_MESSAGE);
			
		}
	};

	
	
	public LeftButtonMenuController(FridgeManager fridge){
		this.setView(new LeftButtonMenuView());
		view.getUndoButton().addActionListener(buttonUndoListener);
		view.getRedoButton().addActionListener(buttonRedoListener);
		view.getRemoveButton().addActionListener(buttonRemoveListener);
		this.fridge = fridge;
	}
	
	
	public ActionListener getUndoButtonActionListener() {
		// TODO Auto-generated method stub
		return buttonUndoListener;
	}
	
	public ActionListener getRedoButtonActionListener() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ChangeListener getCheckButtonActionListener() {
		// TODO Auto-generated method stub
		return null;
	}

	public LeftButtonMenuView getView() {
		return view;
	}

	public void setView(LeftButtonMenuView view) {
		this.view = view;
	}


	public ActionListener getButtonRedoListener() {
		return buttonRedoListener;
	}


	public void setButtonRedoListener(ActionListener buttonRedoListener) {
		this.buttonRedoListener = buttonRedoListener;
	}


	public ActionListener getButtonRemoveListener() {
		return buttonRemoveListener;
	}


	public void setButtonRemoveListener(ActionListener buttonRemoveListener) {
		this.buttonRemoveListener = buttonRemoveListener;
	}
}
