package antivoland.console.viewport.view.export;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Age;
import antivoland.console.viewport.view.Snapshot;

import java.util.ArrayList;
import java.util.List;

public class Recorder {
    public static class Frame {
        public final String value;
        public final long delayMillis;

        private Frame(String value, long delayMillis) {
            this.value = value;
            this.delayMillis = delayMillis;
        }
    }

    public static final int FRAME_INTERVAL_MILLIS = 100;

    public final List<Frame> frames = new ArrayList<>();
    private final Age age = new Age();
    private volatile long lastAgeMillis = -1;

    public void record(Tick tick, Snapshot snapshot) {
        age.tick(tick);
        if (lastAgeMillis < 0) {
            lastAgeMillis = age.millis();
            return;
        }
        var delayMillis = age.millis() - lastAgeMillis;
        if (delayMillis < FRAME_INTERVAL_MILLIS) {
            return;
        }
        frames.add(new Frame(snapshot.value, delayMillis));
        lastAgeMillis = age.millis();
    }
}