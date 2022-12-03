package antivoland.console.viewport;

import java.io.PrintStream;

class ConsoleViewport {
    final static int DEFAULT_SIZE = 80;

    private final PrintStream stream;
    private final int size;
    private final Component.Pane root = new Component.Pane();

    ConsoleViewport() {
        this(System.out, DEFAULT_SIZE);
    }

    ConsoleViewport(final PrintStream stream) {
        this(stream, DEFAULT_SIZE);
    }

    ConsoleViewport(PrintStream stream, int size) {
        this.stream = stream;
        this.size = size;

        new Ticker(this::handleTickerEvent);
    }

    private void handleTickerEvent(final Ticker.Event event) {
        draw(root.data());
    }

    void add(final Component component) {
        root.add(component);
    }

    void draw(final String data) {
        clear();
        stream.print('\r');
        stream.print(data);
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