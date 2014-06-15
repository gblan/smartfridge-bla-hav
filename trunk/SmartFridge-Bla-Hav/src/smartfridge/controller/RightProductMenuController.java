package smartfridge.controller;

import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.view.sides.RightProductMenuView;

public class RightProductMenuController {

	
	private FridgeManager fridge;
	private RightProductMenuView view;
	
	public RightProductMenuController(FridgeManager f){
		// TODO Auto-generated constructor stub
		this.setFridge(f);
		this.setView(new RightProductMenuView());
		this.view.getProductList().setListData(listProduct());
	}

	public void refreshData(){
		this.view.getProductList().setListData(listProduct());
	}
	
	private ProductAbstract[] listProduct(){
		ProductAbstract[] listData = fridge.getFridge().getFridgeContent().toArray(
				new ProductAbstract[fridge.getFridge().getFridgeContent().size()]);
		return listData;
		
	}

	public FridgeManager getFridge() {
		return fridge;
	}

	public void setFridge(FridgeManager fridge) {
		this.fridge = fridge;
	}

	public RightProductMenuView getView() {
		return view;
	}

	public void setView(RightProductMenuView rightProductMenuView) {
		this.view = rightProductMenuView;
	}
}
