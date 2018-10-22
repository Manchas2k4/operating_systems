import java.util.Random;

public class Customer extends Thread {
	private static Random r = new Random();
	private int number, timeout, loop;
	
	public Customer(int number, int timeout, int loop) {
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
		for (int i = 0; i < loop; i++) {
			System.out.println("Customer " + number + " = I am entering the barbershop");
			try {
				Barbershop.mutex.acquire();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			if (Barbershop.chairs == Barbershop.MAXCHAIRS) {
				System.out.println("Customer " + number + " = There is no place, I return later");
				Barbershop.mutex.release();
				System.out.println("Customer " + number + " = I am leaving the barbershop");
				delay(timeout/2, timeout);
				continue;
			}
			
			Barbershop.chairs++;
			Barbershop.mutex.release();
		
			Barbershop.customers.release();
			try {
				Barbershop.barber.acquire();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			System.out.println("Customer " + number + " = The barber is cuttig my hair");
			
			Barbershop.customersDone.release();
			try {
				Barbershop.barberDone.acquire();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			try {
				Barbershop.mutex.acquire();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			Barbershop.chairs--;
			Barbershop.mutex.release();
			
			System.out.println("Customer " + number + " = I am leaving the barbershop");
			delay(timeout/2, timeout);
		}
	}
}