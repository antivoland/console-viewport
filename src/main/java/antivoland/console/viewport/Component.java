package antivoland.console.viewport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

abstract class Component {
    final AtomicInteger x = new AtomicInteger();
    final long createdTimestamp = System.currentTimeMillis();

    final int x() {
        return x.get();
    }

    abstract int size();

    abstract String data(Ticker.Event event);

    static class Pane extends Component {
        final Collection<Component> children = new ArrayList<>();

        synchronized void add(final Component component) {
            children.add(component);
        }

        @Override
        synchronized public int size() {
            var size = 0;
            for (final var child : children) {
                size += child.size();
            }
            return size;
        }

        @Override
        synchronized String data(Ticker.Event event) {
            final var builder = new StringBuilder();
            for (final var child : children) {
                builder.append(child.data(event));
            }
            return builder.toString();
        }
    }

    static class Player extends Component {

        static final Frames FRAMES = new Frames(List.of(
                new Frame("🙉", 100),
                new Frame("🙊", 100)));

        @Override
        public int size() {
            return FRAMES.size();
        }

        @Override
        String data(final Ticker.Event event) {
            return FRAMES.data(event);
        }
    }

    static class Timer extends Component {

        @Override
        public int size() {
            return 5;
        }

        @Override
        String data(final Ticker.Event event) {
            var dt = event.currentTimestamp - createdTimestamp;
            var minutes = dt / 1000 / 60;
            var seconds = dt / 1000;
            return format("%02d:%02d", minutes, seconds);
        }
    }
}