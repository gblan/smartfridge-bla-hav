package smartfridge.view.sides;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;

public class FridgeProductRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	private final JLabel label = new JLabel("", JLabel.CENTER);
	private final JLabel icon = new JLabel((Icon) null, JLabel.CENTER);
	private final JPanel panel = new JPanel(new BorderLayout());

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		this.setLayout(new FlowLayout());

		ProductAbstract p = (ProductAbstract) value;

		ImageIcon i = new ImageIcon();
		i = new ImageIcon("resources/"
				+ p.getTypeProduct().toString().toLowerCase() + ".jpg");

		icon.setIcon(i);
		label.setText(p.getProductName());

		panel.add(icon);
		panel.add(label, BorderLayout.SOUTH);

		if (isSelected) {
			panel.setBackground(Color.GRAY);
			panel.setForeground(Color.BLACK);
		} else {
			panel.setBackground(Color.WHITE);
			panel.setForeground(Color.BLACK);
		}

		/* HALO lumineux si périmé */
		if (p instanceof ProductPerishable) {
			if (((ProductPerishable) p).getDatePerishment().compareTo(
					new GregorianCalendar()) < 0) {

				panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,
						Color.RED));
			} else {
				GregorianCalendar datePlus3 = new GregorianCalendar();
				datePlus3.add(Calendar.DATE, 3);
				if (((ProductPerishable) p).getDatePerishment().compareTo(
						datePlus3) < 0) {

					panel.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,
							Color.ORANGE));
				}
				else{
					panel.setBorder(null);

				}
			}
		} else {
			panel.setBorder(null);

		}

		return panel;
	}
}