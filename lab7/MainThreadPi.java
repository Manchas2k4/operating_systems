// LAB 6
// By Victor Hugo Torres Rivera
// A01701017


public class MainThreadPi {
	private static int NUM_RECTS = 100_000_000;
	private static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();

	public static void main(String args[]) {
		long startTime, stopTime;
		double acum = 0;
		double pi_estimate;
		int total_number_in_circle = 0;
		int number_of_tosses = 3453453;

		ThreadPi threads[] = new ThreadPi[4];

		acum = 0;
		for (int i = 0; i < 4; i++) {
			threads[i] = new ThreadPi(number_of_tosses);
		}

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 4; i++) {
			threads[i].start();
		}

		for (int i = 0; i < 4; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stopTime = System.currentTimeMillis();
		acum +=  (stopTime - startTime);

		double aux = 0;
		for (int i = 0; i < 4; i++) {
			total_number_in_circle += threads[i].getNumberInCircle();
		}
		pi_estimate = total_number_in_circle/(double)number_of_tosses;
		System.out.printf("sum = %.15f\n", pi_estimate);
	}
}
