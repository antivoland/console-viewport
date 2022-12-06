package antivoland.console.viewport.stage;

import antivoland.console.viewport.World;
import antivoland.console.viewport.model.Player;
import antivoland.console.viewport.tick.Tick;
import antivoland.console.viewport.tick.Ticker;
import antivoland.console.viewport.view.Camera;
import antivoland.console.viewport.view.Viewport;
import antivoland.console.viewport.view.component.Animation;

import java.io.Closeable;
import java.util.List;

import static antivoland.console.viewport.asset.Emoji.AnimalsAndNature.*;

public class Stage implements Closeable {
    private final Ticker ticker = new Ticker(this::handleTick);
    public final Player player = new Player();
    public final Camera camera = new Camera(this);
    public final Viewport viewport = new Viewport();
    public final List<Animation> animations = List.of(
            new Animation(300, // moon
                    NEW_MOON,
                    WAXING_CRESCENT_MOON,
                    FIRST_QUARTER_MOON,
                    WAXING_GIBBOUS_MOON,
                    FULL_MOON,
                    WANING_GIBBOUS_MOON,
                    LAST_QUARTER_MOON,
                    WANING_CRESCENT_MOON),
            new Animation(500, // globe
                    GLOBE_SHOWING_EUROPE_AFRICA,
                    GLOBE_SHOWING_AMERICAS,
                    GLOBE_SHOWING_ASIA_AUSTRALIA),
            new Animation(500, // camel
                    CAMEL,
                    TWO_HUMP_CAMEL),
            new Animation(500, // pig
                    PIG_FACE,
                    PIG_NOSE),
            new Animation(300,
                    ".",
                    "o",
                    "O",
                    "o",
                    "."
                    ),
            new Animation(300,
                    "_",
                    "_",
                    "_",
                    "_",
                    "-",
                    "~",
                    "`",
                    "_"
                    ),
            new Animation(250,
                    "░",
                    "▒",
                    "▓",
                    "▒",
                    "░"
                    ),
            new Animation(400,
                    "’", "‛"),
            new Animation(400,
                    "†", "‡"),
            new Animation(400,
                    "∝", "∞"),
            new Animation(400,
                    "∴","∻", "∵","∻"),
            new Animation(400,
                    "∼","∽"),
            new Animation(400,
                    "⊶","⊷"),
            new Animation(400,
                    "⊹"," "),
            new Animation(400,
                    "⋋","⋌"),
            new Animation(400,
                    "⋮","⋰","⋯","⋱"),
            new Animation(400,
                    "⎜",
                    "⎡",
                    "⎛",
                    "⎡",
                    "⎜",
                    "⎤",
                    "⎞",
                    "⎤",
                    "⎜"),
            new Animation(400,
                    "⎟","⎠","⎟","⎝"),
            new Animation(400,
                    "⊏","⊂"),
            new Animation(200,
                    "←",
                    "←",
                    "↖",
                    "↑",
                    "↗",
                    "→",
                    "↘",
                    "↓",
                    "↙")
            //https://www.williamrobertson.net/documents/ascii.shtml
    );

    public Stage() {
        int x0 = 20;
        for (int i = 0; i < animations.size(); ++i) {
            animations.get(i).x = x0 + i * 3;
        }

        ticker.run();
    }

    private void handleTick(Tick tick) {
        if (player.task != null) {
            player.task.tick(tick);
        }

        var snapshot = camera.snapshot(tick, viewport.size);
        viewport.draw(snapshot);

        // animate movements
    }

    @Override
    public void close() {
        ticker.close();
    }
}