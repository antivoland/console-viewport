package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Aging;

public abstract class Component extends Aging {

    public volatile int x;
    public final int size;

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
}