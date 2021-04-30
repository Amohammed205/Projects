package module8;

import java.util.*;
import java.util.concurrent.*;

public class ThreadsTimer {

	public static void main(String[] args) throws ExecutionException, InterruptedException{
		//A single thread
		long startTime = System.currentTimeMillis();
		long nPoints = 10000000L;
		MonteCarloPiCalculatorTask task = new
				MonteCarloPiCalculatorTask(nPoints);
		double pi = task.call();
		long endTime = System.currentTimeMillis();
		System.out.println("With one thread the esitmate for pi is: "+pi);
		System.out.println("It took "+(-startTime+endTime) +" ms to execute");

		//4 threads
		long startTime4 = System.currentTimeMillis();
		long nPoints4 = 10000000L;
		int nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task4 = new
					MonteCarloPiCalculatorTask(nPoints4/nThreads);
			Future<Double> future = threadPool.submit(task4);
			futures.add(future);
		}
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();
		double pi4 = sum/nThreads;
		long endTime4 = System.currentTimeMillis();
		System.out.println("With four thread the esitmate for pi is: "+pi4);
		System.out.println("It took "+(-startTime4+endTime4) +" ms to execute");
		System.out.println("");
		System.out.println("As seen from the results above when there is 4 threads the time"
				+ "\nto execute was shorter, this is because 4 threads are working on the"
				+ "\ncalculation simultaneously as opposed to one. Logically the time for"
				+ "\nthe 4 threads should be four times shorter but the calculation of the"
				+ "\naverage increases it.");
	}
}
