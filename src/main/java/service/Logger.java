package service;

public class Logger {
    public static final String RESET = "\u001B[0m";     // Reset
    public static final String RED = "\u001B[31m";      // Red
    public static final String GREEN = "\u001B[32m";    // Green
    public static final String INFO = "\u001B[34m";     // Blue

    private Logger() { }

    public static void logError(String message) {
        System.out.println("[" + RED + "ERROR" + RESET + "] " + message);
    }

    public static void logInfo(String message) {
        System.out.println("[" + INFO + "INFO" + RESET + "] " + message);
    }

    public static void logSuccess(String message) {
        System.out.println("[" + GREEN + "SUCCESS" + RESET + "] " + message);
    }

    public static void logWarning(String message) {
        System.out.println("[" + RED + "WARNING" + RESET + "] " + message);
    }
}
