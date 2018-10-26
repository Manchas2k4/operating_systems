public class Example {
	public static void main(String args[]) {	
		if (args.length < 1) {
			System.out.println("usage: " + args[0] + " args1 args2 ... argsn");
			System.exit(-1);
		}
		
		for (int i = 0; i < args.length; i++) {
			System.out.println("" + i + " - args[" + i + "] = " + args[i]);
		}
	}
}
