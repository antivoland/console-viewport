package antivoland.console.viewport.view;

import antivoland.console.viewport.tick.Tick;

import java.util.concurrent.atomic.AtomicLong;

public final class Age {
    private final AtomicLong millis = new AtomicLong();

    public void tick(Tick tick) {
        millis.addAndGet(tick.dt);
    }

    public long millis() {
        return millis.get();
    }
}