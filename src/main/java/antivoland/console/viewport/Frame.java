package antivoland.console.viewport;

public class Frame {
    static final int DEFAULT_DURATION_MILLIS = 2000;
    final String data;
    final int durationMillis;

    Frame(String data) {
        this(data, DEFAULT_DURATION_MILLIS);
    }

    public Frame(final String data, final int durationMillis) {
        this.data = data;
        this.durationMillis = durationMillis;
    }
}