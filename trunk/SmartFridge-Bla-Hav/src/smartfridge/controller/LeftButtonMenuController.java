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
	


	



	
	
	public LeftButtonMenuController(FridgeManager fridge){
		this.setView(new LeftButtonMenuView());


		this.fridge = fridge;
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



}
