package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Component {

    public volatile int x;
    public final int size;
    private final AtomicLong ageMillis = new AtomicLong(0);

    protected Component(int size) {
        this.size = size;
    }

    @Deprecated
    public String value(Tick event) {
        throw new UnsupportedOperationException("Method was deprecated");
    }

    public String value() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public final void tick(Tick event) {
        ageMillis.addAndGet(event.dt);
    }

    public final long ageMillis() {
        return ageMillis.get();
    }
}