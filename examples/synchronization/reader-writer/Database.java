
public class Database {
	private static Database instance;
	private int readers, writers, writersWaiting;
	
	private Database() {
		readers = writers = writersWaiting = 0;
	}
	
	private synchronized static void createInstance() {
		 if (instance == null) { 
			 instance = new Database();
		 }
	 }
	
	public static Database getInstance() {
		 if (instance == null) {
			 createInstance();
		 }
		 return instance;
	 }
	
	public synchronized void startReading() {
		while (writers > 0 || writersWaiting > 0) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		readers++;
	}
	
	public synchronized void finishReading() {
		readers--;
		notifyAll();
	}
	
	public synchronized void startWriting() { 
		writersWaiting++;
		while (readers > 0) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		writersWaiting--;
		writers++;
	}
	
	public synchronized void finishWriting() {
		writers--;
		notifyAll();
	}
}
