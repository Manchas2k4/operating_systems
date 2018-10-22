public class Application {
	public static final int READER_FACTOR = 20;
	public static final int READER_TIMEOUT = 250;
	public static final int READER_LOOP = 20;
	
	public static final int WRITER_FACTOR = 20;
	public static final int WRITER_TIMEOUT = 500;
	public static final int WRITER_LOOP = 20;
	
	public static void main(String args[]) {
		for (int i = 0; i < 20; i++) {
			(new Reader(READER_FACTOR, READER_TIMEOUT, READER_LOOP)).start();
		}
		for (int i = 0; i < 10; i++) {
			(new Writer(WRITER_FACTOR, WRITER_TIMEOUT, WRITER_LOOP)).start();
		}
	}
}