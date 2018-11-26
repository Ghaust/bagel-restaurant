package logger;

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
    public void log(String message){
        DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        delegate.log(DATE_FORMAT.format(new Date()) + " " + className + " " + message);

    }

    public void debug(String category, String message)
    {
        DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        delegate.debug(DATE_FORMAT.format(new Date()) + " Classe: " + className + " Categorie: " + category, " Message:" + message);

    }
    public void info(String category, String message)
    {
        //DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        //delegate.info(DATE_FORMAT.format(new Date()) + " Classe: " + className + " Categorie: " + category, " Message:" + message);
        delegate.info("["+category+"]", message);
    }
    public void error(String category, String message)
    {
        DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        delegate.error(DATE_FORMAT.format(new Date()) + " Classe: " + className + " Categorie: " + category, " Message:" + message);
    }
}
