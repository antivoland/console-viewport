package antivoland.console.viewport.view.component;

import antivoland.console.viewport.Frame;
import antivoland.console.viewport.Frames;

import java.util.List;

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
    public String value() {
        return FRAMES.data(ageMillis());
    }
}