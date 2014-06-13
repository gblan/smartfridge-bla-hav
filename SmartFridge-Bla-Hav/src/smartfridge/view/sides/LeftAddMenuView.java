package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import smartfridge.controller.LeftAddMenuController;


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
	
	
	public LeftAddMenuView(){
		super();
		
		bg = new ButtonGroup();
		drinks = new JRadioButton();
		meats = new JRadioButton();
		fish = new JRadioButton();
		diary = new JRadioButton();
		vegetables = new JRadioButton();
		fruits = new JRadioButton();
		eggs = new JRadioButton();
		others = new JRadioButton();
		
		
		Icon defaultIcon = new ImageIcon("resources/drinks2.jpg");
		drinks.setIcon(defaultIcon );
		bg.add(drinks);
		bg.add(meats);
		bg.add(fish);
		bg.add(diary);
		bg.add(vegetables);
		bg.add(fruits);
		bg.add(eggs);
		bg.add(others);
		
		LeftAddMenuController controler = new LeftAddMenuController();

		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(drinks);
		this.add(meats);
		this.add(fish);
		this.add(diary);
		this.add(vegetables);
		this.add(fruits);
		this.add(eggs);
		this.add(others);
		
	}
}
