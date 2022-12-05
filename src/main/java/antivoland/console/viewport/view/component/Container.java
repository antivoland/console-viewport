package antivoland.console.viewport.view.component;

import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.Snapshot;

import java.util.ArrayList;
import java.util.List;

public abstract class Container extends Component {
    protected final List<Component> children = new ArrayList<>();

    public Container(int size, Viewport viewport) {
        super(size, viewport);
    }

    public synchronized void add(Component component) {
        children.add(component);
    }

    public synchronized void clear() {
        children.clear();
    }

    @Override
    public synchronized Snapshot snapshot(Tick event) {
        Snapshot snapshot = new Snapshot(viewport.size);
        for (Component child : children) {
            snapshot = snapshot.append(child.snapshot(event));
        }
        return snapshot;
    }
}