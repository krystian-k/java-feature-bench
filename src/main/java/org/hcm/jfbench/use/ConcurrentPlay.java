package org.hcm.jfbench.use;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrentPlay {
	private static final Logger LOG = LoggerFactory.getLogger(ConcurrentPlay.class);

	public void justPlay() {
		Map<String, String> translate = new ConcurrentHashMap<>();
		translate.merge("aaaa", "bbbb", String::concat);
		translate.merge("aaaa", "cccc", String::concat);
		LOG.info(translate.entrySet().toString());

		Map<String, Integer> str2int = new HashMap<>();
		Integer a = 2;
		for (; a < 1_000_00; a++);
		LOG.info(a.toString());
		str2int.put("aaaa", a);
		LOG.info(Integer.toString(str2int.get("aaaa") + 1));
	}
}
