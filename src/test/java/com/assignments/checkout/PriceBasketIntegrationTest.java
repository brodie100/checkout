/**
 * 
 */
package com.assignments.checkout;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author BMC
 * Bit ashamed of this test as it was introduced to reduce time spent on 
 * verifying output.
 * Ideally each test should verify only one piece of output for each input.  
 * This is something I would definitely fix.
 *
 */
public class PriceBasketIntegrationTest extends AbstractTest{

	final InputStream originalInput = System.in;
	final PrintStream originalOutput = System.out;
	
	private File outputFileNoOffers = new File("src/test/resources/PriceBasketNoDiscountsTestOutput");
	private File outputFileWithOffers = new File("src/test/resources/PriceBasketValidDiscountsTestOutput");
	private PrintStream outputFile;
	
	/**
	 * Set System.in to File input
	 * @throws FileNotFoundException - if file is not in place specified in test.
	 */
	@Before
	public void setUp() throws FileNotFoundException {
	    final FileInputStream file = new FileInputStream(new File("src/test/resources/PriceBasketTestInput"));
	    this.outputFile = new PrintStream(new FileOutputStream(new File("src/test/resources/PriceBasketTestOutput"), false));
	    System.setIn(file);
	    System.setOut(this.outputFile);
	}

	/**
	 * Set System.in back to normal
	 */
	@After
	public void tearDown() {
		System.setIn(this.originalInput);
		System.setOut(this.originalOutput);
	}

	/**
	 * Test method for {@link com.assignments.checkout.PriceBasket#main(java.lang.String[])}.
	 * Tests that no discounts are applied
	 * @throws IOException - read files causes IO exceptions
	 */
	@Test
	public final void testMainWithNoDiscounts() throws IOException {
		PriceBasket.main(new String [] {"noOffers"});
		this.outputFile.close();
		assertTrue(
				FileUtils.contentEquals(
						this.outputFileNoOffers, new File("src/test/resources/PriceBasketTestOutput")));
		
	}
	
	/**
	 * Test method for {@link com.assignments.checkout.PriceBasket#main(java.lang.String[])}.
	 * Tests that Discounts work.
	 * @throws IOException - read files causes IO exceptions
	 */
	@Test
	public final void testMainWithDiscounts() throws IOException {
		PriceBasket.main(new String [] {});
		this.outputFile.close();
		assertTrue(
				FileUtils.contentEquals(
						this.outputFileWithOffers, new File("src/test/resources/PriceBasketTestOutput")));
		
	}

}
