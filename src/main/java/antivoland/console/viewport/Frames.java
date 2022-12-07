package antivoland.console.viewport;

import antivoland.console.viewport.tick.Tick;

import java.util.List;

import static java.lang.Math.max;

public class Frames {
    final List<Frame> frames;
    final long createdTimeMillis = System.currentTimeMillis();

    public Frames(final List<Frame> frames) {
        this.frames = frames;
    }

    private int totalDurationMillis() {
        var totalDurationMillis = 0;
        for (final Frame frame : frames) {
            totalDurationMillis += frame.durationMillis;
        }
        return totalDurationMillis;
    }

    public int maxSize() {
        var size = 0;
        for (final var frame : frames) {
            size = max(size, frame.data.length());
        }
        return size;
    }

    public String data(final Tick tick) {
        throw new UnsupportedOperationException("Method was deprecated");
    }

    public String data(final long ageMillis) {
        if (frames.isEmpty()) {
            return "";
        }
        final var totalDurationMillis = totalDurationMillis();

        var dt = ageMillis % totalDurationMillis;

        var i = 0;
        var dti = 0;
        do {
            final var frame = frames.get(i);
            dti += frame.durationMillis;
        } while (dti <= dt && ++i < frames.size());
        return frames.get(i).data;
    }
}