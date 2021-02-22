package Logging;

import org.apache.log4j.Logger;

public class ExamenLogger {
    private static Logger logger;

    private ExamenLogger() { }
    private static void setLogger(Logger logger) {
        ExamenLogger.logger = logger;
    }
    private static void initialize() {
        setLogger(Logger.getLogger("Examen"));
    }

    public static Logger log() {
        if (logger == null) { initialize(); }
        return logger;
    }
}
