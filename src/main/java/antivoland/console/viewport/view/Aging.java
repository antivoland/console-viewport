package antivoland.console.viewport.view;

import antivoland.console.viewport.tick.Tick;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Aging {
    private final AtomicLong ageMillis = new AtomicLong(0);

    public void tick(Tick tick) {
        ageMillis.addAndGet(tick.dt);
    }

    public final long ageMillis() {
        return ageMillis.get();
    }
}