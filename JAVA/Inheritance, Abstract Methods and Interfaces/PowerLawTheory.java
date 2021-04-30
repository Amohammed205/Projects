package module6;

//Implements theory to PowerLawTheory 
public class PowerLawTheory implements Theory{

	// The power of the function
	private double n;     

	//Constructor
	public PowerLawTheory(double n) {
		this.n = n;
	} 
	//toString function to give n
	public String toString (){
		return ("x^" + this.n);
	}
	//Method for the y=x^n function
	public double y(double x) {
		double y = Math.pow(x, n);
		return y;
	}

}
