package smartfridge.view.sides;

import java.awt.BorderLayout;
import java.util.GregorianCalendar;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import smartfridge.enu.TypeProductEnum;
import smartfridge.fridge.Fridge;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;

public class RightProductMenuView extends RightSide {

	private static final long serialVersionUID = 1L;

	private JList<ProductAbstract> productList;

	public RightProductMenuView() {
		super();

		GregorianCalendar g = new GregorianCalendar(2014, 05, 20);

		ProductPerishable p12 = new ProductPerishable(TypeProductEnum.MEATS,
				"rognons2", 500, g);
		g.set(14, 05, 20);
		ProductPerishable p = new ProductPerishable(TypeProductEnum.FISH,
				"Colin", 150, g);
		g.set(2016, 05, 25);

		ProductPerishable p2 = new ProductPerishable(TypeProductEnum.DRINKS,
				"rhum", 3, g);
		ProductUnPerishable p3 = new ProductUnPerishable(
				TypeProductEnum.DRINKS, "rhum blanc", 1);
		g.set(2014, 05, 20);

		ProductPerishable p4 = new ProductPerishable(TypeProductEnum.MEATS,
				"rognons", 500, g);

		Fridge f = new Fridge();
		FridgeManager fm = new FridgeManager(f);
		fm.addProduct(p);
		fm.addProduct(p2);
		fm.addProduct(p3);
		fm.addProduct(p4);
		fm.addProduct(p12);

		ProductAbstract[] listData = f.getFridgeContent().toArray(
				new ProductAbstract[f.getFridgeContent().size()]);

		productList = new JList<ProductAbstract>();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		productList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		productList.setVisibleRowCount(-1);

		JScrollPane scroll = new JScrollPane(productList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		productList.setListData(listData);
		ListCellRenderer renderer = new FridgeProductRenderer();
		productList.setCellRenderer(renderer);

		this.setLayout(new BorderLayout());

		this.add(scroll);
	}
}
