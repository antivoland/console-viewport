package antivoland.console.viewport.view.component;

import java.util.ArrayList;
import java.util.List;

public abstract class Container extends Component {
    protected final List<Component> children = new ArrayList<>();

    public Container(int size) {
        super(size);
    }

    public synchronized void add(Component component) {
        children.add(component);
    }

    public synchronized void clear() {
        children.clear();
    }
}