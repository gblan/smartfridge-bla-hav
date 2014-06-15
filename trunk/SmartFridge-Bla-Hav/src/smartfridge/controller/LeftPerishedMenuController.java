package smartfridge.controller;


import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftPerishedMenuView;

public class LeftPerishedMenuController {
	
	private LeftPerishedMenuView view;
	
	public LeftPerishedMenuController(FridgeManager fridge){
		this.view = new LeftPerishedMenuView();
	}




	public void refreshText(String t){
		this.view.getPerishedLabel().setText(t);
	}
	public boolean verifText(){
		
		if(view.getPerishedLabel().getText().matches("\\d+")){
			return true;
		}
		else
			return false;
		
	}
	public LeftPerishedMenuView getView() {
		return view;
	}

	public void setView(LeftPerishedMenuView view) {
		this.view = view;
	}

}
