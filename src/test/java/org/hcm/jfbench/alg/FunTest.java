package org.hcm.jfbench.alg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FunTest {

	@Test
	public void computeIfAbsentTest() {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		Map<String, String> map = new HashMap<>();
		strings.forEach(
				s-> map.computeIfAbsent("" + s.charAt(0), s::concat).concat(", ").concat(s)
		);
		System.out.println("f: " + map.get("f"));
	}
}
