package antivoland.console.viewport.view.component;

import antivoland.console.viewport.view.Viewport;

public class Panel extends Container {
    final Align align;

    public Panel(int size, Viewport viewport, Align align) {
        super(size, viewport);
        this.align = align;
    }

    @Override
    public synchronized void add(Component component) {
        super.add(component);
        align.realign(this);
    }
}