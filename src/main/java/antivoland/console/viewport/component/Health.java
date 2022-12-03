package antivoland.console.viewport.component;

import antivoland.console.viewport.Animation;
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

    public Health() {
        for (int i = 0; i < 3; ++i) {
            add(fullSlot());
        }
        add(changingSlot());
        for (int i = 0; i < 6; ++i) {
            add(emptySlot());
        }
//        for (int i = 0; i < SLOTS; ++i) {
//            add(emptySlot());
//        }
    }

//    public synchronized void set(final int value, final int maxValue) {
//        var l = value / maxValue * SLOTS;
//        for (int i = 0; i <= l; ++i) {
//            children.add()
//            add(emptySlot());
//        }
//
//
//    }
}