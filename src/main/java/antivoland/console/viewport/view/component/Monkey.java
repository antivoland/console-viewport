package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.Snapshot;

import java.util.List;
import java.util.Map;

public class Monkey extends Component {

    private static final Frames FRAMES = new Frames(List.of(
            new Frame("🙉", 800),
            new Frame("🙊", 300)));

    public Monkey(Viewport viewport) {
        super(FRAMES.maxSize(), viewport);
    }

    @Override
    public Map<Integer, String> values(Tick event) {
        return Map.of(x, FRAMES.data(event));
    }

    @Override
    public String value(Tick tick) {
        return FRAMES.data(tick);
    }

    @Override
    public Snapshot snapshot(Tick event) {
        return new Snapshot(viewport.size).append(x, FRAMES.data(event));
    }
}