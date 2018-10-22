import java.util.concurrent.Semaphore;

public class Barbershop {
	public static Semaphore customers = new Semaphore(0);
	public static Semaphore barber = new Semaphore(0);
	public static Semaphore customersDone = new Semaphore(0);
	public static Semaphore barberDone = new Semaphore(0);
	public static Semaphore mutex = new Semaphore(1);
	
	public static final int MAXCHAIRS = 3;
	public static int chairs = 0;
}