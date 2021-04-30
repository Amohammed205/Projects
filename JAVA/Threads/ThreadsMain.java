package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		
		//Set the threads
		Thread CD = new Thread(new CountdownTask(10));
		Thread PN = new Thread(new PrimeNumberTask());
		CD.start();
		PN.start();
		
		try {
			//Waiting for the CD thread to finish
			CD.join();
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Stops the PN thread
		PN.interrupt();	
		
	}

}
