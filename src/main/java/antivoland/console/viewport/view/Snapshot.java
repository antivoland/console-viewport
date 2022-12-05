package antivoland.console.viewport.view;

import static java.lang.Math.min;

public class Snapshot {
    private static final char TRANSPARENT = ' ';
    public final String value;

    public Snapshot(int size) {
        this((TRANSPARENT + "").repeat(size));
    }

    private Snapshot(String value) {
        this.value = value;
    }

    public Snapshot append(Snapshot snapshot) {
        return append(0, snapshot.value);
    }

    public Snapshot append(int i, String value) {
        if (i + value.length() <= 0 || i > this.value.length()) {
            return this;
        }

        var sb = new StringBuilder(this.value);
        for (int j = 0; j < min(value.length(), this.value.length() - i); ++j) {
            var c = value.charAt(j);
            if (c != TRANSPARENT) {
                sb.setCharAt(i + j, c);
            }
        }
        return new Snapshot(sb.toString());
    }

    @Override
    public String toString() {
        return value;
    }
}