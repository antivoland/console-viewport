package antivoland.console.viewport;

import antivoland.console.viewport.component.Component;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Animation extends Component {
    private final Frames frames;

    public Animation(final Frame... frames) {
        this(Arrays.stream(frames).collect(toList()));
    }

    public Animation(final List<Frame> frames) {
        this.frames = new Frames(frames);
    }

    @Override
    public int size() {
        return frames.size();
    }

    @Override
    public String data(Ticker.Event event) {
        return frames.data(event);
    }
}
