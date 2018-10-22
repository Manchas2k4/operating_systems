
public class Table {
	private static Table instance;
	private boolean eating[];
	
	private Table() {
		eating = new boolean[Application.SIZE];
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
	
	private int left(int i) {
		return ( (i - 1 + eating.length) %  eating.length );
	}
	
	private int right(int i) {
		return ( (i + 1) % eating.length );
	}
	
	public synchronized void getForks(int i) {
		while (eating[left(i)] && eating[right(i)]) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		eating[i] = true;
	}
	
	public synchronized void putForks(int i) {
		eating[i] = false;
		notifyAll();
	}
}
