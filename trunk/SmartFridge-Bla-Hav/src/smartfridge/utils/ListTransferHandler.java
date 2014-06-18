package smartfridge.utils;

import java.awt.Component;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;

import smartfridge.controller.RightProductMenuController;
import smartfridge.enu.TypeActionEnum;
import smartfridge.fridge.FridgeManager;
import smartfridge.product.ProductAbstract;
import smartfridge.product.ProductPerishable;
import smartfridge.product.ProductUnPerishable;
import smartfridge.view.MainMenu;

public class ListTransferHandler extends TransferHandler {

	private FridgeManager fm;
	private RightProductMenuController mainMenuController;

	public ListTransferHandler(FridgeManager fm,
			RightProductMenuController mainMenuController) {
		this.fm = fm;
		this.mainMenuController = mainMenuController;
	}

	@Override
	public boolean canImport(TransferSupport support) {
		return (support.getComponent() instanceof JLabel)
				&& support
						.isDataFlavorSupported(ListProductTransferable.LIST_ITEM_DATA_FLAVOR);
	}

	@Override
	public boolean importData(TransferSupport support) {
		boolean accept = false;
		if (canImport(support)) {
			try {
				Transferable t = support.getTransferable();
				Object value = t
						.getTransferData(ListProductTransferable.LIST_ITEM_DATA_FLAVOR);
				if (value instanceof ProductPerishable
						|| value instanceof ProductUnPerishable) {
					Component component = support.getComponent();
					if (component instanceof JLabel) {
						accept = true;
					}
				}
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		return accept;
	}

	@Override
	public int getSourceActions(JComponent c) {
		return DnDConstants.ACTION_COPY_OR_MOVE;
	}

	@Override
	protected Transferable createTransferable(JComponent c) {
		Transferable t = null;
		if (c instanceof JList) {
			JList list = (JList) c;
			Object product = list.getSelectedValue();
			if (product instanceof ProductPerishable) {
				ProductPerishable p = (ProductPerishable) product;
				t = new ListProductTransferable(p);
			} else {
				ProductUnPerishable p = (ProductUnPerishable) product;
				t = new ListProductTransferable(p);
			}
		}
		return t;
	}

	@Override
	protected void exportDone(JComponent source, Transferable data, int action) {
		if (action == MOVE) {
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"Would You Really Want to Remove This Product?", "WARNING",
					JOptionPane.OK_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				try {
					this.fm.executeAction(TypeActionEnum.REMOVE,
							(ProductAbstract) data.getTransferData(null), 0);
				} catch (UnsupportedFlavorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			mainMenuController.refreshData();
		}
	}
}