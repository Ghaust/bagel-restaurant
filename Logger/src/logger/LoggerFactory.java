package logger.src.logger;

public class LoggerFactory {

    public static CompositeLogger getLogger(String className) {
        return new CompositeLogger(new FileLogger(className), new ContextualLogger(className, new ConsoleLogger(className) {
        }));
    }
}
