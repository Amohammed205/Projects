package module6;

import java.util.*;

public class ChiSquared implements GoodnessOfFitCalculator,Theory{

	//Finds y value
	public double y(double x) {
		return y(x);
	}

	//Finds Chi Squared
	public double GoodnessOfFit(Collection<DataPoint> data, Theory object) {
		double chisq = 0;

		//Gets each x,y and ey in the whole data array
		for (DataPoint ArrValues : data) {
			double xvalues = ArrValues.getx();
			double yvalues = ArrValues.gety();
			double eyvalues = ArrValues.getey();

			//Finding the expected values of y
			double expectedY = object.y(xvalues);
			//Summing all Chi squared values
			chisq += (Math.pow((yvalues - expectedY), 2)/Math.pow(eyvalues, 2));
		}
		return chisq ;
	}
}
