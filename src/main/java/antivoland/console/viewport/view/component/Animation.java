package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.Snapshot;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Animation extends Component {
    private final Frames frames;

    public Animation(Viewport viewport, Frame... frames) {
        this(viewport, new Frames(Arrays.stream(frames).collect(toList())));
    }

    private Animation(Viewport viewport, Frames frames) {
        super(frames.maxSize(), viewport);
        this.frames = frames;
    }

    @Override
    public Map<Integer, String> values(Tick event) {
        return Map.of(x, frames.data(event));
    }

    @Override
    public Snapshot snapshot(Tick event) {
        return new Snapshot(viewport.size).append(x, frames.data(event));
    }
}
