package Logging;

import org.apache.log4j.Logger;

public final class VaccinatieLogger {
    private static Logger logger;

    private VaccinatieLogger() { }
    private static void setLogger(Logger logger) {
        VaccinatieLogger.logger = logger;
    }
    private static void initialize() {
        setLogger(Logger.getLogger("Vaccinatie"));
    }

    public static Logger log() {
        if (logger == null) { initialize(); }
        return logger;
    }
}
