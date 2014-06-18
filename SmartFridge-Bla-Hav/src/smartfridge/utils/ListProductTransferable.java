package smartfridge.utils;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import smartfridge.product.ProductAbstract;

public class ListProductTransferable implements Transferable {

    public static final DataFlavor LIST_ITEM_DATA_FLAVOR = new DataFlavor(ProductAbstract.class, "Fridge/Product");
    private ProductAbstract product;

    public ListProductTransferable(ProductAbstract product) {
        this.product = product;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{LIST_ITEM_DATA_FLAVOR};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(LIST_ITEM_DATA_FLAVOR);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {

        return product;

    }
}