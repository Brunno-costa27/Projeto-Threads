package trabalho1;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Thread Thread1 = new Thread1();
		Thread2 Thread2 = new Thread2();
		Thread3 Thread3 = new Thread3();
		Thread1.start();
		Thread2.start();
		Thread3.start();
	}

}
