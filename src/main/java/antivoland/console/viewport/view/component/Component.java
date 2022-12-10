package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Age;

public abstract class Component {

    public volatile int x;
    public final int size;
    public final Age age = new Age();

    protected Component(int size) {
        this.size = size;
    }

    public void tick(Tick tick) {
        age.tick(tick);
    }

    public final long ageMillis() {
        return age.millis();
    }

    @Deprecated
    public String value(Tick event) {
        throw new UnsupportedOperationException("Method was deprecated");
    }

    public String value() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}