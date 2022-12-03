package antivoland.console.viewport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

abstract class Component {
    final AtomicInteger x = new AtomicInteger();

    final int x() {
        return x.get();
    }

    abstract int size();

    abstract String data();

    final void tick(Ticker.Event event) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    static class Pane extends Component {
        final Collection<Component> children = new ArrayList<>();

        void add(final Component component) {
            children.add(component);
        }

        @Override
        public int size() {
            var size = 0;
            for (final var child : children) {
                size += child.size();
            }
            return size;
        }

        @Override
        String data() {
            final var builder = new StringBuilder();
            for (final var child : children) {
                builder.append(child.data());
            }
            return builder.toString();
        }
    }

    static class Player extends Component {
        @Override
        public int size() {
            return 1;
        }

        @Override
        String data() {
            return "@";
        }
    }
}