package smartfridge.view.sides;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import smartfridge.enu.TypeProductEnum;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;
import smartfridge.utils.ListItemTransferHandler;

public class RightProductMenuView extends RightSide {

	private static final long serialVersionUID = 1L;

	private JList<ProductAbstract> productList;

	public RightProductMenuView() {
		super();

		

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		productList = new JList<ProductAbstract>();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		productList.setVisibleRowCount(-1);

		JScrollPane scroll = new JScrollPane(productList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ListCellRenderer renderer = new FridgeProductRenderer();
		productList.setCellRenderer(renderer);
		productList.setTransferHandler(new ListItemTransferHandler());
		productList.setDropMode(DropMode.INSERT);
		productList.setDragEnabled(true);
		
		scroll.setPreferredSize(new Dimension(200,300));
	
		this.setLayout(new BorderLayout());

		this.add(scroll);
		
		
		//JLabel trash = new JLabel(new ImageIcon("resources/corbeille.png"));
		////this.add(Box.createRigidArea(new Dimension(0,300)));
		//this.add(trash);
	}

	public RightProductMenuView(int i) {
		super();

		if(i < 0){
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
		productList.setTransferHandler(new ListItemTransferHandler());
		productList.setDropMode(DropMode.INSERT);
		productList.setDragEnabled(true);

		
		this.setLayout(new BorderLayout());

		this.add(scroll);
	}
	public JList<ProductAbstract> getProductList() {
		return productList;
	}

	public void setProductList(JList<ProductAbstract> productList) {
		this.productList = productList;
	}
}
