import java.util.Random;

public class Barber extends Thread {
	private static Random r = new Random();
	private int number, timeout, loop;
	
	public Barber(int number, int timeout, int loop) {
		this.number = number;
		this.timeout = timeout;
		this.loop = loop;
	}
	
	public void delay(int a, int b) {
		int low = (int) Math.min(a, b);
		int high = (int) Math.max(a, b);
		try {
			Thread.sleep(r.nextInt(high - low) + low);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public void run() {
		System.out.println("Barber " + number + " = No customers, I am going to sleep");
		for (int i = 0; i < loop; i++) {
			try {
				Barbershop.customers.acquire();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			Barbershop.barber.release();
			
			System.out.println("Barber " + number + " = Attending a client");
			delay(timeout/2, timeout);
			System.out.println("Barber " + number + " = Done");
			
			try {
				Barbershop.customersDone.acquire();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			Barbershop.barberDone.release();
			
			System.out.println("Barber " + number + " = While another client arrives, I will fall asleep");
		}
	}
}