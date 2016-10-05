
public class HelloWorldd {
	static {
		System.load("D:\\UDMS\\Project\\HelloWorld\\HelloWorld.dll");
		//System.loadLibrary("HelloWorld");
	}
	
	public native static void hello();
}

