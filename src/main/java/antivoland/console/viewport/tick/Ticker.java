package antivoland.console.viewport.tick;

import java.io.Closeable;
import java.util.function.Consumer;

public class Ticker implements Closeable {

    private static final int DEFAULT_TICK_INTERVAL_MILLIS = 50;

    private final Consumer<Tick> tickHandler;
    private volatile long previousTimestamp;
    private final Thread worker;

    public Ticker(final Consumer<Tick> tickHandler) {
        this(tickHandler, DEFAULT_TICK_INTERVAL_MILLIS);
    }

    @SuppressWarnings("BusyWait")
    public Ticker(final Consumer<Tick> tickHandler, final int tickIntervalMillis) {
        this.tickHandler = tickHandler;
        worker = new Thread(() -> {
            while (true) {
                tick();
                try {
                    Thread.sleep(tickIntervalMillis);
                } catch (final InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public void run() {
        worker.start();
    }

    private void tick() {
        final long currentTimestamp = System.currentTimeMillis();
        previousTimestamp = currentTimestamp;
        tickHandler.accept(new Tick(currentTimestamp, previousTimestamp));
    }

    @Override
    public void close() {
        worker.interrupt();
        try {
            worker.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}