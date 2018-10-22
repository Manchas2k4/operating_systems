import java.util.*;

public class Philosopher extends Thread {
	private static Random r = new Random();
	private int number, timeout, factor, loop;
	
	public Philosopher(int n, int f, int t, int l) {
		number = n;
		factor = f;
		timeout = t;
		loop = l;
	}
	
	public void espera() {
		try {
			Thread.sleep(r.nextInt(factor) * timeout);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("Philosopher " + number + " started");
		for (int i = 0; i < loop; i++) {
			System.out.println("Philosopher " + number + " is going to take the forks");
			Table.getInstance().getForks(number);
			espera();
			Table.getInstance().putForks(number);
			System.out.println("Philosopher " + number + " returned the forks");
			espera();
		}
		System.out.println("Philosopher " + number + " finished");
	}
}
