import java.util.*;

public class Reader extends Thread {
	private static Random r = new Random();
	private int factor, timeout, loop;
	
	public Reader(int f, int t, int l) {
		factor = f;
		timeout = t;
		loop = l;
	}
	
	public void espera() {
		try {
			Thread.sleep((r.nextInt(factor) + 1) * timeout);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("Reader " + getId() + " started");
		for (int i = 0; i < loop; i++) {
			System.out.println("Reader " + getId() + " is going to read");
			Database.getInstance().startReading();
			System.out.println("Reader " + getId() + " is reading");
			espera();
			Database.getInstance().finishReading();
			System.out.println("Reader " + getId() + " has finished reading");
			espera();
		}
		System.out.println("Reader " + getId() + " finished");
	}
}
