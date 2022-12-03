package antivoland.console.viewport.component;

import antivoland.console.viewport.Ticker;

import java.util.ArrayList;
import java.util.Collection;

public class Pane extends Component {
    final Collection<Component> children = new ArrayList<>();

    public synchronized void add(final Component component) {
        children.add(component);
    }

    @Override
    public synchronized int size() {
        var size = 0;
        for (final var child : children) {
            size += child.size();
        }
        return size;
    }

    @Override
    public synchronized String data(final Ticker.Event event) {
        final var builder = new StringBuilder();
        for (final var child : children) {
            builder.append(child.data(event));
        }
        return builder.toString();
    }
}