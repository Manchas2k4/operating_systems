import java.util.*;

public class Writer extends Thread {
	private static Random r = new Random();
	private int factor, timeout, loop;
	
	public Writer(int f, int t, int l) {
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
		System.out.println("Writer " + getId() + " started");
		for (int i = 0; i < loop; i++) {
			System.out.println("Writer " + getId() + " is going to write");
			Database.getInstance().startWriting();
			System.out.println("Writer " + getId() + " is writing");
			espera();
			Database.getInstance().finishWriting();
			System.out.println("Writer " + getId() + " has finished writing");
			espera();
		}
		System.out.println("Writer " + getId() + " finished");
	}
}
