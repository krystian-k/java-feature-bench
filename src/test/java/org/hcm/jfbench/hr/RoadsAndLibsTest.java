package org.hcm.jfbench.hr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class RoadsAndLibsTest {

	private boolean runTest(String inFile, String response) throws IOException {
		File file = new File(ClassLoader.getSystemClassLoader().getResource(inFile).getFile());
		System.setIn(new FileInputStream(file));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		RoadsAndLibs.main(new String[0]);
		final String result = out.toString().trim().replace("\r\n", ";");
		System.err.println(result);
		assertEquals(response, result);
		return response.equalsIgnoreCase(result);
	}

	@Test
	public void testAllCases() throws IOException {
		final String response = "5649516;5295483;9261576;3960530;7629795;40216260;6701050;40280315;4614540;12407190;7850257285;6785201034;813348013;4211840970;8610471142;7263742960;4331105640;1226092626;7288635830;8276704464;5;4;12;9234981465;5854508506;7754252297;8085193494;9504556779;8011172848;9123393445;7326423794;8259748808;8049633228";
		assertTrue(runTest("./roadsAndLibs/roads_and_libs_in_all.txt", response));
	}

	@Test
	public void testLongCases() throws IOException {
		final String response = "9234981465;5854508506;7754252297;8085193494;9504556779;8011172848;9123393445;7326423794;8259748808;8049633228";
		assertTrue(runTest("./roadsAndLibs/roads_and_libs_in_long.txt", response));
	}

	@Test
	public void testEasyCase() throws IOException {
		final String response = "5";
		assertTrue(runTest("./roadsAndLibs/roads_and_libs_in_easy.txt", response));
	}
}