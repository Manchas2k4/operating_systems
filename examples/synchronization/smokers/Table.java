import java.util.*;

public class Table {
	private static Table instance;
	private boolean empty;
	private int missingElement;
	
	private Table() {
		empty = true;
		missingElement = -1;
	}
	
	private synchronized static void createInstance() {
		 if (instance == null) { 
			 instance = new Table();
		 }
	 }

	public static Table getInstance() {
		 if (instance == null) {
			 createInstance();
		 }
		 return instance;
	 }
	
	public synchronized void putElements(int i) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		missingElement = i;
		empty = false;
		notifyAll();
	}
	
	public synchronized void getElements(int i) {
		while (empty || missingElement != i) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		} 
	}
	
	public synchronized void finishSmoking() {
		empty = true;
		notifyAll();
	}
}
