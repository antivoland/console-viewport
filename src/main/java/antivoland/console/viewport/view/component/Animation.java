package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class Animation extends Component {
    private static final int DEFAULT_FRAME_DURATION_MILLIS = 300;
    private final Frames frames;

    public Animation(String... frames) {
        this(DEFAULT_FRAME_DURATION_MILLIS, frames);
    }

    public Animation(int frameDurationMillis, String... frames) {
        this(new Frames(Arrays.stream(frames).map(frame -> new Frame(frame, frameDurationMillis)).collect(toList())));
    }

    public Animation(Frame... frames) {
        this(new Frames(Arrays.stream(frames).collect(toList())));
    }

    public Animation(Frames frames) {
        super(frames.maxSize());
        this.frames = frames;
    }

    @Override
    public String value() {
        return frames.data(ageMillis());
    }
}
