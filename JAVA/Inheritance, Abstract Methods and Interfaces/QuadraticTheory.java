package module6;

//Implements theory to QuadraticTheory 
public class QuadraticTheory implements Theory {

	// Defining the Constants
	private double a; 
	private double b; 
	private double c; 

	//Constructor
	public QuadraticTheory(double a,double b,double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	} 
	//toString function to give n
	public String toString (){
		return (this.a +"x^2" + "+" +this.b +"x" +"+" +this.c);
	}
	//Method for the y = (ax^2) + bx + c function
	public double y(double x) {
		double y = (a*Math.pow(x, 2)) + (b*x) + c;
		return y;
	}
}
