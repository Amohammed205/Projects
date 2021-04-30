package module9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiPanel extends JPanel implements ActionListener {
	
	//initiating variables
	private SolarSystem aniPanel;
	private JButton startButton;
	private JButton stopButton;
	private JButton speedButton;
	private JButton slowButton;
	//Time interval
	public static int delta = 1 ;
	
	//Create JPanel containing panel and buttons
	public GuiPanel() {
		super();
		setPreferredSize(new Dimension(500,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		aniPanel = new SolarSystem(4000,4000);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		speedButton = new JButton("Speed up");
		slowButton = new JButton("Slow down");
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		speedButton.addActionListener(this);
		slowButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(speedButton);
		buttonPanel.add(slowButton);

		add(aniPanel);
		add(buttonPanel);
	}
	//Where to go when button is clicked
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()== speedButton) sUp();
		else if (e.getSource()== slowButton) sDown();

	}
	//Actions for when buttons are clicked
	public void start() {aniPanel.start();}
	public void stop() {aniPanel.stop();}
	public void sUp() { delta += delta +10;}
	public void sDown() { delta -= delta -10;}

}

