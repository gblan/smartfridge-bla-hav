package smartfridge.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.view.sides.RightProductMenuView;

public class RightProductMenuController {

	private FridgeManager fridge;
	private RightProductMenuView view;
	private int perishedInt;


	public RightProductMenuController(FridgeManager fm) {
		// TODO Auto-generated constructor stub
		this.setFridge(fm);
		this.setView(new RightProductMenuView(fm, this));
		this.view.getProductList().setListData(listProduct());

	}
	
	public RightProductMenuController(FridgeManager fm, DetailMenuController menu) {
		this.setFridge(fm);
		this.setView(new RightProductMenuView(fm, menu));
		this.view.getProductList().setListData(listProduct());

	}

	public RightProductMenuController(FridgeManager fm, MenuController menu) {
		this.setFridge(fm);
		this.setView(new RightProductMenuView(fm, menu));
		this.view.getProductList().setListData(listProduct());


	}

	public RightProductMenuController(FridgeManager fm, int check) {
		this.setFridge(fm);
		this.perishedInt = check;
		this.setView(new RightProductMenuView(fm, this, check));
		this.view.getProductList().setListData(listProductPerished(check));
	}

	public void refreshData() {
		this.view.getProductList().setListData(listProduct());
	}

	public void refreshSelected(int index) {
		this.view.getProductList().setSelectedIndex(index);
	}

	private ProductAbstract[] listProduct() {
		ProductAbstract[] listData = fridge
				.getFridge()
				.getFridgeContent()
				.toArray(
						new ProductAbstract[fridge.getFridge()
								.getFridgeContent().size()]);
		return listData;

	}

	private List<ProductAbstract> getListPerishedProductIn(int n) {
		ArrayList<ProductAbstract> list;
		list = new ArrayList<ProductAbstract>();
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		if (n < 0) {
			n = 0;
		}
		calendar.add(Calendar.DATE, n - 1);

		for (ProductAbstract p : this.fridge.getFridge().getFridgeContent()) {
			if (p instanceof ProductPerishable) {
				if (((ProductPerishable) p).getDatePerishment()
						.getTimeInMillis() < calendar.getTimeInMillis()) {
					list.add(p);
				}
			}
		}
		return list;
	}

	public ProductAbstract getSelectedProduct() {
		return this.view.getProductList().getSelectedValue();
	}
	public void setSelectedProduct(){
		this.view.getProductList().setSelectedIndex(0);
	}

	public int getIndexSelectedProduct() {
		return this.view.getProductList().getSelectedIndex();
	}

	public void refreshDataPerished(int i) {
		this.perishedInt = i;
		this.view.getProductList().setListData(listProductPerished(i));
	}

	private ProductAbstract[] listProductPerished(int n) {

		ProductAbstract[] listData = getListPerishedProductIn(n).toArray(
				new ProductAbstract[getListPerishedProductIn(n).size()]);
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
	
	public void refreshDataPerished(){
		this.view.getProductList().setListData(listProductPerished(this.perishedInt));
	}
	

}
