package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;

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
    public String value() {
        var minutes = ageMillis() / 1000 / 60;
        var seconds = ageMillis() / 1000 - minutes * 60;
        return format("%02d%s%02d", minutes, FRAMES.data(ageMillis()), seconds);
    }
}