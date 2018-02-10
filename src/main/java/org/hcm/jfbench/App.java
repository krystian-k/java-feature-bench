package org.hcm.jfbench;

import org.hcm.jfbench.use.ConcurrentPlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	private App() {
		throw new IllegalAccessError("App main class, use main method");
	}

	public static void main(String[] args) {
		LOG.info("Started...");
		new ConcurrentPlay().justPlay();
		LOG.info("Finished...");
	}
}
