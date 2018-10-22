import java.util.*;

public class Smoker extends Thread {
	private static Random r = new Random();
	private boolean live;
	private int element, factor, timeout;
	
	public Smoker(int e, int f, int t) {
		live = true;
		element = e;
		factor = f;
		timeout = t;
	}
	
	public void espera() {
		try {
			Thread.sleep(r.nextInt(factor) * timeout);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	public String getElement() {
		switch(element) {
		case 1: return "matches";
		case 2: return "tabacco";
		case 3: return "paper";
		default: return "";
		}
	}
	
	public void run() {
		System.out.println("Smoker with " + getElement() + " started");
		while(live) {
			Table.getInstance().getElements(element);
			System.out.println("Smoker with " + getElement() + " has taken the elements");
			espera();
			Table.getInstance().finishSmoking();
			System.out.println("Smoker with " + getElement() + " has smoked.");
			espera();
		}
	}
	
	public void finished() {
		live = false;
		System.out.println("Smoker with " + getElement() + " finished");
	}
}
