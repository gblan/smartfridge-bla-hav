package smartfridge.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import smartfridge.enu.TypeActionEnum;
import smartfridge.fridge.FridgeManager;


public class DetailMenuController {
	
	private RightProductMenuController rightControl;
	private LeftDetailMenuController leftControl;
	private FridgeManager fridge;
	public RightProductMenuController getRightControl() {
		return rightControl;
	}
	
	
	public DetailMenuController( FridgeManager fridge){
		this.rightControl = new RightProductMenuController(fridge);
		this.leftControl = new LeftDetailMenuController(fridge);
		this.fridge = fridge;
		this.rightControl.getView().getProductList().addMouseListener(productListener);
		this.leftControl.getView().getDecreaseQuantityButton().addActionListener(buttonLess);
		this.leftControl.getView().getIncreaseQuantityButton().addActionListener(buttonMore);
	}
	
	private ActionListener buttonLess = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if((leftControl.getView().getActualQUantity().getText().matches("\\d+"))){
				fridge.executeAction(TypeActionEnum.DECREASE_QUANTITY, rightControl.getSelectedProduct(), 1);
				leftControl.refreshData(rightControl.getSelectedProduct());
			}
			
		}
	};
	
	private ActionListener buttonMore = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if((leftControl.getView().getActualQUantity().getText().matches("\\d+"))){
				fridge.executeAction(TypeActionEnum.INCREASE_QUANTITY, rightControl.getSelectedProduct(), 1);
				leftControl.refreshData(rightControl.getSelectedProduct());
			}
			
		}
	};
	private MouseListener productListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2 ){
				leftControl.refreshData(rightControl.getSelectedProduct());
				rightControl.refreshSelected(rightControl.getIndexSelectedProduct());
			}
			
		}
	};
	
	public void setRightControl(RightProductMenuController rightControl) {
		this.rightControl = rightControl;
	}
	public LeftDetailMenuController getLeftControl() {
		return leftControl;
	}
	public void setLeftControl(LeftDetailMenuController leftControl) {
		this.leftControl = leftControl;
	}
	public FridgeManager getFridge() {
		return fridge;
	}
	public void setFridge(FridgeManager fridge) {
		this.fridge = fridge;
	}

}
