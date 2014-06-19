package smartfridge.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import smartfridge.enu.TypeProductEnum;
import smartfridge.fridge.FridgeManager;
import smartfridge.view.sides.LeftAddMenuView;

public class LeftAddMenuController extends AddingMenuController {

	private FridgeManager fridge;
	private LeftAddMenuView view;

	private ActionListener radioButtonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String string = e.getActionCommand();

			switch (string) {

			case "Drinks":
				setType(TypeProductEnum.DRINKS);
				break;

			case "Meats":
				setType(TypeProductEnum.MEATS);
				break;

			case "Fish":
				setType(TypeProductEnum.FISH);
				break;

			case "Diary":
				setType(TypeProductEnum.DIARY);
				break;

			case "Vegetables":
				setType(TypeProductEnum.VEGETABLES);
				break;

			case "Fruits":
				setType(TypeProductEnum.FRUITS);
				break;

			case "Eggs":
				setType(TypeProductEnum.EGGS);
				break;

			case "Others":
				setType(TypeProductEnum.DRINKS);
				break;
			default:
				setType(null);
				break;
			}
		}

	};

	public LeftAddMenuController(FridgeManager fridge) {
		this.setFridge(fridge);
		this.setView(new LeftAddMenuView());

		this.view.getDrinks().addActionListener(radioButtonListener);
		this.view.getMeats().addActionListener(radioButtonListener);
		this.view.getFish().addActionListener(radioButtonListener);
		this.view.getDiary().addActionListener(radioButtonListener);
		this.view.getVegetables().addActionListener(radioButtonListener);
		this.view.getFruits().addActionListener(radioButtonListener);
		this.view.getEggs().addActionListener(radioButtonListener);
		this.view.getOthers().addActionListener(radioButtonListener);
	}

	public ActionListener getRadioButton() {

		return radioButtonListener;

	}

	public LeftAddMenuView getView() {
		return view;
	}

	public void setView(LeftAddMenuView view) {
		this.view = view;
	}

	public FridgeManager getFridge() {
		return fridge;
	}

	public void setFridge(FridgeManager fridge) {
		this.fridge = fridge;
	}

	public TypeProductEnum getType() {
		return AddingMenuController.TYPE;
	}

	public void setType(TypeProductEnum type) {
		AddingMenuController.TYPE = type;
	}

}
