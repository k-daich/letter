package jp.daich.util.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jUtil {

    private static final Logger logger = LogManager.getLogger();

    private Log4jUtil() {
    }

    public static void error(final Class<Object> clz, final String message) {
        logger.error("[" + clz.getCanonicalName() + "] " + message);
    }

}