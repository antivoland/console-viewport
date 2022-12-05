package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.tick.Tick;

import java.util.List;

import static java.lang.String.format;

public class Timer extends Component {
    static final Frames FRAMES = new Frames(List.of(
            new Frame(":", 500),
            new Frame(" ", 500)));

    public Timer() {
        super(5);
    }

    @Override
    public String value(Tick event) {
        var dt = event.currentTimeMillis - createdTimeMillis;
        var minutes = dt / 1000 / 60;
        var seconds = dt / 1000 - minutes * 60;
        return format("%02d%s%02d", minutes, FRAMES.data(event), seconds);
    }
}
