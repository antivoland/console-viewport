package antivoland.console.viewport.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.Ticker;

import java.util.List;

import static java.lang.String.format;

public class Timer extends Component {
    static final Frames FRAMES = new Frames(List.of(
            new Frame(":", 500),
            new Frame(" ", 500)));

    @Override
    public int size() {
        return 5;
    }

    @Override
    public String data(final Ticker.Event event) {
        var dt = event.currentTimestamp - createdTimestamp;
        var minutes = dt / 1000 / 60;
        var seconds = dt / 1000 - minutes * 60;
        return format("%02d%s%02d", minutes, FRAMES.data(event), seconds);
    }
}
