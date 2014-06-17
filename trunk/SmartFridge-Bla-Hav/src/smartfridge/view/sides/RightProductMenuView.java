package smartfridge.view.sides;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import smartfridge.product.ProductAbstract;
import smartfridge.utils.ListItemTransferHandler;

public class RightProductMenuView extends RightSide {

	private static final long serialVersionUID = 1L;

	private JList<ProductAbstract> productList;

	public RightProductMenuView() {
		super();

		
//		this.setLayout(new BorderLayout());

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
		productList.setTransferHandler(new ListItemTransferHandler());
		productList.setDropMode(DropMode.INSERT);
		productList.setDragEnabled(true);
		
		scroll.setPreferredSize(new Dimension(200,300));
	
//		this.setLayout(new BorderLayout());

		this.add(scroll);
				
		JLabel labelTrash = new JLabel(new ImageIcon("resources/corbeille.png"));
		labelTrash.setDropTarget(new DropTarget()
		{
			public void drop(DropTargetDropEvent dtde) 
			{
				try{
					System.out.println("SUPPRIMER ICI");
					DataFlavor[] datas = dtde.getCurrentDataFlavors();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.add(Box.createRigidArea(new Dimension(0,300)));
		this.add(labelTrash);
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
