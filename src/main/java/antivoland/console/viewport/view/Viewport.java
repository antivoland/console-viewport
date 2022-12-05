package antivoland.console.viewport.view;

import java.io.PrintStream;

public class Viewport {

    private static final int DEFAULT_SIZE = 80;

    private final PrintStream stream;
    public final int size;
    private volatile String lastSnapshot;

    public Viewport() {
        this(System.out, DEFAULT_SIZE);
    }

    public Viewport(PrintStream stream) {
        this(stream, DEFAULT_SIZE);
    }

    public Viewport(PrintStream stream, int size) {
        this.stream = stream;
        this.size = size;
    }

    public synchronized void draw(Snapshot snapshot) {
        if (snapshot.value.equals(this.lastSnapshot)) {
            return;
        }
        this.lastSnapshot = snapshot.value;
        stream.print('\r' + snapshot.value);
        stream.flush();
    }

    public void clear() {
        draw(new Snapshot(this.size));
    }
}