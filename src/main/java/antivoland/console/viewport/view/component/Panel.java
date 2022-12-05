package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;

public class Panel extends Container {
    final Align align;

    public Panel(int size, Align align) {
        super(size);
        this.align = align;
    }

    @Override
    public synchronized void add(Component component) {
        super.add(component);
        align.realign(this);
    }

    @Override
    public String value(Tick event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}