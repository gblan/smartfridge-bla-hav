package smartfridge.view.sides;

import java.awt.BorderLayout;
import java.util.GregorianCalendar;

import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

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
		
		scroll.setSize(100, 100);

		
		this.setLayout(new BorderLayout());

		this.add(scroll);
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
