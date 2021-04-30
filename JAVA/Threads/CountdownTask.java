package module8;

public class CountdownTask implements Runnable{
	//Setting Count down number
	private int countdownnum;
	//Constructor
	public CountdownTask(int CDN) {
		this.countdownnum = CDN;
	}

	public void run() {
		//Count down prints the time left and when it reaches zero in the run method
		for(int i=countdownnum; i>=0; i-=1) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {

		//Tested thread for 20 seconds
		Thread TCD = new Thread(new CountdownTask(20));
		TCD.start();
	}
}
