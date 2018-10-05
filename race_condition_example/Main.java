public class Main {
	private static final int THREADS = 5;
	
	public static void main(String args[]) {
		Counter counter = new Counter();
		Increment incs[] = new Increment[THREADS];
		Decrement decs[] = new Decrement[THREADS];
		
		for (int i = 0; i < THREADS; i++) {
			incs[i] = new Increment(counter);
			decs[i] = new Decrement(counter);
		}
		
		for (int i = 0; i < THREADS; i++) {
			incs[i].start();
			decs[i].start();
		}
		
		try {
			decs[0].join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
