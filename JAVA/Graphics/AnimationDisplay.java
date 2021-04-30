package module9;

import javax.swing.*;

public class AnimationDisplay {
	
	//Creation and set up of a new window
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("SolarSystem Animation");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(4000,4000);
				JPanel panel = new GuiPanel();
				frame.add(panel);
				frame.setVisible(true);
			}
		});
	}
}
