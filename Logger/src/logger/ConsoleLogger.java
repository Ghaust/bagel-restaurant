package logger;


public class ConsoleLogger implements Logger {
    private String message;



    public ConsoleLogger(String message) {
        this.message = message;
    }

    @Override
    public void log(String message) {

        System.out.println(message);
    }

    @Override
    public void info(String category, String message) {

        System.out.println(message);

    }
    @Override
    public void error(String category, String message) {


    }
    @Override
    public void debug(String category, String message) {


    }



}
