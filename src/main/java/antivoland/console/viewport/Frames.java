package antivoland.console.viewport;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Frames {
    final List<Frame> frames;

    public Frames(List<Frame> frames) {
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

    public static Frames parse(String value) {
        return parse(value, 1);
    }

    public static Frames parse(String value, int frameSize) {
        var frames = new ArrayList<Frame>();
        var j = 0;
        var frame = new StringBuilder();
        for (int i = 0; i < value.length(); ++i) {
            frame.append(value.charAt(i));
            j = j + 1 % frameSize;
            if (j == 0) {
                frames.add(new Frame(frame.toString()));
                frame = new StringBuilder();
            }
        }
        return new Frames(frames);
    }
}