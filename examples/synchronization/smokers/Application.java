
public class Application {
	public static final int SIZE = 5;
	public static final int SMOKER_TIMEOUT = 20;
	public static final int SMOKER_FACTOR = 250;
	
	public static void main(String args[]) {
		Smoker smokers[] = new Smoker[3];
		for (int i = 0; i < 3; i++) {
			smokers[i] = new Smoker(i + 1, SMOKER_FACTOR, SMOKER_TIMEOUT);
			smokers[i].start();
		}
		Agent a = new Agent();
		a.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		a.finished();
		for (int i = 0; i < 3; i++) {
			smokers[i].finished();
		}
	}
}
