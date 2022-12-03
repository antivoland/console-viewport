package antivoland.console.viewport.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.Ticker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

public abstract class Component {
    final AtomicInteger x = new AtomicInteger();
    final long createdTimestamp = System.currentTimeMillis();

    final int x() {
        return x.get();
    }

    public abstract int size();

    public abstract String data(Ticker.Event event);

    public static class Pane extends Component {
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
        public synchronized String data(Ticker.Event event) {
            final var builder = new StringBuilder();
            for (final var child : children) {
                builder.append(child.data(event));
            }
            return builder.toString();
        }
    }

    public static class Player extends Component {

        static final Frames FRAMES = new Frames(List.of(
                new Frame("🙉", 100),
                new Frame("🙊", 100)));

        @Override
        public int size() {
            return FRAMES.size();
        }

        @Override
        public String data(final Ticker.Event event) {
            return FRAMES.data(event);
        }
    }

    public static class Timer extends Component {

        @Override
        public int size() {
            return 5;
        }

        @Override
        public String data(final Ticker.Event event) {
            var dt = event.currentTimestamp - createdTimestamp;
            var minutes = dt / 1000 / 60;
            var seconds = dt / 1000;
            return format("%02d:%02d", minutes, seconds);
        }
    }
}