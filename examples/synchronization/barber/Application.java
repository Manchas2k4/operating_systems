public class Application {
	public static final int CUSTOMER_TIMEOUT = 2000;
	public static final int CUSTOMER_LOOP = 20;
	
	public static final int BARBER_TIMEOUT = 500;
	public static final int BARBER_LOOP = 20;
	
	public static void main(String args[]) {
		(new Barber(1, BARBER_TIMEOUT, BARBER_LOOP)).start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			(new Customer(i, CUSTOMER_TIMEOUT, CUSTOMER_LOOP)).start();
		}
	}
}
