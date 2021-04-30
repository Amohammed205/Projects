package module8;

import java.util.*;  

public class PrimeNumberTask implements Runnable {

	public void run() {
		//Creates a new empty list
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		//Initialise variables
		long maxprime = 0;
		int numofprimes = 0;
		int maxval = Integer.MAX_VALUE;

		for(int i=1; i<=maxval; i++) {

			//reset the number of factors
			int numoffactors = 0;
			
			for(int num =i/2; num>1; num--)
			{
				//Is the number being tested divisible my anything other than 1 and itself
				if(i%num==0)
				{
					numoffactors = numoffactors + 1;
				}

			//If the number of factors is zero then the number being tested is a prime
			if(numoffactors == 0) {

				//Adds the prime number to a list
				primelist.add(i);

				maxprime = i;
				numofprimes++;
			}
			// run until interrupted

			if (Thread.currentThread().isInterrupted()) {
				//Outputs the results and ends the thread
				System.out.println("The largest integer checked was " + i);
				System.out.println("The largest prime number found was " +maxprime);
				System.out.println("There were " + numofprimes + " prime numbers found");
				return;
			}
		}	     	      
	}
}
}