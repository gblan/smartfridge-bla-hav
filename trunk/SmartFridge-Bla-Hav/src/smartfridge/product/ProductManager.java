package smartfridge.product;

public class ProductManager {


	public void increaseQuantity(ProductAbstract product, int quantityToAdd) {
		product.setQuantity(product.getQuantity()+ quantityToAdd);
	}

	public void decreaseQuantity(ProductAbstract product, int quantityToDecrease) {
		product.setQuantity(product.getQuantity()- quantityToDecrease);
	}

}
