package module6;

import java.io.*;
import java.util.*;

public class DataAnalysis {

	//Code obtained from exercises 
	private static Theory bestTheory(Collection<DataPoint> data, Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.GoodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) throws IOException {
		//DataPoints
		Collection<DataPoint> data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		//New array for theories
		Collection<Theory> Theories = new ArrayList<Theory>();
		try {
			//Setting up each theory
			PowerLawTheory PLT1 = new PowerLawTheory(2);
			PowerLawTheory PLT2 = new PowerLawTheory(2.05);
			QuadraticTheory QT1 = new QuadraticTheory(1,10,0);
			Theories.add(PLT1);
			Theories.add(PLT2);
			Theories.add(QT1);
			System.out.println("The best theory is " + bestTheory(data, Theories, new ChiSquared()) );
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
