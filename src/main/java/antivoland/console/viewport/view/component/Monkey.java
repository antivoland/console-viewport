package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.view.Viewport;

import java.util.List;
import java.util.Map;

import static antivoland.console.viewport.asset.Emoji.AnimalsAndNature.HEAR_NO_EVIL_MONKEY;
import static antivoland.console.viewport.asset.Emoji.AnimalsAndNature.SEE_NO_EVIL_MONKEY;

public class Monkey extends Component {

    private static final Frames FRAMES = new Frames(List.of(
            new Frame(HEAR_NO_EVIL_MONKEY, 800),
            new Frame(SEE_NO_EVIL_MONKEY, 300)));

    public Monkey() {
        super(FRAMES.maxSize());
    }

    @Override
    public String value(Tick tick) {
        return FRAMES.data(tick);
    }
}