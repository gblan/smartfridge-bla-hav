package smartfridge.view.sides;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import smartfridge.controller.MenuController;
import smartfridge.controller.RightProductMenuController;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.utils.ListTransferHandler;

public class RightProductMenuView extends RightSide {

	private static final long serialVersionUID = 1L;

	private JList<ProductAbstract> productList;
	private FridgeManager fm;

	public RightProductMenuView(FridgeManager fm, RightProductMenuController menuController) {
		super();

		// this.setLayout(new BorderLayout());

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		productList = new JList<ProductAbstract>();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		productList.setVisibleRowCount(-1);

		JScrollPane scroll = new JScrollPane(productList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ListCellRenderer renderer = new FridgeProductRenderer();
		productList.setCellRenderer(renderer);

		productList.setDragEnabled(true);
		productList.setTransferHandler(new ListTransferHandler(fm,menuController));

		scroll.setPreferredSize(new Dimension(200, 300));

		this.add(scroll);

		JLabel labelTrash = new JLabel(new ImageIcon("resources/corbeille.png"));
		labelTrash.setTransferHandler(new ListTransferHandler(fm, menuController));

		//this.add(Box.createRigidArea(new Dimension(0, 300)));
		this.add(labelTrash);
	}


	public RightProductMenuView(FridgeManager fm,RightProductMenuController rightProductMenuController, int i) {
		super();

		if (i < 0) {
			i = 0;
		}

		productList = new JList<ProductAbstract>();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		productList.setVisibleRowCount(-1);

		JScrollPane scroll = new JScrollPane(productList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ListCellRenderer renderer = new FridgeProductRenderer();
		productList.setCellRenderer(renderer);

		productList.setDragEnabled(true);
		productList.setTransferHandler(new ListTransferHandler(fm, rightProductMenuController));
		
		scroll.setPreferredSize(new Dimension(200, 300));


		this.add(scroll);
		/*
		JLabel labelTrash = new JLabel(new ImageIcon("resources/corbeille.png"));
		labelTrash.setTransferHandler(new ListTransferHandler(fm, rightProductMenuController));

		//this.add(Box.createRigidArea(new Dimension(0, 300)));
		this.add(labelTrash);
		*/	
	}
	
	public RightProductMenuView(FridgeManager fm, MenuController menuController) {
		super();

		// this.setLayout(new BorderLayout());

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		productList = new JList<ProductAbstract>();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		productList.setVisibleRowCount(-1);

		JScrollPane scroll = new JScrollPane(productList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ListCellRenderer renderer = new FridgeProductRenderer();
		productList.setCellRenderer(renderer);

		productList.setDragEnabled(true);
		productList.setTransferHandler(new ListTransferHandler(fm,menuController));

		scroll.setPreferredSize(new Dimension(200, 300));

		this.add(scroll);

		JLabel labelTrash = new JLabel(new ImageIcon("resources/corbeille.png"));
		labelTrash.setTransferHandler(new ListTransferHandler(fm, menuController));

		//this.add(Box.createRigidArea(new Dimension(0, 300)));
		this.add(labelTrash);
	}

	public JList<ProductAbstract> getProductList() {
		return productList;
	}

	public void setProductList(JList<ProductAbstract> productList) {
		this.productList = productList;
	}
}
