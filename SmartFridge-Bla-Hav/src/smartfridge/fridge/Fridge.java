package smartfridge.fridge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import smartfridge.product.ProductAbstract;

public class Fridge implements Serializable{

	private static final long serialVersionUID = -5601074623725600420L;
	private List<ProductAbstract> fridgeContent = new ArrayList<ProductAbstract>();

	public List<ProductAbstract> getFridgeContent() {
		return fridgeContent;
	}

	/**
	 * LOADING FROM DB
	 * 
	 * @param fridgeContent
	 */
	public Fridge(ArrayList<ProductAbstract> fridgeContent) {
		super();
		this.fridgeContent = fridgeContent;
	}

	public Fridge() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		String res = "";
		int i = 1;
		res += "#####################\n";
		res += "The Fridge contents : \n";
		res += "#####################\n";

		for (ProductAbstract p : this.fridgeContent) {
			res += "#" + i;
			res += p.toString() + "\n";
			i++;
		}

		return res;
	}

}
