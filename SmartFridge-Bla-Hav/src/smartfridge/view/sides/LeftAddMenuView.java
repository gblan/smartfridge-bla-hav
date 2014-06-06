package smartfridge.view.sides;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class LeftAddMenuView extends LeftSide {

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
		
		bg.add(drinks);
		bg.add(meats);
		bg.add(fish);
		bg.add(diary);
		bg.add(vegetables);
		bg.add(fruits);
		bg.add(eggs);
		bg.add(others);
		
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
