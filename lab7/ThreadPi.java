// LAB 6
// By Victor Hugo Torres Rivera
// A01701017

import java.util.Random;
public class ThreadPi extends Thread {
	private int number_of_tosses;
	private int number_in_circle;
	private Random random;

	public ThreadPi(int number_of_tosses) {
		this.random	 = new Random(System.currentTimeMillis());
		this.number_of_tosses = number_of_tosses;
		this.number_in_circle = 0;
	}

	public double getNumberInCircle() {
		return number_in_circle;
	}

	public void run() {
		int toss = 0;
		double x, y, distance_squared;
		for ( toss = 0; toss < number_of_tosses ; toss ++) {
			x = random.nextDouble()*2-1;
			y = random.nextDouble()*2-1;
			distance_squared = x * x + y * y ;
			if ( distance_squared <= 1){
				number_in_circle++;
			}
		}
	}
}
