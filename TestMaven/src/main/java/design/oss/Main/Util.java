package design.oss.Main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {

	private static final Logger TEE_LOG = Util.getLogger("design.oss.log.tee");
	public static Object tee(Object message) {
		TEE_LOG.info(message);
		return message;
	}

	public static Logger getLogger(String loggerName) {
		return LogManager.getLogger(loggerName);
	}

	public static Logger getLogger() {
		return LogManager.getLogger();
	}

	public static void loggerTest() {
		Logger logger = getLogger();
		logger.trace("trace!");
		logger.debug("debug!");
		logger.info("info!");
		logger.warn("warn!");
		logger.error("error!");
		logger.fatal("fatal!");
	}

	public static void logInfo(Object message) {
		getLogger().info(message);
	}
}
