package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.tick.Tick;

public class Health extends Container {

    private Animation fullSlot() {
        return new Animation(new Frame("▒", 1000));
    }

    private Animation emptySlot() {
        return new Animation(new Frame("░", 1000));
    }

    private Animation changingSlot() {
        return new Animation(
                new Frame("▓", 500),
                new Frame("░", 500));
    }

    private static int SLOTS = 10;

    public Health() {
        super(SLOTS);
    }

    @Override
    public String value(Tick event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public synchronized void set(final int current, final int max) {
        children.clear();
        final var l = Math.round((float) SLOTS * current / max);
        for (int i = +0; i < l; ++i) {
            add(fullSlot());
        }
        for (int i = l; i < SLOTS; ++i) {
            add(emptySlot());
        }
    }
}