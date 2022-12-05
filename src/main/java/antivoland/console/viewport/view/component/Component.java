package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.Snapshot;

import java.util.Map;

public abstract class Component {

    public final int size;
    public final long created = System.currentTimeMillis();
    public volatile int x;
    protected final Viewport viewport;

    protected Component(int size, Viewport viewport) {
        this.size = size;
        this.viewport = viewport;
    }

    public Map<Integer, String> values(Tick event) {
        throw new UnsupportedOperationException("Method was deprecated");
    }

    public String value(Tick event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public abstract Snapshot snapshot(Tick event);
}