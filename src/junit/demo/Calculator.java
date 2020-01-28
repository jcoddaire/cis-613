package junit.demo;


public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mul(int a, int b) {
		return a * b;
	}
	
	public int div(int a, int b) {
		return a / b;
	}
	
	public static void sayHello() {
		System.out.println("hello from Calculator class");
	}
	
	public void sayBye() {
		System.out.println("bye from a Calculator instance");
	}
}
