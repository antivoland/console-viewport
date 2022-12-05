package antivoland.console.viewport.view.component;

import java.util.function.Consumer;

public enum Align {
    LEFT(container -> {
        int x = 0;
        for (int i = 0; i < container.children.size(); ++i) {
            var child = container.children.get(i);
            child.x = x;
            x += child.size;
        }

    }),
    CENTER(container -> {
        throw new UnsupportedOperationException("Not implemented yet");
    }),
    RIGHT(container -> {
        int x = container.size - container.children.get(container.children.size() - 1).size;
        for (int i = container.children.size() - 1; i >= 0; --i) {
            var child = container.children.get(i);
            child.x = x;
            x -= child.size;
        }
    });

    private final Consumer<Container> realign;

    Align(Consumer<Container> realign) {
        this.realign = realign;
    }

    public void realign(Container container) {
        if (container.children.isEmpty()) {
            return;
        }
        realign.accept(container);
    }
}