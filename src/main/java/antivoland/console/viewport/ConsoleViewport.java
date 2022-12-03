package antivoland.console.viewport;

import java.io.PrintStream;

class ConsoleViewport {
    final static int DEFAULT_SIZE = 80;

    private final PrintStream stream;
    private final int size;

    ConsoleViewport() {
        this(System.out, DEFAULT_SIZE);
    }

    ConsoleViewport(final PrintStream stream) {
        this(stream, DEFAULT_SIZE);
    }

    ConsoleViewport(PrintStream stream, int size) {
        this.stream = stream;
        this.size = size;

        new Ticker(this::handleTickerEvent, 100);
    }

    private void handleTickerEvent(final Ticker.Event event) {
        draw("Tick event: " + event.toString());
    }

    void draw(final String line) {
        clear();
        stream.print('\r');
        stream.print(line);
    }

    void clear() {
        stream.print('\r');
        for (int i = 0; i < size; ++i) {
            stream.print(' ');
        }
    }

    void message(final String message) {
        stream.print(message);
    }
}