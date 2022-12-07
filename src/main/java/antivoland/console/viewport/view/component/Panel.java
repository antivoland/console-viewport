package antivoland.console.viewport.view.component;

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
}