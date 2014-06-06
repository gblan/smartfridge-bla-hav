package smartfridge.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import smartfridge.view.sides.LeftButtonMenuView;
import smartfridge.view.sides.RightProductMenuView;

public class MainMenu extends JFrame{

	public MainMenu(){
		super("Smart Fridge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Ajout des 2 parties de la fenêtre */
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
		
		LeftButtonMenuView left = new LeftButtonMenuView();
		mainPanel.add(left );
		
	    JSeparator separator = new JSeparator();
	    mainPanel.add(separator);
	    
	    RightProductMenuView right = new RightProductMenuView();

		mainPanel.add(right);
		
		pack();

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
