public class Counter {
	private int value;
	
	public Counter() {
		value = 0;
	}
	
	public void inc() {
		value++;
	}
	
	public void dec() {
		value--;
	}
	
	public int getValue() {
		return value;
	}
}
