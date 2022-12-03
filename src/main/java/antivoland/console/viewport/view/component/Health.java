package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;

public class Health extends Pane {

    private static Animation fullSlot() {
        return new Animation(new Frame("▒", 1000));
    }

    private static Animation emptySlot() {
        return new Animation(new Frame("░", 1000));
    }

    private static Animation changingSlot() {
        return new Animation(
                new Frame("▓", 500),
                new Frame("░", 500));
    }

    private static int SLOTS = 10;

    public synchronized void set(final int current, final int max) {
        children.clear();
        final var l = Math.round((float) SLOTS * current / max);
        for (int i = 0; i < l; ++i) {
            add(fullSlot());
        }
        for (int i = l; i < SLOTS; ++i) {
            add(emptySlot());
        }
    }
}