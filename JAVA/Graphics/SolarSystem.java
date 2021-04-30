package module9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SolarSystem extends JPanel implements ActionListener {


	private final int delay = 50; // delay in ms between steps
	private static double angle = 0.0; // current angle from x axis
	private Timer animationTimer; // timer controlling frame rate
	private static int Time=0 ; //Time in days

	public static void Orbit(Graphics g, SystemObjects planet) {
		double e= planet.getE();
		//Gets the distance from the focus in polar coordinates
		double r= (planet.getSemimajor()*(1-e*e))/(1+(e*Math.cos(angle)));

		//Calculates x and y coordinates from the polar coordinate value r
		double x = r*Math.cos((Time*2*Math.PI/planet.getPeriod())) ;
		double y =  r*Math.sin((Time*2*Math.PI/planet.getPeriod())) ;

		//Draws a disc to represent the planet at its current position
		g.fillOval((int) (x-planet.getRadius()), (int) (y-planet.getRadius()), (int) (2*planet.getRadius()), (int) (2*planet.getRadius()));
		
		//Updates the coordinates of the planets
		planet.setX(x);
		planet.setY(y);
		
		//Updates the angle from x axis
		angle = Math.atan2(y, x);
	}
	
	//Creates panel
	SolarSystem(int width, int height) {
		setPreferredSize(new Dimension(width,height));

		animationTimer = new Timer(delay,this);
		animationTimer.start();

	}

	//Paints the planets along their orbits
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Initialises height and width
		int height = getHeight();
		int width = getWidth();
		
		//Initialises the planets
		SystemObjects Mercury= new SystemObjects(0.5, 0.5, 1 ,1, 0.206,0.248);
		SystemObjects Venus= new SystemObjects(1, 1, 5 ,5, 0.007,0.6152);
		SystemObjects Earth= new SystemObjects(2, 1.5, 10 ,10, 0.0167,1);
		SystemObjects Mars= new SystemObjects(2.5, 0.8, 50 ,50, 0.093,1.8809);
		SystemObjects Jupiter= new SystemObjects(3.5, 5, 100 ,100, 0.048,11.862);
		SystemObjects Saturn= new SystemObjects(4, 4, 150 ,150, 0.056,29.458);
		SystemObjects Uranus= new SystemObjects(4.5, 3, 250 ,250, 0.046,84.01);
		SystemObjects Neptune= new SystemObjects(5, 2, 300 ,300, 0.01, 164.79);

		//Fills the canvas
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);

		//Creates the sun disc
		g.setColor(Color.YELLOW);
		g.fillOval(0, 0, 40, 40);
		
		// Draws the planets as they go along their orbits
		g.setColor(Color.BLUE);
		Orbit(g,Earth);
		Orbit(g,Uranus);

		g.setColor(Color.ORANGE);
		Orbit(g,Jupiter);
		Orbit(g,Saturn);

		g.setColor(Color.RED);
		Orbit(g,Mars);
		Orbit(g,Venus);
		Orbit(g,Mercury);

		//Counts the days passed in the simulation
		g.drawString(Integer.toString(Time) + "days", -750, -300);
	}

	//Animation timer
	public void actionPerformed(ActionEvent event) {
		Time += GuiPanel.delta ;
		repaint();
	}

	//Animation start and stop
	public void start() {animationTimer.start();}
	public void stop() {animationTimer.stop();}

}


