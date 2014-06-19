package smartfridge.controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;

import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.view.sides.RightProductMenuView;

public class RightProductMenuController {

	private FridgeManager fridge;
	private RightProductMenuView view;

	public RightProductMenuController(FridgeManager fm) {
		// TODO Auto-generated constructor stub
		this.setFridge(fm);
		this.setView(new RightProductMenuView(fm, this));
		this.view.getProductList().setListData(listProduct());
		//this.view.getLabelTrash().addMouseListener(corbeilleListener);
		//this.view.getLabelTrash().addFocusListener(corbeilleFocusListener);
		//this.view.getLabelTrash().addMouseMotionListener(corbeilleDragListener);
	}

	public RightProductMenuController(FridgeManager fm, MenuController menu) {
		// TODO Auto-generated constructor stub
		this.setFridge(fm);
		this.setView(new RightProductMenuView(fm, menu));
		this.view.getProductList().setListData(listProduct());
		//this.view.getLabelTrash().addMouseListener(corbeilleListener);
		//this.view.getLabelTrash().addFocusListener(corbeilleFocusListener);
		//this.view.getLabelTrash().addMouseMotionListener(corbeilleDragListener);

	}

	public RightProductMenuController(FridgeManager fm, int check) {
		// TODO Auto-generated constructor stub
		this.setFridge(fm);
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

	public int getIndexSelectedProduct() {
		return this.view.getProductList().getSelectedIndex();
	}

	public void refreshDataPerished(int i) {
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
	
	
	private MouseMotionListener corbeilleDragListener = new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseDragged(MouseEvent arg0) {
			System.out.println("drag");
			view.getLabelTrash().setIcon(new ImageIcon("resources/corbeilleFocus.png"));
			
		}
	};
	
	private FocusListener corbeilleFocusListener = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			view.getLabelTrash().setIcon(new ImageIcon("resources/corbeille.png"));
			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			view.getLabelTrash().setIcon(new ImageIcon("resources/corbeilleFocus.png"));
			
		}
	};
	private MouseListener corbeilleListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// labelTrash.setIcon(new
			// ImageIcon("resources/corbeilleFocus.png"));

		}

		@Override
		public void mouseExited(MouseEvent e) {

			view.getLabelTrash().setIcon(new ImageIcon("resources/corbeille.png"));

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			view.getLabelTrash().setIcon(new ImageIcon("resources/corbeilleFocus.png"));

		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}
	};
}
