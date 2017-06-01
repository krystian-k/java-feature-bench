package org.hcm.jfbench.alg;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EratosthenesSieveNaiveTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 0, 1, 0 }, { 20, 22, 0 },
				{ 2, 11, 5 }, { 0, 100, 25 },
				{ 5, 13, 4 }, { 100_000, 2 * Integer.MAX_VALUE, 0},
				{ 0, 100_000, 9592 }, { 0, 10_000_000, 664_579 },
				{ 100_000, 10_000_000, 654_987},
				{ 0, 100_000_000, 5_761_455 }
		});
	}

	private int rangeStart;
	private int rangeEnd;
	private int numOfPrimes;

	public EratosthenesSieveNaiveTest(int rangeStart, int rangeEnd, int numOfPrimes) {
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
		this.numOfPrimes = numOfPrimes;
	}

	@Test
	public void testPrimesV1() {
		assertEquals(numOfPrimes, EratosthenesSieveNaive.getPrimesV1(rangeStart, rangeEnd).size());
	}

	@Test
	public void testPrimesV2() {
		assertEquals(numOfPrimes, EratosthenesSieveNaive.getPrimesV2(rangeStart, rangeEnd).size());
	}

	@Test
	public void testPrimesV3() {
		assertEquals(numOfPrimes, EratosthenesSieveNaive.getPrimesV3(rangeStart, rangeEnd).size());
	}
}