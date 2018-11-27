package logger.src.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextualLogger {
    private final String className;
    private final Logger delegate;

    public ContextualLogger(String className, Logger delegate) {
        this.className=className;
        this.delegate=delegate;
    }


    public void info(String category, String message)
    {
        delegate.info("["+category+"]", message);
    }

    public void error(String category, String message)
    {
        DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        delegate.error(DATE_FORMAT.format(new Date()) + " Classe: " + className + " Categorie: " + category, " Message:" + message);
    }
}
