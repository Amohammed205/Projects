package module6;

import java.io.*;
import java.net.*;
import java.util.*;

public class TestDataPoints {

	//Method to read URLS and return the numbers in the URL as an Array
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		String line= "";
		ArrayList<DataPoint> ArrValues= new ArrayList<DataPoint>() ; //Creating a new array
		URL u = new URL(url);
		InputStream is = u.openStream(); //Opens URL and sets it to an InputStream from String
		InputStreamReader isr = new InputStreamReader(is); //Reads the InputStream
		BufferedReader b = new BufferedReader(isr); //Creates the bufferedReader object

		while((line = b.readLine()) != null) {
			try {
				Scanner s = new Scanner (line); 

				double x = s.nextDouble();
				double y = s.nextDouble();
				double ey = s.nextDouble();

				if(s.hasNext() == true) {
					String LDP = s.next();
					DataPoint DP = new LabelledDataPoint(LDP,x,y,ey);
					ArrValues.add(DP);
				}
				else {
					DataPoint DP = new DataPoint(x,y,ey);
					ArrValues.add(DP);
				}

				s.close();
			}

			catch (Exception e) {
				System.out.println("The URL you have entered could not be found") ;
			}
		}
		return ArrValues;
	}

	public static void main(String[] args) throws IOException {
		
		try {
			//The URL lines are added to an ArrayList
			Collection <DataPoint> datapoints = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			DataPoint currentline = new DataPoint(0,0,0) ;

			//Creates an iterator to go through every object in the list
			Iterator<DataPoint> i = datapoints.iterator();

			//Loops the iterator for every line
			while (i.hasNext()) {
				currentline = i.next();
				System.out.println(currentline);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
