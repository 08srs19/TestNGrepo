package testscript;

import org.testng.annotations.Test;

public class Sample extends Base {
	@Test(priority=1)
	void show() {
		System.out.println("show");
	}
	@Test(priority=2)
	void display() {
		System.out.println("display");
	}

}
