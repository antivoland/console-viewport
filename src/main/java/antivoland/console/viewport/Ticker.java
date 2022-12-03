package antivoland.console.viewport;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class Ticker {

    public static class Event {
        public final long previousTimestamp;
        public final long currentTimestamp;

        private Event(long previousTimestamp, long currentTimestamp) {
            this.previousTimestamp = previousTimestamp;
            this.currentTimestamp = currentTimestamp;
        }

        @Override
        public String toString() {
            return "(" + previousTimestamp + ", " + currentTimestamp + ")";
        }
    }

    private static final int DEFAULT_TICK_INTERVAL_MILLIS = 10;

    private final AtomicLong previousTimestamp = new AtomicLong();
    private final Consumer<Event> tickHandler;

    Ticker(final Consumer<Event> tickHandler) {
        this(tickHandler, DEFAULT_TICK_INTERVAL_MILLIS);
    }

    @SuppressWarnings("BusyWait")
    Ticker(final Consumer<Event> tickHandler, final int tickIntervalMillis) {
        this.tickHandler = tickHandler;

        new Thread(() -> { // todo: pause ticker
            while (true) {
                tick();
                try {
                    Thread.sleep(tickIntervalMillis);
                } catch (final InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    void tick() {
        final long currentTimestamp = System.currentTimeMillis();
        final var event = new Event(currentTimestamp, previousTimestamp.getAndSet(currentTimestamp));
        tickHandler.accept(event);
    }

    int fps() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}