package antivoland.console.viewport;

import java.io.PrintStream;

class ConsoleViewport {
    private final PrintStream stream;

    ConsoleViewport(final PrintStream stream) {
        this.stream = stream;
    }

    void draw(final String token) {
        stream.print('\r');
        stream.print(token);
    }
}