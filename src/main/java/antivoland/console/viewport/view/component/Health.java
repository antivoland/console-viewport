package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.view.Viewport;

public class Health extends Container {

    private Animation fullSlot() {
        return new Animation(viewport, new Frame("▒", 1000));
    }

    private Animation emptySlot() {
        return new Animation(viewport, new Frame("░", 1000));
    }

    private Animation changingSlot() {
        return new Animation(viewport,
                new Frame("▓", 500),
                new Frame("░", 500));
    }

    private static int SLOTS = 10;

    public Health(Viewport viewport) {
        super(SLOTS, viewport);
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