package smartfridge.view.sides;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

import smartfridge.product.ProductAbstract;

public class FridgeProductRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		ProductAbstract p = (ProductAbstract)value;
		switch (p.getTypeProduct()) {
		case DIARY:		this.setIcon(new ImageIcon("resources/diary.jpg"));	break;
		case DRINKS:	this.setIcon(new ImageIcon("resources/drinks.jpg"));	break;
		case EGGS:		this.setIcon(new ImageIcon("resources/eggs.jpg"));	break;
		case FISH:		this.setIcon(new ImageIcon("resources/fish.jpg"));	break;
		case FRUITS:	this.setIcon(new ImageIcon("resources/fruits.jpg"));	break;
		case MEATS:		this.setIcon(new ImageIcon("resources/meat.jpg"));	break;
		case VEGETABLES:this.setIcon(new ImageIcon("resources/vegetables.jpg"));	break;
		case OTHERS:		break;
		default:		;	break;
		}
		this.setText(p.getProductName());

		return this;
	}
}