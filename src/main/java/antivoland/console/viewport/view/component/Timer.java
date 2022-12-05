package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.Snapshot;

import java.util.List;

import static java.lang.String.format;

public class Timer extends Component {
    static final Frames FRAMES = new Frames(List.of(
            new Frame(":", 500),
            new Frame(" ", 500)));

    public Timer(Viewport viewport) {
        super(5, viewport);
    }

    @Override
    public String value(Tick event) {
        var dt = event.currentTimeMillis - created;
        var minutes = dt / 1000 / 60;
        var seconds = dt / 1000 - minutes * 60;
        return format("%02d%s%02d", minutes, FRAMES.data(event), seconds);
    }

    @Override
    public Snapshot snapshot(final Tick event) {
        var dt = event.currentTimeMillis - created;
        var minutes = dt / 1000 / 60;
        var seconds = dt / 1000 - minutes * 60;
        return new Snapshot(viewport.size).append(x, format("%02d%s%02d", minutes, FRAMES.data(event), seconds));
    }
}
