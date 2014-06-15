package smartfridge.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import smartfridge.fridge.FridgeManager;

public class PerishedController {
	
	private RightProductMenuController rightControl;
	private LeftPerishedMenuController leftControl;
	protected FridgeManager fridge;
	
	public PerishedController( FridgeManager fridge){

		this.fridge = fridge;
		this.setRightControl(new RightProductMenuController(fridge));
		this.setLeftControl(new LeftPerishedMenuController(fridge));
		this.leftControl.getView().getPerishedLabel().addKeyListener(perishableListener);

	}
	
	private KeyListener perishableListener = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			
			if(leftControl.verifText()){
				
			}
			
		}
	};

	public RightProductMenuController getRightControl() {
		return rightControl;
	}

	public void setRightControl(RightProductMenuController rightControl) {
		this.rightControl = rightControl;
	}

	public LeftPerishedMenuController getLeftControl() {
		return leftControl;
	}

	public void setLeftControl(LeftPerishedMenuController leftControl) {
		this.leftControl = leftControl;
	}

}
