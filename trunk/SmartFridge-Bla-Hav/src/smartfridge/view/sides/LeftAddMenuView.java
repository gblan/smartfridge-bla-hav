package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class LeftAddMenuView extends LeftSide {

	private static final long serialVersionUID = 1L;

	private ButtonGroup bg;
	private JRadioButton drinks;
	private JRadioButton meats;
	private JRadioButton fish;
	private JRadioButton diary;
	private JRadioButton vegetables;
	private JRadioButton fruits;
	private JRadioButton eggs;
	private JRadioButton others;

	public LeftAddMenuView() {
		super();

		bg = new ButtonGroup();
		drinks = new JRadioButton(new ImageIcon("resources/drinks.jpg"));
		meats = new JRadioButton(new ImageIcon("resources/meats.jpg"));
		fish = new JRadioButton(new ImageIcon("resources/fish.jpg"));
		diary = new JRadioButton(new ImageIcon("resources/diary.jpg"));
		vegetables = new JRadioButton(new ImageIcon("resources/vegetables.jpg"));
		fruits = new JRadioButton(new ImageIcon("resources/fruits.jpg"));
		eggs = new JRadioButton(new ImageIcon("resources/eggs.jpg"));
		others = new JRadioButton();

		bg.add(drinks);
		bg.add(meats);
		bg.add(fish);
		bg.add(diary);
		bg.add(vegetables);
		bg.add(fruits);
		bg.add(eggs);
		bg.add(others);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// Icon image = new ImageIcon("resources/drinks.jpg");
		drinks.setText("Drinks");
		this.add(drinks);
		meats.setText("Meats");
		this.add(meats);
		fish.setText("Fish");
		this.add(fish);
		diary.setText("Diary");
		this.add(diary);
		vegetables.setText("Vegetables");
		this.add(vegetables);
		fruits.setText("Fruits");
		this.add(fruits);
		eggs.setText("Eggs");
		this.add(eggs);
		others.setText("Others");
		this.add(others);

	}

	public ButtonGroup getBg() {
		return bg;
	}

	public void setBg(ButtonGroup bg) {
		this.bg = bg;
	}

	public JRadioButton getDrinks() {
		return drinks;
	}

	public void setDrinks(JRadioButton drinks) {
		this.drinks = drinks;
	}

	public JRadioButton getMeats() {
		return meats;
	}

	public void setMeats(JRadioButton meats) {
		this.meats = meats;
	}

	public JRadioButton getFish() {
		return fish;
	}

	public void setFish(JRadioButton fish) {
		this.fish = fish;
	}

	public JRadioButton getDiary() {
		return diary;
	}

	public void setDiary(JRadioButton diary) {
		this.diary = diary;
	}

	public JRadioButton getVegetables() {
		return vegetables;
	}

	public void setVegetables(JRadioButton vegetables) {
		this.vegetables = vegetables;
	}

	public JRadioButton getFruits() {
		return fruits;
	}

	public void setFruits(JRadioButton fruits) {
		this.fruits = fruits;
	}

	public JRadioButton getEggs() {
		return eggs;
	}

	public void setEggs(JRadioButton eggs) {
		this.eggs = eggs;
	}

	public JRadioButton getOthers() {
		return others;
	}

	public void setOthers(JRadioButton others) {
		this.others = others;
	}

	public JRadioButton getSelected() {
		try {
			return (JRadioButton) this.bg.getSelection();
		} catch (Exception e) {
			return null;
		}
	}
}
