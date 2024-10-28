import java.util.logging.*;

public class LoggerSetup {
    private static final Logger logger = Logger.getLogger(LoggerSetup.class.getName());

    public static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
