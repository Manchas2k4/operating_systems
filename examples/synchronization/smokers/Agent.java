import java.util.*;

public class Agent extends Thread {
	private static Random r = new Random();
	private boolean live;
	
	public Agent() {
		live = true;
	}
	
	public void run() {
		System.out.println("Agent started");
		while (live) {
			int missing = r.nextInt(3) + 1;
			Table.getInstance().putElements(missing);
			switch(missing) {
			case 1: System.out.println("Agent produces tobacco and paper."); break;
			case 2: System.out.println("Agent produces paper and matches."); break;
			case 3: System.out.println("Agent produces matches and tobacco."); break;
			}
		}
	}
	
	public void finished() {
		live = false;
		System.out.println("Agent finished");
	}
}