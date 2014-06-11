package smartfridge.view.sides;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RightProductMenuView extends RightSide {

	private static final long serialVersionUID = 1L;

	private JList productList;

	public RightProductMenuView() {
		super();
		
		productList = new JList<>();
		productList.setCellRenderer(new FridgeProductRenderer());
	}
}
