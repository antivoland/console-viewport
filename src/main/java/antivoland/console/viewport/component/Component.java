package antivoland.console.viewport.component;

import antivoland.console.viewport.Ticker;

public abstract class Component {
    protected final long createdTimestamp = System.currentTimeMillis();

    public abstract int size();

    public abstract String data(Ticker.Event event);
}