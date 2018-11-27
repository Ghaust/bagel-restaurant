package logger.src.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileLogger {
    private final Path path;

    public FileLogger(String pathAsString) {
        path = Paths.get(pathAsString).toAbsolutePath();
    }



    public void info(String category, String message) {
        try {
            DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

            Files.write(path, (DATE_FORMAT.format(new Date()) + " info " + " Categorie: [" + category + "]" + " Message:" + message + "\n").getBytes(), APPEND, CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write log message to file [" + path + "]", e);
        }
    }

    public void error(String category, String message) {
        try {
            DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

            Files.write(path, (DATE_FORMAT.format(new Date()) + " error " + " Categorie: [" + category + "]" + " Message:" + message + "\n").getBytes(), APPEND, CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write log message to file [" + path + "]", e);
        }
    }
}
