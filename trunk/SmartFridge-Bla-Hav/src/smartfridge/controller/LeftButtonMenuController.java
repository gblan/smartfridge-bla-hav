package smartfridge.controller;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftButtonMenuView;

public class LeftButtonMenuController{
	
	private FridgeManager fridge;
	private LeftButtonMenuView view;
	


	



	
	
	public LeftButtonMenuController(FridgeManager fridge){
		this.setView(new LeftButtonMenuView());
		this.getView().getAddingButton().addMouseListener(addingbuttonListener);



		this.fridge = fridge;
	}
	
	private MouseListener addingbuttonListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon("resources/buttonAddSmall.png"));
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			((AbstractButton) e.getSource()).setIcon(new ImageIcon("resources/buttonAddSmallFocus.png"));
			
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	public void refreshUndoRedo(){
		if(!fridge.undoIsEmpty()){
			this.view.getUndoButton().setEnabled(true);
		}
		else{
			this.view.getUndoButton().setEnabled(false);

		}
		if(!fridge.redoIsEmpty()){
			this.view.getRedoButton().setEnabled(true);
		}
		else{
			this.view.getRedoButton().setEnabled(false);

		}
	}
	

	public LeftButtonMenuView getView() {
		return view;
	}

	public void setView(LeftButtonMenuView view) {
		this.view = view;
	}



}
