package module6;

import java.util.*;

public class DataPoint {

	// parameter set by experiment
	protected double x;     
	// Measurement of dependent variable
	protected double y;     
	// Uncertainty on y
	protected double ey;

	//Constructor
	public DataPoint(double x,double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;  		
	}

	//gets the current value of x
	public double getx() {
		return this.x;
	}

	//gets the current value of y
	public double gety() {
		return this.y;
	}

	//gets the current value of ey
	public double getey() {
		return this.ey;
	}
	public String toString (){
		return ("x = " + this.x + ", y = " + this.y + " +- " + this.ey);
	}

	//Method that assigns the values in a line to DataPoint
	public static DataPoint LineValues(String line) {
		Scanner s = new Scanner(line);
		double x = s.nextDouble();
		double y = s.nextDouble();
		double ey = s.nextDouble();
		s.close();
		return new DataPoint(x, y, ey);
	}

}

