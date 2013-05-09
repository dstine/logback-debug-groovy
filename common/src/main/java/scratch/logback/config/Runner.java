package scrach.logback.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

	public static void main(String[] args) {
		LoggerFactory.getLogger(Runner.class).info("hello");
	}
}
