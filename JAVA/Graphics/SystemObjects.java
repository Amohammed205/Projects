package module9;

public class SystemObjects {

	//Setting variables for the planets  
	private double semimajor;  
	private double x;    //x coordinate of the planet from the origin
	private double y;   //y coordinate of the planet from the origin
	private double diameter; 
	private double e  ;	//Eccentricities of the planets 
	private double period;  

	//Constructor
	public SystemObjects (double semimajor, double diameter, double x, double y, double e, double period){
		this.semimajor=semimajor;
		this.diameter=diameter;
		this.x=x;
		this.y=y;
		this.e=e;
		this.period=period;
	}

	public double getDistance() {
		return Math.sqrt(x*x+y*y);
	}

	public double getRadius() {
		//We  enlarge the diameters to make the planets visible in the animation
		return diameter*10/2;
	}

	public double getSemimajor() {
		return semimajor*150;
	}

	public double getE() {
		return e;
	}

	public double getPeriod() {
		return period*365;
	}

	public void setX(double x) {
		this.x=x;
	}

	public void setY(double y) {
		this.y=y;
	}

}
