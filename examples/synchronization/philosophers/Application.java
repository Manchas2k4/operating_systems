
public class Application {
	public static final int SIZE = 5;
	public static final int PHILOSOPHER_TIMEOUT = 20;
	public static final int PHILOSOPHER_FACTOR = 250;
	public static final int PHILOSOPHER_LOOP = 10;
	
	public static void main(String args[]) {
		for (int i = 0; i < SIZE; i++) {
			(new Philosopher(i, PHILOSOPHER_FACTOR, 
					PHILOSOPHER_TIMEOUT, PHILOSOPHER_LOOP)).start();
		}
	}
}
