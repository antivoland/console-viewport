package antivoland.console.viewport.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.Ticker;

import java.util.List;

public class Monkey extends Component {

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