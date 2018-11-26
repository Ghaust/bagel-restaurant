package logger;

public class CompositeLogger implements Logger {
    private FileLogger fileLogger;
    private ContextualLogger contextualLogger;

    public CompositeLogger(FileLogger fileLogger, ContextualLogger contextualLogger) {
        this.fileLogger = fileLogger;
        this.contextualLogger = contextualLogger;
    }


    public void log(String message){
        fileLogger.log(message);
        contextualLogger.log(message);


    }
    public void debug(String category, String message)
    {
        fileLogger.debug(category, message);
        contextualLogger.debug(category, message);
    }
    public void info(String category, String message)
    {
        fileLogger.info(category, message);
        contextualLogger.info(category, message);
    }
    public void error(String category, String message)
    {
        fileLogger.error(category, message);
        contextualLogger.error(category, message);
    }

}
