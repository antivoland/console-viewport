package antivoland.console.viewport.view;

import antivoland.console.viewport.Ticker;
import antivoland.console.viewport.view.component.Component;
import antivoland.console.viewport.view.component.Pane;

import java.io.PrintStream;

public class ConsoleViewport {
    final static int DEFAULT_SIZE = 80;

    private final PrintStream stream;
    private final int size;
    private final Pane root = new Pane();
    private volatile String data;

    ConsoleViewport() {
        this(System.out, DEFAULT_SIZE);
    }

    public ConsoleViewport(final PrintStream stream) {
        this(stream, DEFAULT_SIZE);
    }

    public ConsoleViewport(PrintStream stream, int size) {
        this.stream = stream;
        this.size = size;

        new Ticker(event -> draw(root.data(event)));
    }

    public void add(final Component component) {
        root.add(component);
    }

    public synchronized void draw(final String data) {
        if (data.equals(this.data)) {
            return;
        }
        this.data = data;
        clear();
        stream.print('\r');
        stream.print(data);
    }

    public void clear() {
        stream.print('\r');
        for (int i = 0; i < size; ++i) {
            stream.print(' ');
        }
    }

    public void message(final String message) {
        stream.print(message);
    }
}