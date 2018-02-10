package org.hcm.jfbench.use;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hcm.jfbench.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrentPlay {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public void justPlay() {
		Map<String, String> translate = new ConcurrentHashMap<>();
		translate.merge("aaaa", "bbbb", String::concat);
		translate.merge("aaaa", "cccc", String::concat);
		LOG.info(translate.entrySet().toString());

		Map<String, Integer> str2int = new HashMap<>();
		str2int.put("aaaa", 2);
		System.out.println(str2int.get("aaaa") + 1);
	}
}
