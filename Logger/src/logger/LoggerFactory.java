package logger;

public class LoggerFactory {

    public static CompositeLogger getLogger(FileLogger fileLogger, ContextualLogger contextualLogger) {
        return new CompositeLogger(fileLogger, contextualLogger);
    }
}
