package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;

public abstract class Component {

    public volatile int x;
    public final int size;
    public final long createdTimeMillis = System.currentTimeMillis();

    protected Component(int size) {
        this.size = size;
    }

    public abstract String value(Tick event);
}