package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import shoppingList.Driver;

class TestShoppingList {

	@Test
	void testMenu() {
		String[] args = null;
		
		try {
			InputStream stream = new FileInputStream("testSuite.txt");
			System.setIn(stream);
			
	 		Driver.main(args);
		}
		catch (IOException e) {
			fail("IOException encountered");
		}
	}

}
