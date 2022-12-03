package antivoland.console.viewport.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.Ticker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

public abstract class Component {
    final AtomicInteger x = new AtomicInteger();
    final long createdTimestamp = System.currentTimeMillis();

    final int x() {
        return x.get();
    }

    public abstract int size();

    public abstract String data(Ticker.Event event);

}