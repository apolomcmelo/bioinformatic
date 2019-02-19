package bioinformatic;

public class Timer {
    private static long time;
    
    public static void start() {
        time = System.currentTimeMillis();
    }
    
    public static void stop() {
        time = System.currentTimeMillis() - time;
    }
    
    private static long getDurationInSeconds() {
        return time / 1000;
    }
    
    private static long getDurationInMinutes() {
        return time / 0x3e8 / 0x3c;
    }
    
    public static void printInSeconds() {
        System.out.println("Tempo de execução: " + getDurationInSeconds() + "s");
    }
    
    public static void printInMinutes() {
        System.out.println("Tempo de execução: " + getDurationInMinutes() + "min");
    }
    
    public static void printInMillis() {
        System.out.println("Tempo de execução: " + time + "ms");
    }
}