package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.tick.Tick;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class Animation extends Component {
    private static final int DEFAULT_FRAME_DURATION_MILLIS = 500;
    private final Frames frames;

    public Animation(String... frames) {
        this(new Frames(Arrays.stream(frames).map(frame -> new Frame(frame, DEFAULT_FRAME_DURATION_MILLIS)).collect(toList())));
    }

    public Animation(Frame... frames) {
        this(new Frames(Arrays.stream(frames).collect(toList())));
    }

    private Animation(Frames frames) {
        super(frames.maxSize());
        this.frames = frames;
    }

    @Override
    public String value(Tick event) {
        return frames.data(event);
    }
}
