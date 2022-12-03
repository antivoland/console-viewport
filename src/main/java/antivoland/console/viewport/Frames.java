package antivoland.console.viewport;

import java.util.List;

import static java.lang.Math.max;

class Frames {
    final List<Frame> frames;
    final long createdTimestamp = System.currentTimeMillis();

    Frames(final List<Frame> frames) {
        this.frames = frames;
    }

    private int totalDurationMillis() {
        var totalDurationMillis = 0;
        for (final Frame frame : frames) {
            totalDurationMillis += frame.durationMillis;
        }
        return totalDurationMillis;
    }

    public int size() {
        var size = 0;
        for (final var frame : frames) {
            size = max(size, frame.data.length());
        }
        return size;
    }

    String data(final Ticker.Event event) {
        if (frames.isEmpty()) {
            return "";
        }
        final var totalDurationMillis = totalDurationMillis();

        var dt = event.currentTimestamp - createdTimestamp;
        dt = dt % totalDurationMillis;

        var i = 0;
        var dti = 0;
        do {
            final var frame = frames.get(i);
            dti += frame.durationMillis;
        } while (dti <= dt && ++i < frames.size());
        return frames.get(i).data;
    }
}