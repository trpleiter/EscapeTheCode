package nl.tompleiter;

public class Stopwatch {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    public float getGameTimeSeconds() {
        return (endTime - startTime) / 1000f;
    }
}