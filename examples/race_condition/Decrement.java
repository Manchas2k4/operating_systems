import java.util.Random;

public class Decrement extends Thread {
	private static final int N = 3;
	private static final Random r = new Random();
	private Counter counter;
	
	public Decrement(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		int prev = 0;
		
		for (int i = 0; i < N; i++) {
			prev = counter.getValue();
			counter.dec();
			System.out.println("Dec ID = " + this.getId() + " prev = " + prev + " current = " + counter.getValue());
			
			try {
				Thread.sleep(r.nextInt(1000) + 1);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
